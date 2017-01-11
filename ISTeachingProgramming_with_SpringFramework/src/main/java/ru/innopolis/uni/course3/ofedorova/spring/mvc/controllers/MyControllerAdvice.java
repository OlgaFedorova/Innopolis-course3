package ru.innopolis.uni.course3.ofedorova.spring.mvc.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Класс для перехвата специфических исключительных ситуаций..
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 11.01.2017
 */
@ControllerAdvice
public class MyControllerAdvice {

    /**
     * Метод возвращает представление для отображения информации об ошибки NullPointerException.
     * @return представление для отображения информации об ошибки.
     */
    @ExceptionHandler(NullPointerException.class)
    public ModelAndView catchNullPointerException(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/error");
        mv.addObject("exception", e);
        return mv;
    }
}
