package com.batra.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class RestControllerAdviceHandler {
    private static final Logger LOG = LoggerFactory.getLogger(RestControllerAdviceHandler.class);

    public RestControllerAdviceHandler() {
    }

    @ExceptionHandler({RestBaseException.class})
    public ResponseEntity<ApiError> appNotFound(RestBaseException ex) {
        LOG.error("Data Not Found");
        return this.error(ex.getMessage(), ex.getCode());
    }

    private ResponseEntity<ApiError> error(final String message, final Integer code) {
        ApiError response = new ApiError();
        response.setCode(code);
        response.setMessage(message);
        return new ResponseEntity(response, HttpStatus.valueOf(code));
    }
}
