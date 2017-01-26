package ru.innopolis.uni.course3.ofedorova.services.handlerdecisions;

import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoDecisionsException;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoMarksException;
import ru.innopolis.uni.course3.ofedorova.models.Decision;

/**
 * Интерфейс реализует главный сервис для работы с моделью данных "Decision".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public interface MainServiceForHandlerDecisions {

    /**
     * Метод добавляет решение пользователя в систему и выставляет оценку..
     *
     * @param decision решениe пользователя.
     */
    void add(Decision decision) throws DAOtoDecisionsException, DAOtoMarksException;
}
