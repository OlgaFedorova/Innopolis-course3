package ru.innopolis.uni.course3.ofedorova.dao.users;

import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoUsersException;
import ru.innopolis.uni.course3.ofedorova.models.User;

import java.util.Collection;
import java.util.Map;

/**
 * Интерфейс реализует модель доступа к данным модели "User".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.12.2016
 */
public interface DAOtoUsers {

    /**
     * Метод возвращает список рейтинга пользователей.
     *
     * @return список рейтинга пользователей.
     */
    Collection<User> valuesRating() throws DAOtoUsersException;

    /**
     * Метод возвращает пользователя по запрашиваемому имени.
     *
     * @param name имя пользователя.
     * @return Если пользователь найден, будет возвращена ссылка на него, иначе возвращается null.
     */
    User getByName(String name) throws DAOtoUsersException;

    /**
     * Метод возвращает пользователя по запрашиваемому идентификатору.
     *
     * @param id идентификатор пользователя.
     * @return Если пользователь найден, будет возвращена ссылка на него, иначе возвращается null.
     */
    User getById(int id) throws DAOtoUsersException;

    /**
     * Метод добавляет нового пользователя в БД.
     *
     * @param name     имя пользователя.
     * @param password пароль пользователя.
     * @param salt     соль для хеширования пароля.
     * @return Если пользователя удалось создать будет возвращена ссылка на него, иначе возвращается null.
     */
    User addNewUser(String name, String password, String salt) throws DAOtoUsersException;

    /**
     * Метод возвращает пароль пользователя.
     *
     * @param id идентификатор пользователя.
     * @return Map, в котором ключ "password" соответствует значению пароля;
     * ключ "salt" соответствует значение соли, используемой для хеширования.
     */
    Map<String, String> getPasswordAndSalt(int id) throws DAOtoUsersException;

    /**
     * Метод обновляет пароль у пользователя.
     *
     * @param id          идентификатор пользователя.
     * @param newPassword значение нового пароля.
     * @param salt        соль для хеширования пароля.
     * @return Обновленный объект пользователя.
     */
    User updatePassword(int id, String newPassword, String salt) throws DAOtoUsersException;
}
