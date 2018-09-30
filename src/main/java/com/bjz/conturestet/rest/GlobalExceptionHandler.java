package com.bjz.conturestet.rest;

import com.bjz.conturestet.rest.response.APIError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIError> handleAnyException(Exception e) {
        LOGGER.error(e.getMessage(), e);
        return new ResponseEntity<>(new APIError()
                .setCode(APIError.ErrorCode.UNKNOWN)
                .setMessage("Something went wrong"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
