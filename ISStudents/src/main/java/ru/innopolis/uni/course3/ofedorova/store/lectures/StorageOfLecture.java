package ru.innopolis.uni.course3.ofedorova.store.lectures;

import ru.innopolis.uni.course3.ofedorova.models.Lecture;

import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
public interface StorageOfLecture {

    public Collection<Lecture> values();

    public int add(final Lecture lecture);

    public void edit(final Lecture lecture);

    public void delete(final int id);

    public Lecture get(final int id);

    public int generateId();

    public void close();
}
