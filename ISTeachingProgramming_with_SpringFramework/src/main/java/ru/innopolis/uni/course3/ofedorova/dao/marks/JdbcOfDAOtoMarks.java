package ru.innopolis.uni.course3.ofedorova.dao.marks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.uni.course3.ofedorova.constants.SQLQueries;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoMarksException;

/**
 * Класс реализует модель доступа к данным модели "Mark" с помощью Jdbc.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class JdbcOfDAOtoMarks extends JdbcDaoSupport implements DAOtoMarks {

    /**
     * Объект для логгирования.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(JdbcOfDAOtoMarks.class);

    /**
     * Метод добавляет оценку за решение пользователя в БД.
     *
     * @param idTask идентификатор задания.
     * @param idUser идентификатор пользователя.
     * @param mark   оценка за задание.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void add(int idTask, int idUser, int mark) throws DAOtoMarksException {
        this.getJdbcTemplate().update(SQLQueries.ADD_MARKS, new Object[]{idTask, idUser, mark});
    }
}
