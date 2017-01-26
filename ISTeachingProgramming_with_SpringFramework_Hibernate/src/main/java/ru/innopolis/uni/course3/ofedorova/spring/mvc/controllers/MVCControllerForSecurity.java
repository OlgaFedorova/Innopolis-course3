package ru.innopolis.uni.course3.ofedorova.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.uni.course3.ofedorova.constants.MVCControllersCommonFunctions;
import ru.innopolis.uni.course3.ofedorova.common.models.User;
import ru.innopolis.uni.course3.ofedorova.services.users.MainServiceForUsers;

/**
 * Spring-контроллер для работы с авторизацией пользователей.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 09.01.2017
 */
@Controller
public class MVCControllerForSecurity {
    /**
     * Объект-сервис для работы с данными пользователя.
     */
    private final MainServiceForUsers mainService;

    /**
     * Создает новый объект.
     *
     * @param mainService значение поля "mainService".
     */
    @Autowired
    public MVCControllerForSecurity(MainServiceForUsers mainService) {
        this.mainService = mainService;
    }

    /**
     * Метод отображает страницу для авторизации пользователя.
     *
     * @return view для отображения.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String logonUser() {
        String view = "";
        if (MVCControllersCommonFunctions.getUserFromSession() == null) {
            view = "/security/logon";
        } else {
            view = MVCControllersCommonFunctions.redirectInfoAboutAuthorization();
        }
        return view;
    }

    /**
     * Метод отображает информацию об авторизации пользователя.
     *
     * @param model объект модели, связанный с формой.
     * @return view для отображения.
     */
    @RequestMapping(value = "/info-about-authorization")
    public String infoAboutAuthorization(Model model) {
        User user = MVCControllersCommonFunctions.getUserFromSession();
        model.addAttribute("username", user == null ? "не авторизован" : user.getUsername());
        return "/security/info-about-authorization";
    }

    /**
     * Метод осуществляет выход пользователя из системы.
     *
     * @return view для отображения.
     */
    @RequestMapping(value = "/success-logout")
    public String logout() {
        return "/security/success-logout";
    }

    /**
     * Метод информирует об ошибке входа.
     *
     * @return view для отображения.
     */
    @RequestMapping(value = "/logonError")
    public String logonError() {
        return "/security/logonError";
    }
}
