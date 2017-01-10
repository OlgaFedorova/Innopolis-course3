package ru.innopolis.uni.course3.ofedorova.dao.students;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.innopolis.uni.course3.ofedorova.models.Student;
import ru.innopolis.uni.course3.ofedorova.services.SQLQueries;

import java.sql.*;
import java.util.Collection;

/**
 * Created by Olga on 22.12.2016.
 */
public class JdbcDAOForStudent extends JdbcDaoSupport implements DAOForStudent {

    private JdbcBasicDAOForStudent basicDAOForStudent;

    public void setBasicDAOForStudent(JdbcBasicDAOForStudent basicDAOForStudent) {
        this.basicDAOForStudent = basicDAOForStudent;
    }

    @Override
    public Collection<Student> getStudents() {
        return this.basicDAOForStudent.getStudents();
    }

    @Override
    public int add(Student student) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.getJdbcTemplate().update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                final PreparedStatement ps = con.prepareStatement(SQLQueries.ADD_STUDENT,
                        Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, student.getName());
                ps.setString(2, student.getGroup());
                return ps;
            }
        }, keyHolder);
        return (Integer) keyHolder.getKeyList().get(0).get("id");
    }

    @Override
    public void edit(Student student) {
        this.getJdbcTemplate().update(SQLQueries.EDIT_STUDENT, student.getName(), student.getGroup(), student.getId());
    }

    @Override
    public void delete(int id) {
        this.getJdbcTemplate().update(SQLQueries.DELETE_STUDENT, id);
    }

    @Override
    public Student getStudent(int id) {
        return this.basicDAOForStudent.getStudent(id);
    }
}
