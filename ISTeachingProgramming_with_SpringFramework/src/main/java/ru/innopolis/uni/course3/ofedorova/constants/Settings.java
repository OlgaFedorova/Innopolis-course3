package ru.innopolis.uni.course3.ofedorova.constants;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.innopolis.uni.course3.ofedorova.controllers.ControllerForDecisionsAndMarks;
import ru.innopolis.uni.course3.ofedorova.controllers.ControllerForTasks;
import ru.innopolis.uni.course3.ofedorova.controllers.ControllerForUsers;

/**
 * Класс для хранения общих настроек системы.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 04.01.2017
 */
public class Settings {
    /**
     * Контекст приложений Spring для внедерния зависимостей.
     */
    private static final ApplicationContext APPLICATION_CONTEXT = new ClassPathXmlApplicationContext("appContext.xml");

    /**
     * Метод возвращает компонент "ControllerForUsers" из контекста приложений.
     *
     * @return контроллер для работы с пользователями.
     */
    public static ControllerForUsers getControllerForUsers() {
        return (ControllerForUsers) Settings.APPLICATION_CONTEXT.getBean("controllerForUsers");
    }

    /**
     * Метод возвращает компонент "ControllerForTasks" из контекста приложений.
     *
     * @return контроллер для работы с заданиями.
     */
    public static ControllerForTasks getControllerForTasks() {
        return (ControllerForTasks) Settings.APPLICATION_CONTEXT.getBean("controllerForTasks");
    }

    /**
     * Метод возвращает компонент "ControllerForDecisionsAndMarks" из контекста приложений.
     *
     * @return контроллер для работы с решениями пользователя и их оценками.
     */
    public static ControllerForDecisionsAndMarks getControllerForDecisionsAndMarks() {
        return (ControllerForDecisionsAndMarks) Settings.APPLICATION_CONTEXT.getBean("controllerForDecisionsAndMarks");
    }
}
