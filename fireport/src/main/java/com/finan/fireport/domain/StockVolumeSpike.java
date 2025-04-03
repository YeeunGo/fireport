package com.finan.fireport.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stock_volume_spike",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"stock_id", "baseDate", "period"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockVolumeSpike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 종목 참조 (FK)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id", nullable = false)
    private StockCorporationInfo stock;

    private LocalDate baseDate; // 기준일자 (오늘 거래량 기준)

    private Integer period; // N일 평균 기준 (5일, 10일, 15일 등)

    private Long todayVolume; // 오늘 거래량

    private Long averageVolume; // 최근 N일 평균 거래량

    private BigDecimal spikeRate; // 급등률 (%) = today / avg * 100
}