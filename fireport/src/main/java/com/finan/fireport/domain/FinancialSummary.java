package com.finan.fireport.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "financial_summary")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinancialSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate basDt; // 기준일자

    @Column(length = 13, nullable = false)
    private String crno; // 법인등록번호

    @Column(length = 3)
    private String curCd; // 통화코드

    private int bizYear; // 사업연도

    @Column(length = 50)
    private String fnclDcd; // 재무제표구분코드

    @Column(length = 100)
    private String fnclDcdNm; // 재무제표구분코드명

    private BigDecimal enpSaleAmt; // 매출금액

    private BigDecimal enpBzopPft; // 영업이익

    private BigDecimal iclsPalClcAmt; // 포괄손익계산금액

    private BigDecimal enpCrtmNpf; // 당기순이익

    private BigDecimal enpTastAmt; // 총자산금액

    private BigDecimal enpTdbtAmt; // 총부채금액

    private BigDecimal enpTcptAmt; // 총자본금액

    private BigDecimal enpCptlAmt; // 자본금액

    private BigDecimal fnclDebtRto; // 부채비율
}