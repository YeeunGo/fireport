package com.finan.fireport.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

/* 요약재무제표 responseDto */

@Getter
@RequiredArgsConstructor
public class FinancialSummaryItemDto {

    private final String basDt;          // 기준일자
    private final String crno;           // 법인등록번호
    private final String curCd;          // 통화코드
    private final int bizYear;           // 사업연도
    private final String fnclDcd;        // 재무제표구분코드
    private final String fnclDcdNm;      // 재무제표구분코드명

    private final BigDecimal enpSaleAmt;       // 매출금액
    private final BigDecimal enpBzopPft;       // 영업이익
    private final BigDecimal iclsPalClcAmt;    // 포괄손익계산금액
    private final BigDecimal enpCrtmNpf;       // 당기순이익
    private final BigDecimal enpTastAmt;       // 총자산금액
    private final BigDecimal enpTdbtAmt;       // 총부채금액
    private final BigDecimal enpTcptAmt;       // 총자본금액
    private final BigDecimal enpCptlAmt;       // 자본금액
    private final BigDecimal fnclDebtRto;      // 부채비율
}