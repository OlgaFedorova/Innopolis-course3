package ru.innopolis.uni.course3.ofedorova.dao.lectures;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import ru.innopolis.uni.course3.ofedorova.models.Lecture;
import ru.innopolis.uni.course3.ofedorova.services.SQLQueries;

import java.sql.*;
import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
public class JdbcBasicDAOForLecture extends JdbcDaoSupport implements BasicDAOForLecture {

    @Override
    public Collection<Lecture> valuesLectures() {
        return this.getJdbcTemplate().query(SQLQueries.LIST_LECTURES, new RowMapper<Lecture>() {
            @Override
            public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Lecture(rs.getInt("id"), rs.getString("subject"), rs.getInt("hours_of_theory"), rs.getInt("hours_of_practice"));
            }
        });
    }

    @Override
    public Lecture getLectureById(int id) {
        return this.getJdbcTemplate().queryForObject(SQLQueries.LECTURE_BY_ID, new Object[]{id}, new RowMapper<Lecture>() {
            @Override
            public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Lecture(rs.getInt("id"), rs.getString("subject"), rs.getInt("hours_of_theory"), rs.getInt("hours_of_practice"));
            }
        });
    }

}
