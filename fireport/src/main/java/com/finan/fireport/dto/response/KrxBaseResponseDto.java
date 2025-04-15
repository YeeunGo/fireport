package com.finan.fireport.dto.response;

import lombok.Getter;

@Getter
public class KrxBaseResponseDto<T> {
    private KrxBaseResponseItemDto<T> response;
}