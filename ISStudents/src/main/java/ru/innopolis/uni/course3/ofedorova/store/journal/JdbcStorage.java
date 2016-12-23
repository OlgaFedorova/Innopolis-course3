package ru.innopolis.uni.course3.ofedorova.store.journal;

import ru.innopolis.uni.course3.ofedorova.models.Journal;
import ru.innopolis.uni.course3.ofedorova.models.Lecture;
import ru.innopolis.uni.course3.ofedorova.models.Student;
import ru.innopolis.uni.course3.ofedorova.service.Settings;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Olga on 22.12.2016.
 */
public class JdbcStorage implements StorageOfJournal {

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
    public Collection<Journal> values() {
        final List<Journal> records = new ArrayList<>();
        try (final Statement statement = this.connection.createStatement();
            final ResultSet rs = statement.executeQuery("SELECT j.*, " +
                                                        "l.id as l_id, l.subject, l.hours_of_theory, l.hours_of_practice, " +
                                                        "s.id as s_id, s.name, s.class " +
                                                        "FROM journal AS j " +
                                                        "LEFT OUTER JOIN students AS s " +
                                                        "ON j.student_id = s.id " +
                                                        "LEFT OUTER JOIN lectures AS l " +
                                                        "ON j.lecture_id = l.id " +
                                                        "ORDER BY date_of_record, id")) {
            while (rs.next()) {
                records.add(new Journal(rs.getInt("id"), rs.getString("date_of_record"),
                        new Lecture(rs.getInt("l_id"), rs.getString("subject"), rs.getInt("hours_of_theory"), rs.getInt("hours_of_practice")),
                        new Student(rs.getInt("s_id"), rs.getString("name"), rs.getString("class"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }

    @Override
    public int add(Journal journal) {
        try (final PreparedStatement statement = this.connection.prepareStatement("INSERT  INTO journal (date_of_record, lecture_id, student_id) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = formatter.parse(journal.getDateOfRecord());
            statement.setDate(1, new java.sql.Date(date.getTime()));
            statement.setInt(2, journal.getLecture().getId());
            statement.setInt(3, journal.getStudent().getId());
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not create new record in journal");
    }

    @Override
    public void delete(int id) {
        try (final PreparedStatement statement = this.connection.prepareStatement("DELETE FROM  journal WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    @Override
    public Collection<Lecture> getLectures() {
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
    public Lecture getLecture(int id) {
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
    public Student getStudent(int id) {
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
}
