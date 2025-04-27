package com.finan.fireport.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stock_market_info")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StockMarketInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate basDt; // 기준일자

    @Column(length = 6)
    private String srtnCd; // 단축코드 (6자리 종목 코드)

    @Column(length = 12)
    private String isinCd; // ISIN 코드

    @Column(length = 200)
    private String itmsNm; // 종목명

    @Column(length = 10)
    private String mrktCtg; // 시장 구분 (KOSPI/KOSDAQ/KONEX)

    private Integer clpr; // 종가

    private Integer vs; // 전일 대비 등락

    private BigDecimal fltRt; // 등락률 (소수 가능)

    private Integer mkp; // 시가

    private Integer hipr; // 고가

    private Integer lopr; // 저가

    private Long trqu; // 거래량

    private Long trPrc; // 거래대금

    private Long lstgStCnt; // 상장주식수

    private Long mrktTotAmt; // 시가총액

    @Builder
    public StockMarketInfo(Long id, LocalDate basDt, String srtnCd, String isinCd, String itmsNm, String mrktCtg, Integer clpr, Integer vs, BigDecimal fltRt, Integer mkp, Integer hipr, Integer lopr, Long trqu, Long trPrc, Long lstgStCnt, Long mrktTotAmt) {
        this.id = id;
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