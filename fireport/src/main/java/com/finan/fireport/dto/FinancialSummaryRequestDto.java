package com.finan.fireport.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FinancialSummaryRequestDto extends BaseRequestDto{
    private String crno;           // 법인등록번호
    private String bizYear;        // 사업연도

    protected FinancialSummaryRequestDto(String bizYear, String crno, Integer numOfRows, Integer pageNo, String serviceKey) {
        super(numOfRows, pageNo, serviceKey);
        this.crno = crno;
        this.bizYear = bizYear;
    }
}