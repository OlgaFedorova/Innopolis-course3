package ru.innopolis.uni.course3.ofedorova.dao.decisions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.course3.ofedorova.models.Decision;

/**
 * Класс реализует модель доступа к данным модели "Decision"  с помощью JDBC.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public class HibernateOfDAOtoDecisions implements DAOtoDecisions {
    /**
     * Объект для логгирования.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(HibernateOfDAOtoDecisions.class);

    /**
     * Метод добавляет решение пользователя в систему.
     *
     * @param decision решениe пользователя.
     */
    @Override
    public void add(Decision decision) {
        /*
        this.getJdbcTemplate().update(SQLQueries.ADD_DECISIONS, new Object[]{decision.getTask(), decision.getUser(), decision.getDecision()});
        */
    }
}
