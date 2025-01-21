package com.bigcorp.booking.cours.core.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdvancedPointCut {

    @Before("execution(public * *(..)) && withinMyServices()")
    public void logBefore() {
        System.out.println("Utilisation de pointcut enregistré avec @Pointcut avant la méthode.");
    }

    public void logAfter() {
        System.out.println("Utilisation de pointcut enregistré avec @Pointcut avant la méthode.");
    }

    @Pointcut("execution(public * com.bigcorp.booking.cours.core.service.*.*(..))")
    public void getServiceMethod() {
    }

    @Pointcut("within(com.bigcorp.booking.cours.core.service.*)")
    public void withinMyServices() {

    }

}
