package com.finan.fireport.domain;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
/* 공공 데이터 API - 상장종목정보 Entity*/
@Entity
@Table(name = "stock_corporation_info")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockItemInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate basDt; // 기준일자

    @Column(length = 9)
    private String srtnCd; // 단축코드

    @Column(length = 12)
    private String isinCd; // ISIN 코드

    @Column(length = 10)
    private String mrktCtg; // 시장구분 (KOSPI/KOSDAQ/KONEX 등)

    @Column(length = 240)
    private String itmsNm; // 종목명

    @Column(length = 20)
    private String crno; // 법인등록번호

    @Column(length = 240)
    private String corpNm; // 법인명
}