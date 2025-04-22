package com.finan.fireport.service;

import com.finan.fireport.common.util.DateFormats;
import com.finan.fireport.domain.StockIssueInfo;
import com.finan.fireport.dto.request.FinancialSummaryRequestDto;
import com.finan.fireport.dto.request.StockIssueInfoRequestDto;
import com.finan.fireport.dto.response.FinancialSummaryResponseDto;
import com.finan.fireport.dto.response.KrxBaseResponseDto;
import com.finan.fireport.dto.response.StockIssueInfoResponseDto;
import com.finan.fireport.infrastructure.api.FinanSummaryApiClient;
import com.finan.fireport.infrastructure.api.StockissueInfoApiClient;
import com.finan.fireport.mapper.StockIssueInfoMapper;
import com.finan.fireport.repository.FinancialSummaryRepository;
import com.finan.fireport.repository.StockissueInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockissueInfoService {
    private final StockissueInfoApiClient apiClient;
    private final StockissueInfoRepository repository;
    private final StockIssueInfoMapper mapper;

    @Transactional
    public void fetchAndSaveStockIssueInfos (){

        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);

        String yesterdayStr = yesterday.format(DateFormats.YYYYMMDD);

        StockIssueInfoRequestDto dto = StockIssueInfoRequestDto.builder()
                .pageNo(1000)
                .numOfRows(1)
                .basDt(yesterdayStr)
                .build();

        KrxBaseResponseDto<StockIssueInfoResponseDto> response = apiClient.fetchStockIssueInfos(dto);
        List<StockIssueInfoResponseDto> list = response.getResponse().getBody().getItems().getItem();

        List<StockIssueInfo> StockIssueInfos = mapper.toEntityList(list);
        repository.saveAll(StockIssueInfos);

    }
}
