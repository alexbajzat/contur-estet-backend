package com.bjz.conturestet.rest;

import com.bjz.conturestet.exception.NotFoundException;
import com.bjz.conturestet.exception.RegisterException;
import com.bjz.conturestet.rest.response.APIError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Brought to life by bjz on 9/30/2018.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotImplementedException.class)
    public ResponseEntity<APIError> handleImplementationException(Exception e) {
        return new ResponseEntity<>(new APIError()
                .setCode(APIError.ErrorCode.NOT_PERMITTED)
                .setMessage("Operation not supported"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RegisterException.class)
    public ResponseEntity<APIError> handleRegistrationException(Exception e) {
        return new ResponseEntity<>(new APIError()
                .setCode(APIError.ErrorCode.BAD_REGISTER)
                .setMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<APIError> handleNotFoundException(Exception e) {
        return new ResponseEntity<>(new APIError()
                .setCode(APIError.ErrorCode.NOT_FOUND)
                .setMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
    }


}
