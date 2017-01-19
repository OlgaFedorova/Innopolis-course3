package ru.innopolis.uni.course3.ofedorova.dao.students;

import ru.innopolis.uni.course3.ofedorova.models.Student;

/**
 * Created by Olga on 22.12.2016.
 */
public interface DAOForStudent extends BasicDAOForStudent {

    int add(final Student student);

    void edit(final Student student);

    void delete(final int id);

    Student getStudent(final int id);
}
