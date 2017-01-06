package ru.innopolis.uni.course3.ofedorova.dao.lectures;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.innopolis.uni.course3.ofedorova.models.Lecture;
import ru.innopolis.uni.course3.ofedorova.service.SQLQueries;

import java.sql.*;
import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
public class JdbcDAOForLecture extends JdbcDaoSupport implements DAOForLecture {

    private JdbcBasicDAOForLecture basicDAOForLecture;

    public void setBasicDAOForLecture(JdbcBasicDAOForLecture basicDAOForLecture) {
        this.basicDAOForLecture = basicDAOForLecture;
    }

    @Override
    public Collection<Lecture> valuesLectures() {
        return this.basicDAOForLecture.valuesLectures();
    }

    @Override
    public int add(Lecture lecture) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.getJdbcTemplate().update(new PreparedStatementCreator() {
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
        return (Integer) keyHolder.getKeyList().get(0).get("id");
    }

    @Override
    public void edit(Lecture lecture) {
        this.getJdbcTemplate().update(SQLQueries.EDIT_LECTURE, new Object[]{lecture.getSubject(), lecture.getHoursOfTheory(), lecture.getHoursOfPractice(), lecture.getId()});
    }

    @Override
    public void delete(int id) {
        this.getJdbcTemplate().update(SQLQueries.DELETE_LECTURE, id);
    }

    @Override
    public Lecture getLectureById(int id) {
        return this.basicDAOForLecture.getLectureById(id);
    }
}
