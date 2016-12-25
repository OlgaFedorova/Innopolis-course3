package ru.innopolis.uni.course3.ofedorova.dao.users;

import ru.innopolis.uni.course3.ofedorova.models.User;

/**
 * Интерфейс реализует модель доступа к данным модели "User".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.12.2016
 */
public interface DAOtoUsers {

    /**
     * Метод возвращает пользователя по запрашиваемому имени.
     *
     * @param name имя пользователя.
     * @return Если пользователь найден, будет возвращена ссылка на него, иначе возвращается null.
     */
    User getByName(String name);

    /**
     * Метод добавляет нового пользователя в БД.
     *
     * @param name     имя пользователя.
     * @param password пароль пользователя.
     * @return Если пользователя удалось создать будет возвращена ссылка на него, иначе возвращается null.
     */
    User addNewUser(String name, String password);

    /**
     * Метод закрывает соединение для работы с данными.
     */
    void close();

}
