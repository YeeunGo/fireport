package com.finan.fireport.mapper;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DateMapper {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    public LocalDate stringToLocalDate(String date) {
        return LocalDate.parse(date, FORMATTER);
    }

    public String localDateToString(LocalDate date) {
        return date.format(FORMATTER);
    }
}