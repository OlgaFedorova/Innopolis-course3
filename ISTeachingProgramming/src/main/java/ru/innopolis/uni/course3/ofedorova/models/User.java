package ru.innopolis.uni.course3.ofedorova.models;

/**
 * Класс реализует модель "Пользователь системы".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.12.2016
 */
public class User extends Base {
    /**
     * Имя пользователя.
     */
    private final String name;
    /**
     * Пароль пользователя.
     */
    private final String password;

    /**
     * Создает новый {@code User}.
     *
     * @param id       значение для поля "id".
     * @param name     значение для поля "name".
     * @param password значение для поля "password".
     */
    public User(int id, String name, String password) {
        super(id);
        this.name = name;
        this.password = password;
    }

    /**
     * Создает новый {@code User}.
     *
     * @param name     значение для поля "name".
     * @param password значение для поля "password".
     */
    public User(String name, String password) {
        this(-1, name, password);
    }

    /**
     * Метод возвращает значение поля "name".
     *
     * @return значение поля "name".
     */
    public String getName() {
        return this.name;
    }

    /**
     * Метод возвращает значение поля "password".
     *
     * @return значение поля "password".
     */
    public String getPassword() {
        return this.password;
    }
}
