package com.finan.fireport.dto.request;

import lombok.NonNull;

public abstract class KrxBaseRequestDto {
    private final Integer numOfRows;
    private final Integer pageNo;
    private final String resultType = "json";

    protected KrxBaseRequestDto(Integer numOfRows, Integer pageNo) {
        this.numOfRows = numOfRows;
        this.pageNo = pageNo;
    }
}