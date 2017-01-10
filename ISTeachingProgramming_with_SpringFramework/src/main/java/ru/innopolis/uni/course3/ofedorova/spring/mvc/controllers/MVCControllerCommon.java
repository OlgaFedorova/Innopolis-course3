package ru.innopolis.uni.course3.ofedorova.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.innopolis.uni.course3.ofedorova.constants.MVCControllersCommonFunctions;
import ru.innopolis.uni.course3.ofedorova.models.User;

import javax.servlet.http.HttpSession;

/**
 * Spring-контроллер для отображения основных страниц приложения.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 09.01.2017
 */
@Controller
@SessionAttributes("userSession")
public class MVCControllerCommon {

    /**
     * Метод возвращает представление для главной страницы.
     *
     * @param model объект модели, связанный с формой.
     * @return view для отображения.
     */
    @RequestMapping("/index")
    public String showHomePage(Model model) {
        User user = MVCControllersCommonFunctions.getUserFromSession(model);
        model.addAttribute("username", user == null ? "не авторизован" : user.getName());
        return "index";
    }

    /**
     * Метод возвращает представление для страницы с ошибкой.
     *
     * @return view для отображения.
     */
    @RequestMapping("/error")
    public String showPageError() {
        return "/error";
    }
}
