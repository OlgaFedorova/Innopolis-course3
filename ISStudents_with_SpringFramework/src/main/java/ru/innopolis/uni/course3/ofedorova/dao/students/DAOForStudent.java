package ru.innopolis.uni.course3.ofedorova.dao.students;

import ru.innopolis.uni.course3.ofedorova.models.Student;

import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
public interface DAOForStudent {

    public Collection<Student> values();

    public int add(final Student student);

    public void edit(final Student student);

    public void delete(final int id);

    public Student get(final int id);

    public int generateId();
}
