package ru.innopolis.uni.course3.ofedorova.common.controllers;

import ru.innopolis.uni.course3.ofedorova.common.models.Journal;
import ru.innopolis.uni.course3.ofedorova.common.models.Lecture;
import ru.innopolis.uni.course3.ofedorova.common.models.Student;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
public interface AbstractJournalController extends Serializable {

    static final long SerialVersionUID = 1L;

    Collection<Journal> values();

    int add(Journal journal);

    void delete(int id);

    Collection<Lecture> valuesLectures();

    Lecture getLectureById(int id);

    Student getStudent(int id);

    Collection<Student> getStudents();

    int generateId();
}
