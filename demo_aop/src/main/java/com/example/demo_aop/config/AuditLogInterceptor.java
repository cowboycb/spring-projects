package com.example.demo_aop.config;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuditLogInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object var3 = null;
        try {
            var3 = invocation.proceed();
            System.out.println("INVOKED - {}" + invocation.getMethod().getName());
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        return var3;
    }
}
