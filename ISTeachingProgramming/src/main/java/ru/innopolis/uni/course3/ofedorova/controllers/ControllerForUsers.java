package ru.innopolis.uni.course3.ofedorova.controllers;

import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoUsersException;
import ru.innopolis.uni.course3.ofedorova.dao.users.DAOtoUsers;
import ru.innopolis.uni.course3.ofedorova.dao.users.JdbcOfDAOtoUsers;
import ru.innopolis.uni.course3.ofedorova.models.User;
import ru.innopolis.uni.course3.ofedorova.service.users.ServiceOfUsers;
import ru.innopolis.uni.course3.ofedorova.service.users.ServiceOfUsersImpl;

import java.util.Collection;
import java.util.Map;

/**
 * Класс реализует контроллер для работы с моделью данных "User".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.12.2016
 */
public class ControllerForUsers implements DAOtoUsers {
    /**
     * Объект для доступа к данным модели "User".
     */
    private final DAOtoUsers storeOfUsers = new JdbcOfDAOtoUsers();
    /**
     * Сервисные объект для обработки данных пользователя.
     */
    private final ServiceOfUsers serviceOfUsers = new ServiceOfUsersImpl();

    /**
     * Метод возвращает список рейтинга пользователей.
     *
     * @return список рейтинга пользователей.
     */
    @Override
    public Collection<User> valuesRating() throws DAOtoUsersException {
        return this.storeOfUsers.valuesRating();
    }

    /**
     * Метод возвращает пользователя по запрашиваемому имени.
     *
     * @param name имя пользователя.
     * @return Если пользователь найден, будет возвращена ссылка на него, иначе возвращается null.
     */
    @Override
    public User getByName(String name) throws DAOtoUsersException {
        return this.storeOfUsers.getByName(name);
    }

    /**
     * Метод возвращает пользователя по запрашиваемому идентификатору.
     *
     * @param id идентификатор пользователя.
     * @return Если пользователь найден, будет возвращена ссылка на него, иначе возвращается null.
     */
    @Override
    public User getById(int id) throws DAOtoUsersException {
        return this.storeOfUsers.getById(id);
    }

    /**
     * Метод добавляет нового пользователя в БД.
     *
     * @param name     имя пользователя.
     * @param password пароль пользователя.
     * @return Если пользователя удалось создать будет возвращена ссылка на него, иначе возвращается null.
     */
    public User addNewUser(String name, String password) throws DAOtoUsersException {
        Map<String, String> hashAndSalt = this.serviceOfUsers.hashPasswordAndReturnWithSalt(password);
        return this.storeOfUsers.addNewUser(name, hashAndSalt.get("password"), hashAndSalt.get("salt"));
    }

    /**
     * Метод добавляет нового пользователя в БД.
     *
     * @param name     имя пользователя.
     * @param password пароль пользователя.
     * @param salt соль для хеширования пароля.
     * @return Если пользователя удалось создать будет возвращена ссылка на него, иначе возвращается null.
     */
    @Override
    public User addNewUser(String name, String password, String salt) throws DAOtoUsersException {
        return this.storeOfUsers.addNewUser(name, password, salt);
    }

    /**
     * Метод возвращает пароль пользователя.
     *
     * @param id идентификатор пользователя.
     * @return значение пароля пользователя.
     */
    @Override
    public String getPassword(int id) throws DAOtoUsersException {
        return this.storeOfUsers.getPassword(id);
    }

    /**
     * Метод обновляет пароль у пользователя.
     *
     * @param id          идентификатор пользователя.
     * @param newPassword значение нового пароля.
     * @return Обновленный объект пользователя.
     */
    @Override
    public User updatePassword(int id, String newPassword) throws DAOtoUsersException {
        return this.storeOfUsers.updatePassword(id, newPassword);
    }

    /**
     * Метод закрывает соединение для работы с данными.
     */
    @Override
    public void close() {
        this.storeOfUsers.close();
    }

    /**
     * Метод проверяет корректность данных валидации входа.
     *
     * @param username имя пользователя.
     * @param password пароль пользователя.
     * @return Если валидация пройдена успешно будет возвращено значения пользователя для сессии, иначе возвращается null.
     */
    public User validateLogin(String username, String password) throws DAOtoUsersException {
        return this.serviceOfUsers.validateLogin(username, password, this.getByName(username));
    }

    /**
     * Метод проверяет, что пароль заполнен.
     *
     * @param password пароль пользователя.
     * @param confirm  подтверждение пароля.
     * @return Если пароль заполне возвращается true, иначе false.
     */
    public boolean passwordEmpty(String password, String confirm) {
        return this.serviceOfUsers.passwordEmpty(password, confirm);
    }

    /**
     * Метод проверяет совпадение паролей.
     *
     * @param password пароль пользователя.
     * @param confirm  подтверждение пароля.
     * @return Если пароль и его подтверждение совпадают возвращается true, иначе false.
     */
    public boolean checkPasswords(String password, String confirm) {
        return this.serviceOfUsers.checkPasswords(password, confirm);
    }

    /**
     * Метод проверяет корректность введенного имени.
     *
     * @param name имя для проверки.
     * @return Если имя корректно возвращается true, иначе возвращается false.
     */
    public boolean checkName(String name) {
        return this.serviceOfUsers.checkName(name);
    }

    /**
     * Метод проверяет корректность введенных данных для редактирования профиля пользователя.
     *
     * @param id                   идентификатор пользователя.
     * @param inputCurrentPassword значение введенного текущего пароля.
     * @param newPassword          значение нового пароля.
     * @param confirmPassword      подтверждение нового пароля.
     * @return Если данные корректны, возвращается true, иначе else.
     */
    public boolean checkDataForEdid(int id, String inputCurrentPassword, String newPassword, String confirmPassword) throws DAOtoUsersException {
        return this.serviceOfUsers.checkDataForEdid(inputCurrentPassword, this.getPassword(id), newPassword, confirmPassword);
    }

}
