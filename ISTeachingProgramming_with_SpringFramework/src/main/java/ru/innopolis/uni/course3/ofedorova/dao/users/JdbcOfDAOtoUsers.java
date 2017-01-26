package ru.innopolis.uni.course3.ofedorova.dao.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.uni.course3.ofedorova.constants.SQLQueries;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoUsersException;
import ru.innopolis.uni.course3.ofedorova.common.models.User;

import java.sql.*;
import java.util.*;

/**
 * Класс реализует модель доступа к данным модели "User" с помощью JDBC.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.12.2016
 */
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class JdbcOfDAOtoUsers extends JdbcDaoSupport implements DAOtoUsers {
    /**
     * Объект для логгирования.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(JdbcOfDAOtoUsers.class);

    /**
     * Метод возвращает список рейтинга пользователей.
     *
     * @return список рейтинга пользователей.
     */
    @Override
    public Collection<User> valuesRating() throws DAOtoUsersException {
        return this.getJdbcTemplate().query(SQLQueries.VALUES_RATING, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new User(rs.getInt("id"), rs.getString("name"), rs.getInt("mark"));
            }
        });
    }

    /**
     * Метод возвращает пользователя по запрашиваемому имени.
     *
     * @param name имя пользователя.
     * @return Если пользователь найден, будет возвращена ссылка на него, иначе возвращается null.
     */
    @Override
    public User getByName(String name) throws DAOtoUsersException {
        return this.getJdbcTemplate().queryForObject(SQLQueries.USER_BY_NAME, new Object[]{name}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getString("salt"));
            }
        });
    }

    /**
     * Метод возвращает пользователя по запрашиваемому идентификатору.
     *
     * @param id идентификатор пользователя.
     * @return Если пользователь найден, будет возвращена ссылка на него, иначе возвращается null.
     */
    @Override
    public User getById(int id) throws DAOtoUsersException {
        return this.getJdbcTemplate().queryForObject(SQLQueries.USER_BY_ID, new Object[]{id}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getString("salt"));
            }
        });
    }

    /**
     * Метод добавляет нового пользователя в БД.
     *
     * @param user данные нового пользователя.
     * @return Если пользователя удалось создать будет возвращена ссылка на него, иначе возвращается null.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public User addNewUser(User user) throws DAOtoUsersException {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.getJdbcTemplate().update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                final PreparedStatement ps = con.prepareStatement(SQLQueries.ADD_NEW_USER,
                        Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getSalt());
                return ps;
            }
        }, keyHolder);
        return new User((Integer) keyHolder.getKeyList().get(0).get("id"), user.getUsername(), user.getPassword(), user.getSalt());
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
        return this.getJdbcTemplate().queryForObject(SQLQueries.PASSWORD_AND_SALT, new Object[]{id}, new RowMapper<Map<String, String>>() {
            @Override
            public Map<String, String> mapRow(ResultSet rs, int rowNum) throws SQLException {
                Map<String, String> result = new HashMap<>();
                result.put("password", rs.getString("password"));
                result.put("salt", rs.getString("salt"));
                return result;
            }
        });
    }

    /**
     * Метод обновляет пароль у пользователя.
     *
     * @param user данные нового пользователя.
     * @return Обновленный объект пользователя.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public User updatePassword(User user) throws DAOtoUsersException {
        this.getJdbcTemplate().update(SQLQueries.UPDATE_PASSWORD, user.getPassword(), user.getSalt(), user.getId());
        return this.getById(user.getId());
    }
}
