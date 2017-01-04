package ru.innopolis.uni.course3.ofedorova.dao.decisions;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoDecisionsException;
import ru.innopolis.uni.course3.ofedorova.service.ConnectionPoolFactory;

import java.sql.*;

/**
 * Класс реализует модель доступа к данным модели "Decision"  с помощью JDBC.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
@Component
@Qualifier("jdbcOfDAOtoDecisions")
public class JdbcOfDAOtoDecisions implements DAOtoDecisions {
    /**
     * Объект для логгирования.
     */
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(JdbcOfDAOtoDecisions.class);

    /**
     * Метод добавляет решение пользователя в систему.
     *
     * @param idTask   идентификатор задачи.
     * @param idUser   идентификатор пользователя.
     * @param decision текст решения.
     */
    @Override
    public void add(int idTask, int idUser, String decision) throws DAOtoDecisionsException {
        try (final Connection connection = ConnectionPoolFactory.getConnection();
             final PreparedStatement statement = connection.prepareStatement("INSERT  INTO decisions (id_task , id_user, decision) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, idTask);
            statement.setInt(2, idUser);
            statement.setString(3, decision);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                }
            }
        } catch (SQLException | NullPointerException e) {
            JdbcOfDAOtoDecisions.LOGGER.info(e.getMessage());
            throw new DAOtoDecisionsException();
        }
    }
}
