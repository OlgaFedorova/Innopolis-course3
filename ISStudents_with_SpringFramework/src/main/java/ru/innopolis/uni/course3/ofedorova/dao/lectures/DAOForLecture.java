package ru.innopolis.uni.course3.ofedorova.dao.lectures;

import ru.innopolis.uni.course3.ofedorova.models.Lecture;

/**
 * Created by Olga on 22.12.2016.
 */
public interface DAOForLecture extends BasicDAOForLecture {

    int add(final Lecture lecture);

    void edit(final Lecture lecture);

    void delete(final int id);
}
