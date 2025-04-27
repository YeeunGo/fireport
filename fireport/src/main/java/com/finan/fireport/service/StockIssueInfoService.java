package com.finan.fireport.service;

import com.finan.fireport.common.util.DateFormats;
import com.finan.fireport.domain.StockIssueInfo;
import com.finan.fireport.dto.request.StockIssueInfoRequest;
import com.finan.fireport.dto.response.KrxBaseResponseDto;
import com.finan.fireport.dto.response.StockIssueInfoResponse;
import com.finan.fireport.infrastructure.api.StockIssueInfoApiClient;
import com.finan.fireport.mapper.StockIssueInfoMapper;
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
    private final StockIssueInfoRepository repository;
    private final StockIssueInfoMapper mapper;

    @Transactional
    public void fetchAndSaveStockIssueInfos (){

        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);

        String yesterdayStr = yesterday.format(DateFormats.YYYYMMDD);

        StockIssueInfoRequest dto = StockIssueInfoRequest.builder()
                .pageNo(1)
                .numOfRows(1000)
                .basDt(yesterdayStr)
                .build();

        KrxBaseResponseDto<StockIssueInfoResponse> response = apiClient.fetchStockIssueInfos(dto);
        List<StockIssueInfoResponse> list = response.getResponse().getBody().getItems().getItem();

        List<StockIssueInfo> StockIssueInfos = mapper.toEntityList(list);
        repository.saveAll(StockIssueInfos);

    }
}
