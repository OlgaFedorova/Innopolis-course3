package ru.innopolis.uni.course3.ofedorova.dao.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoUsersException;
import ru.innopolis.uni.course3.ofedorova.common.models.User;
import ru.innopolis.uni.course3.ofedorova.services.ConnectionPoolFactory;

import java.sql.*;
import java.util.*;

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
     * Метод возвращает список рейтинга пользователей.
     *
     * @return список рейтинга пользователей.
     */
    @Override
    public Collection<User> valuesRating() throws DAOtoUsersException {
        final List<User> users = new ArrayList<>();
        try (final Connection connection = ConnectionPoolFactory.getConnection();
             final Statement statement = connection.createStatement()) {
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
        } catch (SQLException | NullPointerException e) {
            JdbcOfDAOtoUsers.LOGGER.info(e.getMessage());
            throw new DAOtoUsersException();
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
    public User getByName(String name) throws DAOtoUsersException {
        User user = null;
        try (final Connection connection = ConnectionPoolFactory.getConnection();
             final PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE name = ?")) {
            statement.setString(1, name);
            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getString("salt"));
                    break;
                }
            }
        } catch (SQLException | NullPointerException e) {
            JdbcOfDAOtoUsers.LOGGER.info(e.getMessage());
            throw new DAOtoUsersException();
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
    public User getById(int id) throws DAOtoUsersException {
        User user = null;
        try (final Connection connection = ConnectionPoolFactory.getConnection();
             final PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?")) {
            statement.setInt(1, id);
            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getString("password"));
                    break;
                }
            }
        } catch (SQLException | NullPointerException e) {
            JdbcOfDAOtoUsers.LOGGER.info(e.getMessage());
            throw new DAOtoUsersException();
        }
        return user;
    }

    /**
     * Метод добавляет нового пользователя в БД.
     *
     * @param name     имя пользователя.
     * @param password пароль пользователя.
     * @param salt     соль для хеширования пароля.
     * @return Если пользователя удалось создать будет возвращена ссылка на него, иначе возвращается null.
     */
    @Override
    public User addNewUser(String name, String password, String salt) throws DAOtoUsersException {
        User user = null;
        try (final Connection connection = ConnectionPoolFactory.getConnection();
             final PreparedStatement statement = connection.prepareStatement("INSERT  INTO users (name, password, salt) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.setString(2, password);
            statement.setString(3, salt);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user = new User(generatedKeys.getInt(1), name, password, salt);
                }
            }
        } catch (SQLException | NullPointerException e) {
            JdbcOfDAOtoUsers.LOGGER.info(e.getMessage());
            throw new DAOtoUsersException();
        }
        return user;
    }

    /**
     * Метод возвращает пароль пользователя.
     *
     * @param id идентификатор пользователя.
     * @return Map, в котором ключ "password" соответствует значению пароля;
     * ключ "salt" соответствует значение соли, используемой для хеширования.
     */
    @Override
    public Map<String, String> getPasswordAndSalt(int id) throws DAOtoUsersException {
        Map<String, String> result = new HashMap<>();
        try (final Connection connection = ConnectionPoolFactory.getConnection();
             final PreparedStatement statement = connection.prepareStatement("SELECT password, salt FROM users WHERE id = ?")) {
            statement.setInt(1, id);
            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    result.put("password", rs.getString("password"));
                    result.put("salt", rs.getString("salt"));
                    break;
                }
            }
        } catch (SQLException | NullPointerException e) {
            JdbcOfDAOtoUsers.LOGGER.info(e.getMessage());
            throw new DAOtoUsersException();
        }
        return result;
    }

    /**
     * Метод обновляет пароль у пользователя.
     *
     * @param id          идентификатор пользователя.
     * @param newPassword значение нового пароля.
     * @param salt        соль для хеширования пароля.
     * @return Обновленный объект пользователя.
     */
    @Override
    public User updatePassword(int id, String newPassword, String salt) throws DAOtoUsersException {
        try (final Connection connection = ConnectionPoolFactory.getConnection();
             final PreparedStatement statement = connection.prepareStatement("UPDATE users SET password = ?, salt = ? WHERE id = ?")) {
            statement.setString(1, newPassword);
            statement.setString(2, salt);
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            JdbcOfDAOtoUsers.LOGGER.info(e.getMessage());
            throw new DAOtoUsersException();
        }
        return this.getById(id);
    }
}
