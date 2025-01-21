package com.bigcorp.booking.cours.core.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
    @Before("execution(public * com.bigcorp.booking.cours.core.service.*.*(..))")
    // pointcut : la cible à exécuter
    // On pourrait utiliser logBefore(JoinPoint jp) pour récupérer les arguments
    // de la méthode
    public void logBefore() {
        System.out.println("Une méthode va être appelée ");
    }

    @AfterReturning(pointcut = "execution(public * com.bigcorp.booking.cours.core.service.*.*(..))", returning = "machin")
    // // pointcut : la cible à exécuter
    public void log(Object machin) {
        System.out.println("Une méthode a été appelée, et a renvoyé : " + machin);
    }

    // Advice 'autour' des méthodes de la classe SlowService
    @Around("execution(public * com.bigcorp.booking.cours.core.service.CompanyService.*(..))")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("La méthode va s'exécuter !!!");
        long startTime = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("La méthode s'est exécutée avec le résultat : " + retVal);
        System.out.println("Elle a pris : " + (endTime - startTime) + " ms ");
        return retVal;
    }

}
