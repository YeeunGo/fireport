package com.finan.fireport.infrastructure.api;

import com.finan.fireport.dto.request.FinancialSummaryRequestDto;
import com.finan.fireport.dto.response.FinancialSummaryResponseDto;
import com.finan.fireport.infrastructure.api.util.QueryStringConverter;
import org.springframework.stereotype.Service;

@Service
public class FinanSummaryApiClient extends AbstractApiClient{
    private static final String FI_SUMMARY_PATH = "/GetFinaStatInfoService_V2/getSummFinaStat_V2";

    public FinancialSummaryResponseDto finanSummary (FinancialSummaryRequestDto dto) {
        FinancialSummaryResponseDto result = null;
        String queryString = QueryStringConverter.convertDtoToParam(dto);
        result = createGetRequest(FI_SUMMARY_PATH, queryString)
                .bodyToMono(FinancialSummaryResponseDto.class)
                .block();

        return result;
    }
}
