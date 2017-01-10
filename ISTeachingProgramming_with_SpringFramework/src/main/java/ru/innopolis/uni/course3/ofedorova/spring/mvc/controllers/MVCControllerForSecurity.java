package ru.innopolis.uni.course3.ofedorova.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoUsersException;
import ru.innopolis.uni.course3.ofedorova.models.User;
import ru.innopolis.uni.course3.ofedorova.services.main.MainServiceForUsers;

import javax.servlet.http.HttpSession;

/**
 * Spring-контроллер для работы с авторизацией.
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
     * @param mainService значение поля "mainService".
     */
    @Autowired
    public MVCControllerForSecurity(MainServiceForUsers mainService) {
        this.mainService = mainService;
    }

    /**
     * Метод отображает страницу для авторизации пользователя.
     * @param session http-сессия.
     * @param model объект модели, связанный с формой.
     * @return view для отображения.
     */
    @RequestMapping(value = "/security/logon", method = RequestMethod.GET)
    public String logonUser(HttpSession session, Model model){
        String view = "";
        User user = MVCControllersCommon.getUserFromSession(session);
        if (user == null) {
            model.addAttribute("user", new User());
            view = "/security/logon";
        } else {
            view = MVCControllersCommon.redirectInfoAboutAuthorization();
        }
        return view;
    }

    /**
     * Метод получает данные с формы, необходимые для авторизации пользователя.
     * @param session http-сессия.
     * @param user объект пользователя, связанный с формой.
     * @return view для отображения.
     */
    @RequestMapping(value = "/security/logon", method = RequestMethod.POST)
    public String logonUserFromForm(HttpSession session, User user){
        String view = "";
        try {
            User userCheck = this.mainService.validateLogin(user.getName(), user.getPassword());
            if (userCheck == null) {
                view = "/security/logonError";
            } else {
                MVCControllersCommon.setUserInSession(session, userCheck);
                view = "redirect:/security/success-logon";
            }
        } catch (DAOtoUsersException e) {
            view = MVCControllersCommon.redirectErrorPage();
        }
        return view;
    }

    /**
     * Метод отображает информацию об авторизации пользователя.
     * @param session http-сессия.
     * @param model объект модели, связанный с формой.
     * @return view для отображения.
     */
    @RequestMapping(value = "/info-about-authorization")
    public String infoAboutAuthorization(HttpSession session, Model model){
        User user = MVCControllersCommon.getUserFromSession(session);
        model.addAttribute("username", user == null ? "не авторизован" : user.getName());
        return "/security/info-about-authorization";
    }

    /**
     * Метод возвращает страницу о том, что пользователь успешно авторизован.
     * @param session http-сессия.
     * @param model объект модели, связанный с формой.
     * @return view для отображения.
     */
    @RequestMapping(value = "/security/success-logon")
    public String logonSuccess(HttpSession session, Model model){
        User user = MVCControllersCommon.getUserFromSession(session);
        model.addAttribute("username", user == null ? "не авторизован" : user.getName());
        return "/security/success-logon";
    }

    /**
     * Метод осуществляет выход пользователя из системы.
     * @param session http-сессия.
     * @return view для отображения.
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        MVCControllersCommon.setUserInSession(session, null);
        return "/security/success-logout";
    }
}
