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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockIssueInfoService {
    private final StockIssueInfoApiClient apiClient;
    private final StockIssueInfoJdbcRepository jdbcRepository;
    private final StockIssueInfoMapper mapper;
    private static final Integer NUM_OF_ROWS = 100;
    private static final Integer NUM_THREADS = 4; // 병렬 스레드 수

    @Transactional
        public void fetchAndSaveStockIssueInfos (LocalDate baseDay) throws InterruptedException {
        int totalPages = getTotalPages(baseDay);

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);  // 스레드 풀 설정
        //LocalDate yesterday = LocalDate.now().minusDays(1); --

        List<Callable<Void>> tasks = new ArrayList<>();

        for(int pageNo = 1; pageNo <= totalPages; pageNo++){
            final int page = pageNo;
            tasks.add(()->{
                StockIssueInfoRequest requestDto = StockIssueInfoRequest.builder()
                        .pageNo(page)
                        .numOfRows(NUM_OF_ROWS)
                        .basDt(baseDay.format(DateFormats.YYYYMMDD))
                        .build();

                KrxBaseResponseDto<StockIssueInfoResponse> response = apiClient.fetchStockIssueInfos(requestDto);
                List<StockIssueInfoResponse> items = response.getItems();

                if (!items.isEmpty()) {
                    List<StockIssueInfo> StockIssueInfos = mapper.toEntityList(items);
                    jdbcRepository.bulkInsert(StockIssueInfos);
                    log.info("페이지 번호 {} - 데이터 처리 완료", page);
                }
                return null;
            });
        }

        try{
            // 병렬처리
            executorService.invokeAll(tasks);
        } catch(InterruptedException e){
            Thread.currentThread().interrupt(); // 스레드 중단
            log.error("스레드 작업 중 인터럽트 발생", e);
        } finally{
            executorService.shutdown(); // 스레드 풀 종료
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
