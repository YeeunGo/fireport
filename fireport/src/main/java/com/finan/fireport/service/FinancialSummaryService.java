package com.finan.fireport.service;

import com.finan.fireport.common.util.DateFormats;
import com.finan.fireport.domain.FinancialSummary;
import com.finan.fireport.dto.request.FinancialSummaryRequest;
import com.finan.fireport.dto.response.FinancialSummaryResponse;
import com.finan.fireport.dto.response.KrxBaseResponseDto;
import com.finan.fireport.infrastructure.api.FinancialSummaryApiClient;
import com.finan.fireport.mapper.FinancialSummaryMapper;
import com.finan.fireport.repository.FinancialSummaryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FinancialSummaryService {
    private final FinancialSummaryApiClient apiClient;
    private final FinancialSummaryRepository repository;
    private final FinancialSummaryMapper mapper;

    @Transactional
    public void fetchAndSaveFinancialSummaries (){

        FinancialSummaryRequest dto = FinancialSummaryRequest.builder()
                .pageNo(1)
                .numOfRows(1000)
                .build();

        KrxBaseResponseDto<FinancialSummaryResponse> response = apiClient.fetchFinancialSummaries(dto);
        List<FinancialSummaryResponse> list = response.getResponse().getBody().getItems().getItem();

        List<FinancialSummary> FinancialSummaries = mapper.toEntityList(list);
        repository.saveAll(FinancialSummaries);

    }
}
