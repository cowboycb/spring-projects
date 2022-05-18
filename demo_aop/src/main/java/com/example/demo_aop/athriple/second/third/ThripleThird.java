package com.example.demo_aop.athriple.second.third;

import com.example.demo_aop.config.Audit;

import org.springframework.stereotype.Component;

@Component
public class ThripleThird {

    @Audit
    public void thriplePackageAnnotated(){
        System.out.println("thripleThirdPackageAnnotated");
    }

    public void thriplePackage(){
        System.out.println("thripleThirdPackage");
    }
}
