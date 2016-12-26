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
     * Метод возвращает пользователя по запрашиваемому идентификатору.
     *
     * @param id идентификатор пользователя.
     * @return Если пользователь найден, будет возвращена ссылка на него, иначе возвращается null.
     */
    User getById(int id);

    /**
     * Метод добавляет нового пользователя в БД.
     *
     * @param name     имя пользователя.
     * @param password пароль пользователя.
     * @return Если пользователя удалось создать будет возвращена ссылка на него, иначе возвращается null.
     */
    User addNewUser(String name, String password);

    /**
     * Метод возвращает пароль пользователя.
     *
     * @param id идентификатор пользователя.
     * @return значение пароля пользователя.
     */
    String getPassword(int id);

    /**
     * Метод обновляет пароль у пользователя.
     * @param id идентификатор пользователя.
     * @param newPassword значение нового пароля.
     * @return Обновленный объект пользователя.
     */
    User updatePassword(int id, String newPassword);

    /**
     * Метод закрывает соединение для работы с данными.
     */
    void close();

}
