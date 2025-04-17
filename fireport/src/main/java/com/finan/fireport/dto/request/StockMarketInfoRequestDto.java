package com.finan.fireport.dto.request;

import lombok.Builder;
import lombok.Getter;

/*주식시세 requestDto*/
@Getter
public class StockMarketInfoRequestDto extends KrxBaseRequestDto {

    private final String basDt;
    private final String beginBasDt;
    private final String endBasDt;
    private final String likeBasDt;
    private final String likeSrtnCd;
    private final String isinCd;
    private final String likeIsinCd;
    private final String itmsNm;
    private final String likeItmsNm;
    private final String mrktCls;
    private final String beginVs;
    private final String endVs;
    private final String beginFltRt;
    private final String endFltRt;
    private final String beginTrqu;
    private final String endTrqu;
    private final String beginTrPrc;
    private final String endTrPrc;
    private final String beginLstgStCnt;
    private final String endLstgStCnt;
    private final String beginMrktTotAmt;
    private final String endMrktTotAmt;

    @Builder
    public StockMarketInfoRequestDto(
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
            String mrktCls,
            String beginVs,
            String endVs,
            String beginFltRt,
            String endFltRt,
            String beginTrqu,
            String endTrqu,
            String beginTrPrc,
            String endTrPrc,
            String beginLstgStCnt,
            String endLstgStCnt,
            String beginMrktTotAmt,
            String endMrktTotAmt
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
        this.mrktCls = mrktCls;
        this.beginVs = beginVs;
        this.endVs = endVs;
        this.beginFltRt = beginFltRt;
        this.endFltRt = endFltRt;
        this.beginTrqu = beginTrqu;
        this.endTrqu = endTrqu;
        this.beginTrPrc = beginTrPrc;
        this.endTrPrc = endTrPrc;
        this.beginLstgStCnt = beginLstgStCnt;
        this.endLstgStCnt = endLstgStCnt;
        this.beginMrktTotAmt = beginMrktTotAmt;
        this.endMrktTotAmt = endMrktTotAmt;
    }
}