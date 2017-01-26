package ru.innopolis.uni.course3.ofedorova.services.users;

import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoUsersException;
import ru.innopolis.uni.course3.ofedorova.dao.users.DAOtoUsers;
import ru.innopolis.uni.course3.ofedorova.common.models.User;

import java.util.Collection;
import java.util.Map;

/**
 * Класс реализует главный сервис для работы с моделью данных "User".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.12.2016
 */
public class MainServiceForUsersImpl implements MainServiceForUsers {
    /**
     * Объект для доступа к данным модели "User".
     */
    private final DAOtoUsers daOtoUsers;
    /**
     * Сервисные объект для обработки данных пользователя.
     */
    private final ServiceForValidateDataOfUsers serviceOfUsers;

    /**
     * Создает новый {@code MainServiceForUsersImpl}.
     *
     * @param daOtoUsers     значение поля "daOtoUsers".
     * @param serviceOfUsers значение поля "serviceOfUsers".
     */
    public MainServiceForUsersImpl(DAOtoUsers daOtoUsers, ServiceForValidateDataOfUsers serviceOfUsers) {
        this.daOtoUsers = daOtoUsers;
        this.serviceOfUsers = serviceOfUsers;
    }

    /**
     * Метод возвращает список рейтинга пользователей.
     *
     * @return список рейтинга пользователей.
     */
    @Override
    public Collection<Object[]> valuesRating() throws DAOtoUsersException {
        return this.daOtoUsers.valuesRating();
    }

    /**
     * Метод возвращает пользователя по запрашиваемому имени.
     *
     * @param name имя пользователя.
     * @return Если пользователь найден, будет возвращена ссылка на него, иначе возвращается null.
     */
    @Override
    public User getByName(String name) throws DAOtoUsersException {
        return this.daOtoUsers.getByName(name);
    }

    /**
     * Метод возвращает пользователя по запрашиваемому идентификатору.
     *
     * @param id идентификатор пользователя.
     * @return Если пользователь найден, будет возвращена ссылка на него, иначе возвращается null.
     */
    @Override
    public User getById(int id) throws DAOtoUsersException {
        return this.daOtoUsers.getById(id);
    }

    /**
     * Метод добавляет нового пользователя в БД.
     *
     * @param user объект пользователя.
     * @return Если пользователя удалось создать будет возвращена ссылка на него, иначе возвращается null.
     */
    @Override
    public User addNewUser(User user) throws DAOtoUsersException {
        Map<String, String> hashAndSalt = this.serviceOfUsers.hashPasswordAndReturnWithSalt(user.getPassword());
        return this.daOtoUsers.addNewUser(new User(user.getUsername(), hashAndSalt.get("password"), hashAndSalt.get("salt")));
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
        return this.daOtoUsers.getPasswordAndSalt(id);
    }

    /**
     * Метод обновляет пароль у пользователя.
     *
     * @param user объект пользователя.
     * @return Обновленный объект пользователя.
     */
    @Override
    public User updatePassword(User user) throws DAOtoUsersException {
        Map<String, String> hashAndSalt = this.serviceOfUsers.hashPasswordAndReturnWithSalt(user.getNewPassword());
        user.setPassword(hashAndSalt.get("password"));
        user.setSalt(hashAndSalt.get("salt"));
        return this.daOtoUsers.updatePassword(user);
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
        return this.serviceOfUsers.checkDataForEdid(inputCurrentPassword, this.getPasswordAndSalt(id), newPassword, confirmPassword);
    }
}
