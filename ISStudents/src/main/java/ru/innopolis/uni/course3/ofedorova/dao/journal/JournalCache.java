package ru.innopolis.uni.course3.ofedorova.dao.journal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.uni.course3.ofedorova.common.models.Journal;
import ru.innopolis.uni.course3.ofedorova.common.models.Lecture;
import ru.innopolis.uni.course3.ofedorova.common.models.Student;

import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
@Component
public class JournalCache implements StorageOfJournal {

    @Autowired
    private final StorageOfJournal storage;

    public JournalCache(StorageOfJournal storage) {
        this.storage = storage;
    }

    @Override
    public Collection<Journal> values() {
        return this.storage.values();
    }

    @Override
    public int add(Journal journal) {
        return this.storage.add(journal);
    }

    @Override
    public void delete(int id) {
        this.storage.delete(id);
    }

    @Override
    public int generateId() {
        return this.storage.generateId();
    }

    @Override
    public void close() {
        this.storage.close();
    }

    @Override
    public Collection<Lecture> getLectures() {
        return this.storage.getLectures();
    }

    @Override
    public Lecture getLecture(int id) {
        return this.storage.getLecture(id);
    }

    @Override
    public Student getStudent(int id) {
        return this.storage.getStudent(id);
    }

    @Override
    public Collection<Student> getStudents() {
        return this.storage.getStudents();
    }
}
