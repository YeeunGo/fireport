package com.finan.fireport.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Embeddable
public class StockIssueInfoId  implements Serializable {
    private LocalDate basDt;             // 기준일자
    private String crno;                 // 법인등록번호

    public void setCrno(String crno) {
        this.crno = crno;
    }

    public void setBasDt(LocalDate basDt) {
        this.basDt = basDt;
    }
}
