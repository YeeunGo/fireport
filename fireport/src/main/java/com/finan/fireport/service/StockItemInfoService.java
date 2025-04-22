package com.finan.fireport.service;

import com.finan.fireport.dto.request.FinancialSummaryRequestDto;
import com.finan.fireport.dto.request.StockItemInfoRequestDto;
import com.finan.fireport.dto.response.FinancialSummaryResponseDto;
import com.finan.fireport.infrastructure.api.StockItemInfoApiclient;
import com.finan.fireport.repository.FinancialSummaryRepository;
import com.finan.fireport.repository.StockItemInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockItemInfoService {
    private final StockItemInfoApiclient apiClient;
    private final StockItemInfoRepository repository;

    @Transactional
    public void fetchAndSaveStockItemInfo (){
//        StockItemInfoRequestDto dto = StockItemInfoRequestDto.builder()
//                .crno()
//
//        List<FinancialSummaryResponseDto> financialSummaryResponseDtos = apiClient.fetchFinancialSummaries(dto);

    }
}
