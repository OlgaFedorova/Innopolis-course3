package ru.innopolis.uni.course3.ofedorova.mvc.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Olga on 07.01.2017.
 */
@Controller
public class MVCControllerHome {

    @RequestMapping({"/"})
    public String showHomePage() {
        return "index";
    }
}
