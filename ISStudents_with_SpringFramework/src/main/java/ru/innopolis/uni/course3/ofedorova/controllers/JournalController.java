package ru.innopolis.uni.course3.ofedorova.controllers;

import ru.innopolis.uni.course3.ofedorova.dao.journal.DAOForJournal;
import ru.innopolis.uni.course3.ofedorova.models.Journal;
import ru.innopolis.uni.course3.ofedorova.models.Lecture;
import ru.innopolis.uni.course3.ofedorova.models.Student;

import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
public class JournalController implements DAOForJournal {

    private final DAOForJournal daoForJournal;

    public JournalController(DAOForJournal daoForJournal) {
        this.daoForJournal = daoForJournal;
    }

    @Override
    public Collection<Journal> values() {
        return this.daoForJournal.values();
    }

    @Override
    public int add(Journal journal) {
        return this.daoForJournal.add(journal);
    }

    @Override
    public void delete(int id) {
        this.daoForJournal.delete(id);
    }

    @Override
    public int generateId() {
        return this.daoForJournal.generateId();
    }

    @Override
    public Collection<Lecture> getLectures() {
        return this.daoForJournal.getLectures();
    }

    @Override
    public Lecture getLecture(int id) {
        return this.daoForJournal.getLecture(id);
    }

    @Override
    public Student getStudent(int id) {
        return this.daoForJournal.getStudent(id);
    }

    @Override
    public Collection<Student> getStudents() {
        return this.daoForJournal.getStudents();
    }
}
