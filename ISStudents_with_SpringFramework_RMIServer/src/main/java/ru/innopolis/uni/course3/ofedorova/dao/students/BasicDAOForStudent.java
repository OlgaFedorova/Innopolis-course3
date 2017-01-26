package ru.innopolis.uni.course3.ofedorova.dao.students;

import ru.innopolis.uni.course3.ofedorova.common.models.Student;

import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
public interface BasicDAOForStudent {

    Collection<Student> getStudents();

    Student getStudent(final int id);
}
