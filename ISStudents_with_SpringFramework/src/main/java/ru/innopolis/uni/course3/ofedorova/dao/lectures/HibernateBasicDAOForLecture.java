package ru.innopolis.uni.course3.ofedorova.dao.lectures;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import ru.innopolis.uni.course3.ofedorova.models.Journal;
import ru.innopolis.uni.course3.ofedorova.models.Lecture;
import ru.innopolis.uni.course3.ofedorova.services.SQLQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Olga on 22.12.2016.
 */
public class HibernateBasicDAOForLecture implements BasicDAOForLecture {

    private final SessionFactory factory;

    public HibernateBasicDAOForLecture() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public Collection<Lecture> valuesLectures() {
        Collection<Lecture> result = Collections.EMPTY_LIST;
        final Session session = this.factory.openSession();;
        Transaction tx = session.beginTransaction();
        try {
            result = session.createQuery("FROM Lecture").list();
        } finally {
            tx.commit();
            session.close();
        }
        return result;
    }

    @Override
    public Lecture getLectureById(int id) {
        return null;
    }

}
