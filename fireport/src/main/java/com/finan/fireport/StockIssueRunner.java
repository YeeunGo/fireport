package com.finan.fireport;

import com.finan.fireport.service.FinancialSummaryService;
import com.finan.fireport.service.StockIssueInfoService;
import com.finan.fireport.service.StockItemInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class StockIssueRunner implements CommandLineRunner {

    private final StockIssueInfoService IssueService;
    private final StockItemInfoService ItemService;
    private final FinancialSummaryService FinanSummaryService;

    @Override
    public void run(String... args) throws InterruptedException {
        IssueService.fetchAndSaveStockIssueInfos(LocalDate.now());
        //ItemService.fetchAndSaveStockItemInfos();
        //FinanSummaryService.fetchAndSaveFinancialSummaries();
    }
}