package ru.innopolis.uni.course3.ofedorova.spring.mvc.controllers;

import org.springframework.ui.Model;
import ru.innopolis.uni.course3.ofedorova.models.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Olga on 11.01.2017.
 */
public class ModelFactory {

    public static Model getModelWithUserSession(){
        final Map<String, Object> model = new HashMap<>();
        final User user = new User(1, "user1", "", "");
        model.put("userSession", model);
        return (Model)model;
    }

    public static Model getModelWithoutUserSession(){
        final Map<String, Object> model = new HashMap<>();
        return (Model)model;
    }
}
