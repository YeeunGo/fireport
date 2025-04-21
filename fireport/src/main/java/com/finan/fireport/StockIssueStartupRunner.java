package com.finan.fireport;


import com.finan.fireport.service.StockissueInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockIssueStartupRunner implements CommandLineRunner {

    private final StockissueInfoService service;

    @Override
    public void run(String... args) throws Exception {
        service.fetchAndSaveStockIssueInfos();
    }
}