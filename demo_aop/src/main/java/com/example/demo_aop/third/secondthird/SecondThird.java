package com.example.demo_aop.third.secondthird;

import com.example.demo_aop.config.Audit;

import org.springframework.stereotype.Component;

@Component
public class SecondThird {
    @Audit
    public void secondThirdAnnotated(){
        System.out.println("secondThirdAnnotated");
    }

    public void secondThird(){
        System.out.println("secondThird");
    }
}
