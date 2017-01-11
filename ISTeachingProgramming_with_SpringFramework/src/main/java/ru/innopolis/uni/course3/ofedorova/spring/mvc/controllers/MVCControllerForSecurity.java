package ru.innopolis.uni.course3.ofedorova.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ru.innopolis.uni.course3.ofedorova.constants.MVCControllersCommonFunctions;
import ru.innopolis.uni.course3.ofedorova.models.User;
import ru.innopolis.uni.course3.ofedorova.services.users.MainServiceForUsers;

import java.util.IllegalFormatCodePointException;

/**
 * Spring-контроллер для работы с авторизацией пользователей.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 09.01.2017
 */
@Controller
@SessionAttributes("userSession")
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
     * @param model объект модели, связанный с формой.
     * @return view для отображения.
     */
    @RequestMapping(value = "/security/logon", method = RequestMethod.GET)
    public String logonUser(Model model) {
        String view = "";
        if (MVCControllersCommonFunctions.getUserFromSession(model) == null) {
            model.addAttribute("user", new User());
            view = "/security/logon";
        } else {
            view = MVCControllersCommonFunctions.redirectInfoAboutAuthorization();
        }
        return view;
    }

    /**
     * Метод получает данные с формы, необходимые для авторизации пользователя.
     *
     * @param user объект пользователя, связанный с формой.
     * @return view для отображения.
     */
    @RequestMapping(value = "/security/logon", method = RequestMethod.POST)
    public String logonUserFromForm(Model model, User user) {
        String view = "";
        User userCheck = this.mainService.validateLogin(user.getName(), user.getPassword());
        if (userCheck == null) {
            view = "/security/logonError";
        } else {
            MVCControllersCommonFunctions.setUserInSession(model, userCheck);
            view = "redirect:/security/success-logon";
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
        User user = MVCControllersCommonFunctions.getUserFromSession(model);
        model.addAttribute("username", user == null ? "не авторизован" : user.getName());
        return "/security/info-about-authorization";
    }

    /**
     * Метод возвращает страницу о том, что пользователь успешно авторизован.
     *
     * @param model объект модели, связанный с формой.
     * @return view для отображения.
     */
    @RequestMapping(value = "/security/success-logon")
    public String logonSuccess(Model model) {
        User user = MVCControllersCommonFunctions.getUserFromSession(model);
        model.addAttribute("username", user == null ? "не авторизован" : user.getName());
        return "/security/success-logon";
    }

    /**
     * Метод осуществляет выход пользователя из системы.
     *
     * @param sessionStatus статус сессии.
     * @return view для отображения.
     */
    @RequestMapping(value = "/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "/security/success-logout";
    }
}
