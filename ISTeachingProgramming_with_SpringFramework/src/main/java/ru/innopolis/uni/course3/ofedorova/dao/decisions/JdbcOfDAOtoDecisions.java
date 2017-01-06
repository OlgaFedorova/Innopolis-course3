package ru.innopolis.uni.course3.ofedorova.dao.decisions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import ru.innopolis.uni.course3.ofedorova.constants.SQLQueries;

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
    public static final Logger LOGGER = LoggerFactory.getLogger(JdbcOfDAOtoDecisions.class);

    /**
     * Метод добавляет решение пользователя в систему.
     *
     * @param idTask   идентификатор задачи.
     * @param idUser   идентификатор пользователя.
     * @param decision текст решения.
     */
    @Override
    public void add(int idTask, int idUser, String decision) {
        this.getJdbcTemplate().update(SQLQueries.ADD_DECISIONS, new Object[]{idTask, idUser, decision});
    }
}
