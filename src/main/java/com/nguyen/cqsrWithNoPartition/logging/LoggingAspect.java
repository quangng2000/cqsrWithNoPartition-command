package com.nguyen.cqsrWithNoPartition.logging;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.nguyen.cqsrWithNoPartition.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Executing method: {}", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.nguyen.cqsrWithNoPartition.service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Method {} returned value: {}", joinPoint.getSignature().getName(), result);
    }

    @AfterThrowing(pointcut = "execution(* com.nguyen.cqsrWithNoPartition.service.*.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        logger.error("Method {} threw exception: {}", joinPoint.getSignature().getName(), exception.getMessage());
    }

    @After("execution(* com.nguyen.cqsrWithNoPartition.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("Finished executing method: {}", joinPoint.getSignature().getName());
    }
}

