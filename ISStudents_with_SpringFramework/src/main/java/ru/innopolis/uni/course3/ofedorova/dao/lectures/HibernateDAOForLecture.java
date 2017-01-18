package ru.innopolis.uni.course3.ofedorova.dao.lectures;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import ru.innopolis.uni.course3.ofedorova.models.Lecture;
import ru.innopolis.uni.course3.ofedorova.services.SQLQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
public class HibernateDAOForLecture implements DAOForLecture {

    private BasicDAOForLecture basicDAOForLecture;
    private final SessionFactory factory;

    public HibernateDAOForLecture(HibernateBasicDAOForLecture basicDAOForLecture) {
        this.basicDAOForLecture = basicDAOForLecture;
        this.factory = new Configuration().configure().buildSessionFactory();
    }


    @Override
    public Collection<Lecture> valuesLectures() {
        return this.basicDAOForLecture.valuesLectures();
    }

    @Override
    public int add(Lecture lecture) {
        return 1;
    }

    @Override
    public void edit(Lecture lecture) {

    }

    @Override
    public void delete(int id) {
    }

    @Override
    public Lecture getLectureById(int id) {
        return null;
    }
}
