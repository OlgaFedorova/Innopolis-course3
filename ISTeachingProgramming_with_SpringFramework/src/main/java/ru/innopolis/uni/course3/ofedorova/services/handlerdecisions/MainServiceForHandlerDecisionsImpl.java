package ru.innopolis.uni.course3.ofedorova.services.handlerdecisions;

import ru.innopolis.uni.course3.ofedorova.dao.decisions.DAOtoDecisions;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoDecisionsException;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoMarksException;
import ru.innopolis.uni.course3.ofedorova.dao.marks.DAOtoMarks;
import ru.innopolis.uni.course3.ofedorova.models.Decision;
import ru.innopolis.uni.course3.ofedorova.models.Mark;

/**
 * Класс реализует главный сервис для работы с моделью данных "Decision".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public class MainServiceForHandlerDecisionsImpl implements MainServiceForHandlerDecisions {

    /**
     * Объект для доступа к данным модели "Decision".
     */
    private final DAOtoDecisions daOtoDecisions;
    /**
     * Объект для доступа к данным модели "Mark".
     */
    private final DAOtoMarks daOtoMarks;
    /**
     * Сервисный объект для выставления оценок пользователю.
     */
    private final ServiceOfMarks serviceOfMarks;

    /**
     * Создает новый {@code MainServiceForHandlerDecisionsImpl}.
     *
     * @param storeOfDecisions значение поля "daOtoDecisions".
     * @param storeOfMarks     значение поля "daOtoMarks".
     * @param serviceOfMarks   значение поля "serviceOfMarks".
     */
    public MainServiceForHandlerDecisionsImpl(DAOtoDecisions storeOfDecisions, DAOtoMarks storeOfMarks, ServiceOfMarks serviceOfMarks) {
        this.daOtoDecisions = storeOfDecisions;
        this.daOtoMarks = storeOfMarks;
        this.serviceOfMarks = serviceOfMarks;
    }

    /**
     * Метод добавляет решение пользователя в систему и выставляет оценку..
     *
     * @param decision решениe пользователя.
     */
    @Override
    public void add(Decision decision) throws DAOtoDecisionsException, DAOtoMarksException {
        this.daOtoDecisions.add(decision);
        this.daOtoMarks.add(new Mark(decision.getIdTask(), decision.getIdUser(), this.serviceOfMarks.getMark()));
    }
}
