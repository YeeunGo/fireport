package com.finan.fireport.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/*주식 발행내역 조회 Entity*/
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

    private String crno;                  // 법인등록번호
    private String isinCd;               // ISIN 코드
    private String itmsShrtnCd;          // 종목단축코드
    private String stckIssuCmpyNm;       // 주식발행회사명
    private String isinCdNm;             // ISIN 코드명
    private String scrsItmsKcd;          // 유가증권 종목 종류 코드
    private String scrsItmsKcdNm;        // 유가증권 종목 종류 코드명
    private Long stckParPrc;             // 주식 액면가
    private Long issuStckCnt;            // 발행 주식 수
    private LocalDate lstgDt;            // 상장일자
    private LocalDate lstgAbolDt;        // 상장폐지일자
    private LocalDate dpsgRegDt;         // 예탁 등록 일자
    private LocalDate dpsgCanDt;         // 예탁 취소 일자
    private String issuFrmtClsfNm;       // 발행 형태 구분명
    private LocalDate basDt;             // 기준일자
}