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

}
