package com.finan.fireport.dto.request;

public abstract class KrxBaseRequestDto {
    private final Integer numOfRows;
    private final Integer pageNo;
    private final String serviceKey;
    private final String resultType = "json";

    protected KrxBaseRequestDto(Integer numOfRows, Integer pageNo, String serviceKey) {
        this.numOfRows = numOfRows;
        this.pageNo = pageNo;
        this.serviceKey = serviceKey;
    }
}