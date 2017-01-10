package ru.innopolis.uni.course3.ofedorova.constants;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.innopolis.uni.course3.ofedorova.services.handlerdecisions.MainServiceForHandlerDecisionsImpl;
import ru.innopolis.uni.course3.ofedorova.services.tasks.MainServiceForTasksImpl;
import ru.innopolis.uni.course3.ofedorova.services.users.MainServiceForUsersImpl;

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
     * Метод возвращает компонент "MainServiceForUsersImpl" из контекста приложений.
     *
     * @return контроллер для работы с пользователями.
     */
    public static MainServiceForUsersImpl getControllerForUsers() {
        return (MainServiceForUsersImpl) Settings.APPLICATION_CONTEXT.getBean("mainServiceForUsers");
    }

    /**
     * Метод возвращает компонент "MainServiceForTasksImpl" из контекста приложений.
     *
     * @return контроллер для работы с заданиями.
     */
    public static MainServiceForTasksImpl getControllerForTasks() {
        return (MainServiceForTasksImpl) Settings.APPLICATION_CONTEXT.getBean("mainServiceForTasks");
    }

    /**
     * Метод возвращает компонент "MainServiceForHandlerDecisionsImpl" из контекста приложений.
     *
     * @return контроллер для работы с решениями пользователя и их оценками.
     */
    public static MainServiceForHandlerDecisionsImpl getControllerForDecisionsAndMarks() {
        return (MainServiceForHandlerDecisionsImpl) Settings.APPLICATION_CONTEXT.getBean("mainServiceForDecisionsAndMarks");
    }
}
