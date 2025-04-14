package com.finan.fireport.infrastructure.api.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

public class QueryStringConverter {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static <T> String convertDtoToParam(T dto){
        Map<String, Object> paramMap = objectMapper.convertValue(dto, new TypeReference<>() {});

        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
        paramMap.forEach((key, value) -> {
            if (value != null) {
                builder.queryParam(key, value.toString());
            }
        });

        return builder.encode().toUriString();

    }
}
