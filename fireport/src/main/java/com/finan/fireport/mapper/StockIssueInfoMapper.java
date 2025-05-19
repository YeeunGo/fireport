package com.finan.fireport.mapper;

import com.finan.fireport.domain.StockIssueInfo;
import com.finan.fireport.dto.response.StockIssueInfoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring", uses = DateMapper.class)
public interface  StockIssueInfoMapper {

    @Mapping(target = "id.crno", source = "crno")
    @Mapping(target = "id.basDt", source = "basDt")
    StockIssueInfo toEntity(StockIssueInfoResponse dto);

    @Mapping(target = "crno", source = "id.crno")
    @Mapping(target = "basDt", source = "id.basDt")
    StockIssueInfoResponse toDto(StockIssueInfo entity);

    @Mapping(target = "id.crno", source = "crno")
    @Mapping(target = "id.basDt", source = "basDt")
    List<StockIssueInfo> toEntityList(List<StockIssueInfoResponse> dtoList);
}
