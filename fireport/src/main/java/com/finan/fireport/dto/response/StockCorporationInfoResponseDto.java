package com.finan.fireport.dto.response;

import lombok.Builder;
import lombok.Getter;

/*종목정보 responseDto*/
@Getter
public class StockCorporationInfoResponseDto {
    private final String basDt;    // 기준일자 (yyyyMMdd → 나중에 LocalDate 변환 가능)
    private final String srtnCd;   // 단축코드
    private final String isinCd;   // ISIN 코드
    private final String mrktCtg;  // 시장구분 (KOSPI/KOSDAQ/KONEX 등)
    private final String itmsNm;   // 종목명
    private final String crno;     // 법인등록번호
    private final String corpNm;   // 법인명

    @Builder
    public StockCorporationInfoResponseDto(String basDt, String srtnCd, String isinCd, String mrktCtg, String itmsNm, String crno, String corpNm) {
        this.basDt = basDt;
        this.srtnCd = srtnCd;
        this.isinCd = isinCd;
        this.mrktCtg = mrktCtg;
        this.itmsNm = itmsNm;
        this.crno = crno;
        this.corpNm = corpNm;
    }
}