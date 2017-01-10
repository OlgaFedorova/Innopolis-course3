package ru.innopolis.uni.course3.ofedorova.dao.marks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoMarksException;
import ru.innopolis.uni.course3.ofedorova.services.ConnectionPoolFactory;

import java.sql.*;

/**
 * Класс реализует модель доступа к данным модели "Mark" с помощью Jdbc.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public class JdbcOfDAOtoMarks implements DAOtoMarks {

    /**
     * Объект для логгирования.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcOfDAOtoMarks.class);

    /**
     * Метод добавляет оценку за решение пользователя в БД.
     *
     * @param idTask идентификатор задания.
     * @param idUser идентификатор пользователя.
     * @param mark   оценка за задание.
     */
    @Override
    public void add(int idTask, int idUser, int mark) throws DAOtoMarksException {
        try (final Connection connection = ConnectionPoolFactory.getConnection();
             final PreparedStatement statement = connection.prepareStatement("INSERT  INTO marks (id_task , id_user, mark) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, idTask);
            statement.setInt(2, idUser);
            statement.setInt(3, mark);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                }
            }
        } catch (SQLException | NullPointerException e) {
            JdbcOfDAOtoMarks.LOGGER.info(e.getMessage());
            throw new DAOtoMarksException();
        }
    }
}
