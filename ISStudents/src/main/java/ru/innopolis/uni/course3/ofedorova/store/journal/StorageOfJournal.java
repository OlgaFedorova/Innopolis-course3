package ru.innopolis.uni.course3.ofedorova.store.journal;

import ru.innopolis.uni.course3.ofedorova.models.Journal;

import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
public interface StorageOfJournal {

    public Collection<Journal> values();

    public int add(final Journal journal);

    public void delete(final int id);

    public int generateId();

    public void close();
}
