package com.finan.fireport.domain;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class StockIssueInfoId  implements Serializable {
    private LocalDate basDt;             // 기준일자
    private String crno;                 // 법인등록번호
}
