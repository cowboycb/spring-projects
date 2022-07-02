package com.example.demo_openfeign;

import com.example.demo_openfeign.exception.RestApiClientException;
import com.example.demo_openfeign.exception.RestApiServerException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ RestApiClientException.class, RestApiServerException.class })
    public ResponseEntity<String> clientException(RestApiClientException se) {
        return ResponseEntity
            .status(se.getHttpStatus())
            .contentType(MediaType.APPLICATION_JSON)
            .body(se.getContent());
    }
}
