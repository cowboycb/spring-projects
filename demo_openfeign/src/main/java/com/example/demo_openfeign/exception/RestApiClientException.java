package com.example.demo_openfeign.exception;

import feign.Response;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class RestApiClientException extends Exception {

    private final String content;
    private final HttpStatus httpStatus;

    public RestApiClientException(String requestUrl, HttpStatus responseStatus,
                                  Response.Body responseBody) {
        super("A Client exception was thrown from " + requestUrl);
        this.content = getContent(responseBody);
        this.httpStatus = responseStatus;
        log.error("Client exception handled {}, {}", requestUrl, content);
    }

    private String getContent(Response.Body responseBody) {
        try {
            return IOUtils.toString(responseBody.asInputStream(), StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            log.error("Response content couldn't be read ", e);
            return "";
        }
    }
}
