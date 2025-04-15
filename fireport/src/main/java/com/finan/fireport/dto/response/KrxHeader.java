package com.finan.fireport.dto.response;

import lombok.Getter;

@Getter
public class KrxHeader {
    protected final String resultCode;
    protected final String resultMsg;

    public KrxHeader(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }
}