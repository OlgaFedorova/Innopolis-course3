package ru.innopolis.uni.course3.ofedorova.spring.config;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * Класс для перехвата исключительных ситуаций пакета "ru.innopolis.uni.course3.ofedorova.dao.exceptions".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 11.01.2017
 */
public class MyExceptionResolver extends SimpleMappingExceptionResolver {

    /**
     * Метод возвращает модель и представление.
     *
     * @param viewName
     * @param ex
     * @return
     */
    @Override
    protected ModelAndView getModelAndView(String viewName, Exception ex) {
        return super.getModelAndView(viewName, ex);
    }

}
