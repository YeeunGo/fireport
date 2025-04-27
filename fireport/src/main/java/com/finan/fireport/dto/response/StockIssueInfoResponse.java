package com.finan.fireport.dto.response;

import lombok.*;

/*주식발행내역조회 responseDto*/
@Getter
public class StockIssueInfoResponse {

    private final String basDt;               // 기준일자
    private final String crno;                // 법인등록번호
    private final String isinCd;              // ISIN 코드

    private final String itmsShrtnCd;         // 종목단축코드
    private final String isinCdNm;            // ISIN 코드명
    private final String stckIssuCmpyNm;      // 주식발행회사명
    private final String scrsItmsKcd;         // 유가증권종목종류코드
    private final String scrsItmsKcdNm;       // 유가증권종목종류코드명
    private final String stckParPrc;          // 주식액면가
    private final String issuStckCnt;         // 발행주식수
    private final String lstgDt;              // 상장일자
    private final String lstgAbolDt;          // 상장폐지일자
    private final String dpsgRegDt;           // 예탁등록일자
    private final String dpsgCanDt;           // 예탁취소일자
    private final String issuFrmtClsfNm;      // 발행형태구분명

    @Builder
    public StockIssueInfoResponse(String basDt, String crno, String isinCd, String itmsShrtnCd, String isinCdNm, String stckIssuCmpyNm, String scrsItmsKcd, String scrsItmsKcdNm, String stckParPrc, String issuStckCnt, String lstgDt, String lstgAbolDt, String dpsgRegDt, String dpsgCanDt, String issuFrmtClsfNm) {
        this.basDt = basDt;
        this.crno = crno;
        this.isinCd = isinCd;
        this.itmsShrtnCd = itmsShrtnCd;
        this.isinCdNm = isinCdNm;
        this.stckIssuCmpyNm = stckIssuCmpyNm;
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