package com.example.demo_openfeign;

import com.example.demo_openfeign.clients.BoredServiceClient;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final BoredServiceClient boredServiceClient;

    @GetMapping(value = "/bored", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getActivity(){
        return boredServiceClient.getActivity();
    }

    @GetMapping(value = "/listly", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getLists(@RequestParam String url){
        URI uri = URI.create("https://list.ly/api/v4/meta?url=" + url);
        return boredServiceClient.dynamicUrl(uri);
    }
}
