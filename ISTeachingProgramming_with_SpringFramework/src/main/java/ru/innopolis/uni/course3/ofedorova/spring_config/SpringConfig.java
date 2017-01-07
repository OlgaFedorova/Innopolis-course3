package ru.innopolis.uni.course3.ofedorova.spring_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import ru.innopolis.uni.course3.ofedorova.controllers.ControllerForDecisionsAndMarks;
import ru.innopolis.uni.course3.ofedorova.controllers.ControllerForTasks;
import ru.innopolis.uni.course3.ofedorova.controllers.ControllerForUsers;
import ru.innopolis.uni.course3.ofedorova.dao.decisions.DAOtoDecisions;
import ru.innopolis.uni.course3.ofedorova.dao.decisions.JdbcOfDAOtoDecisions;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoDecisionsException;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoMarksException;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoTasksException;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoUsersException;
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

import java.sql.SQLException;

/**
 * Класс для хранения конфигурации зависимостей Spring.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 05.01.2017
 */
@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringConfig implements TransactionManagementConfigurer {

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
        JdbcOfDAOtoDecisions daOtoDecisions = new JdbcOfDAOtoDecisions();
        daOtoDecisions.setJdbcTemplate(this.jdbcTemplate());
        daOtoDecisions.getJdbcTemplate().setExceptionTranslator(new SQLExceptionTranslator() {
            @Override
            public DataAccessException translate(String task, String sql, SQLException ex) {
                JdbcOfDAOtoDecisions.LOGGER.info(ex.getMessage());
                return new DAOtoDecisionsException(ex.getMessage(), ex);
            }
        });
        return daOtoDecisions;
    }

    /**
     * Связывает компонент "daOtoMarks" с типом "JdbcOfDAOtoMarks".
     *
     * @return новый объект типа "JdbcOfDAOtoMarks".
     */
    @Bean
    @Scope("singleton")
    public DAOtoMarks daOtoMarks() {
        JdbcOfDAOtoMarks daOtoMarks = new JdbcOfDAOtoMarks();
        daOtoMarks.setJdbcTemplate(this.jdbcTemplate());
        daOtoMarks.getJdbcTemplate().setExceptionTranslator(new SQLExceptionTranslator() {
            @Override
            public DataAccessException translate(String task, String sql, SQLException ex) {
                JdbcOfDAOtoMarks.LOGGER.info(ex.getMessage());
                return new DAOtoMarksException(ex.getMessage(), ex);
            }
        });
        return daOtoMarks;
    }

    /**
     * Связывает компонент "daOtoTasks" с типом "JdbcOfDAOtoTasks".
     *
     * @return новый объект типа "JdbcOfDAOtoTasks".
     */
    @Bean
    @Scope("singleton")
    public DAOtoTasks daOtoTasks() {
        JdbcOfDAOtoTasks daOtoTasks = new JdbcOfDAOtoTasks();
        daOtoTasks.setJdbcTemplate(this.jdbcTemplate());
        daOtoTasks.getJdbcTemplate().setExceptionTranslator(new SQLExceptionTranslator() {
            @Override
            public DataAccessException translate(String task, String sql, SQLException ex) {
                JdbcOfDAOtoTasks.LOGGER.info(ex.getMessage());
                return new DAOtoTasksException(ex.getMessage(), ex);
            }
        });
        return daOtoTasks;
    }

    /**
     * Связывает компонент "daOtoUsers" с типом "JdbcOfDAOtoUsers".
     *
     * @return новый объект типа "JdbcOfDAOtoUsers".
     */
    @Bean
    @Scope("singleton")
    public DAOtoUsers daOtoUsers() {
        JdbcOfDAOtoUsers daOtoUsers = new JdbcOfDAOtoUsers();
        daOtoUsers.setJdbcTemplate(this.jdbcTemplate());
        daOtoUsers.getJdbcTemplate().setExceptionTranslator(new SQLExceptionTranslator() {
            @Override
            public DataAccessException translate(String task, String sql, SQLException ex) {
                JdbcOfDAOtoUsers.LOGGER.info(ex.getMessage());
                return new DAOtoUsersException(ex.getMessage(), ex);
            }
        });
        return daOtoUsers;
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

    /**
     * Связывает компонент для работы с пулом соединений с БД.
     *
     * @return объект для работы с пулом соединений с БД.
     */
    @Bean(name = "dataSource")
    @Scope("singleton")
    public org.apache.commons.dbcp.BasicDataSource dataSource() {
        org.apache.commons.dbcp.BasicDataSource dataSource = new org.apache.commons.dbcp.BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost/is_teaching_programming");
        dataSource.setUsername("postgres");
        dataSource.setPassword("123");
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);
        dataSource.setMaxWait(10000);
        return dataSource;
    }

    /**
     * Связывает шаблон для работы с JDBC.
     *
     * @return шаблон для работы с JDBC.
     */
    @Bean(name = "jdbcTemplate")
    @Scope("prototype")
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(this.dataSource());
    }

    /**
     * Связывает компонент для работы с аспектом для перехвата исключительной ситуации EmptyResultDataAccessException в DOA через JDBC.
     *
     * @return аспект для перехвата исключительной ситуации EmptyResultDataAccessException в DOA через JDBC.
     */
    @Bean
    public AspectCatcherEmptyResultDataAccessException aspectCatcherEmptyResultDataAccessException() {
        return new AspectCatcherEmptyResultDataAccessException();
    }

    /**
     * Связывает компонент для работы диспетчера транзакций.
     *
     * @return объект диспетчера транзакций.
     */
    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(this.dataSource());
    }

    /**
     * Return the default transaction manager bean to use for annotation-driven database transaction management, i.e.
     *
     * @return default transaction manager.
     */
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return this.txManager();
    }
}
