package com.udea.rest.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ErrorLogAspect {

    private static final Logger log = LoggerFactory.getLogger(ErrorLogAspect.class);

    @AfterThrowing(pointcut = "execution(* com.udea.rest.service..*(..))", throwing = "e")
    public void logError(Throwable e) {
        log.error(e.getMessage());
    }
}
