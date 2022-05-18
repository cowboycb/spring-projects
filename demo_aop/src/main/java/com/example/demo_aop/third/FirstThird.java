package com.example.demo_aop.third;

import com.example.demo_aop.config.Audit;

import org.springframework.stereotype.Component;

@Component
public class FirstThird {

    @Audit
    public void firstThirdAnnotated(){
        System.out.println("firstThirdAnnotated");
    }

    public void firstThird(){
        System.out.println("firstThird");
    }
}
