package com.finan.fireport.infrastructure.api.util;

import com.finan.fireport.infrastructure.api.util.testdto.TestRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QueryStringConverterTest {

    private final String decodingKey = "9S5dMgXb5JB+";
    private final String encodingKey = "9S5dMgXb5JB%";

    @Test
    @DisplayName("dto -> 쿼리스트링 정상 변환")
    void convertDtoToParam_shouldSucceed() {
        // given
        TestRequestDto dto = TestRequestDto.builder()
                .name("길동이")
                .number(2)
                .build();
        String encoded = URLEncoder.encode(dto.getName(), StandardCharsets.UTF_8);

        // when
        String result = QueryStringConverter.convertDtoToParam(dto);

        // then
        assertThat(result).isEqualTo("?name="+encoded+"&number=2");
    }

    @Test
    @DisplayName("decodingKey를 인코딩한 값과 encodingKey가 다름을 확인한다")
    void convertDtoToParam_testDecodedKey_shouldNotBeEqual() {
        // given
        TestRequestDto dto = new TestRequestDto("yego", 1, decodingKey);
        String encoded = URLEncoder.encode(dto.getName(), StandardCharsets.UTF_8);

        // when
        String result = QueryStringConverter.convertDtoToParam(dto);

        // then
        assertThat(result).isNotEqualTo("?name="+encoded+"&number=1&key="+encodingKey);
    }
}
