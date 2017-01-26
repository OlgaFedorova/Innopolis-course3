package ru.innopolis.uni.course3.ofedorova.dao.lectures;

import ru.innopolis.uni.course3.ofedorova.common.models.Lecture;

import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
public interface BasicDAOForLecture {

    Collection<Lecture> valuesLectures();

    Lecture getLectureById(final int id);
}
