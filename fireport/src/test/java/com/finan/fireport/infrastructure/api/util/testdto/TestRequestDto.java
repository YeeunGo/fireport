package com.finan.fireport.infrastructure.api.util.testdto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class TestRequestDto {
    private String name;
    private Integer number;
    private String key;
}