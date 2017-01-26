package ru.innopolis.uni.course3.ofedorova.common.models;

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
     * Salt для хеширования пароля.
     */
    private String salt;
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
     * @param salt     значение для поля "salt".
     */
    public User(int id, String name, String password, String salt) {
        super(id);
        this.name = name;
        this.password = password;
        this.salt = salt;
    }

    /**
     * Создает новый {@code User}.
     *
     * @param name     значение для поля "name".
     * @param password значение для поля "password".
     * @param salt     значение для поля "salt".
     */
    public User(String name, String password, String salt) {
        this(-1, name, password, salt);
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

    /**
     * Метод возвращает значение поля "salt".
     *
     * @return значение поля "salt".
     */
    public String getSalt() {
        return this.salt;
    }

    /**
     * Compares this object to the specified object.  The result is
     * {@code true} if and only if the argument is not
     * {@code null} and is an {@code Item} object that
     * contains the same values of field "id", "mark", "name", "password", "salt" as this object.
     *
     * @param o the object to compare with.
     * @return {@code true} if the objects are the same;
     * {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (this.getId() != user.getId()) return false;
        if (mark != user.mark) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return salt != null ? salt.equals(user.salt) : user.salt == null;

    }

    /**
     * Returns a hash code for this {@code User}.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + mark;
        result = 31 * result + this.getId();
        return result;
    }
}
