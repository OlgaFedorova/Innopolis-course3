package ru.innopolis.uni.course3.ofedorova.constants;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.innopolis.uni.course3.ofedorova.services.main.MainServiceForDecisionsAndMarks;
import ru.innopolis.uni.course3.ofedorova.services.main.MainServiceForTasks;
import ru.innopolis.uni.course3.ofedorova.services.main.MainServiceForUsers;

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
     * Метод возвращает компонент "MainServiceForUsers" из контекста приложений.
     *
     * @return контроллер для работы с пользователями.
     */
    public static MainServiceForUsers getControllerForUsers() {
        return (MainServiceForUsers) Settings.APPLICATION_CONTEXT.getBean("mainServiceForUsers");
    }

    /**
     * Метод возвращает компонент "MainServiceForTasks" из контекста приложений.
     *
     * @return контроллер для работы с заданиями.
     */
    public static MainServiceForTasks getControllerForTasks() {
        return (MainServiceForTasks) Settings.APPLICATION_CONTEXT.getBean("mainServiceForTasks");
    }

    /**
     * Метод возвращает компонент "MainServiceForDecisionsAndMarks" из контекста приложений.
     *
     * @return контроллер для работы с решениями пользователя и их оценками.
     */
    public static MainServiceForDecisionsAndMarks getControllerForDecisionsAndMarks() {
        return (MainServiceForDecisionsAndMarks) Settings.APPLICATION_CONTEXT.getBean("mainServiceForDecisionsAndMarks");
    }
}
