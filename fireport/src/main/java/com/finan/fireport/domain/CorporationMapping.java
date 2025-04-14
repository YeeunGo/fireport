package com.finan.fireport.domain;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "corporation_mapping")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class CorporationMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 8, nullable = false, unique = true)
    private String corpCode; // 공시고유번호 (DART)

    @Column(length = 13)
    private String crno; // 법인등록번호 (공공API 기준)

    @Column(length = 240, nullable = false)
    private String corpName; // 법인명 (DART/공공 API)

    @Column(length = 6)
    private String stockCode; // 종목코드(DART)

    @Column(length = 20)
    private String marketType; // KOSPI / KOSDAQ / KONEX

    private String modifyDate; // DART 기준 변경일자
}