package com.finan.fireport.infrastructure.api;

import com.finan.fireport.dto.request.FinancialSummaryRequestDto;
import com.finan.fireport.dto.response.FinancialSummaryResponseDto;
import com.finan.fireport.infrastructure.api.util.QueryStringConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanSummaryApiClient extends AbstractApiClient{
    private static final String FI_SUMMARY_PATH = "/GetFinaStatInfoService_V2/getSummFinaStat_V2";

    public List<FinancialSummaryResponseDto> fetchFinancialSummaries (FinancialSummaryRequestDto dto) {
        String queryString = QueryStringConverter.convertDtoToParam(dto);

        return createGetRequest(FI_SUMMARY_PATH, queryString, "financial-summary")
                .bodyToFlux(FinancialSummaryResponseDto.class)
                .collectList()
                .block();
    }
}
