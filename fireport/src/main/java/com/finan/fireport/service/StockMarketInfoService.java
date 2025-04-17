package com.finan.fireport.service;

import com.finan.fireport.infrastructure.api.FinanSummaryApiClient;
import com.finan.fireport.repository.FinancialSummaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockMarketInfoService {
    private final FinanSummaryApiClient apiClient;
    private final FinancialSummaryRepository repository;
}
