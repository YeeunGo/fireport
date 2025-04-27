package com.finan.fireport.infrastructure.api;

import com.finan.fireport.dto.request.StockIssueInfoRequest;
import com.finan.fireport.dto.response.KrxBaseResponseDto;
import com.finan.fireport.dto.response.StockIssueInfoResponse;
import com.finan.fireport.infrastructure.api.util.QueryStringConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

@Service
public class StockIssueInfoApiClient extends AbstractApiClient {
    private static final String STOCK_ISSUE_PATH = "/GetStocIssuInfoService_V2/getStocIssuStat_V2";

    @Value("${open-api.service-keys.stock-issue}")
    private String STOCK_ISSUE_KEY;

    public KrxBaseResponseDto<StockIssueInfoResponse> fetchStockIssueInfos (StockIssueInfoRequest dto) {
        String queryString = QueryStringConverter.convertDtoToParam(dto);

        return createGetRequest(STOCK_ISSUE_PATH, queryString, STOCK_ISSUE_KEY)
                .bodyToMono(new ParameterizedTypeReference<KrxBaseResponseDto<StockIssueInfoResponse>>() {})
                .block();
    }
}
