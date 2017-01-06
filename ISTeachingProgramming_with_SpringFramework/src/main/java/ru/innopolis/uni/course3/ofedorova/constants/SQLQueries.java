package ru.innopolis.uni.course3.ofedorova.constants;

/**
 * Класс содержит константы для SQL-запросов.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 06.01.2017
 */
public class SQLQueries {
    /**
     * Запрос для выборки рейтинга пользователей.
     */
    public static final String VALUES_RATING = new StringBuilder().
            append("SELECT u.id, u.name, Sum(CASE\n").
            append("WHEN m.mark IS NULL THEN 0\n").
            append("ELSE m.mark\n").
            append("END) as mark\n").
            append("FROM users as u\n").
            append("LEFT JOIN marks as m\n").
            append("ON u.id = m.id_user\n").
            append("GROUP BY u.id, u.name\n").
            append("ORDER BY mark desc").toString();
    /**
     * Запрос для выборки пользователя по имени.
     */
    public static final String USER_BY_NAME = "SELECT * FROM users WHERE name = ?";
    /**
     * Запрос для выборки пользователя по идентификатору.
     */
    public static final String USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    /**
     * Запрос для добавления нового пользователя.
     */
    public static final String ADD_NEW_USER = "INSERT INTO users (name, password, salt) VALUES (?, ?, ?)";
    /**
     * Запрос для выборки хешированного пароля и соли пользователя.
     */
    public static final String PASSWORD_AND_SALT = "SELECT password, salt FROM users WHERE id = ?";
    /**
     * Запрос для обновления хешированного пароля и соли пользователя.
     */
    public static final String UPDATE_PASSWORD = "UPDATE users SET password = ?, salt = ? WHERE id = ?";

    /**
     * Запрос добавляет решение пользователя.
     */
    public static final String ADD_DECISIONS = "INSERT  INTO decisions (id_task , id_user, decision) VALUES (?, ?, ?)";
    /**
     * Запрос добавляет баллы за решение пользователя.
     */
    public static final String ADD_MARKS = "INSERT  INTO marks (id_task , id_user, mark) VALUES (?, ?, ?)";

    /**
     * Запрос возвращает список заданий.
     */
    public static final String VALUES_TASKS = new StringBuilder().append("SELECT t.id, t.name, d.id as id_decision, d.decision, m.id as id_mark, m.mark ").
            append("FROM tasks AS t ").
            append("LEFT JOIN decisions AS d ").
            append("ON t.id = d.id_task AND  d.id_user = ? ").
            append("LEFT JOIN marks AS m ").
            append("ON t.id = m.id_task AND  m.id_user = ? ").
            append("ORDER BY id").toString();
    /**
     * Запрос возвращает тинформацию о задании.
     */
    public static final String GET_TASK_BY_ID = new StringBuilder().append("SELECT t.*, d.id as id_decision, d.decision, m.id as id_mark, m.mark ").
            append("FROM tasks AS t ").
            append("LEFT JOIN decisions AS d ").
            append("ON t.id = d.id_task AND d.id_user = ? ").
            append("LEFT JOIN marks AS m ").
            append("ON t.id = m.id_task AND m.id_user = ? ").
            append("WHERE t.id = ?").toString();
}
