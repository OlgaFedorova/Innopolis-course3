package ru.innopolis.uni.course3.ofedorova.constants;

import org.springframework.security.core.context.SecurityContextHolder;
import ru.innopolis.uni.course3.ofedorova.models.User;

/**
 * Класс содержит общие методы для работы с Spring-контроллерами.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.12.2016
 */
public class MVCControllersCommonFunctions {
    /**
     * Метод возвращает авторизованного пользователя.
     *
     * @return авторизованный пользователь.
     */
    public static User getUserFromSession() {
        User user = null;
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null && SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User) {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        return user;
    }

    /**
     * Метод возвращает строку переадресации на страницу с информацией о том, что пользователь уже авторизован.
     *
     * @return
     */
    public static String redirectInfoAboutAuthorization() {
        return "redirect:/info-about-authorization";
    }
}
