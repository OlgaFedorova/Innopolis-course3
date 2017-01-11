package ru.innopolis.uni.course3.ofedorova.constants;

import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
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
     * Метод возвращает пользователя, сохраненного в сессии.
     *
     * @param model хранилище для пользователя сессии.
     * @return пользователь сессии.
     */
    public static User getUserFromSession(Model model) {
        return (User) ((BindingAwareModelMap) model).get("userSession");
    }

    /**
     * Метод сохраняет пользователя в сессию.
     *
     * @param model хранилище для пользователя сессии.
     * @param user  пользователь сессии.
     */
    public static void setUserInSession(Model model, User user) {
        model.addAttribute("userSession", user);
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
