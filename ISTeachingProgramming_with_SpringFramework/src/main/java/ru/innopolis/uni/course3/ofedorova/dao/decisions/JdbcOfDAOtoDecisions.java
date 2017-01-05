package ru.innopolis.uni.course3.ofedorova.dao.decisions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoDecisionsException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Класс реализует модель доступа к данным модели "Decision"  с помощью JDBC.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public class JdbcOfDAOtoDecisions extends JdbcDaoSupport implements DAOtoDecisions {
    /**
     * Объект для логгирования.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcOfDAOtoDecisions.class);

    /**
     * Метод добавляет решение пользователя в систему.
     *
     * @param idTask   идентификатор задачи.
     * @param idUser   идентификатор пользователя.
     * @param decision текст решения.
     */
    @Override
    public void add(int idTask, int idUser, String decision) throws DAOtoDecisionsException {
        try {
            String sql = "INSERT  INTO decisions (id_task , id_user, decision) VALUES (?, ?, ?)";
            this.getJdbcTemplate().update(sql, new Object[]{idTask, idUser, decision});
        } catch (Exception e) {
            JdbcOfDAOtoDecisions.LOGGER.info(e.getMessage());
            throw new DAOtoDecisionsException();
        }
    }
}
