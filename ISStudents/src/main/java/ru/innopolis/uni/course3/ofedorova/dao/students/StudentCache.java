package ru.innopolis.uni.course3.ofedorova.dao.students;

import ru.innopolis.uni.course3.ofedorova.models.Student;

import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
public class StudentCache implements StorageOfStudent {

    private static final StorageOfStudent STORAGE_OF_STUDENT = new JdbcStorage();
    private final StorageOfStudent storage;

    public StudentCache() {
        this.storage = STORAGE_OF_STUDENT;
    }

    @Override
    public Collection<Student> values() {
        return this.storage.values();
    }

    @Override
    public int add(Student student) {
        return this.storage.add(student);
    }

    @Override
    public void edit(Student student) {
        this.storage.edit(student);
    }

    @Override
    public void delete(int id) {
        this.storage.delete(id);
    }

    @Override
    public Student get(int id) {
        return this.storage.get(id);
    }

    @Override
    public int generateId() {
        return this.storage.generateId();
    }

    @Override
    public void close() {
        this.storage.close();
    }


}
