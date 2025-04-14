package com.finan.fireport.infrastructure.api.util.testdto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TestRequestDto {
    private String name;
    private Integer page;
}