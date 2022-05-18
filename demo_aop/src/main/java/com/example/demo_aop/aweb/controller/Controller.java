package com.example.demo_aop.aweb.controller;

import com.example.demo_aop.config.Audit;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Controller {

    @Audit
    public int controllerAnnotated(int p){
        System.out.println("controllerAnnotated");
        return p;
    }

    public int controller(int p){
        System.out.println("controller");
        return p;
    }
}
