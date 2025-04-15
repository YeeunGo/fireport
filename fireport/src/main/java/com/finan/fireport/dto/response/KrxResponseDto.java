package com.finan.fireport.dto.response;

import lombok.Getter;

import java.util.List;

@Getter
public class KrxResponseDto<T> {
    private List<T> item;
}