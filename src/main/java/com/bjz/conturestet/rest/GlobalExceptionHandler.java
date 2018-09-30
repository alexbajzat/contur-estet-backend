package com.bjz.conturestet.rest;

import com.bjz.conturestet.rest.response.APIError;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Brought to life by bjz on 10/1/2018.
 */
@RestControllerAdvice
@Order(value = 9999)
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIError> handleAnyException(Exception e) {
        return new ResponseEntity<>(new APIError()
                .setCode(APIError.ErrorCode.UNKNOWN)
                .setMessage("Operation not supported"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
