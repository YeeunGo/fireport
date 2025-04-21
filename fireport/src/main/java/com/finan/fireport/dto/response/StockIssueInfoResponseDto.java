package com.finan.fireport.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

/*주식발행내역조회 responseDto*/
@Getter
public class StockIssueInfoResponseDto {

    private final String basDt;               // 기준일자
    private final String crno;                // 법인등록번호
    private final String isinCd;              // ISIN 코드
    private final String isinCdNm;            // ISIN 코드명
    private final String stckIssuCmpyNm;      // 주식발행회사명
    private final String scrsDcd;             // 유가증권구분코드
    private final String stckIssuSqno;        // 주식발행일련번호
    private final String stckIssuDt;          // 주식발행일자 (yyyyMMdd)
    private final String stckIssuDcnt;        // 주식발행차수
    private final String scrsItmsKcd;         // 유가증권종목종류코드
    private final String scrsItmsKcdNm;       // 유가증권종목종류코드명
    private final String stckIssuRcd;         // 주식발행사유코드
    private final String stckIssuRcdNm;       // 주식발행사유코드명
    private final Long issuStckCnt;           // 발행주식수
    private final String lstgDt;              // 상장일자 (nullable, yyyyMMdd)

    @Builder
    public StockIssueInfoResponseDto(String basDt, String crno, String isinCd, String isinCdNm, String stckIssuCmpyNm, String scrsDcd, String stckIssuSqno, String stckIssuDt, String stckIssuDcnt, String scrsItmsKcd, String scrsItmsKcdNm, String stckIssuRcd, String stckIssuRcdNm, Long issuStckCnt, String lstgDt) {
        this.basDt = basDt;
        this.crno = crno;
        this.isinCd = isinCd;
        this.isinCdNm = isinCdNm;
        this.stckIssuCmpyNm = stckIssuCmpyNm;
        this.scrsDcd = scrsDcd;
        this.stckIssuSqno = stckIssuSqno;
        this.stckIssuDt = stckIssuDt;
        this.stckIssuDcnt = stckIssuDcnt;
        this.scrsItmsKcd = scrsItmsKcd;
        this.scrsItmsKcdNm = scrsItmsKcdNm;
        this.stckIssuRcd = stckIssuRcd;
        this.stckIssuRcdNm = stckIssuRcdNm;
        this.issuStckCnt = issuStckCnt;
        this.lstgDt = lstgDt;
    }
}