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
    private String password;
    /**
     * Общий балл.
     */
    private int mark;

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
     * Создает новый {@code User}.
     *
     * @param id   значение для поля "id".
     * @param name значение для поля "name".
     * @param mark значение поля "mark".
     */
    public User(int id, String name, int mark) {
        super(id);
        this.name = name;
        this.mark = mark;
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

    /**
     * Метод возвращает значение поля "mark".
     *
     * @return значение поля "mark".
     */
    public int getMark() {
        return this.mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (mark != user.mark) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + mark;
        return result;
    }
}
