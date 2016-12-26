package ru.innopolis.uni.course3.ofedorova.service.users;

import ru.innopolis.uni.course3.ofedorova.models.User;

/**
 * Класс реализует модель обработки данных пользователя.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.12.2016
 */
public class ServiceOfUsersImpl implements ServiceOfUsers {

    /**
     * Метод проверяет корректность данных валидации входа.
     *
     * @param username имя пользователя.
     * @param password пароль пользователя.
     * @param user     пользователь для сверки данных.
     * @return Если валидация пройдена успешно будет возвращено значения пользователя для сессии, иначе возвращается null.
     */
    @Override
    public User validateLogin(String username, String password, User user) {
        User result = null;
        if (user != null && user.getPassword().equals(password.trim())) {
            result = user;
        }
        return result;
    }

    /**
     * Метод проверяет совпадение паролей.
     *
     * @param password пароль пользователя.
     * @param confirm  подтверждение пароля.
     * @return Если пароль и его подтверждение совпадают возвращается true, иначе false.
     */
    @Override
    public boolean checkPasswords(String password, String confirm) {
        boolean result = false;
        if (password != null && confirm != null && password.equals(confirm)) {
            result = true;
        }
        return result;
    }

    /**
     * Метод проверяет корректность введенных данных для редактирования профиля пользователя.
     *
     * @param inputCurrentPassword значение введенного текущего пароля.
     * @param currentPasswordDB значение сохраненного пароля в БД.
     * @param newPassword     значение нового пароля.
     * @param confirmPassword подтверждение нового пароля.
     * @return Если данные корректны, возвращается true, иначе else.
     */
    @Override
    public boolean checkDataForEdid(String inputCurrentPassword, String currentPasswordDB, String newPassword, String confirmPassword) {
        boolean isValidate = false;
        if(inputCurrentPassword != null && currentPasswordDB != null
                && inputCurrentPassword.equals(currentPasswordDB)
                && newPassword != null && confirmPassword != null
                && newPassword.equals(confirmPassword)){
            isValidate = true;
        }
        return isValidate;
    }
}
