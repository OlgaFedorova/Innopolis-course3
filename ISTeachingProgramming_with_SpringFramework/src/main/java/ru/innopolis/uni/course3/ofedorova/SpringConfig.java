package ru.innopolis.uni.course3.ofedorova;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.innopolis.uni.course3.ofedorova.controllers.ControllerForDecisionsAndMarks;
import ru.innopolis.uni.course3.ofedorova.controllers.ControllerForTasks;
import ru.innopolis.uni.course3.ofedorova.controllers.ControllerForUsers;
import ru.innopolis.uni.course3.ofedorova.dao.decisions.DAOtoDecisions;
import ru.innopolis.uni.course3.ofedorova.dao.decisions.JdbcOfDAOtoDecisions;
import ru.innopolis.uni.course3.ofedorova.dao.marks.DAOtoMarks;
import ru.innopolis.uni.course3.ofedorova.dao.marks.JdbcOfDAOtoMarks;
import ru.innopolis.uni.course3.ofedorova.dao.tasks.DAOtoTasks;
import ru.innopolis.uni.course3.ofedorova.dao.tasks.JdbcOfDAOtoTasks;
import ru.innopolis.uni.course3.ofedorova.dao.users.DAOtoUsers;
import ru.innopolis.uni.course3.ofedorova.dao.users.JdbcOfDAOtoUsers;
import ru.innopolis.uni.course3.ofedorova.service.marks.ServiceOfMarks;
import ru.innopolis.uni.course3.ofedorova.service.marks.ServiceOfMarksImpl;
import ru.innopolis.uni.course3.ofedorova.service.users.ServiceOfUsers;
import ru.innopolis.uni.course3.ofedorova.service.users.ServiceOfUsersImpl;

/**
 * Класс для хранения конфигурации зависимостей Spring.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 05.01.2017
 */
@Configuration
public class SpringConfig {

    /**
     * Связывает компонент "controllerForDecisionsAndMarks" с типом "ControllerForDecisionsAndMarks".
     *
     * @return новый объект типа "ControllerForDecisionsAndMarks".
     */
    @Bean
    @Scope("singleton")
    public ControllerForDecisionsAndMarks controllerForDecisionsAndMarks() {
        return new ControllerForDecisionsAndMarks(this.daOtoDecisions(), this.daOtoMarks(), this.serviceOfMarks());
    }

    /**
     * Связывает компонент "controllerForTasks" с типом "ControllerForTasks".
     *
     * @return новый объект типа "ControllerForTasks".
     */
    @Bean
    @Scope("singleton")
    public ControllerForTasks controllerForTasks() {
        return new ControllerForTasks(this.daOtoTasks());
    }

    /**
     * Связывает компонент "controllerForUsers" с типом "ControllerForUsers".
     *
     * @return новый объект типа "ControllerForUsers".
     */
    @Bean
    @Scope("singleton")
    public ControllerForUsers controllerForUsers() {
        return new ControllerForUsers(this.daOtoUsers(), this.serviceOfUsers());
    }

    /**
     * Связывает компонент "daOtoDecisions" с типом "JdbcOfDAOtoDecisions".
     *
     * @return новый объект типа "JdbcOfDAOtoDecisions".
     */
    @Bean
    @Scope("singleton")
    public DAOtoDecisions daOtoDecisions() {
        return new JdbcOfDAOtoDecisions();
    }

    /**
     * Связывает компонент "daOtoMarks" с типом "JdbcOfDAOtoMarks".
     *
     * @return новый объект типа "JdbcOfDAOtoMarks".
     */
    @Bean
    @Scope("singleton")
    public DAOtoMarks daOtoMarks() {
        return new JdbcOfDAOtoMarks();
    }

    /**
     * Связывает компонент "daOtoTasks" с типом "JdbcOfDAOtoTasks".
     *
     * @return новый объект типа "JdbcOfDAOtoTasks".
     */
    @Bean
    @Scope("singleton")
    public DAOtoTasks daOtoTasks() {
        return new JdbcOfDAOtoTasks();
    }

    /**
     * Связывает компонент "daOtoUsers" с типом "JdbcOfDAOtoUsers".
     *
     * @return новый объект типа "JdbcOfDAOtoUsers".
     */
    @Bean
    @Scope("singleton")
    public DAOtoUsers daOtoUsers() {
        return new JdbcOfDAOtoUsers();
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
     * Связывает компонент "serviceOfUsers" с типом "ServiceOfUsersImpl".
     *
     * @return новый объект типа "ServiceOfUsersImpl".
     */
    @Bean
    @Scope("singleton")
    public ServiceOfUsers serviceOfUsers() {
        return new ServiceOfUsersImpl();
    }
}
