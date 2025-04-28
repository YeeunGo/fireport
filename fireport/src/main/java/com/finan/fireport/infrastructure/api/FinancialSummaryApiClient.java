package com.finan.fireport.infrastructure.api;


import com.finan.fireport.dto.request.FinancialSummaryRequest;
import com.finan.fireport.dto.response.FinancialSummaryResponse;
import com.finan.fireport.dto.response.KrxBaseResponseDto;
import com.finan.fireport.infrastructure.api.util.QueryStringConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

@Service
public class FinancialSummaryApiClient extends AbstractApiClient {
    private static final String STOCK_ISSUE_PATH = "/GetFinaStatInfoService_V2/getSummFinaStat_V2";

    @Value("${open-api.service-keys.financial-summary}")
    private String FINAN_SUMMARY_KEY;

    public KrxBaseResponseDto<FinancialSummaryResponse> fetchFinancialSummaries (FinancialSummaryRequest dto) {
        String queryString = QueryStringConverter.convertDtoToParam(dto);

        return createGetRequest(STOCK_ISSUE_PATH, queryString, FINAN_SUMMARY_KEY)
                .bodyToMono(new ParameterizedTypeReference<KrxBaseResponseDto<FinancialSummaryResponse>>() {})
                .block();
    }
}
