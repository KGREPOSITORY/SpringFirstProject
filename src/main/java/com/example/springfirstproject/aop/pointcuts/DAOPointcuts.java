package com.example.springfirstproject.aop.pointcuts;

import org.aspectj.lang.annotation.Pointcut;

public class DAOPointcuts {

    @Pointcut("execution(* com.example.springfirstproject.dao.*Service.*())")
    public void allDAOMethodsWithParameters(){};

    @Pointcut("execution(* com.example.springfirstproject.dao.*Service.*(..))")
    public void allDAOMethodsWithoutParameters(){};

    @Pointcut("allDAOMethodsWithoutParameters() || allDAOMethodsWithParameters()")
    public void allDAOMethods(){};

}
