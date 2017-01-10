package ru.innopolis.uni.course3.ofedorova.spring.config;

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
import ru.innopolis.uni.course3.ofedorova.services.handlerdecisions.MainServiceForHandlerDecisions;
import ru.innopolis.uni.course3.ofedorova.services.handlerdecisions.MainServiceForHandlerDecisionsImpl;
import ru.innopolis.uni.course3.ofedorova.services.tasks.MainServiceForTasks;
import ru.innopolis.uni.course3.ofedorova.services.tasks.MainServiceForTasksImpl;
import ru.innopolis.uni.course3.ofedorova.services.users.MainServiceForUsers;
import ru.innopolis.uni.course3.ofedorova.services.users.MainServiceForUsersImpl;
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
import ru.innopolis.uni.course3.ofedorova.services.handlerdecisions.ServiceOfMarks;
import ru.innopolis.uni.course3.ofedorova.services.handlerdecisions.ServiceOfMarksImpl;
import ru.innopolis.uni.course3.ofedorova.services.users.ServiceForValidateDataOfUsers;
import ru.innopolis.uni.course3.ofedorova.services.users.ServiceForValidateDataOfUsersImpl;

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
    @Bean(name = "txManager")
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
