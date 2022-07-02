package com.example.demo_openfeign.clients;

import feign.FeignException;
import java.net.URI;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BoredServiceFallbackFactory implements FallbackFactory<BoredServiceClient> {
    @Override
    public BoredServiceClient create(Throwable cause) {
        String httpStatus = cause instanceof FeignException ? Integer.toString(((FeignException) cause).status()) : "";

        return new BoredServiceClient() {
            @Override
            public String getActivity() {
                return null;
            }

            @Override
            public String dynamicUrl(URI baseUri) {
                log.error("{} is called and returned {}", baseUri, httpStatus);
                return "EMPTY";
            }
        };
    }
}
