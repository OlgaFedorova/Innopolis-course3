package ru.innopolis.uni.course3.ofedorova.store.storageofstudents;

import ru.innopolis.uni.course3.ofedorova.models.Student;
import ru.innopolis.uni.course3.ofedorova.service.Settings;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Olga on 22.12.2016.
 */
public class JdbcStorage implements StorageOfStudent {

    static{
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private final Connection connection;

    public JdbcStorage() {
        final Settings settings = Settings.getInstance();
        try {
            this.connection = DriverManager.getConnection(settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Collection<Student> values() {
        final List<Student> students = new ArrayList<>();
        try (final Statement statement = this.connection.createStatement();
             final ResultSet rs = statement.executeQuery("SELECT * FROM students")) {
            while (rs.next()) {
                students.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("class")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public int add(Student student) {
        try (final PreparedStatement statement = this.connection.prepareStatement("INSERT  INTO students (name, class) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getGroup());
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not create new student");
    }

    @Override
    public void edit(Student student) {
        try (final PreparedStatement statement = this.connection.prepareStatement("UPDATE students SET name = ?, class = ? WHERE id = ?")) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getGroup());
            statement.setInt(3, student.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (final PreparedStatement statement = this.connection.prepareStatement("DELETE FROM  students WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student get(int id) {
        try (final PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM students WHERE id = ?")) {
            statement.setInt(1, id);
            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    return new Student(rs.getInt("id"), rs.getString("name"), rs.getString("class"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException(String.format("Student %s does not exists", id));
    }

    @Override
    public int generateId() {
        //TODO
        return 0;
    }

    @Override
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
