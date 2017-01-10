package ru.innopolis.uni.course3.ofedorova.dao.decisions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.uni.course3.ofedorova.constants.SQLQueries;
import ru.innopolis.uni.course3.ofedorova.models.Decision;

/**
 * Класс реализует модель доступа к данным модели "Decision"  с помощью JDBC.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class JdbcOfDAOtoDecisions extends JdbcDaoSupport implements DAOtoDecisions {
    /**
     * Объект для логгирования.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(JdbcOfDAOtoDecisions.class);

    /**
     * Метод добавляет решение пользователя в систему.
     *
     * @param decision решениe пользователя.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void add(Decision decision) {
        this.getJdbcTemplate().update(SQLQueries.ADD_DECISIONS, new Object[]{decision.getIdTask(), decision.getIdUser(), decision.getDecision()});
    }
}
