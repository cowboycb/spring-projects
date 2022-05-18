package com.example.demo_aop.aweb;

import com.example.demo_aop.config.Audit;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WebClass {

    @Audit
    public String webClassAnnotated(String param) {
        System.out.println("webClassAnnotated");
        return "annotation";
    }

    public String webClass(String param) {
        System.out.println("webClass");
        return "component";
    }
}
