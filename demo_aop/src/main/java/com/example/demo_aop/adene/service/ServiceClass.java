package com.example.demo_aop.adene.service;

import com.example.demo_aop.config.Audit;

import org.springframework.stereotype.Component;

@Component
public class ServiceClass {

    @Audit
    public String serviceClassAnnotated(String param) {
        System.out.println("serviceClassAnnotated");
        return "annotation";
    }

    public String serviceClass(String param) {
        System.out.println("serviceClass");
        return "component";
    }

}
