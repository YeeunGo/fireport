package com.finan.fireport.service;

import com.finan.fireport.common.util.DateFormats;
import com.finan.fireport.domain.StockIssueInfo;
import com.finan.fireport.dto.request.StockIssueInfoRequest;
import com.finan.fireport.dto.response.KrxBaseResponseDto;
import com.finan.fireport.dto.response.StockIssueInfoResponse;
import com.finan.fireport.infrastructure.api.StockIssueInfoApiClient;
import com.finan.fireport.mapper.StockIssueInfoMapper;
import com.finan.fireport.repository.StockIssueInfoJdbcRepository;
import com.finan.fireport.repository.StockIssueInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockIssueInfoService {
    private final StockIssueInfoApiClient apiClient;
    //private final StockIssueInfoRepository repository;
    private final StockIssueInfoJdbcRepository jdbcRepository;
    private final StockIssueInfoMapper mapper;
    private static final Integer NUM_OF_ROWS = 100;

    @Transactional
        public void fetchAndSaveStockIssueInfos (LocalDate baseDay){
        int pageNo = 1;

        //LocalDate yesterday = LocalDate.now().minusDays(1); --

        StockIssueInfoRequest requestDto = StockIssueInfoRequest.builder()
                .pageNo(pageNo)
                .numOfRows(NUM_OF_ROWS)
                .basDt(baseDay.format(DateFormats.YYYYMMDD))
                .build();

        while(true){
            // open api 자체가 실패했을 때 처리는 아직 구현은 안했는데, OpenDataClient 내에서 처리하는게 좋을 것 같습니다.
            KrxBaseResponseDto<StockIssueInfoResponse> response = apiClient.fetchStockIssueInfos(requestDto);
            List<StockIssueInfoResponse> items = response.getItems();

            if (items.isEmpty()) {
                log.info("모든 정보를 조회해서 while문을 종료합니다.");
                break;
            }

            List<StockIssueInfo> StockIssueInfos = mapper.toEntityList(items);

            jdbcRepository.bulkInsert(StockIssueInfos);

            requestDto = StockIssueInfoRequest.builder()
                    .pageNo(++pageNo)
                    .numOfRows(NUM_OF_ROWS)
                    .basDt(baseDay.format(DateFormats.YYYYMMDD))
                    .build();
        }
    }

    private int getTotalPages(LocalDate baseDay){
        StockIssueInfoRequest requestDto = StockIssueInfoRequest.builder()
                .pageNo(1)
                .numOfRows(NUM_OF_ROWS)
                .basDt(baseDay.format(DateFormats.YYYYMMDD))
                .build();
        KrxBaseResponseDto<StockIssueInfoResponse> response = apiClient.fetchStockIssueInfos(requestDto);
        int totalItems = response.getResponse().getBody().getTotalCount();
        return (int) Math.ceil((double) totalItems / NUM_OF_ROWS);
    }
}
