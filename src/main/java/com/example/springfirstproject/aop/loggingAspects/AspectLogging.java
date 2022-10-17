package com.example.springfirstproject.aop.loggingAspects;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(10)
@Slf4j
public class AspectLogging {

    @Around("com.example.springfirstproject.aop.pointcuts.DAOPointcuts.allDAOMethods()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Class name : {}  method : {} \n with following parameters: {}",
                joinPoint.getTarget().getClass().getName(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));
        try {
            Object result = joinPoint.proceed();
            log.info("Class name : {} \n Method result: {}",joinPoint.getTarget().getClass().getName(),
                    result);
            return result;
        } catch (Throwable e) {
            log.error("Something go wrong. Class : {} \n Method : {} \n Parameters : {} \n Error : {} \n Trace : {}",
                    joinPoint.getTarget().getClass().getName(),
                    joinPoint.getSignature().getName(),
                    Arrays.toString(joinPoint.getArgs()),
                    e.getMessage(),
                    e.getStackTrace());
            throw e;
        }
    }
}