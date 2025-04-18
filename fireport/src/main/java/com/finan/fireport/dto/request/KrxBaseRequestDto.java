package com.finan.fireport.dto.request;

import lombok.NonNull;

public abstract class KrxBaseRequestDto {
    private final Integer numOfRows;
    private final Integer pageNo;
    @NonNull
    private final String serviceKey;
    private final String resultType = "json";

    protected KrxBaseRequestDto(Integer numOfRows, Integer pageNo, String serviceKey) {
        this.numOfRows = numOfRows;
        this.pageNo = pageNo;
        this.serviceKey = serviceKey;
    }
}