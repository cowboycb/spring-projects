package com.example.demo_openfeign.clients;

import java.net.URI;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Bored-API", url = "http://www.boredapi.com/api/activity/",
    fallbackFactory = BoredServiceFallbackFactory.class)
public interface BoredServiceClient {

    @GetMapping
    String getActivity();

    @GetMapping
    String dynamicUrl(URI baseUri);
}
