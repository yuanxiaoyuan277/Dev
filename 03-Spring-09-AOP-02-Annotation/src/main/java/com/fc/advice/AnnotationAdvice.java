package com.fc.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

//切面类
@Aspect
public class AnnotationAdvice {
    @Pointcut("execution(* com.fc.service.impl.*ServiceImpl.*(..))")
    public static void pointcut(){}

    @Before("AnnotationAdvice.pointcut()")
    public void before(){
        System.out.println("前置通知，方法执行前执行~");
    }

    @AfterReturning("AnnotationAdvice.pointcut()")
    public void afterReturning(){
        System.out.println("后置通知，方法正常返回后执行~");
    }

    @After("AnnotationAdvice.pointcut()")
    public void after(){
        System.out.println("最终通知，无论是否发生异常都会执行~");
    }

    @AfterThrowing("AnnotationAdvice.pointcut()")
    public void afterThrowing (){
        System.out.println("异常通知，方法执行异常执行~");
    }

    @Around("AnnotationAdvice.pointcut()")
    public Object around(ProceedingJoinPoint joinPoint)throws Throwable{
        System.out.println("环绕通知————前置");

        Object proceed = joinPoint.proceed();

        System.out.println("环绕通知————后置");

        return proceed;
    }
}
