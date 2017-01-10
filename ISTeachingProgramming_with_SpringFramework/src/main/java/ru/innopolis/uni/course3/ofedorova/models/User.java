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
    private String name;
    /**
     * Пароль пользователя.
     */
    private String password;
    /**
     * Salt для хеширования пароля.
     */
    private String salt;
    /**
     * Подтверждение пароля пользователя.
     */
    private String confirmPassword;
    /**
     * Новый пароль пользователя.
     */
    private String newPassword;
    /**
     * Подтверждение нового пароля пользователя.
     */
    private String confirmNewPassword;
    /**
     * Текущий пароль пользователя.
     */
    private String currentPassword;
    /**
     * Общий балл.
     */
    private int mark;

    /**
     * Создает новый {@code User}.
     */
    public User() {
        super(1);
    }

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
     * Метод устанавливает новое значение для поля "name".
     *
     * @param name новое значение для поля "name".
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод устанавливает новое значение для поля "password".
     *
     * @param password новое значение для поля "password".
     */
    public void setPassword(String password) {
        this.password = password;
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
     * Метод возвращает значение поля "confirmPassword".
     *
     * @return значение поля "confirmPassword".
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * Метод устанавливает новое значение для поля "confirmPassword".
     *
     * @param confirmPassword новое значение для поля "confirmPassword".
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * Метод возвращает значение поля "newPassword".
     *
     * @return значение поля "newPassword".
     */
    public String getNewPassword() {
        return this.newPassword;
    }

    /**
     * Метод устанавливает новое значение поля "newPassword".
     *
     * @param newPassword новое значение поля "newPassword".
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     * Метод возвращает значение поля "confirmNewPassword".
     *
     * @return значение поля "confirmNewPassword".
     */
    public String getConfirmNewPassword() {
        return this.confirmNewPassword;
    }

    /**
     * Метод возвращает значение поля "currentPassword.
     *
     * @return значение поля "currentPassword".
     */
    public String getCurrentPassword() {
        return this.currentPassword;
    }

    /**
     * Метод устанавливает новое значение поля "currentPassword".
     *
     * @param currentPassword новое значение поля "currentPassword".
     */
    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    /**
     * Метод устанавливает новое значение поля "confirmNewPassword".
     *
     * @param confirmNewPassword новое значение поля "confirmNewPassword".
     */
    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }

    /**
     * Метод устанавливает новое значение поля "salt".
     * @param salt новое значение поля "salt".
     */
    public void setSalt(String salt) {
        this.salt = salt;
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
