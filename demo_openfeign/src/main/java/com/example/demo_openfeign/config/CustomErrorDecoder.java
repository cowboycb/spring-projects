package com.example.demo_openfeign.config;

import com.example.demo_openfeign.exception.RestApiClientException;
import com.example.demo_openfeign.exception.RestApiServerException;

import feign.Response;
import feign.codec.ErrorDecoder;

import org.springframework.http.HttpStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String mmethod, Response response) {
        log.info("Method ======= {} =======", mmethod);
        String requestUrl = response.request().url();
        Response.Body responseBody = response.body();
        HttpStatus responseStatus = HttpStatus.valueOf(response.status());

        if (responseStatus.is5xxServerError()) {
            return new RestApiServerException(requestUrl, responseStatus, responseBody);
        } else if (responseStatus.is4xxClientError()) {
            return new RestApiClientException(requestUrl, responseStatus, responseBody);
        } else {
            return new Exception("Generic exception");
        }
    }
}
