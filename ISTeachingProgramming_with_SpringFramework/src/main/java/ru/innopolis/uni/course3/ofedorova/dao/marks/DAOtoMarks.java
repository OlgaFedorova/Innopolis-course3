package ru.innopolis.uni.course3.ofedorova.dao.marks;

import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoMarksException;

/**
 * Интерфейс реализует модель доступа к данным модели "Mark".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public interface DAOtoMarks {

    /**
     * Метод добавляет оценку за решение пользователя в БД.
     *
     * @param idTask идентификатор задания.
     * @param idUser идентификатор пользователя.
     * @param mark   оценка за задание.
     */
    void add(int idTask, int idUser, int mark) throws DAOtoMarksException;
}
