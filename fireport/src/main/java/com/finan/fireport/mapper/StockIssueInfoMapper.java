package com.finan.fireport.mapper;

import com.finan.fireport.domain.StockIssueInfo;
import com.finan.fireport.dto.response.StockIssueInfoResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring", uses = DateMapper.class)
public interface  StockIssueInfoMapper {

    @Mapping(target = "id", ignore = true)
    StockIssueInfo toEntity(StockIssueInfoResponseDto dto);

    StockIssueInfoResponseDto toDto(StockIssueInfo entity);

    List<StockIssueInfo> toEntityList(List<StockIssueInfoResponseDto> dtoList);
}
