package ru.innopolis.uni.course3.ofedorova.service.users;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoUsersException;
import ru.innopolis.uni.course3.ofedorova.models.User;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс реализует модель обработки данных пользователя.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.12.2016
 */
public class ServiceOfUsersImpl implements ServiceOfUsers {

    /**
     * Для работы криптографии.
     */
    static private SecretKeyFactory secretKeyFactory;
    static {
        Security.addProvider(new BouncyCastleProvider());
    }
    /**
     * Объект для логгирования.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceOfUsersImpl.class);

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
     * Метод проверяет, что пароль заполнен.
     *
     * @param password пароль пользователя.
     * @param confirm  подтверждение пароля.
     * @return Если пароль заполне возвращается true, иначе false.
     */
    @Override
    public boolean passwordEmpty(String password, String confirm) {
        return password == null || (password != null && password.isEmpty());
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
        if (password != null && confirm != null && !password.isEmpty() && password.equals(confirm)) {
            result = true;
        }
        return result;
    }

    /**
     * Метод проверяет корректность введенного имени.
     *
     * @param name имя для проверки.
     * @return Если имя корректно возвращается true, иначе возвращается false.
     */
    @Override
    public boolean checkName(String name) {
        return name.matches("[qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM]+\\d*") && name.length() <= 25;
    }

    /**
     * Метод проверяет корректность введенных данных для редактирования профиля пользователя.
     *
     * @param inputCurrentPassword значение введенного текущего пароля.
     * @param currentPasswordDB    значение сохраненного пароля в БД.
     * @param newPassword          значение нового пароля.
     * @param confirmPassword      подтверждение нового пароля.
     * @return Если данные корректны, возвращается true, иначе else.
     */
    @Override
    public boolean checkDataForEdid(String inputCurrentPassword, String currentPasswordDB, String newPassword, String confirmPassword) {
        boolean isValidate = false;
        if (inputCurrentPassword != null && currentPasswordDB != null
                && inputCurrentPassword.equals(currentPasswordDB)
                && newPassword != null && confirmPassword != null
                && !newPassword.isEmpty() && newPassword.equals(confirmPassword)) {
            isValidate = true;
        }
        return isValidate;
    }

    /**
     * Метод хеширует пароль и возвращает его значение и значение соли, используемое для хеширования.
     * @param password пароль для хеширования.
     * @return Map, в котором ключ "password" соответствует значению пароля;
     * ключ "salt" соответствует значение соли, используемой для хеширования.
     * @throws DAOtoUsersException ошибка в работе с данными.
     */
    @Override
    public Map<String, String> hashPasswordAndReturnWithSalt(String password) throws DAOtoUsersException {

        Map<String, String> result = new HashMap<>();

        try {
            int iterations = 1;
            char[] chars = password.toCharArray();
            byte[] salt = this.generateSaltForHash();

            PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations,  255);
            SecretKeyFactory skf = ServiceOfUsersImpl.getSecretKeyFactory();
            byte[] hash = skf.generateSecret(spec).getEncoded();

            result.put("salt", new String(salt));
            result.put("password", new String(hash));
        } catch (InvalidKeySpecException e) {
            ServiceOfUsersImpl.LOGGER.info(e.getMessage());
            throw new DAOtoUsersException();
        }
        return result;
    }

    /**
     * Метод генерирует соль для хеширования паролей.
     * @return значение соли.
     */
    private byte[] generateSaltForHash() throws DAOtoUsersException {
        byte[] salt = new byte[10];
        try {
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            sr.nextBytes(salt);
        } catch (NoSuchAlgorithmException e) {
            ServiceOfUsersImpl.LOGGER.info(e.getMessage());
            throw new DAOtoUsersException();
        }
        return salt;
    }

    /**
     * Метод возвращает фабрику для работы с хешированием.
     * @return фабрика для работы с хешированием.
     * @throws DAOtoUsersException ошибка в работе с данными.
     */
    private static SecretKeyFactory getSecretKeyFactory() throws DAOtoUsersException {
        if(ServiceOfUsersImpl.secretKeyFactory == null){
            try {
                ServiceOfUsersImpl.secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            } catch (NoSuchAlgorithmException e) {
                ServiceOfUsersImpl.LOGGER.info(e.getMessage());
                throw new DAOtoUsersException();
            }
        }
        return ServiceOfUsersImpl.secretKeyFactory;
    }
}
