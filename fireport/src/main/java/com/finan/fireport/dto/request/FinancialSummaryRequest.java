package com.finan.fireport.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

/*요약 재무제표 requestDto*/
@Getter
public class FinancialSummaryRequest extends KrxBaseRequestDto {

    private final String crno;               // 법인등록번호
    private final String bizYear;     // 법인에 대해 법령이 규정한 1회계기간으로서 법인세의 과세기간

    @Builder
    public FinancialSummaryRequest(
            @NonNull Integer numOfRows,
            @NonNull Integer pageNo,
            String crno,
            String bizYear
    ) {
        super(numOfRows, pageNo);
        this.crno = crno;
        this.bizYear = bizYear;
    }
}