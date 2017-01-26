package ru.innopolis.uni.course3.ofedorova.common.controllers;

import ru.innopolis.uni.course3.ofedorova.common.models.Journal;
import ru.innopolis.uni.course3.ofedorova.common.models.Lecture;
import ru.innopolis.uni.course3.ofedorova.common.models.Student;
import ru.innopolis.uni.course3.ofedorova.dao.journal.DAOForJournal;

import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
public class JournalController implements AbstractJournalController {

    static final long SerialVersionUID = 1L;

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
    public Collection<Lecture> valuesLectures() {
        return this.daoForJournal.valuesLectures();
    }

    @Override
    public Lecture getLectureById(int id) {
        return this.daoForJournal.getLectureById(id);
    }

    @Override
    public Student getStudent(int id) {
        return this.daoForJournal.getStudent(id);
    }

    @Override
    public Collection<Student> getStudents() {
        return this.daoForJournal.getStudents();
    }

    public int generateId() {
        return 0;
    }
}
