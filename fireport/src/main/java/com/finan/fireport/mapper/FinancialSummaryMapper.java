package com.finan.fireport.mapper;

import com.finan.fireport.domain.FinancialSummary;
import com.finan.fireport.domain.StockItemInfo;
import com.finan.fireport.dto.response.FinancialSummaryResponse;
import com.finan.fireport.dto.response.StockItemInfoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring", uses = DateMapper.class)
public interface FinancialSummaryMapper {

    @Mapping(target = "id", ignore = true)
    FinancialSummary toEntity(FinancialSummaryResponse dto);

    FinancialSummaryResponse toDto(FinancialSummary entity);

    List<FinancialSummary> toEntityList(List<FinancialSummaryResponse> dtoList);
}
