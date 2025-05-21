package com.finan.fireport.service;

import com.finan.fireport.common.util.DateFormats;
import com.finan.fireport.domain.StockIssueInfo;
import com.finan.fireport.domain.StockItemInfo;
import com.finan.fireport.dto.request.StockIssueInfoRequest;
import com.finan.fireport.dto.request.StockItemInfoRequest;
import com.finan.fireport.dto.response.KrxBaseResponseDto;
import com.finan.fireport.dto.response.StockIssueInfoResponse;
import com.finan.fireport.dto.response.StockItemInfoResponse;
import com.finan.fireport.infrastructure.api.StockItemInfoApiClient;
import com.finan.fireport.mapper.StockItemInfoMapper;
import com.finan.fireport.repository.StockItemInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockItemInfoService {
    private final StockItemInfoApiClient apiClient;
    private final StockItemInfoRepository repository;
    private final StockItemInfoMapper mapper;

    @Transactional
    public void fetchAndSaveStockItemInfos (){

        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);

        String yesterdayStr = yesterday.format(DateFormats.YYYYMMDD);

        StockItemInfoRequest dto = StockItemInfoRequest.builder()
                .pageNo(1)
                .numOfRows(1000)
                .build();

        KrxBaseResponseDto<StockItemInfoResponse> response = apiClient.fetchStockItemInfos(dto);
        List<StockItemInfoResponse> list = response.getItems();

        List<StockItemInfo> StockItemInfos = mapper.toEntityList(list);
        repository.saveAll(StockItemInfos);

    }
}
