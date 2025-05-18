package com.finan.fireport.scheduler;

import com.finan.fireport.service.StockIssueInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class KrxSchedule {
    private final StockIssueInfoService stockIssueInfoService;

    // 매일 AM 00:20에 실행
    @Scheduled(cron = "0 20 0 * * *")
    public void run() {
        LocalDate now = LocalDate.now();
        stockIssueInfoService.fetchAndSaveStockIssueInfos(now);
    }
}
