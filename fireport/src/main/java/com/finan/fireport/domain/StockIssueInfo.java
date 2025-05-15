package com.finan.fireport.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/*주식 발행내역 조회 Entity*/
@Entity
@Table(name = "stock_issue_info")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StockIssueInfo {
    //여기에 Id 추가

    @EmbeddedId
    StockIssueInfoId id;

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


    @Builder
    public StockIssueInfo( StockIssueInfoId id, String isinCd, String itmsShrtnCd, String stckIssuCmpyNm, String isinCdNm, String scrsItmsKcd, String scrsItmsKcdNm, Long stckParPrc, Long issuStckCnt, LocalDate lstgDt, LocalDate lstgAbolDt, LocalDate dpsgRegDt, LocalDate dpsgCanDt, String issuFrmtClsfNm) {
        this.id = id;
        this.isinCd = isinCd;
        this.itmsShrtnCd = itmsShrtnCd;
        this.stckIssuCmpyNm = stckIssuCmpyNm;
        this.isinCdNm = isinCdNm;
        this.scrsItmsKcd = scrsItmsKcd;
        this.scrsItmsKcdNm = scrsItmsKcdNm;
        this.stckParPrc = stckParPrc;
        this.issuStckCnt = issuStckCnt;
        this.lstgDt = lstgDt;
        this.lstgAbolDt = lstgAbolDt;
        this.dpsgRegDt = dpsgRegDt;
        this.dpsgCanDt = dpsgCanDt;
        this.issuFrmtClsfNm = issuFrmtClsfNm;

    }
}