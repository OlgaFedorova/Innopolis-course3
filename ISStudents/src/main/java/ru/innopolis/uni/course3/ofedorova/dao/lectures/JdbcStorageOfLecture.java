package ru.innopolis.uni.course3.ofedorova.dao.lectures;

import org.springframework.stereotype.Component;
import ru.innopolis.uni.course3.ofedorova.models.Lecture;
import ru.innopolis.uni.course3.ofedorova.services.ConnectionPoolFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Olga on 22.12.2016.
 */
@Component
public class JdbcStorageOfLecture implements StorageOfLecture {

    private Connection connection;

    public JdbcStorageOfLecture() {
        try {
            this.connection = ConnectionPoolFactory.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Lecture> values() {
        final List<Lecture> lectures = new ArrayList<>();
        try (final Statement statement = this.connection.createStatement();
            final ResultSet rs = statement.executeQuery("SELECT * FROM lectures ORDER BY id")) {
            while (rs.next()) {
                lectures.add(new Lecture(rs.getInt("id"), rs.getString("subject"), rs.getInt("hours_of_theory"), rs.getInt("hours_of_practice")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lectures;
    }

    @Override
    public int add(Lecture lecture) {
        try (final PreparedStatement statement = this.connection.prepareStatement("INSERT  INTO lectures (subject, hours_of_theory, hours_of_practice) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, lecture.getSubject());
            statement.setInt(2, lecture.getHoursOfTheory());
            statement.setInt(3, lecture.getHoursOfPractice());
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not create new lecture");
    }

    @Override
    public void edit(Lecture lecture) {
        try (final PreparedStatement statement = this.connection.prepareStatement("UPDATE lectures SET subject = ?, hours_of_theory = ?, hours_of_practice = ? WHERE id = ?")) {
            statement.setString(1, lecture.getSubject());
            statement.setInt(2, lecture.getHoursOfTheory());
            statement.setInt(3, lecture.getHoursOfPractice());
            statement.setInt(4, lecture.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (final PreparedStatement statement = this.connection.prepareStatement("DELETE FROM  lectures WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Lecture get(int id) {
        try (final PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM lectures WHERE id = ?")) {
            statement.setInt(1, id);
            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    return new Lecture(rs.getInt("id"), rs.getString("subject"), rs.getInt("hours_of_theory"), rs.getInt("hours_of_practice"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException(String.format("Lecture %s does not exists", id));
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
