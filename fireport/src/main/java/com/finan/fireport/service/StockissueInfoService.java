package com.finan.fireport.service;

import com.finan.fireport.dto.request.FinancialSummaryRequestDto;
import com.finan.fireport.dto.request.StockIssueInfoRequestDto;
import com.finan.fireport.dto.response.FinancialSummaryResponseDto;
import com.finan.fireport.dto.response.KrxBaseResponseDto;
import com.finan.fireport.dto.response.StockIssueInfoResponseDto;
import com.finan.fireport.infrastructure.api.FinanSummaryApiClient;
import com.finan.fireport.infrastructure.api.StockissueInfoApiClient;
import com.finan.fireport.repository.FinancialSummaryRepository;
import com.finan.fireport.repository.StockissueInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockissueInfoService {
    private final StockissueInfoApiClient apiClient;
    private final StockissueInfoRepository repository;

    @Value("${temp-stock-issue-key}")
    private String serviceKey;

    @Transactional
    public void fetchAndSaveStockIssueInfos (){

        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);

        StockIssueInfoRequestDto dto = StockIssueInfoRequestDto.builder()
                .serviceKey(serviceKey)
                .pageNo(1000)
                .numOfRows(1)
                .basDt(yesterday)
                .build();



        KrxBaseResponseDto<StockIssueInfoResponseDto> response = apiClient.fetchStockIssueInfos(dto);

        List<StockIssueInfoResponseDto> list = (List<StockIssueInfoResponseDto>) response.getResponse().getBody().getItems();

    }
}
