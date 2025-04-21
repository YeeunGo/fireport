package com.finan.fireport.service;

import com.finan.fireport.dto.request.FinancialSummaryRequestDto;
import com.finan.fireport.dto.response.FinancialSummaryResponseDto;
import com.finan.fireport.infrastructure.api.FinanSummaryApiClient;
import com.finan.fireport.repository.FinancialSummaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinancialSummaryService {
    private final FinanSummaryApiClient apiClient;
    private final FinancialSummaryRepository repository;

    @Value("${open-api.service-key.financial-summary}")
    private String serviceKey;

    @Transactional
    public void fetchAndSaveFinanSumarry (){
        FinancialSummaryRequestDto dto = FinancialSummaryRequestDto.builder()
                .crno("1234567890")
                .bizYear("2023")
                .numOfRows(100)
                .pageNo(1)
                .serviceKey(serviceKey)
                .build();

        List<FinancialSummaryResponseDto> financialSummaryResponseDtos = apiClient.fetchFinancialSummaries(dto);

    }
}
