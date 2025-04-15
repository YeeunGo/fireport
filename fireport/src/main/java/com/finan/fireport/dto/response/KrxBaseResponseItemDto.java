package com.finan.fireport.dto.response;

public class KrxBaseResponseItemDto<T> {
    protected final KrxHeader header;
    protected final KrxBody<T> body;

    public KrxBaseResponseItemDto(KrxHeader header, Integer pageNo, String serviceKey, KrxBody<T> body) {
        this.header = header;
        this.body = body;
    }
}
