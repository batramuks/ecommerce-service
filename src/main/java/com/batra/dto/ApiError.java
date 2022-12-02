package com.batra.dto;


public class ApiError {
    private Integer code = null;
    private String message = null;

    public ApiError() {
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

