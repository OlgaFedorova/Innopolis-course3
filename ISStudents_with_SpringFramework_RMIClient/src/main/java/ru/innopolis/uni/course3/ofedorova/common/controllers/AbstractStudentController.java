package ru.innopolis.uni.course3.ofedorova.common.controllers;

import ru.innopolis.uni.course3.ofedorova.common.models.Student;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
public interface AbstractStudentController extends Serializable {

    static final long SerialVersionUID = 1L;

    Collection<Student> getStudents();

    int add(Student student);

    void edit(Student student);

    void delete(int id);

    Student getStudent(int id);

    int generateId();
}
