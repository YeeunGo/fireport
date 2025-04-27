package com.finan.fireport.mapper;

import com.finan.fireport.domain.StockItemInfo;
import com.finan.fireport.dto.response.StockItemInfoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring", uses = DateMapper.class)
public interface StockItemInfoMapper {

    @Mapping(target = "id", ignore = true)
    StockItemInfo toEntity(StockItemInfoResponse dto);

    StockItemInfoResponse toDto(StockItemInfo entity);

    List<StockItemInfo> toEntityList(List<StockItemInfoResponse> dtoList);
}
