package ru.innopolis.uni.course3.ofedorova.dao.journal;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import ru.innopolis.uni.course3.ofedorova.dao.lectures.JdbcBasicDAOForLecture;
import ru.innopolis.uni.course3.ofedorova.dao.students.JdbcBasicDAOForStudent;
import ru.innopolis.uni.course3.ofedorova.models.Journal;
import ru.innopolis.uni.course3.ofedorova.models.Lecture;
import ru.innopolis.uni.course3.ofedorova.models.Student;
import ru.innopolis.uni.course3.ofedorova.service.SQLQueries;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
public class JdbcDAOForJournal extends JdbcDaoSupport implements DAOForJournal {

    private JdbcBasicDAOForLecture basicDAOForLecture;
    private JdbcBasicDAOForStudent basicDAOForStudent;
    private TransactionTemplate transactionTemplate;

    public void setBasicDAOForLecture(JdbcBasicDAOForLecture basicDAOForLecture) {
        this.basicDAOForLecture = basicDAOForLecture;
    }

    public void setBasicDAOForStudent(JdbcBasicDAOForStudent basicDAOForStudent) {
        this.basicDAOForStudent = basicDAOForStudent;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    public Collection<Journal> values() {
        return this.getJdbcTemplate().query(SQLQueries.LIST_JOURNAL, new RowMapper<Journal>() {
            @Override
            public Journal mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Journal(rs.getInt("id"), rs.getString("date_of_record"),
                        new Lecture(rs.getInt("l_id"), rs.getString("subject"), rs.getInt("hours_of_theory"), rs.getInt("hours_of_practice")),
                        new Student(rs.getInt("s_id"), rs.getString("name"), rs.getString("class")));
            }
        });
    }

    @Override
    public int add(Journal journal) {
        return this.transactionTemplate.execute(new TransactionCallback<Integer>() {
            @Override
            public Integer doInTransaction(TransactionStatus status) {
                Integer result = null;
                try {
                    KeyHolder keyHolder = new GeneratedKeyHolder();
                    JdbcDAOForJournal.this.getJdbcTemplate().update(new PreparedStatementCreator() {
                        @Override
                        public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                            final PreparedStatement ps = con.prepareStatement(SQLQueries.ADD_RECORD_INTO_JOURNAL,
                                    Statement.RETURN_GENERATED_KEYS);
                            try {
                                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                                java.util.Date date = formatter.parse(journal.getDateOfRecord());
                                ps.setDate(1, new java.sql.Date(date.getTime()));
                                ps.setInt(2, journal.getLecture().getId());
                                ps.setInt(3, journal.getStudent().getId());
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
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
    public void delete(int id) {
        this.transactionTemplate.execute(new TransactionCallback<Void>() {
            @Override
            public Void doInTransaction(TransactionStatus status) {
                try {
                    JdbcDAOForJournal.this.getJdbcTemplate().update(SQLQueries.DELETE_RECORD_FROM_JOURNAL, id);
                } catch (RuntimeException e) {
                    status.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
    }

    @Override
    public Collection<Lecture> valuesLectures() {
        return this.basicDAOForLecture.valuesLectures();
    }

    @Override
    public Lecture getLectureById(int id) {
        return this.basicDAOForLecture.getLectureById(id);
    }

    @Override
    public Student getStudent(int id) {
        return this.basicDAOForStudent.getStudent(id);
    }

    @Override
    public Collection<Student> getStudents() {
        return this.basicDAOForStudent.getStudents();
    }
}
