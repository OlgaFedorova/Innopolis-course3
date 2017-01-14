package ru.innopolis.uni.course3.ofedorova.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Класс реализует модель "Пользователь системы".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.12.2016
 */
public class User extends Base implements UserDetails {
    /**
     * Имя пользователя.
     */
    private String username;
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
     * Поле для Spring-security, список доступных ролей.
     */
    private List<Role> authorities;
    /**
     * Поле для Spring-security.
     */
    private boolean accountNonExpired = true;
    /**
     * Поле для Spring-security.
     */
    private boolean accountNonLocked = true;
    /**
     * Поле для Spring-security.
     */
    private boolean credentialsNonExpired = true;
    /**
     * Поле для Spring-security.
     */
    private boolean enabled = true;

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
     * @param userName значение для поля "username".
     * @param password значение для поля "password".
     * @param salt     значение для поля "salt".
     */
    public User(int id, String userName, String password, String salt) {
        super(id);
        this.username = userName;
        this.password = password;
        this.salt = salt;
    }

    /**
     * Создает новый {@code User}.
     *
     * @param userName значение для поля "username".
     * @param password значение для поля "password".
     * @param salt     значение для поля "salt".
     */
    public User(String userName, String password, String salt) {
        this(-1, userName, password, salt);
    }

    /**
     * Создает новый {@code User}.
     *
     * @param id       значение для поля "id".
     * @param userName значение для поля "username".
     * @param mark     значение поля "mark".
     */
    public User(int id, String userName, int mark) {
        super(id);
        this.username = userName;
        this.mark = mark;
    }

    /**
     * Метод возвращает значение поля "username".
     *
     * @return значение поля "username".
     */
    public String getUsername() {
        return this.username;
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
     * Метод устанавливает новое значение для поля "username".
     *
     * @param username новое значение для поля "username".
     */
    public void setUsername(String username) {
        this.username = username;
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
     *
     * @param salt новое значение поля "salt".
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * Compares this object to the specified object.  The result is
     * {@code true} if and only if the argument is not
     * {@code null} and is an {@code Item} object that
     * contains the same values of field "id", "mark", "username", "password", "salt" as this object.
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
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
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
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + mark;
        result = 31 * result + this.getId();
        return result;
    }

    /**
     * Метод возвращает значение поля "authorities".
     *
     * @return значение поля "authorities".
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    /**
     * Метод возвращает значение поля "accountNonExpired".
     *
     * @return значение поля "accountNonExpired".
     */
    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    /**
     * Метод возвращает значение поля "accountNonExpired".
     *
     * @return значение поля "accountNonExpired".
     */
    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonExpired;
    }

    /**
     * Метод возвращает значение поля "credentialsNonExpired".
     *
     * @return значение поля "credentialsNonExpired".
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    /**
     * Метод возвращает значение поля "enabled".
     *
     * @return значение поля "enabled".
     */
    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    /**
     * Метод устанавливает новое значение поля "authorities".
     *
     * @param authorities новое значение поля "authorities".
     */
    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }

    /**
     * Метод устанавливает новое значение поля "accountNonExpired".
     *
     * @param accountNonExpired новое значение поля "accountNonExpired".
     */
    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    /**
     * Метод устанавливает новое значение поля "accountNonLocked".
     *
     * @param accountNonLocked новое значение поля "accountNonLocked".
     */
    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    /**
     * Метод устанавливает новое значение поля "credentialsNonExpired".
     *
     * @param credentialsNonExpired новое значение поля "credentialsNonExpired".
     */
    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    /**
     * Метод устанавливает новое значение поля "enabled".
     *
     * @param enabled новое значение поля "enabled".
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
