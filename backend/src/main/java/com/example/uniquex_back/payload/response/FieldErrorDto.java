package com.example.uniquex_back.payload.response;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class FieldErrorDto implements Serializable {

    private final String objectName;

    private final String field;

    private final String message;

    public FieldErrorDto(String dto, String field, String message) {
        this.objectName = dto;
        this.field = field;
        this.message = message;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }

}
