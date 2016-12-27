package ru.innopolis.uni.course3.ofedorova.dao.decisions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.course3.ofedorova.service.ConnectionPoolFactory;

import java.sql.*;

/**
 * Класс реализует модель доступа к данным модели "Decision"  с помощью JDBC.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public class JdbcOfDAOtoDecisions implements DAOtoDecisions {
    /**
     * Объект для логгирования.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcOfDAOtoDecisions.class);

    /**
     * Соединение для работы с БД.
     */
    private Connection connection;

    /**
     * Создает новый {@code JdbcOfDAOtoDecisions}.
     */
    public JdbcOfDAOtoDecisions() {
        this.connection = ConnectionPoolFactory.getConnection();
    }

    /**
     * Метод добавляет решение пользователя в систему.
     *
     * @param idTask   идентификатор задачи.
     * @param idUser   идентификатор пользователя.
     * @param decision текст решения.
     */
    @Override
    public void add(int idTask, int idUser, String decision) {
        try (final PreparedStatement statement = this.connection.prepareStatement("INSERT  INTO decisions (id_task , id_user, decision) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, idTask);
            statement.setInt(2, idUser);
            statement.setString(3, decision);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            JdbcOfDAOtoDecisions.LOGGER.info(e.getMessage());
        }
    }

    /**
     * Метод закрывает соединение для работы с данными.
     */
    @Override
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            JdbcOfDAOtoDecisions.LOGGER.info(e.getMessage());
        }
    }
}
