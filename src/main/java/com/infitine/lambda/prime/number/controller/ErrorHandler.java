package com.infitine.lambda.prime.number.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ErrorHandler {

    public final Object ERROR_MESSAGE = "Wrong input, must be a number, between -2 147 483 648 and 2 147 483 647";

    @ExceptionHandler({NumberFormatException.class})
    public ResponseEntity<Object> handleNumberFormatException(NumberFormatException e) {
        String error = ERROR_MESSAGE.toString();
        return buildResponseEntity(new ApiError(BAD_REQUEST, error, e));
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<Object>(apiError, apiError.getStatus());
    }
}
