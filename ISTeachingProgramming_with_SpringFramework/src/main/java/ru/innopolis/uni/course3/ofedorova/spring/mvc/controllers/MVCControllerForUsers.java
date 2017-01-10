package ru.innopolis.uni.course3.ofedorova.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.innopolis.uni.course3.ofedorova.constants.MVCControllersCommonFunctions;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoUsersException;
import ru.innopolis.uni.course3.ofedorova.models.User;
import ru.innopolis.uni.course3.ofedorova.services.users.MainServiceForUsers;

import javax.servlet.http.HttpSession;

/**
 * Spring-контроллер для работы с данными пользователя.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 09.01.2017
 */
@Controller
@SessionAttributes("userSession")
public class MVCControllerForUsers {
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
    public MVCControllerForUsers(MainServiceForUsers mainService) {
        this.mainService = mainService;
    }

    /**
     * Метод возвращает представление для регистрации нового пользователя.
     *
     * @param model объект модели, связанный с формой.
     * @return view для отображения.
     */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String userCreate(Model model) {
        String view = "";
        if (MVCControllersCommonFunctions.getUserFromSession(model) == null) {
            model.addAttribute("user", new User());
            view = "registration/registration";
        } else {
            view = MVCControllersCommonFunctions.redirectInfoAboutAuthorization();
        }
        return view;
    }

    /**
     * Метод обрабатывает форму регистрации нового пользователя.
     *
     * @param user  объект пользователя, связанный с формой.
     * @param model объект модели, связанный с формой.
     * @return view для отображения.
     */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String userCreateFromForm(User user, Model model) {
        String view = "";
        try {
            if (!this.mainService.checkName(user.getName())) {
                view = "registration/registrationErrorNameIncorrect";
            } else if (this.mainService.getByName(user.getName()) != null) {
                view = "registration/registrationErrorUserDuplicate";
            } else {
                if (this.mainService.passwordEmpty(user.getPassword(), user.getConfirmPassword())) {
                    view = "registration/registrationErrorPasswordEmpty";
                } else {
                    if (this.mainService.checkPasswords(user.getPassword(), user.getConfirmPassword())) {
                        MVCControllersCommonFunctions.setUserInSession(model, this.mainService.addNewUser(user));
                        view = "redirect:/registration-success";
                    } else {
                        model.addAttribute("info", "Пароли не совпадают, попробуйте снова.");
                        view = "registration/registration";
                    }
                }
            }
        } catch (DAOtoUsersException e) {
            view = MVCControllersCommonFunctions.redirectErrorPage();
        }
        return view;
    }

    /**
     * Метод возвращает представление для информации об успешной регистрации.
     *
     * @param model объект модели, связанный с формой.
     * @return view для отображения.
     */
    @RequestMapping(value = "/registration-success")
    public String registrationSuccess(Model model) {
        User user = MVCControllersCommonFunctions.getUserFromSession(model);
        model.addAttribute("username", user == null ? "не авторизован" : user.getName());
        return "registration/registration-success";
    }

    /**
     * Метод возвращает представление для редактирования профиля пользователя.
     *
     * @param model объект модели, связанный с формой.
     * @return view для отображения.
     */
    @RequestMapping(value = "/main/edit-user", method = RequestMethod.GET)
    public String editUser(Model model) {
        model.addAttribute("user", MVCControllersCommonFunctions.getUserFromSession(model));
        return "security/edit-user";
    }

    /**
     * Метод обрабатывает данные формы для редактирования профиля пользователя.
     *
     * @param model объект модели, связанный с формой.
     * @param user  объект пользователя, связанный с формой.
     * @return view для отображения.
     */
    @RequestMapping(value = "/main/edit-user", method = RequestMethod.POST)
    public String editUserFromForm(Model model, User user) {
        String view = "";
        try {
            user.setId(MVCControllersCommonFunctions.getUserFromSession(model).getId());
            if (this.mainService.checkDataForEdid(user.getId(), user.getCurrentPassword(), user.getNewPassword(), user.getConfirmNewPassword())) {
                MVCControllersCommonFunctions.setUserInSession(model, this.mainService.updatePassword(user));
                view = "redirect:/main/edit-user-success";
            } else {
                view = "security/edit-user-error";
            }
        } catch (DAOtoUsersException e) {
            view = MVCControllersCommonFunctions.redirectErrorPage();
        }
        return view;
    }

    /**
     * Метод отображает представление с информацией об успешном редактировании профиля пользователя.
     *
     * @param model объект модели, связанный с формой.
     * @return view для отображения.
     */
    @RequestMapping(value = "/main/edit-user-success")
    public String editUserSuccess(HttpSession session, Model model) {
        User user = MVCControllersCommonFunctions.getUserFromSession(model);
        model.addAttribute("username", user == null ? "не авторизован" : user.getName());
        return "security/success-edit-user";
    }

    /**
     * Метод отображает представление с информацией о рейтингах пользователей.
     *
     * @param model объект модели, связанный с формой.
     * @return view для отображения.
     */
    @RequestMapping(value = "/main/user-rating")
    public String userRating(Model model) {
        String view = "";
        try {
            model.addAttribute("users", this.mainService.valuesRating());
            view = "main/marks/UserRatingView";
        } catch (DAOtoUsersException e) {
            view = MVCControllersCommonFunctions.redirectErrorPage();
        }
        return view;
    }
}
