package com.finan.fireport.dto.response;

import lombok.Builder;
import lombok.Getter;

/*상장종목정보 Response Dto*/
@Getter
public class StockItemInfoResponse {
    private String basDt;         // 기준일자 (YYYYMMDD)
    private String srtnCd;        // 단축코드
    private String isinCd;        // ISIN 코드
    private String mrktCtg;       // 시장 구분 (KOSPI, KOSDAQ 등)
    private String itmsNm;        // 종목명
    private String crno;          // 법인등록번호
    private String corpNm;        // 법인명

    @Builder
    public StockItemInfoResponse(String basDt, String srtnCd, String isinCd, String mrktCtg, String itmsNm, String crno, String corpNm) {
        this.basDt = basDt;
        this.srtnCd = srtnCd;
        this.isinCd = isinCd;
        this.mrktCtg = mrktCtg;
        this.itmsNm = itmsNm;
        this.crno = crno;
        this.corpNm = corpNm;
    }
}
