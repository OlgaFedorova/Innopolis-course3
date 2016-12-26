package ru.innopolis.uni.course3.ofedorova.controllers;

import ru.innopolis.uni.course3.ofedorova.dao.users.DAOtoUsers;
import ru.innopolis.uni.course3.ofedorova.dao.users.JdbcOfDAOtoUsers;
import ru.innopolis.uni.course3.ofedorova.models.User;
import ru.innopolis.uni.course3.ofedorova.service.users.ServiceOfUsers;
import ru.innopolis.uni.course3.ofedorova.service.users.ServiceOfUsersImpl;

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
     * Метод возвращает пользователя по запрашиваемому имени.
     *
     * @param name имя пользователя.
     * @return Если пользователь найден, будет возвращена ссылка на него, иначе возвращается null.
     */
    @Override
    public User getByName(String name) {
        return this.storeOfUsers.getByName(name);
    }

    /**
     * Метод возвращает пользователя по запрашиваемому идентификатору.
     *
     * @param id идентификатор пользователя.
     * @return Если пользователь найден, будет возвращена ссылка на него, иначе возвращается null.
     */
    @Override
    public User getById(int id) {
        return this.storeOfUsers.getById(id);
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
        return this.storeOfUsers.addNewUser(name, password);
    }

    /**
     * Метод возвращает пароль пользователя.
     *
     * @param id идентификатор пользователя.
     * @return значение пароля пользователя.
     */
    @Override
    public String getPassword(int id) {
        return this.storeOfUsers.getPassword(id);
    }

    /**
     * Метод обновляет пароль у пользователя.
     * @param id идентификатор пользователя.
     * @param newPassword значение нового пароля.
     * @return Обновленный объект пользователя.
     */
    @Override
    public User updatePassword(int id, String newPassword) {
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
    public User validateLogin(String username, String password) {
        return this.serviceOfUsers.validateLogin(username, password, this.getByName(username));
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
     * Метод проверяет корректность введенных данных для редактирования профиля пользователя.
     *
     * @param id идентификатор пользователя.
     * @param inputCurrentPassword значение введенного текущего пароля.
     * @param newPassword     значение нового пароля.
     * @param confirmPassword подтверждение нового пароля.
     * @return Если данные корректны, возвращается true, иначе else.
     */
    public boolean checkDataForEdid(int id, String inputCurrentPassword, String newPassword, String confirmPassword) {
        return this.serviceOfUsers.checkDataForEdid(inputCurrentPassword, this.getPassword(id), newPassword, confirmPassword);
    }

}
