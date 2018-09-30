package com.bjz.conturestet.rest;

import com.bjz.conturestet.exception.LoginException;
import com.bjz.conturestet.exception.NotFoundException;
import com.bjz.conturestet.exception.RegisterException;
import com.bjz.conturestet.rest.response.APIError;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Brought to life by bjz on 9/30/2018.
 */
@RestControllerAdvice
@Order(value = 9998)
public class GlobalBusinessExceptionHandler {
    @ExceptionHandler(NotImplementedException.class)
    public ResponseEntity<APIError> handleImplementationException(NotImplementedException e) {
        return new ResponseEntity<>(new APIError()
                .setCode(APIError.ErrorCode.NOT_PERMITTED)
                .setMessage("Operation not supported"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RegisterException.class)
    public ResponseEntity<APIError> handleRegistrationException(RegisterException e) {
        return new ResponseEntity<>(new APIError()
                .setCode(APIError.ErrorCode.BAD_REGISTER)
                .setMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<APIError> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(new APIError()
                .setCode(APIError.ErrorCode.NOT_FOUND)
                .setMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<APIError> handleLoginException(LoginException e) {
        return new ResponseEntity<>(new APIError()
                .setCode(APIError.ErrorCode.BAD_LOGIN)
                .setMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
