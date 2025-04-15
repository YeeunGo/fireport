package com.finan.fireport.dto.response;

import lombok.Getter;

@Getter
public class KrxBody<T> {
    protected final Integer numOfRows;
    protected final Integer pageNo;
    protected final Integer totalCount;
    protected final T items;

    public KrxBody(Integer numOfRows, Integer pageNo, Integer totalCount, T items) {
        this.numOfRows = numOfRows;
        this.pageNo = pageNo;
        this.totalCount = totalCount;
        this.items = items;
    }
}