package ru.innopolis.uni.course3.ofedorova.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.uni.course3.ofedorova.constants.MVCControllersCommonFunctions;
import ru.innopolis.uni.course3.ofedorova.models.User;

/**
 * Spring-контроллер для отображения основных страниц приложения.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 09.01.2017
 */
@Controller
public class MVCControllerCommon {

    /**
     * Метод возвращает представление для главной страницы.
     *
     * @param model объект модели, связанный с формой.
     * @return view для отображения.
     */
    @RequestMapping("/index")
    public String showHomePage(Model model) {
        User user = MVCControllersCommonFunctions.getUserFromSession();
        model.addAttribute("username", user == null ? "не авторизован" : user.getUsername());
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

    /**
     * Метод возвращает представление для страницы с ошибкой 403 "Отсутствие доступа".
     *
     * @return view для отображения.
     */
    @RequestMapping("/notaccess")
    public String page403() {
        return "notaccess";
    }
}
