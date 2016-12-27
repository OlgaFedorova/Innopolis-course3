package ru.innopolis.uni.course3.ofedorova.dao.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.course3.ofedorova.models.User;
import ru.innopolis.uni.course3.ofedorova.service.ConnectionPoolFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Класс реализует модель доступа к данным модели "User" с помощью JDBC.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.12.2016
 */
public class JdbcOfDAOtoUsers implements DAOtoUsers {
    /**
     * Объект для логгирования.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcOfDAOtoUsers.class);

    /**
     * Соединение для работы с БД.
     */
    private Connection connection;

    /**
     * Создает новый {@code JdbcOfDAOtoUsers}.
     */
    public JdbcOfDAOtoUsers() {
        try {
            this.connection = ConnectionPoolFactory.getConnection();
        } catch (SQLException e) {
            JdbcOfDAOtoUsers.LOGGER.info(e.getMessage());
        }
    }

    /**
     * Метод возвращает список рейтинга пользователей.
     *
     * @return список рейтинга пользователей.
     */
    @Override
    public Collection<User> valuesRating() {
        final List<User> users = new ArrayList<>();
        try (final Statement statement = this.connection.createStatement()) {
            try (final ResultSet rs = statement.executeQuery(new StringBuilder().append("SELECT u.id, u.name, Sum(CASE\n").
                    append("WHEN m.mark IS NULL THEN 0\n").
                    append("ELSE m.mark\n").
                    append("END) as mark\n").
                    append("FROM users as u\n").
                    append("LEFT JOIN marks as m\n").
                    append("ON u.id = m.id_user\n").
                    append("GROUP BY u.id, u.name\n").
                    append("ORDER BY mark desc").toString())) {
                while (rs.next()) {
                    users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getInt("mark")));
                }
            }
        } catch (SQLException e) {
            JdbcOfDAOtoUsers.LOGGER.info(e.getMessage());
        }
        return users;
    }

    /**
     * Метод возвращает пользователя по запрашиваемому имени.
     *
     * @param name имя пользователя.
     * @return Если пользователь найден, будет возвращена ссылка на него, иначе возвращается null.
     */
    @Override
    public User getByName(String name) {
        User user = null;
        try (final PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM users WHERE name = ?")) {
            statement.setString(1, name);
            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"));
                    break;
                }
            }
        } catch (SQLException e) {
            JdbcOfDAOtoUsers.LOGGER.info(e.getMessage());
        }
        return user;
    }

    /**
     * Метод возвращает пользователя по запрашиваемому идентификатору.
     *
     * @param id идентификатор пользователя.
     * @return Если пользователь найден, будет возвращена ссылка на него, иначе возвращается null.
     */
    @Override
    public User getById(int id) {
        User user = null;
        try (final PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM users WHERE id = ?")) {
            statement.setInt(1, id);
            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"));
                    break;
                }
            }
        } catch (SQLException e) {
            JdbcOfDAOtoUsers.LOGGER.info(e.getMessage());
        }
        return user;
    }

    /**
     * Метод добавляет нового пользователя в БД.
     *
     * @param name     имя пользователя.
     * @param password пароль пользователя.
     * @return Если пользователя удалось создать будет возвращена ссылка на него, иначе возвращается null.
     */
    @Override
    public User addNewUser(String name, String password) {
        User user = null;
        try (final PreparedStatement statement = this.connection.prepareStatement("INSERT  INTO users (name, password) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.setString(2, password);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user = new User(generatedKeys.getInt(1), name, password);
                }
            }
        } catch (SQLException e) {
            JdbcOfDAOtoUsers.LOGGER.info(e.getMessage());
        }
        return user;
    }

    /**
     * Метод возвращает пароль пользователя.
     *
     * @param id идентификатор пользователя.
     * @return значение пароля пользователя.
     */
    @Override
    public String getPassword(int id) {
        String password = null;
        try (final PreparedStatement statement = this.connection.prepareStatement("SELECT password FROM users WHERE id = ?")) {
            statement.setInt(1, id);
            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    password = rs.getString("password");
                    break;
                }
            }
        } catch (SQLException e) {
            JdbcOfDAOtoUsers.LOGGER.info(e.getMessage());
        }
        return password;
    }

    /**
     * Метод обновляет пароль у пользователя.
     *
     * @param id          идентификатор пользователя.
     * @param newPassword значение нового пароля.
     * @return Обновленный объект пользователя.
     */
    @Override
    public User updatePassword(int id, String newPassword) {
        try (final PreparedStatement statement = this.connection.prepareStatement("UPDATE users SET password = ? WHERE id = ?")) {
            statement.setString(1, newPassword);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            JdbcOfDAOtoUsers.LOGGER.info(e.getMessage());
        }
        return this.getById(id);
    }

    /**
     * Метод закрывает соединение для работы с данными.
     */
    @Override
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            JdbcOfDAOtoUsers.LOGGER.info(e.getMessage());
        }
    }

}
