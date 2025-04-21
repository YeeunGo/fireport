package com.finan.fireport.mapper;

import com.finan.fireport.domain.StockIssueInfo;
import com.finan.fireport.dto.response.StockIssueInfoResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface  StockIssueInfoMapper {

    StockIssueInfo toEntity(StockIssueInfoResponseDto dto);

    StockIssueInfoResponseDto toDto(StockIssueInfo entity);

    List<StockIssueInfo> toEntityList(List<StockIssueInfoResponseDto> dtoList);
}
