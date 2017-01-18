package ru.innopolis.uni.course3.ofedorova.dao.journal;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Olga on 17.01.2017.
 */
public class HibernateDAOForJournalTest {
    @Test
    public void values() throws Exception {
        new HibernateDAOForJournal().valuesLectures();
    }

}