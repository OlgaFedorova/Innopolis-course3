package ru.innopolis.uni.course3.ofedorova.dao.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import ru.innopolis.uni.course3.ofedorova.constants.SQLQueries;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoTasksException;
import ru.innopolis.uni.course3.ofedorova.models.Decision;
import ru.innopolis.uni.course3.ofedorova.models.Mark;
import ru.innopolis.uni.course3.ofedorova.models.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Класс реализует доступ к данным модели "Task" с помощью JDBC.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public class JdbcOfDAOtoTasks extends JdbcDaoSupport implements DAOtoTasks {
    /**
     * Объект для логгирования.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(JdbcOfDAOtoTasks.class);

    /**
     * Метод возвращает список заданий в БД.
     *
     * @param idUser идентификатор пользователя.
     * @return список заданий в БД.
     */
    @Override
    public Collection<Task> values(int idUser) throws DAOtoTasksException {
        return this.getJdbcTemplate().query(SQLQueries.VALUES_TASKS, new Object[]{idUser, idUser}, new RowMapper<Task>() {
            @Override
            public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
                return JdbcOfDAOtoTasks.this.createTask(rs.getInt("id"), idUser, rs, false);
            }
        });
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
        return this.getJdbcTemplate().queryForObject(SQLQueries.GET_TASK_BY_ID,
                new Object[]{idUser, idUser, id},
                new RowMapper<Task>() {
                    @Override
                    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return JdbcOfDAOtoTasks.this.createTask(id, idUser, rs, true);
                    }
                });
    }

    /**
     * Метод создает объект Task на основании данных выборки.
     *
     * @param id          идентификатор задачи.
     * @param idUser      идентификатор пользователя.
     * @param rs          выборка.
     * @param withContent признак, что необходиом создавать "Task" с полем "content".
     * @return объект Task на основании данных выборки.
     * @throws SQLException
     */
    private Task createTask(int id, int idUser, ResultSet rs, boolean withContent) throws SQLException {
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
        Task task;
        if (withContent) {
            task = new Task(rs.getInt("id"), rs.getString("name"), rs.getString("content"), decision, mark);
        } else {
            task = new Task(rs.getInt("id"), rs.getString("name"), decision, mark);
        }
        return task;
    }
}
