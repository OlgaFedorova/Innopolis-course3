package ru.innopolis.uni.course3.ofedorova.service.users;

import org.junit.Test;
import ru.innopolis.uni.course3.ofedorova.models.User;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Класс для тестирования ServiceOfUsersImpl.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public class ServiceOfUsersImplTest {
    /**
     * Объект для тестирования.
     */
    private ServiceOfUsers serviceOfUsers = new ServiceOfUsersImpl();

    /**
     * Метод тестирует вылидацию входа при корректных данных.
     */
    @Test
    public void whenValidateLoginTrue() {
        final String username = "name";
        final String password = "123";
        final String passwordCorrect = "123";
        final int id = 1;
        final User user = new User(id, username, passwordCorrect);

        assertTrue(user == this.serviceOfUsers.validateLogin(username, password, user));
    }

    /**
     * Метод тестирует вылидацию входа при некорректных данных.
     */
    @Test
    public void whenValidateLoginFalse() {
        final String username = "name";
        final String password = "123";
        final String passwordCorrect = "567";
        final int id = 1;
        final User user = new User(id, username, passwordCorrect);

        assertTrue(this.serviceOfUsers.validateLogin(username, password, user) == null);
    }

    /**
     * Метод проверяет проверку паролей при условии, что они совпадают.
     */
    @Test
    public void whenCheckPasswordsTrue() {
        final String password = "123";
        final String passwordConfirm = "123";

        assertTrue(this.serviceOfUsers.checkPasswords(password, passwordConfirm));
    }

    /**
     * Метод проверяет проверку паролей при условии, что они не совпадают.
     */
    @Test
    public void whenCheckPasswordsFalse() {
        final String password = "123";
        final String passwordConfirm = "567";

        assertFalse(this.serviceOfUsers.checkPasswords(password, passwordConfirm));
    }

    /**
     * Метод тестирует проверку данных для редактирования профиля пользователя в ситуации корректно введенных данных.
     */
    @Test
    public void whenCheckDataForEdidTrue() {
        final String inputCurrentPassword = "123";
        final String currentPasswordDB = "123";
        final String newPassword = "456";
        final String confirmPassword = "456";

        assertTrue(this.serviceOfUsers.checkDataForEdid(inputCurrentPassword, currentPasswordDB, newPassword, confirmPassword));
    }

    /**
     * Метод тестирует проверку данных для редактирования профиля пользователя в ситуации некорректно введенных данных:
     * введенный текущий пароль не совпадает с сохраненным в базе.
     */
    @Test
    public void whenCheckDataForEdidFalseInputCurrentPasswordNotEqualsCurrentPasswordDB() {
        final String inputCurrentPassword = "123";
        final String currentPasswordDB = "789";
        final String newPassword = "456";
        final String confirmPassword = "456";

        assertFalse(this.serviceOfUsers.checkDataForEdid(inputCurrentPassword, currentPasswordDB, newPassword, confirmPassword));
    }

    /**
     * Метод тестирует проверку данных для редактирования профиля пользователя в ситуации некорректно введенных данных:
     * новый пароль и его подтверждение не совпадают.
     */
    @Test
    public void whenCheckDataForEdidFalseNewPasswordNotEqualsConfirmPassword() {
        final String inputCurrentPassword = "123";
        final String currentPasswordDB = "123";
        final String newPassword = "456";
        final String confirmPassword = "789";

        assertFalse(this.serviceOfUsers.checkDataForEdid(inputCurrentPassword, currentPasswordDB, newPassword, confirmPassword));
    }

}