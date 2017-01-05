package ru.innopolis.uni.course3.ofedorova.dao.marks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoMarksException;

/**
 * Класс реализует модель доступа к данным модели "Mark" с помощью Jdbc.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public class JdbcOfDAOtoMarks extends JdbcDaoSupport implements DAOtoMarks {

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
        try {
            String sql = "INSERT  INTO marks (id_task , id_user, mark) VALUES (?, ?, ?)";
            this.getJdbcTemplate().update(sql, new Object[]{idTask, idUser, mark});
        } catch (Exception e) {
            JdbcOfDAOtoMarks.LOGGER.info(e.getMessage());
            throw new DAOtoMarksException();
        }
    }
}
