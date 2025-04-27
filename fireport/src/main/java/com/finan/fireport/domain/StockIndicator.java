package com.finan.fireport.domain;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stock_indicator")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StockIndicator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 종목 기준 (FK)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id", nullable = false)
    private StockItemInfo stock; // 종목 정보 참조 (isinCd, srtnCd 등)

    private LocalDate baseDate; // 기준일자

    private BigDecimal per;      // PER = 시가 / EPS
    private BigDecimal pbr;      // PBR = 시가 / BPS
    private BigDecimal roe;      // ROE = 순이익 / 자본
    private BigDecimal roa;      // ROA = 순이익 / 자산
    private BigDecimal debtRatio; // 부채비율 = 부채 / 자본

    @Builder
    public StockIndicator(Long id, StockItemInfo stock, LocalDate baseDate, BigDecimal per, BigDecimal pbr, BigDecimal roe, BigDecimal roa, BigDecimal debtRatio) {
        this.id = id;
        this.stock = stock;
        this.baseDate = baseDate;
        this.per = per;
        this.pbr = pbr;
        this.roe = roe;
        this.roa = roa;
        this.debtRatio = debtRatio;
    }
}