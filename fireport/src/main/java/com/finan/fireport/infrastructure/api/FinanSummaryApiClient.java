package com.finan.fireport.infrastructure.api;

import com.finan.fireport.dto.request.FinancialSummaryRequestDto;
import com.finan.fireport.dto.response.FinancialSummaryResponseDto;
import org.springframework.stereotype.Service;

@Service
public class FinanSummaryApiClient extends AbstractApiClient{
    private static final String FI_SUMMARY_PATH = "/GetFinaStatInfoService_V2/getSummFinaStat_V2";

//    public FinancialSummaryResponseDto finanSummary (FinancialSummaryRequestDto dto) {
//        //QueryStringConverter<FinancialSummaryRequestDto> queryStringConverter = new QueryStringConverter<>();
//    }
}
