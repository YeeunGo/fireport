package com.finan.fireport.infrastructure.api;

import com.finan.fireport.dto.request.FinancialSummaryRequestDto;
import com.finan.fireport.dto.response.KrxBaseResponseDto;
import com.finan.fireport.dto.response.StockItemResponseDto;
import com.finan.fireport.infrastructure.api.util.QueryStringConverter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

@Service
public class StockItemInfoApiclient extends AbstractApiClient{
    private static final String FI_SUMMARY_PATH = "/GetKrxListedInfoService/getItemInfo";

    public KrxBaseResponseDto<StockItemResponseDto> fetchStockItemInfos (FinancialSummaryRequestDto dto) {
        String queryString = QueryStringConverter.convertDtoToParam(dto);
        return createGetRequest(FI_SUMMARY_PATH, queryString, "stock-item-info")
                .bodyToMono(new ParameterizedTypeReference<KrxBaseResponseDto<StockItemResponseDto>>() {})
                .block();
    }
}
