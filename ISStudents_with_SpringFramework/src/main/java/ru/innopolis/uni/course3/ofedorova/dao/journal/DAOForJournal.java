package ru.innopolis.uni.course3.ofedorova.dao.journal;

import ru.innopolis.uni.course3.ofedorova.models.Journal;
import ru.innopolis.uni.course3.ofedorova.models.Lecture;
import ru.innopolis.uni.course3.ofedorova.models.Student;

import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
public interface DAOForJournal {

    public Collection<Journal> values();

    public int add(final Journal journal);

    public void delete(final int id);

    public int generateId();

    public Collection<Lecture> getLectures();

    public Collection<Student> getStudents();

    public Lecture getLecture(final int id);

    public Student getStudent(final int id);
}
