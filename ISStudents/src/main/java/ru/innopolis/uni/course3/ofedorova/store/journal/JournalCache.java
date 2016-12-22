package ru.innopolis.uni.course3.ofedorova.store.journal;

import ru.innopolis.uni.course3.ofedorova.models.Journal;

import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
public class JournalCache implements StorageOfJournal {

    private static final StorageOfJournal STORAGE_OF_LECTURE = new JdbcStorage();
    private final StorageOfJournal storage;

    public JournalCache() {
        this.storage = STORAGE_OF_LECTURE;
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
}
