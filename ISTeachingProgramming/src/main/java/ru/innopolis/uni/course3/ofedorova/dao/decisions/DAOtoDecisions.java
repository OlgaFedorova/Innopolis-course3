package ru.innopolis.uni.course3.ofedorova.dao.decisions;

import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoDecisionsException;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoMarksException;

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
     * @param idTask   идентификатор задачи.
     * @param idUser   идентификатор пользователя.
     * @param decision текст решения.
     */
    void add(int idTask, int idUser, String decision) throws DAOtoDecisionsException, DAOtoMarksException;
}
