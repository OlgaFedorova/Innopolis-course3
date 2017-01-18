package ru.innopolis.uni.course3.ofedorova.dao.marks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoMarksException;
import ru.innopolis.uni.course3.ofedorova.models.Mark;

/**
 * Класс реализует модель доступа к данным модели "Mark" с помощью Jdbc.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public class HibernateOfDAOtoMarks implements DAOtoMarks {

    /**
     * Объект для логгирования.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(HibernateOfDAOtoMarks.class);

    /**
     * Метод добавляет оценку за решение пользователя в БД.
     *
     * @param mark оценка за задание.
     */
    @Override
    public void add(Mark mark) throws DAOtoMarksException {
        /*
        this.getJdbcTemplate().update(SQLQueries.ADD_MARKS, new Object[]{mark.getTask(), mark.getUser(), mark.getMark()});
        */
    }
}
