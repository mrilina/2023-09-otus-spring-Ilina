package ru.otus.hw.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * Аспекты, реализуют логирование начала и окончания работы методов репозитория.
 *
 * @author Irina Ilina
 */
@Component
@Aspect
public class LoggingAspect {

    /**
     * Применяет аспект.
     *
     * @param proceedingJoinPoint точка
     * @return результат
     * @throws Throwable исключительная ситуация
     */
    @Around("execution(* ru.otus.hw.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();

        System.out.println("Begin of method " + methodName);

        var targetMethodResult = proceedingJoinPoint.proceed();

        System.out.println("end of method " + methodName);

        return targetMethodResult;
    }
}
