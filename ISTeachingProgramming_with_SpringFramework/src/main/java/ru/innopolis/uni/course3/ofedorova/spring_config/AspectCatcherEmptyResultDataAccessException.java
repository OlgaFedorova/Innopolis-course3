package ru.innopolis.uni.course3.ofedorova.spring_config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Collections;

/**
 * Аспект для перехвата исключительной ситуации EmptyResultDataAccessException в DOA через JDBC.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 06.01.2017
 */
@Aspect
public class AspectCatcherEmptyResultDataAccessException {
    /**
     * Точка сопряжения, в которой необходимо вернуть null.
     */
    @Pointcut("execution(* ru.innopolis.uni.course3.ofedorova.dao.users.JdbcOfDAOtoUsers.getByName(..))"
            + "|| execution(* ru.innopolis.uni.course3.ofedorova.dao.users.JdbcOfDAOtoUsers.getById(..))"
            + "|| execution(* ru.innopolis.uni.course3.ofedorova.dao.tasks.JdbcOfDAOtoTasks.getById(..))")
    public void needReturnNull() {
    }

    /**
     * Метод обрамляет вызов целевого метода в точке сопряжения "needReturnNull()".
     *
     * @param pjp обязательный аргумент ProceedingJoinPoint.
     * @return null.
     * @throws Throwable возможная исключительная ситуация
     */
    @Around("needReturnNull()")
    public Object returnUserNull(ProceedingJoinPoint pjp) throws Throwable {
        try {
            return pjp.proceed();
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    /**
     * Точка сопряжения, в которой необходимо вернуть пустой Map.
     */
    @Pointcut("execution(* ru.innopolis.uni.course3.ofedorova.dao.users.JdbcOfDAOtoUsers.getPasswordAndSalt(..))")
    public void needReturnEmptyMap() {
    }

    /**
     * Метод обрамляет вызов целевого метода в точке сопряжения "needReturnEmptyMap()".
     *
     * @param pjp обязательный аргумент ProceedingJoinPoint.
     * @return null.
     * @throws Throwable возможная исключительная ситуация
     */
    @Around("needReturnEmptyMap()")
    public Object returnEmptyMap(ProceedingJoinPoint pjp) throws Throwable {
        try {
            return pjp.proceed();
        } catch (EmptyResultDataAccessException ex) {
            return Collections.EMPTY_MAP;
        }
    }
}
