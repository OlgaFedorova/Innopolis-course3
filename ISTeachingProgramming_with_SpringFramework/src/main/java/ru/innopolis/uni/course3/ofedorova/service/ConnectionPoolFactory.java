package ru.innopolis.uni.course3.ofedorova.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Класс для работы с пулом соединений Tomcat.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.12.2016
 */
public class ConnectionPoolFactory {
    /**
     * Объект для логгирования.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionPoolFactory.class);
    /**
     * Объект для получения соединения к БД.
     */
    private static DataSource ds = null;

    static {
        try {
            InitialContext initContext = new InitialContext();
            ConnectionPoolFactory.ds = (DataSource) initContext.lookup("java:comp/env/jdbc/is_teaching_programming");
        } catch (NamingException e) {
            ConnectionPoolFactory.LOGGER.info(e.getMessage());
        }
    }

    /**
     * Метод возвращает доступное соединение из пула.
     *
     * @return соединение для работы с БД.
     * @throws SQLException
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = ConnectionPoolFactory.ds.getConnection();
        } catch (SQLException e) {
            ConnectionPoolFactory.LOGGER.info(e.getMessage());
        }
        return connection;
    }
}
