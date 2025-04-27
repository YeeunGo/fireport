package com.finan.fireport.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

/*주식 발행내역 조회 requestDto*/
@Getter
public class StockIssueInfoRequest extends KrxBaseRequestDto {

    private final String basDt;              // 기준일자
    private final String crno;               // 법인등록번호
    private final String stckIssuCmpyNm;     // 주식발행회사명

    @Builder
    public StockIssueInfoRequest(
            @NonNull Integer numOfRows,
            @NonNull Integer pageNo,
            @NonNull String basDt,
            String crno,
            String stckIssuCmpyNm
    ) {
        super(numOfRows, pageNo);
        this.basDt = basDt;
        this.crno = crno;
        this.stckIssuCmpyNm = stckIssuCmpyNm;
    }
}