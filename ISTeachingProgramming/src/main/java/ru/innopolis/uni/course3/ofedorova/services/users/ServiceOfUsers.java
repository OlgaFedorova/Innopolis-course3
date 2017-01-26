package ru.innopolis.uni.course3.ofedorova.services.users;

import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoUsersException;
import ru.innopolis.uni.course3.ofedorova.common.models.User;

import java.util.Map;

/**
 * Интерфейс реализует модель обработки данных пользователя.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.12.2016
 */
public interface ServiceOfUsers {

    /**
     * Метод проверяет корректность данных валидации входа.
     *
     * @param username имя пользователя.
     * @param password пароль пользователя.
     * @param user     пользователь для сверки данных.
     * @return Если валидация пройдена успешно будет возвращено значения пользователя для сессии, иначе возвращается null.
     * @throws DAOtoUsersException ошибка в работе с данными.
     */
    User validateLogin(String username, String password, User user) throws DAOtoUsersException;

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
     * @param inputCurrentPassword значение введенного текущего пароля.
     * @param passwordAndSalt      Map, в котором ключ "password" соответствует значению пароля;
     *                             ключ "salt" соответствует значение соли, используемой для хеширования.
     * @param newPassword          значение нового пароля.
     * @param confirmPassword      подтверждение нового пароля.
     * @return Если данные корректны, возвращается true, иначе else.
     * @throws DAOtoUsersException ошибка в работе с данными.
     */
    boolean checkDataForEdid(String inputCurrentPassword, Map<String, String> passwordAndSalt, String newPassword, String confirmPassword) throws DAOtoUsersException;

    /**
     * Метод хеширует пароль и возвращает его значение и значение соли, используемое для хеширования.
     *
     * @param password пароль для хеширования.
     * @return Map, в котором ключ "password" соответствует значению пароля;
     * ключ "salt" соответствует значение соли, используемой для хеширования.
     * @throws DAOtoUsersException ошибка в работе с данными.
     */
    Map<String, String> hashPasswordAndReturnWithSalt(String password) throws DAOtoUsersException;

    /**
     * Методе хеширует переданный пароль с солью и возвращает захешированное значение.
     *
     * @param password пароль для хеширования.
     * @param salt     соль для хеширования.
     * @return захешированное значение пароля.
     * @throws DAOtoUsersException ошибка в работе с данными.
     */
    String hashPassword(String password, byte[] salt) throws DAOtoUsersException;

}
