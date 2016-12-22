package ru.innopolis.uni.course3.ofedorova.store.lectures;

import ru.innopolis.uni.course3.ofedorova.models.Lecture;

import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
public class LectureCache implements StorageOfLecture {

    private static final StorageOfLecture STORAGE_OF_LECTURE = new JdbcStorage();
    private final StorageOfLecture storage;

    public LectureCache() {
        this.storage = STORAGE_OF_LECTURE;
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
