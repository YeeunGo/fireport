package com.finan.fireport.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

/*주식 시세 responseDto*/
@Getter
public class StockMarketInfoResponseDto {

    private final String basDt;        // 기준일자
    private final String srtnCd;       // 단축코드
    private final String isinCd;       // ISIN 코드
    private final String itmsNm;       // 종목명
    private final String mrktCtg;      // 시장 구분

    private final Integer clpr;        // 종가
    private final Integer vs;          // 전일 대비
    private final BigDecimal fltRt;    // 등락률
    private final Integer mkp;         // 시가
    private final Integer hipr;        // 고가
    private final Integer lopr;        // 저가

    private final Long trqu;           // 거래량
    private final Long trPrc;          // 거래대금
    private final Long lstgStCnt;      // 상장주식수
    private final Long mrktTotAmt;     // 시가총액

    @Builder
    public StockMarketInfoResponseDto(String basDt, String srtnCd, String isinCd, String itmsNm, String mrktCtg, Integer clpr, Integer vs, BigDecimal fltRt, Integer mkp, Integer hipr, Integer lopr, Long trqu, Long trPrc, Long lstgStCnt, Long mrktTotAmt) {
        this.basDt = basDt;
        this.srtnCd = srtnCd;
        this.isinCd = isinCd;
        this.itmsNm = itmsNm;
        this.mrktCtg = mrktCtg;
        this.clpr = clpr;
        this.vs = vs;
        this.fltRt = fltRt;
        this.mkp = mkp;
        this.hipr = hipr;
        this.lopr = lopr;
        this.trqu = trqu;
        this.trPrc = trPrc;
        this.lstgStCnt = lstgStCnt;
        this.mrktTotAmt = mrktTotAmt;
    }
}