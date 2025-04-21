package com.finan.fireport.infrastructure.api.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RequiredArgsConstructor
public class QueryStringConverter {
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    public static <T> String convertDtoToParam(T dto){
        Map<String, Object> paramMap = mapper.convertValue(dto, new TypeReference<>() {});

        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
        paramMap.forEach((key, value) -> {
            if (value != null) {
                builder.queryParam(key, value.toString());
            }
        });

        return builder.toUriString();

    }
}
