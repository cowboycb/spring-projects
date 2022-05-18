/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2021. All rights reserved.
 */

package com.example.demo_aop.config;

import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class AopConfigurer {
    @Autowired
    private AuditLogInterceptor auditLogInterceptor;

    @Bean
    public AuditLogInterceptor getAuditLogInterceptor() {
        return new AuditLogInterceptor();
    }

    @Bean
    public AspectJExpressionPointcutAdvisor configurabledvisor() {
        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        //within(com.huawei.iocc.fdi..controller..*)
        advisor.setExpression(
            "("
                + "within(com.example.demo_aop..*)"
                + " || "
                + "within(com.example.demo_aop..third.*)"
             + ") "
                + "&& @annotation(com.example.demo_aop.config.Audit)");
//        advisor.setExpression(
//            "("
//                + "within(com.huawei.iocc.fdi..controller..*)"
//                + " || "
//                + "within(com.huawei.iocc.fdi..controller.*)"
//                + ") "
//                + "&& @annotation(com.example.demo_aop.config.Audit)");
        advisor.setAdvice(auditLogInterceptor);
        return advisor;
    }
}
