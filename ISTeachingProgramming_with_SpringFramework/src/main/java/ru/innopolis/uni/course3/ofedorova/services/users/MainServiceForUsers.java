package ru.innopolis.uni.course3.ofedorova.services.users;

import ru.innopolis.uni.course3.ofedorova.common.models.User;

import java.util.Collection;
import java.util.Map;

/**
 * Интерфейс реализует главный сервис для работы с моделью данных "User".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.12.2016
 */
public interface MainServiceForUsers {

    /**
     * Метод возвращает список рейтинга пользователей.
     *
     * @return список рейтинга пользователей.
     */
    Collection<User> valuesRating();

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
     * @param user объект пользователя.
     * @return Если пользователя удалось создать будет возвращена ссылка на него, иначе возвращается null.
     */
    User addNewUser(User user);

    /**
     * Метод возвращает пароль пользователя.
     *
     * @param id идентификатор пользователя.
     * @return Map, в котором ключ "password" соответствует значению пароля;
     * ключ "salt" соответствует значение соли, используемой для хеширования.
     */
    Map<String, String> getPasswordAndSalt(int id);

    /**
     * Метод обновляет пароль у пользователя.
     *
     * @param user объект пользователя.
     * @return Обновленный объект пользователя.
     */
    User updatePassword(User user);

    /**
     * Метод проверяет корректность данных валидации входа.
     *
     * @param username имя пользователя.
     * @param password пароль пользователя.
     * @return Если валидация пройдена успешно будет возвращено значения пользователя для сессии, иначе возвращается null.
     */
    User validateLogin(String username, String password);

    /**
     * Метод проверяет, что пароль заполнен.
     *
     * @param password пароль пользователя.
     * @param confirm  подтверждение пароля.
     * @return Если пароль заполне возвращается true, иначе false.
     */
    boolean passwordEmpty(String password, String confirm);

    /**
     * Метод проверяет совпадение паролей.
     *
     * @param password пароль пользователя.
     * @param confirm  подтверждение пароля.
     * @return Если пароль и его подтверждение совпадают возвращается true, иначе false.
     */
    boolean checkPasswords(String password, String confirm);

    /**
     * Метод проверяет корректность введенного имени.
     *
     * @param name имя для проверки.
     * @return Если имя корректно возвращается true, иначе возвращается false.
     */
    boolean checkName(String name);

    /**
     * Метод проверяет корректность введенных данных для редактирования профиля пользователя.
     *
     * @param id                   идентификатор пользователя.
     * @param inputCurrentPassword значение введенного текущего пароля.
     * @param newPassword          значение нового пароля.
     * @param confirmPassword      подтверждение нового пароля.
     * @return Если данные корректны, возвращается true, иначе else.
     */
    boolean checkDataForEdid(int id, String inputCurrentPassword, String newPassword, String confirmPassword);

}
