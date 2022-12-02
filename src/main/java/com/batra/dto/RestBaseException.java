package com.batra.dto;


public class RestBaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final Integer code;
    private final String message;

    public RestBaseException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
