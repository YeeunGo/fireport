package com.finan.fireport.dto.request;

import lombok.Builder;
import lombok.Getter;

/*요약재무제표 requestDto*/

@Getter
public class FinancialSummaryRequestDto extends KrxBaseRequestDto {
    private String crno;           // 법인등록번호
    private String bizYear;        // 사업연도

    @Builder
    public FinancialSummaryRequestDto(String bizYear, String crno, Integer numOfRows, Integer pageNo, String serviceKey) {
        super(numOfRows, pageNo);
        this.crno = crno;
        this.bizYear = bizYear;
    }
}