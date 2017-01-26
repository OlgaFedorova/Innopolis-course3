package ru.innopolis.uni.course3.ofedorova.dao.decisions;

import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoDecisionsException;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoMarksException;
import ru.innopolis.uni.course3.ofedorova.common.models.Decision;

/**
 * Интерфейс реализует модель доступа к данным модели "Decision".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public interface DAOtoDecisions {

    /**
     * Метод добавляет решение пользователя в систему.
     *
     * @param decision решениe пользователя.
     */
    void add(Decision decision) throws DAOtoDecisionsException, DAOtoMarksException;
}
