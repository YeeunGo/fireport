package com.finan.fireport.exception;

public enum ErrorCode {
    BAD_REQUEST("400", "잘못된 요청입니다."),
    SERVER_ERROR("500", "서버 오류입니다.");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}