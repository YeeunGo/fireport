package com.finan.fireport.infrastructure.api;


import com.finan.fireport.dto.request.StockItemInfoRequest;
import com.finan.fireport.dto.response.KrxBaseResponseDto;
import com.finan.fireport.dto.response.StockItemInfoResponse;
import com.finan.fireport.infrastructure.api.util.QueryStringConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

@Service
public class StockItemInfoApiClient extends AbstractApiClient {
    private static final String STOCK_ISSUE_PATH = "/GetKrxListedInfoService/getItemInfo";

    @Value("${open-api.service-keys.stock-item}")
    private String STOCK_ITEM_KEY;

    public KrxBaseResponseDto<StockItemInfoResponse> fetchStockItemInfos (StockItemInfoRequest dto) {
        String queryString = QueryStringConverter.convertDtoToParam(dto);

        return createGetRequest(STOCK_ISSUE_PATH, queryString, STOCK_ITEM_KEY)
                .bodyToMono(new ParameterizedTypeReference<KrxBaseResponseDto<StockItemInfoResponse>>() {})
                .block();
    }
}
