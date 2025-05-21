package com.finan.fireport.dto.response;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class KrxBaseResponseDto<T> {
    private KrxBaseResponseItemDto<T> response;

    public List<T> getItems() {
        if (response == null || response.getBody() == null || response.getBody().getItems() == null) {
            return Collections.emptyList();
        }

        return response.getBody().getItems().getItem();
    }
}