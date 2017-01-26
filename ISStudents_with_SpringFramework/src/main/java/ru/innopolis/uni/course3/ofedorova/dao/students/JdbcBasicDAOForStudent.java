package ru.innopolis.uni.course3.ofedorova.dao.students;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import ru.innopolis.uni.course3.ofedorova.models.Student;
import ru.innopolis.uni.course3.ofedorova.services.SQLQueries;

import java.sql.*;
import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
public class JdbcBasicDAOForStudent extends JdbcDaoSupport implements BasicDAOForStudent {

    @Override
    public Student getStudent(int id) {
        return this.getJdbcTemplate().queryForObject(SQLQueries.STUDENT_BY_ID, new Object[]{id}, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Student(rs.getInt("id"), rs.getString("name"), rs.getString("class"));
            }
        });
    }

    @Override
    public Collection<Student> getStudents() {
        return this.getJdbcTemplate().query(SQLQueries.LIST_STUDENTS, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Student(rs.getInt("id"), rs.getString("name"), rs.getString("class"));
            }
        });
    }
}
