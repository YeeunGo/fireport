package com.finan.fireport.infrastructure.api.util;

import com.finan.fireport.infrastructure.api.util.testdto.TestRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class QueryStringConverterTest {
    @Test
    @DisplayName("DTO -> 쿼리 스트링 정상 변환")
    void convertDtoToParam_basic() {
        // given
        TestRequestDto dto = new TestRequestDto("예은", 1);
        String encodedName = URLEncoder.encode(dto.getName(), StandardCharsets.UTF_8);

        // when
        String result = QueryStringConverter.convertDtoToParam(dto);

        // then
        assertThat(result).isEqualTo("?name="+encodedName+"&page=1");
    }
}
