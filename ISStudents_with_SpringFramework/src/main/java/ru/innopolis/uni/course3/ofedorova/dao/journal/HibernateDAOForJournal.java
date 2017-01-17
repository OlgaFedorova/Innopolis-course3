package ru.innopolis.uni.course3.ofedorova.dao.journal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.innopolis.uni.course3.ofedorova.models.Journal;
import ru.innopolis.uni.course3.ofedorova.models.Lecture;
import ru.innopolis.uni.course3.ofedorova.models.Student;
import ru.innopolis.uni.course3.ofedorova.services.HibernateSessionFactory;

import java.util.Collection;

/**
 * Created by Olga on 16.01.2017.
 */
public class HibernateDAOForJournal implements DAOForJournal {

    private final SessionFactory factory;

    public HibernateDAOForJournal() {
        //this.factory = HibernateSessionFactory.getSessionFactory();
        this.factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public Collection<Lecture> valuesLectures() {
        return null;
    }

    @Override
    public Lecture getLectureById(int id) {
        return null;
    }

    @Override
    public Collection<Student> getStudents() {
        return null;
    }

    @Override
    public Student getStudent(int id) {
        return null;
    }

    @Override
    public Collection<Journal> values() {
        final Session session = this.factory.openSession();;
        Transaction tx = session.beginTransaction();
        try {
            return session.createQuery("from Journal").list();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public int add(Journal journal) {
        return 0;
    }

    @Override
    public void delete(int id) {

    }
}
