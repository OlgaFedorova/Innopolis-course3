package ru.innopolis.uni.course3.ofedorova.dao.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoTasksException;
import ru.innopolis.uni.course3.ofedorova.models.Decision;
import ru.innopolis.uni.course3.ofedorova.models.Mark;
import ru.innopolis.uni.course3.ofedorova.models.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcOfDAOtoTasks.class);

    /**
     * Метод возвращает список заданий в БД.
     *
     * @param idUser идентификатор пользователя.
     * @return список заданий в БД.
     */
    @Override
    public Collection<Task> values(int idUser) throws DAOtoTasksException {
        List<Task> tasks = Collections.EMPTY_LIST;
        try {
            String sql = new StringBuilder().append("SELECT t.id, t.name, d.id as id_decision, d.decision, m.id as id_mark, m.mark ").
                    append("FROM tasks AS t ").
                    append("LEFT JOIN decisions AS d ").
                    append("ON t.id = d.id_task AND  d.id_user = ? ").
                    append("LEFT JOIN marks AS m ").
                    append("ON t.id = m.id_task AND  m.id_user = ? ").
                    append("ORDER BY id").toString();
            tasks = this.getJdbcTemplate().query(sql, new Object[]{idUser, idUser}, new RowMapper<Task>() {
                @Override
                public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return JdbcOfDAOtoTasks.this.createTask(rs.getInt("id"), idUser, rs);
                }
            });
        } catch (EmptyResultDataAccessException e) {
            tasks = Collections.EMPTY_LIST;
        } catch (Exception e) {
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
        try {
            String sql = new StringBuilder().append("SELECT t.*, d.id as id_decision, d.decision, m.id as id_mark, m.mark ").
                    append("FROM tasks AS t ").
                    append("LEFT JOIN decisions AS d ").
                    append("ON t.id = d.id_task AND d.id_user = ? ").
                    append("LEFT JOIN marks AS m ").
                    append("ON t.id = m.id_task AND m.id_user = ? ").
                    append("WHERE t.id = ?").toString();

            task = this.getJdbcTemplate().queryForObject(sql,
                    new Object[]{idUser, idUser, id},
                    new RowMapper<Task>() {
                        @Override
                        public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
                            return JdbcOfDAOtoTasks.this.createTask(id, idUser, rs);
                        }
                    });
        } catch (EmptyResultDataAccessException e) {
            task = null;
        } catch (Exception e) {
            JdbcOfDAOtoTasks.LOGGER.info(e.getMessage());
            throw new DAOtoTasksException();
        }
        return task;
    }

    /**
     * Метод создает объект Task на основании данных выборки.
     *
     * @param id     идентификатор задачи.
     * @param idUser идентификатор пользователя.
     * @param rs     выборка.
     * @return объект Task на основании данных выборки.
     * @throws SQLException
     */
    private Task createTask(int id, int idUser, ResultSet rs) throws SQLException {
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
        return new Task(rs.getInt("id"), rs.getString("name"), rs.getString("content"), decision, mark);
    }
}
