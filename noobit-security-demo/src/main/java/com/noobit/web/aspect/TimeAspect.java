package com.noobit.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
public class TimeAspect {
    @Pointcut(value = "execution(* com.noobit.web.controller.UserController.*(..))")
    public void time() {}

    @Around("time()")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) {
        System.out.println("time aspect start");
        long start = new Date().getTime();
        Object result = null;
        try {
            result = pjp.proceed();
            Arrays.stream(pjp.getArgs()).forEach(System.out::println);
            long end = new Date().getTime();
            System.out.println("time aspect: " + (end - start));
            System.out.println("time aspect finish");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return  result;
    }

}
