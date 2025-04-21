package com.finan.fireport.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;

/*주식 발행내역 조회 requestDto*/
@Getter
public class StockIssueInfoRequestDto extends KrxBaseRequestDto {

    private final String basDt;              // 기준일자
    private final String crno;               // 법인등록번호
    private final String stckIssuCmpyNm;     // 주식발행회사명

    @Builder
    public StockIssueInfoRequestDto(
            @NonNull Integer numOfRows,
            @NonNull Integer pageNo,
            @NonNull String serviceKey,
            @NonNull String basDt,
            String crno,
            String stckIssuCmpyNm
    ) {
        super(numOfRows, pageNo, serviceKey);
        this.basDt = basDt;
        this.crno = crno;
        this.stckIssuCmpyNm = stckIssuCmpyNm;
    }
}