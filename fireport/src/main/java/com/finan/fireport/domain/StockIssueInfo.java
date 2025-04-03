package com.finan.fireport.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "stock_issue_info")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockIssueInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate basDt; // 기준일자

    @Column(length = 13, nullable = false)
    private String crno; // 법인등록번호

    @Column(length = 12)
    private String isinCd; // ISIN 코드

    @Column(length = 200)
    private String isinCdNm; // ISIN 코드명

    @Column(length = 1000)
    private String stckIssuCmpyNm; // 주식발행회사명

    @Column(length = 2)
    private String scrsDcd; // 유가증권구분코드

    @Column(length = 10)
    private String stckIssuSqno; // 주식발행일련번호

    private LocalDate stckIssuDt; // 주식발행일자

    @Column(length = 6)
    private String stckIssuDcnt; // 주식발행차수

    @Column(length = 4)
    private String scrsItmsKcd; // 유가증권종목종류코드

    @Column(length = 100)
    private String scrsItmsKcdNm; // 유가증권종목종류코드명 (ex. 보통주, 우선주)

    @Column(length = 3)
    private String stckIssuRcd; // 주식발행사유코드

    @Column(length = 100)
    private String stckIssuRcdNm; // 주식발행사유코드명 (ex. 유상증자)

    private Long issuStckCnt; // 발행주식수

    private LocalDate lstgDt; // 상장일자 (nullable)
}