package ru.innopolis.uni.course3.ofedorova.dao.lectures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.uni.course3.ofedorova.common.models.Lecture;

import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
@Component
public class LectureCache implements StorageOfLecture {

    @Autowired
    private final StorageOfLecture storage;

    public LectureCache(StorageOfLecture storage) {
        this.storage = storage;
    }

    @Override
    public Collection<Lecture> values() {
        return this.storage.values();
    }

    @Override
    public int add(Lecture lecture) {
        return this.storage.add(lecture);
    }

    @Override
    public void edit(Lecture lecture) {
        this.storage.edit(lecture);
    }

    @Override
    public void delete(int id) {
        this.storage.delete(id);
    }

    @Override
    public Lecture get(int id) {
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
