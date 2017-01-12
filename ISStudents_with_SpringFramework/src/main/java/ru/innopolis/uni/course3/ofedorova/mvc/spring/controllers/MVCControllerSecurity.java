package ru.innopolis.uni.course3.ofedorova.mvc.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Olga on 12.01.2017.
 */
@Controller
public class MVCControllerSecurity
{
    @RequestMapping(value = "/logon", method = RequestMethod.GET)
    public String logon(Model model){
        return "logon";
    }

    @RequestMapping(value = "/logonError")
    public String logonError(Model model){
        return "logonError";
    }
}
