package com.finan.fireport.dto.request;

public abstract class BaseRequestDto {
    private final Integer numOfRows;
    private final Integer pageNo;
    private final String serviceKey;
    private final String resultType = "json";

    protected BaseRequestDto(Integer numOfRows, Integer pageNo, String serviceKey) {
        this.numOfRows = numOfRows;
        this.pageNo = pageNo;
        this.serviceKey = serviceKey;
    }
}