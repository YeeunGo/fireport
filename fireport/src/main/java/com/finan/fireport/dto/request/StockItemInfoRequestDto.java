package com.finan.fireport.dto.request;

import lombok.Builder;
import lombok.Getter;

/* 상장종목정보 requestDto */
@Getter
public class StockItemInfoRequestDto extends KrxBaseRequestDto {
    private final String basDt;
    private final String beginBasDt;
    private final String endBasDt;
    private final String likeBasDt;
    private final String likeSrtnCd;
    private final String isinCd;
    private final String likeIsinCd;
    private final String itmsNm;
    private final String likeItmsNm;
    private final String crno;
    private final String corpNm;
    private final String likeCorpNm;

    @Builder
    public StockItemInfoRequestDto(
            Integer numOfRows,
            Integer pageNo,
            String serviceKey,
            String basDt,
            String beginBasDt,
            String endBasDt,
            String likeBasDt,
            String likeSrtnCd,
            String isinCd,
            String likeIsinCd,
            String itmsNm,
            String likeItmsNm,
            String crno,
            String corpNm,
            String likeCorpNm
    ) {
        super(numOfRows, pageNo, serviceKey);
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