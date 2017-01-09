package ru.innopolis.uni.course3.ofedorova.mvc.spring.controllers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Olga on 07.01.2017.
 */
public class HomeControllerTest {

    @Test
    public void whenShowHomePage() {
        MVCControllerForStudents homeController = new MVCControllerForStudents();

        assertEquals("index", homeController.showHomePage());
    }

}