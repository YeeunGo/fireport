package com.finan.fireport.dto.request;

import lombok.Builder;
import lombok.Getter;

/*상장종목정보 Request Dto*/
@Getter
public class StockPriceInfoRequest extends KrxBaseRequestDto{
    private final String basDt;        // 기준일자 (일치 검색)
    private final String beginBasDt;   // 기준일자 >= 검색
    private final String endBasDt;     // 기준일자 < 검색
    private final String likeBasDt;    // 기준일자 포함 검색

    private final String likeSrtnCd;   // 종목단축코드 포함 검색
    private final String isinCd;       // ISIN 코드 일치 검색
    private final String likeIsinCd;   // ISIN 코드 포함 검색
    private final String itmsNm;       // 종목명 일치 검색
    private final String likeItmsNm;   // 종목명 포함 검색

    private final String crno;         // 법인등록번호 일치 검색
    private final String corpNm;       // 법인명 일치 검색
    private final String likeCorpNm;   // 법인명 포함 검색

    @Builder
    public StockPriceInfoRequest(Integer numOfRows, Integer pageNo, String basDt, String beginBasDt, String endBasDt, String likeBasDt, String likeSrtnCd, String isinCd, String likeIsinCd, String itmsNm, String likeItmsNm, String crno, String corpNm, String likeCorpNm) {
        super(numOfRows, pageNo);
        this.basDt = basDt;
        this.beginBasDt = beginBasDt;
        this.endBasDt = endBasDt;
        this.likeBasDt = likeBasDt;
        this.likeSrtnCd = likeSrtnCd;
        this.isinCd = isinCd;
        this.likeIsinCd = likeIsinCd;
        this.itmsNm = itmsNm;
        this.likeItmsNm = likeItmsNm;
        this.crno = crno;
        this.corpNm = corpNm;
        this.likeCorpNm = likeCorpNm;
    }
}
