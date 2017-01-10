package ru.innopolis.uni.course3.ofedorova.services;

/**
 * Created by Olga on 06.01.2017.
 */
public class SQLQueries {

    public static final String LIST_JOURNAL = new StringBuilder().
            append("SELECT j.*, ").
            append("l.id as l_id, l.subject, l.hours_of_theory, l.hours_of_practice, ").
            append("s.id as s_id, s.name, s.class ").
            append("FROM journal AS j ").
            append("LEFT OUTER JOIN students AS s ").
            append("ON j.student_id = s.id ").
            append("LEFT OUTER JOIN lectures AS l ").
            append("ON j.lecture_id = l.id ").
            append("ORDER BY date_of_record, id").toString();

    public static final String ADD_RECORD_INTO_JOURNAL = "INSERT  INTO journal (date_of_record, lecture_id, student_id) VALUES (?, ?, ?)";

    public static final String DELETE_RECORD_FROM_JOURNAL = "DELETE FROM  journal WHERE id = ?";

    public static final String LIST_LECTURES = "SELECT * FROM lectures ORDER BY id";

    public static final String LECTURE_BY_ID = "SELECT * FROM lectures WHERE id = ?";

    public static final String STUDENT_BY_ID = "SELECT * FROM students WHERE id = ?";

    public static final String LIST_STUDENTS = "SELECT * FROM students ORDER BY name";

    public static final String ADD_LECTURE = "INSERT  INTO lectures (subject, hours_of_theory, hours_of_practice) VALUES (?, ?, ?)";

    public static final String EDIT_LECTURE = "UPDATE lectures SET subject = ?, hours_of_theory = ?, hours_of_practice = ? WHERE id = ?";

    public static final String DELETE_LECTURE = "DELETE FROM  lectures WHERE id = ?";

    public static final String ADD_STUDENT = "INSERT  INTO students (name, class) VALUES (?, ?)";

    public static final String DELETE_STUDENT = "DELETE FROM  students WHERE id = ?";

    public static final String EDIT_STUDENT = "UPDATE students SET name = ?, class = ? WHERE id = ?";
}
