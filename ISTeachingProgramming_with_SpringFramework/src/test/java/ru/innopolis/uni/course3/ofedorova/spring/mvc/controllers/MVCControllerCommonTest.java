package ru.innopolis.uni.course3.ofedorova.spring.mvc.controllers;

import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Created by Olga on 11.01.2017.
 */
public class MVCControllerCommonTest {

    /**
     * Метод тестирует отображение главной страницы, пользователь авторизован в сессии.
     */
    @Test
    public void whenShowHomePageAndUserAuthorized() {
        /*
        final MVCControllerCommon mvcControllerCommon = new MVCControllerCommon();
        final Model model = ModelFactory.getModelWithUserSession();
        final String expected = "index";
        final String actual = mvcControllerCommon.showHomePage((Model) model);
        assertTrue(expected.equals(actual)
                && ((User)model.asMap().get("usersession")).getUsername().equals(model.asMap().get("username")));
                */
    }

    @Test
    public void whenShowPageError() {

    }
}