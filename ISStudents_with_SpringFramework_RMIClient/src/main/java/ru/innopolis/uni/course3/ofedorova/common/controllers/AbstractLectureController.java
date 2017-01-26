package ru.innopolis.uni.course3.ofedorova.common.controllers;

import ru.innopolis.uni.course3.ofedorova.common.models.Lecture;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
public interface AbstractLectureController extends Serializable {

    static final long SerialVersionUID = 1L;

    Collection<Lecture> valuesLectures();

    int add(Lecture lecture);

    void edit(Lecture lecture);

    void delete(int id);

    Lecture getLectureById(int id);

    int generateId();
}
