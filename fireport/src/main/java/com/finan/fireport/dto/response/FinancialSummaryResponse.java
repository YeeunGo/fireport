package com.finan.fireport.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FinancialSummaryResponse {
    private String basDt;         // 기준일자 (YYYYMMDD)
    private String crno;          // 법인등록번호
    private String curCd;         // 통화코드 (예: KRW)
    private String bizYear;       // 사업연도

    private String fnclDcd;        // 재무제표 구분코드
    private String fnclDcdNm;      // 재무제표 구분코드명

    private String enpSaleAmt;     // 기업매출금액
    private String enpBzopPft;     // 기업영업이익
    private String iclsPalClcAmt;  // 포괄손익계산금액
    private String enpCrtmNpf;     // 기업당기순이익
    private String enpTastAmt;     // 기업총자산금액
    private String enpTdbtAmt;     // 기업총부채금액
    private String enpTcptAmt;     // 기업총자본금액
    private String enpCptlAmt;     // 기업자본금액
    private String fnclDebtRto;    // 재무제표 부채비율

    @Builder
    public FinancialSummaryResponse(String basDt, String crno, String curCd, String bizYear, String fnclDcd, String fnclDcdNm, String enpSaleAmt, String enpBzopPft, String iclsPalClcAmt, String enpCrtmNpf, String enpTastAmt, String enpTdbtAmt, String enpTcptAmt, String enpCptlAmt, String fnclDebtRto) {
        this.basDt = basDt;
        this.crno = crno;
        this.curCd = curCd;
        this.bizYear = bizYear;
        this.fnclDcd = fnclDcd;
        this.fnclDcdNm = fnclDcdNm;
        this.enpSaleAmt = enpSaleAmt;
        this.enpBzopPft = enpBzopPft;
        this.iclsPalClcAmt = iclsPalClcAmt;
        this.enpCrtmNpf = enpCrtmNpf;
        this.enpTastAmt = enpTastAmt;
        this.enpTdbtAmt = enpTdbtAmt;
        this.enpTcptAmt = enpTcptAmt;
        this.enpCptlAmt = enpCptlAmt;
        this.fnclDebtRto = fnclDebtRto;
    }
}
