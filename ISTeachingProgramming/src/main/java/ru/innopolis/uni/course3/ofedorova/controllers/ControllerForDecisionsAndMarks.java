package ru.innopolis.uni.course3.ofedorova.controllers;

import ru.innopolis.uni.course3.ofedorova.dao.decisions.DAOtoDecisions;
import ru.innopolis.uni.course3.ofedorova.dao.decisions.JdbcOfDAOtoDecisions;
import ru.innopolis.uni.course3.ofedorova.dao.marks.DAOtoMarks;
import ru.innopolis.uni.course3.ofedorova.dao.marks.JdbcOfDAOtoMarks;
import ru.innopolis.uni.course3.ofedorova.service.marks.ServiceOfMarks;
import ru.innopolis.uni.course3.ofedorova.service.marks.ServiceOfMarksImpl;

/**
 * Класс реализует контроллер для работы с моделью данных "Decision".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public class ControllerForDecisionsAndMarks implements DAOtoDecisions {

    /**
     * Объект для доступа к данным модели "Decision".
     */
    private final DAOtoDecisions storeOfDecisions = new JdbcOfDAOtoDecisions();
    /**
     * Объект для доступа к данным модели "Mark".
     */
    private final DAOtoMarks storeOfMarks = new JdbcOfDAOtoMarks();
    /**
     * Сервисный объект для выставления оценок пользователю.
     */
    private final ServiceOfMarks serviceOfMarks = new ServiceOfMarksImpl();

    /**
     * Метод добавляет решение пользователя в систему и выставляет оценку..
     *
     * @param idTask   идентификатор задачи.
     * @param idUser   идентификатор пользователя.
     * @param decision текст решения.
     */
    @Override
    public void add(int idTask, int idUser, String decision) {
        this.storeOfDecisions.add(idTask, idUser, decision);
        this.storeOfMarks.add(idTask, idUser, this.serviceOfMarks.getMark());
    }

    /**
     * Метод закрывает соединение для работы с данными.
     */
    @Override
    public void close() {
        this.storeOfDecisions.close();
    }
}
