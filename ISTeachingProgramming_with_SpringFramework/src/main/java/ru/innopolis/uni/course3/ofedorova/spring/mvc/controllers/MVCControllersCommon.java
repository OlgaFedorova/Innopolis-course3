package ru.innopolis.uni.course3.ofedorova.spring.mvc.controllers;

import ru.innopolis.uni.course3.ofedorova.models.User;

import javax.servlet.http.HttpSession;

/**
 * Класс содержит общие методы для работы с сервлетами.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.12.2016
 */
public class MVCControllersCommon {
    /**
     * Значение кодировки для UTF-8.
     */
    public static final String UTF_8 = "UTF-8";

    /**
     * Метод возвращает пользователя, сохраненного в сессии.
     *
     * @param session текущая сессия.
     * @return пользователь сессии.
     */
    public static User getUserFromSession(HttpSession session) {
        return (User) session.getAttribute("user");
    }

    /**
     * Метод сохраняет пользователя в сессию.
     *
     * @param session текущая сессия.
     */
    public static void setUserInSession(HttpSession session, User user) {
        session.setAttribute("user", user);
    }

    /**
     * Метод возвращает строку переадресации на страницу с информацией об ошибке.
     * @return
     */
    public static String redirectErrorPage(){
        return "redirect:/error";
    }

    /**
     * Метод возвращает строку переадресации на страницу с информацией о том, что пользователь уже авторизован.
     * @return
     */
    public static String redirectInfoAboutAuthorization(){
        return "redirect:/info-about-authorization";
    }
}
