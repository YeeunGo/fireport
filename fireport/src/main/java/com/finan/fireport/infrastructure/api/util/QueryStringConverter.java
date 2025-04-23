package com.finan.fireport.infrastructure.api.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

@RequiredArgsConstructor
public class QueryStringConverter {


    public static <T> String convertDtoToParam(T dto) {
        Map<String, Object> paramMap = extractAllFields(dto);

        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
        paramMap.forEach((key, value) -> {
            if (value != null) {
                builder.queryParam(key, value.toString());
            }
        });

        return builder.toUriString();
    }

    private static Map<String, Object> extractAllFields(Object dto) {
        Map<String, Object> paramMap = new LinkedHashMap<>();
        Class<?> currentClass = dto.getClass();

        while (currentClass != null && currentClass != Object.class) {
            for (Field field : currentClass.getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    Object value = field.get(dto);
                    if (value != null) {
                        paramMap.put(field.getName(), value);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("필드 접근 오류: " + field.getName(), e);
                }
            }
            currentClass = currentClass.getSuperclass();
        }

        return paramMap;
    }


//    private static final ObjectMapper mapper = new ObjectMapper();
//
//    static {
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//    }
//
//
//    public static <T> String convertDtoToParam(T dto){
//        Map<String, Object> paramMap = mapper.convertValue(dto, new TypeReference<>() {});
//
//        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
//        paramMap.forEach((key, value) -> {
//            if (value != null) {
//                builder.queryParam(key, value.toString());
//            }
//        });
//
//        return builder.toUriString();
//
//    }
}
