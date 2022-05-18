package com.example.demo_aop.adene;

import com.example.demo_aop.config.Audit;

import org.springframework.stereotype.Component;

@Component
public class DeneClass {
    @Audit
    public String deneClassAnnotated(String param) {
        System.out.println("deneClassAnnotated");
        return "annotation";
    }

    public String deneClass(String param) {
        System.out.println("deneClass");
        return "component";
    }
}
