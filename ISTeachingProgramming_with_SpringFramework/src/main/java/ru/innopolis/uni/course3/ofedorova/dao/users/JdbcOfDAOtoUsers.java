package ru.innopolis.uni.course3.ofedorova.dao.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoUsersException;
import ru.innopolis.uni.course3.ofedorova.models.User;

import java.sql.*;
import java.util.*;

/**
 * Класс реализует модель доступа к данным модели "User" с помощью JDBC.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.12.2016
 */
public class JdbcOfDAOtoUsers extends JdbcDaoSupport implements DAOtoUsers {
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
        List<User> users = Collections.EMPTY_LIST;
        try {
            String sql = new StringBuilder().append("SELECT u.id, u.name, Sum(CASE\n").
                    append("WHEN m.mark IS NULL THEN 0\n").
                    append("ELSE m.mark\n").
                    append("END) as mark\n").
                    append("FROM users as u\n").
                    append("LEFT JOIN marks as m\n").
                    append("ON u.id = m.id_user\n").
                    append("GROUP BY u.id, u.name\n").
                    append("ORDER BY mark desc").toString();
            users = this.getJdbcTemplate().query(sql, new Object[]{}, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return new User(rs.getInt("id"), rs.getString("name"), rs.getInt("mark"));
                }
            });
        } catch (EmptyResultDataAccessException e) {
            users = Collections.EMPTY_LIST;
        }catch (Exception e) {
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
        try {
            String sql = "SELECT * FROM users WHERE name = ?";
            user = this.getJdbcTemplate().queryForObject(sql, new Object[]{name}, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getString("salt"));
                }
            });
        } catch (EmptyResultDataAccessException e) {
            user = null;
        }catch (Exception e) {
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
        try {
            String sql = "SELECT * FROM users WHERE id = ?";
            user = this.getJdbcTemplate().queryForObject(sql, new Object[]{id}, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getString("salt"));
                }
            });
        } catch (EmptyResultDataAccessException e) {
            user = null;
        }catch (Exception e) {
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
        try{
            String sql = "INSERT  INTO users (name, password, salt) VALUES (?, ?, ?)";
            KeyHolder keyHolder = new GeneratedKeyHolder();
            this.getJdbcTemplate().update(new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                    final PreparedStatement ps = con.prepareStatement(sql,
                            Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, name);
                    ps.setString(2, password);
                    ps.setString(3, salt);
                    return ps;
                }
            }, keyHolder);
            user = new User((Integer) keyHolder.getKeyList().get(0).get("id"), name, password, salt);
        }catch (Exception e) {
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
        Map<String, String> result = Collections.EMPTY_MAP;
        try{
            String sql = "SELECT password, salt FROM users WHERE id = ?";
            result = this.getJdbcTemplate().queryForObject(sql, new Object[]{id}, new RowMapper<Map<String, String>>() {
                @Override
                public Map<String, String> mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Map<String, String> result = new HashMap<>();
                    result.put("password", rs.getString("password"));
                    result.put("salt", rs.getString("salt"));
                    return result;
                }
            });
        } catch (EmptyResultDataAccessException e) {
            result = Collections.EMPTY_MAP;
        }catch (Exception e) {
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
        try{
            String sql = "UPDATE users SET password = ?, salt = ? WHERE id = ?";
            this.getJdbcTemplate().update(sql, newPassword, salt, id);
        }catch (Exception e) {
            JdbcOfDAOtoUsers.LOGGER.info(e.getMessage());
            throw new DAOtoUsersException();
        }
        return this.getById(id);
    }
}
