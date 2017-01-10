package ru.innopolis.uni.course3.ofedorova.services.tasks;

import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoTasksException;
import ru.innopolis.uni.course3.ofedorova.models.Task;

import java.util.Collection;

/**
 * Интерфейс реализует главный сервис для работы с моделью данных "Task".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public interface MainServiceForTasks {

    /**
     * Метод возвращает список заданий в БД.
     *
     * @param idUser идентификатор пользователя.
     * @return список заданий в БД.
     */
    Collection<Task> values(int idUser) throws DAOtoTasksException;

    /**
     * Метод возвращает задание по переданному id.
     *
     * @param id     идентификатор задания.
     * @param idUser идентификатор пользователя.
     * @return задание найденное по id.
     */
    Task getById(int id, int idUser) throws DAOtoTasksException;
}
