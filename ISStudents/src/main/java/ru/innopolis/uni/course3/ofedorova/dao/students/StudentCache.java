package ru.innopolis.uni.course3.ofedorova.dao.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.uni.course3.ofedorova.common.models.Student;

import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
@Component
public class StudentCache implements StorageOfStudent {

    @Autowired
    private final StorageOfStudent storage;

    public StudentCache(StorageOfStudent storage) {
        this.storage = storage;
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
