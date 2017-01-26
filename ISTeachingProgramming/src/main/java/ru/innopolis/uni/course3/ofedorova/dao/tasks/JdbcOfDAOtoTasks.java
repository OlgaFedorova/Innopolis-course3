package ru.innopolis.uni.course3.ofedorova.dao.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoTasksException;
import ru.innopolis.uni.course3.ofedorova.models.Decision;
import ru.innopolis.uni.course3.ofedorova.models.Mark;
import ru.innopolis.uni.course3.ofedorova.models.Task;
import ru.innopolis.uni.course3.ofedorova.services.ConnectionPoolFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Класс реализует доступ к данным модели "Task" с помощью JDBC.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public class JdbcOfDAOtoTasks implements DAOtoTasks {
    /**
     * Объект для логгирования.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcOfDAOtoTasks.class);

    /**
     * Метод возвращает список заданий в БД.
     *
     * @param idUser идентификатор пользователя.
     * @return список заданий в БД.
     */
    @Override
    public Collection<Task> values(int idUser) throws DAOtoTasksException {
        final List<Task> tasks = new ArrayList<>();
        try (final Connection connection = ConnectionPoolFactory.getConnection();
             final PreparedStatement statement = connection.prepareStatement(new StringBuilder().append("SELECT t.id, t.name, d.id as id_decision, d.decision, m.id as id_mark, m.mark ").
                     append("FROM tasks AS t ").
                     append("LEFT JOIN decisions AS d ").
                     append("ON t.id = d.id_task AND  d.id_user = ? ").
                     append("LEFT JOIN marks AS m ").
                     append("ON t.id = m.id_task AND  m.id_user = ? ").
                     append("ORDER BY id").toString())) {
            statement.setInt(1, idUser);
            statement.setInt(2, idUser);
            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    Decision decision = null;
                    Mark mark = null;
                    if (rs.getInt("id_decision") > 0) {
                        decision = new Decision(rs.getInt("id_decision"), rs.getInt("id"), idUser, rs.getString("decision"));
                    }
                    if (rs.getInt("id_mark") > 0) {
                        mark = new Mark(rs.getInt("id_mark"), rs.getInt("mark"));
                    } else {
                        mark = new Mark();
                    }
                    tasks.add(new Task(rs.getInt("id"), rs.getString("name"), decision, mark));
                }
            }
        } catch (SQLException | NullPointerException e) {
            JdbcOfDAOtoTasks.LOGGER.info(e.getMessage());
            throw new DAOtoTasksException();
        }
        return tasks;
    }

    /**
     * Метод возвращает задание по переданному id.
     *
     * @param id     идентификатор задания.
     * @param idUser идентификатор пользователя.
     * @return задание найденное по id.
     */
    @Override
    public Task getById(int id, int idUser) throws DAOtoTasksException {
        Task task = null;
        try (final Connection connection = ConnectionPoolFactory.getConnection();
             final PreparedStatement statement = connection.prepareStatement(new StringBuilder().append("SELECT t.*, d.id as id_decision, d.decision, m.id as id_mark, m.mark ").
                     append("FROM tasks AS t ").
                     append("LEFT JOIN decisions AS d ").
                     append("ON t.id = d.id_task AND d.id_user = ? ").
                     append("LEFT JOIN marks AS m ").
                     append("ON t.id = m.id_task AND m.id_user = ? ").
                     append("WHERE t.id = ?").toString())) {
            statement.setInt(1, idUser);
            statement.setInt(2, idUser);
            statement.setInt(3, id);
            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    Decision decision = null;
                    Mark mark = null;
                    if (rs.getInt("id_decision") > 0) {
                        decision = new Decision(rs.getInt("id_decision"), id, idUser, rs.getString("decision"));
                    }
                    if (rs.getInt("id_mark") > 0) {
                        mark = new Mark(rs.getInt("id_mark"), rs.getInt("mark"));
                    } else {
                        mark = new Mark();
                    }
                    task = new Task(rs.getInt("id"), rs.getString("name"), rs.getString("content"), decision, mark);
                    break;
                }
            }
        } catch (SQLException | NullPointerException e) {
            JdbcOfDAOtoTasks.LOGGER.info(e.getMessage());
            throw new DAOtoTasksException();
        }
        return task;
    }
}
