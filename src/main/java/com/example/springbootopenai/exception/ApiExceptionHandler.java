package com.example.springbootopenai.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodNotValidArgumentException(MethodArgumentNotValidException exception) {
        final List<String> errorList = new ArrayList<>();
        for (final FieldError error : exception.getBindingResult().getFieldErrors()) {
            errorList.add(error.getField() + " : " + error.getDefaultMessage());
        }
        log.error(exception.getMessage(), exception);
        return new ErrorResponse(LocalDateTime.now(), errorList.toString());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleGeneralException(Exception exception) {
        log.error(exception.getMessage(), exception);
        return new ErrorResponse(LocalDateTime.now(), exception.getCause().getMessage());
    }



}
