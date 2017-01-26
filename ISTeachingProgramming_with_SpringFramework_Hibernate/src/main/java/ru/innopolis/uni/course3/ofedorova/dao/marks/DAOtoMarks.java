package ru.innopolis.uni.course3.ofedorova.dao.marks;

import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoMarksException;
import ru.innopolis.uni.course3.ofedorova.common.models.Mark;

/**
 * Интерфейс реализует модель доступа к данным модели "Mark".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public interface DAOtoMarks {

    /**
     * Метод возвращает объект "Оценку".
     *
     * @param idUser идентификатор пользователя.
     * @param idTask идентификатор задания.
     * @return объект "Оценка".
     */
    public Mark getMark(int idUser, int idTask);

    /**
     * Метод добавляет оценку за решение пользователя в БД.
     *
     * @param mark оценка за задание.
     */
    void add(Mark mark) throws DAOtoMarksException;
}
