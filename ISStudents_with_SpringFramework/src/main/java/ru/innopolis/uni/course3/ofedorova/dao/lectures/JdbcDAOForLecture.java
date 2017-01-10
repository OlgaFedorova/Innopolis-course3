package ru.innopolis.uni.course3.ofedorova.dao.lectures;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import ru.innopolis.uni.course3.ofedorova.models.Lecture;
import ru.innopolis.uni.course3.ofedorova.services.SQLQueries;

import java.sql.*;
import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
public class JdbcDAOForLecture extends JdbcDaoSupport implements DAOForLecture {

    private JdbcBasicDAOForLecture basicDAOForLecture;
    private TransactionTemplate transactionTemplate;

    public void setBasicDAOForLecture(JdbcBasicDAOForLecture basicDAOForLecture) {
        this.basicDAOForLecture = basicDAOForLecture;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }


    @Override
    public Collection<Lecture> valuesLectures() {
        return this.basicDAOForLecture.valuesLectures();
    }

    @Override
    public int add(Lecture lecture) {
        return this.transactionTemplate.execute(new TransactionCallback<Integer>() {
            @Override
            public Integer doInTransaction(TransactionStatus status) {
                Integer result = null;
                try {
                    KeyHolder keyHolder = new GeneratedKeyHolder();
                    JdbcDAOForLecture.this.getJdbcTemplate().update(new PreparedStatementCreator() {
                        @Override
                        public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                            final PreparedStatement ps = con.prepareStatement(SQLQueries.ADD_LECTURE,
                                    Statement.RETURN_GENERATED_KEYS);
                            ps.setString(1, lecture.getSubject());
                            ps.setInt(2, lecture.getHoursOfTheory());
                            ps.setInt(3, lecture.getHoursOfPractice());
                            return ps;
                        }
                    }, keyHolder);
                    result = (Integer) keyHolder.getKeyList().get(0).get("id");
                } catch (RuntimeException e) {
                    status.setRollbackOnly();
                    throw e;
                }
                return result;
            }
        });
    }

    @Override
    public void edit(Lecture lecture) {
        this.transactionTemplate.execute(new TransactionCallback<Void>() {
            @Override
            public Void doInTransaction(TransactionStatus status) {
                try {
                    JdbcDAOForLecture.this.getJdbcTemplate().update(SQLQueries.EDIT_LECTURE, new Object[]{lecture.getSubject(), lecture.getHoursOfTheory(), lecture.getHoursOfPractice(), lecture.getId()});
                } catch (RuntimeException e) {
                    status.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
    }

    @Override
    public void delete(int id) {
        this.transactionTemplate.execute(new TransactionCallback<Void>() {
            @Override
            public Void doInTransaction(TransactionStatus status) {
                try {
                    JdbcDAOForLecture.this.getJdbcTemplate().update(SQLQueries.DELETE_LECTURE, id);;
                } catch (RuntimeException e) {
                    status.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
    }

    @Override
    public Lecture getLectureById(int id) {
        return this.basicDAOForLecture.getLectureById(id);
    }
}
