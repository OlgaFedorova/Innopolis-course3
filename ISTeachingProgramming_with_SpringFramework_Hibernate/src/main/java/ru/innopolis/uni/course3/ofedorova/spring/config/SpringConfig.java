package ru.innopolis.uni.course3.ofedorova.spring.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import ru.innopolis.uni.course3.ofedorova.dao.decisions.HibernateOfDAOtoDecisions;
import ru.innopolis.uni.course3.ofedorova.dao.marks.HibernateOfDAOtoMarks;
import ru.innopolis.uni.course3.ofedorova.dao.tasks.HibernateOfDAOtoTasks;
import ru.innopolis.uni.course3.ofedorova.dao.users.HibernateOfDAOtoUsers;
import ru.innopolis.uni.course3.ofedorova.services.handlerdecisions.MainServiceForHandlerDecisions;
import ru.innopolis.uni.course3.ofedorova.services.handlerdecisions.MainServiceForHandlerDecisionsImpl;
import ru.innopolis.uni.course3.ofedorova.services.tasks.MainServiceForTasks;
import ru.innopolis.uni.course3.ofedorova.services.tasks.MainServiceForTasksImpl;
import ru.innopolis.uni.course3.ofedorova.services.users.MainServiceForUsers;
import ru.innopolis.uni.course3.ofedorova.services.users.MainServiceForUsersImpl;
import ru.innopolis.uni.course3.ofedorova.dao.decisions.DAOtoDecisions;
import ru.innopolis.uni.course3.ofedorova.dao.marks.DAOtoMarks;
import ru.innopolis.uni.course3.ofedorova.dao.tasks.DAOtoTasks;
import ru.innopolis.uni.course3.ofedorova.dao.users.DAOtoUsers;
import ru.innopolis.uni.course3.ofedorova.services.handlerdecisions.ServiceOfMarks;
import ru.innopolis.uni.course3.ofedorova.services.handlerdecisions.ServiceOfMarksImpl;
import ru.innopolis.uni.course3.ofedorova.services.users.ServiceForValidateDataOfUsers;
import ru.innopolis.uni.course3.ofedorova.services.users.ServiceForValidateDataOfUsersImpl;

import java.util.Properties;

/**
 * Класс для хранения конфигурации зависимостей Spring.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 05.01.2017
 */
@Configuration
@EnableAspectJAutoProxy
public class SpringConfig {

    /**
     * Связывает компонент "mainServiceForDecisionsAndMarks" с типом "MainServiceForHandlerDecisionsImpl".
     *
     * @return новый объект типа "MainServiceForHandlerDecisionsImpl".
     */
    @Bean(name = "mainServiceForDecisionsAndMarks")
    @Scope("singleton")
    public MainServiceForHandlerDecisions mainServiceForDecisionsAndMarks() {
        return new MainServiceForHandlerDecisionsImpl(this.daOtoDecisions(), this.daOtoMarks(), this.serviceOfMarks());
    }

    /**
     * Связывает компонент "mainServiceForTasks" с типом "MainServiceForTasksImpl".
     *
     * @return новый объект типа "MainServiceForTasksImpl".
     */
    @Bean(name = "mainServiceForTasks")
    @Scope("singleton")
    public MainServiceForTasks mainServiceForTasks() {
        return new MainServiceForTasksImpl(this.daOtoTasks());
    }

    /**
     * Связывает компонент "mainServiceForUsers" с типом "MainServiceForUsersImpl".
     *
     * @return новый объект типа "MainServiceForUsersImpl".
     */
    @Bean(name = "mainServiceForUsers")
    @Scope("singleton")
    public MainServiceForUsers mainServiceForUsers() {
        return new MainServiceForUsersImpl(this.daOtoUsers(), this.serviceOfUsers());
    }

    /**
     * Связывает компонент "daOtoDecisions" с типом "HibernateOfDAOtoDecisions".
     *
     * @return новый объект типа "HibernateOfDAOtoDecisions".
     */
    @Bean
    @Scope("singleton")
    public DAOtoDecisions daOtoDecisions() {
        return new HibernateOfDAOtoDecisions();
    }

    /**
     * Связывает компонент "daOtoMarks" с типом "HibernateOfDAOtoMarks".
     *
     * @return новый объект типа "HibernateOfDAOtoMarks".
     */
    @Bean
    @Scope("singleton")
    public DAOtoMarks daOtoMarks() {
        return new HibernateOfDAOtoMarks();
    }

    /**
     * Связывает компонент "daOtoTasks" с типом "HibernateOfDAOtoTasks".
     *
     * @return новый объект типа "HibernateOfDAOtoTasks".
     */
    @Bean
    @Scope("singleton")
    public DAOtoTasks daOtoTasks() {
        return new HibernateOfDAOtoTasks();
    }

    /**
     * Связывает компонент "daOtoUsers" с типом "HibernateOfDAOtoUsers".
     *
     * @return новый объект типа "HibernateOfDAOtoUsers".
     */
    @Bean
    @Scope("singleton")
    public DAOtoUsers daOtoUsers() {
        return new HibernateOfDAOtoUsers();
    }

    /**
     * Связывает компонент "serviceOfMarks" с типом "ServiceOfMarksImpl".
     *
     * @return новый объект типа "ServiceOfMarksImpl".
     */
    @Bean
    @Scope("singleton")
    public ServiceOfMarks serviceOfMarks() {
        return new ServiceOfMarksImpl();
    }

    /**
     * Связывает компонент "serviceOfUsers" с типом "ServiceForValidateDataOfUsersImpl".
     *
     * @return новый объект типа "ServiceForValidateDataOfUsersImpl".
     */
    @Bean
    @Scope("singleton")
    public ServiceForValidateDataOfUsers serviceOfUsers() {
        return new ServiceForValidateDataOfUsersImpl();
    }


    /**
     * Объявляет компонент, который перехватывает исключения в любой части приложения.
     *
     * @return объект, который перехватывает исключения в любой части приложения.
     */
    @Bean
    public HandlerExceptionResolver handlerExceptionResolver() {
        SimpleMappingExceptionResolver hExceptionResolver = new MyExceptionResolver();

        String errorPage = "/error";

        Properties exceptionMappings = new Properties();
        exceptionMappings.put("ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoDecisionsException", errorPage);
        exceptionMappings.put("ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoMarksException", errorPage);
        exceptionMappings.put("ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoTasksException", errorPage);
        exceptionMappings.put("ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoUsersException", errorPage);

        hExceptionResolver.setExceptionMappings(exceptionMappings);
        return hExceptionResolver;
    }
}
