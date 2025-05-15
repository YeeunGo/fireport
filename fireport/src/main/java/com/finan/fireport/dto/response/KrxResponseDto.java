package com.finan.fireport.dto.response;

import lombok.Getter;

import java.util.List;

// 필요없게 됐음.
@Getter
public class KrxResponseDto<T> {
    private List<T> item;
}