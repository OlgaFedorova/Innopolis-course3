package ru.innopolis.uni.course3.ofedorova.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.innopolis.uni.course3.ofedorova.constants.MVCControllersCommonFunctions;
import ru.innopolis.uni.course3.ofedorova.models.User;
import ru.innopolis.uni.course3.ofedorova.services.users.MainServiceForUsers;

import javax.servlet.http.HttpServletRequest;

/**
 * Spring-контроллер для работы с данными пользователя.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 09.01.2017
 */
@Controller
public class MVCControllerForUsers {
    /**
     * Объект-сервис для работы с данными пользователя.
     */
    private final MainServiceForUsers mainService;

    /**
     * Объект для аутентификации.
     */
    @Autowired
    protected AuthenticationProvider authenticationProvider;

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
        if (MVCControllersCommonFunctions.getUserFromSession() == null) {
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
    public String userCreateFromForm(User user, Model model, HttpServletRequest request) {
        String view = "";
        if (!this.mainService.checkName(user.getUsername())) {
            view = "registration/registrationErrorNameIncorrect";
        } else if (this.mainService.getByName(user.getUsername()) != null) {
            view = "registration/registrationErrorUserDuplicate";
        } else {
            if (this.mainService.passwordEmpty(user.getPassword(), user.getConfirmPassword())) {
                view = "registration/registrationErrorPasswordEmpty";
            } else {
                if (this.mainService.checkPasswords(user.getPassword(), user.getConfirmPassword())) {
                    this.mainService.addNewUser(user);
                    this.authenticateUserAndSetSession(user, request);
                    view = "redirect:/registration-success";
                } else {
                    model.addAttribute("info", "Пароли не совпадают, попробуйте снова.");
                    view = "registration/registration";
                }
            }
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
        User user = MVCControllersCommonFunctions.getUserFromSession();
        model.addAttribute("username", user == null ? "не авторизован" : user.getUsername());
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
        model.addAttribute("user", MVCControllersCommonFunctions.getUserFromSession());
        return "security/edit-user";
    }

    /**
     * Метод обрабатывает данные формы для редактирования профиля пользователя.
     *
     * @param user объект пользователя, связанный с формой.
     * @return view для отображения.
     */
    @RequestMapping(value = "/main/edit-user", method = RequestMethod.POST)
    public String editUserFromForm(User user, HttpServletRequest request) {
        String view = "";
        user.setId(MVCControllersCommonFunctions.getUserFromSession().getId());
        if (this.mainService.checkDataForEdid(user.getId(), user.getCurrentPassword(), user.getNewPassword(), user.getConfirmNewPassword())) {
            this.mainService.updatePassword(user);
            view = "redirect:/main/edit-user-success";
        } else {
            view = "security/edit-user-error";
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
    public String editUserSuccess(Model model) {
        User user = MVCControllersCommonFunctions.getUserFromSession();
        model.addAttribute("username", user == null ? "не авторизован" : user.getUsername());
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
        model.addAttribute("users", this.mainService.valuesRating());
        view = "main/marks/UserRatingView";
        return view;
    }

    /**
     * Метод авторизует пользователя после успешной регистрации.
     *
     * @param user    новый пользователь.
     * @param request
     */
    private void authenticateUserAndSetSession(User user, HttpServletRequest request) {
        String username = user.getUsername();
        String password = user.getPassword();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = this.authenticationProvider.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }
}
