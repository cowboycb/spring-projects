package com.example.demo_aop.runner;

import com.example.demo_aop.adene.DeneClass;
import com.example.demo_aop.adene.service.ServiceClass;
import com.example.demo_aop.athriple.second.third.ThripleThird;
import com.example.demo_aop.aweb.WebClass;
import com.example.demo_aop.aweb.controller.Controller;
import com.example.demo_aop.third.FirstThird;
import com.example.demo_aop.third.secondthird.SecondThird;

import java.time.Instant;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AopRunner implements ApplicationRunner {

    private final WebClass webClass;
    private final Controller controller;
    private final DeneClass deneClass;
    private final ServiceClass serviceClass;
    private final ThripleThird thripleThird;
    private final FirstThird firstThird;
    private final SecondThird secondThird;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        webClass.webClassAnnotated(Instant.now().toString());
        webClass.webClass(Instant.now().toString());

        controller.controller(3);
        controller.controllerAnnotated(4);

        deneClass.deneClassAnnotated(Instant.now().toString());
        deneClass.deneClass(Instant.now().toString());

        serviceClass.serviceClassAnnotated(Instant.now().toString());
        serviceClass.serviceClass(Instant.now().toString());

        thripleThird.thriplePackageAnnotated();
        thripleThird.thriplePackage();

        firstThird.firstThirdAnnotated();
        secondThird.secondThirdAnnotated();
    }
}
