package ru.innopolis.uni.course3.ofedorova.dao.journal;

import ru.innopolis.uni.course3.ofedorova.dao.lectures.BasicDAOForLecture;
import ru.innopolis.uni.course3.ofedorova.dao.students.BasicDAOForStudent;
import ru.innopolis.uni.course3.ofedorova.models.Journal;

import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
public interface DAOForJournal extends BasicDAOForLecture, BasicDAOForStudent {

    Collection<Journal> values();

    int add(final Journal journal);

    void delete(final int id);
}
