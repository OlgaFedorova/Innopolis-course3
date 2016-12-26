package ru.innopolis.uni.course3.ofedorova.servlets;

import com.google.common.base.Charsets;
import ru.innopolis.uni.course3.ofedorova.models.User;

import javax.servlet.http.HttpSession;

/**
 * Класс содержит общие методы для работы с сервлетами.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.12.2016
 */
public class ServletsCommon {
    /**
     * Значение кодировки для UTF-8.
     */
    public static final String UTF_8 = Charsets.UTF_8.toString();

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
        session.setAttribute("user", user);;
    }
}
