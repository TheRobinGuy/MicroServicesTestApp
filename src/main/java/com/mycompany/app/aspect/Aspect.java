package com.mycompany.app.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;
import java.util.Arrays;

@org.aspectj.lang.annotation.Aspect
@Named
public class Aspect {

  private double start;
  private double now;
  private double timeTaken;

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Before("execution(* com.mycompany.app.restful.ProductController.*(..))")
  public void before(JoinPoint joinPoint){
    start = System.currentTimeMillis();
    System.out.println("Before : ");
    System.out.println(joinPoint.getSignature().getName() + ". Arguments : " + Arrays.toString(joinPoint.getArgs()));
  }

  @Around("@annotation(com.mycompany.app.aspect.RecordTiming)")
  public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
    long startTime = System.currentTimeMillis();

    Object proceed = joinPoint.proceed();

    long timeTaken = System.currentTimeMillis() - startTime;

    logger.info("{} executed in {}ms with parameters : {}", joinPoint.getSignature().getName(), timeTaken, Arrays.toString(joinPoint.getArgs()));
    //System.out.println("Time Taken by " + joinPoint + " is " + timeTaken);
    return proceed;
  }

  @AfterReturning(pointcut = "execution(* com.mycompany.app.restful.ProductController.*(..))", returning = "result")
  public void after(JoinPoint joinPoint, Object result){
    now = System.currentTimeMillis();
    timeTaken = (now - start) / 1000.0;
    System.out.println("After : ");
    System.out.println(joinPoint.getSignature().getName() + " Returned : " + result);
    System.out.println("Method executed in " + timeTaken + "s");
  }
}
