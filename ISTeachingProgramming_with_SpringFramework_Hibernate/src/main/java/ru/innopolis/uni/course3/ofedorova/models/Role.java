package ru.innopolis.uni.course3.ofedorova.models;

import org.springframework.security.core.GrantedAuthority;

/**
 * Класс реализует модель "Роль пользователя", необходимый для Spring Security.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 13.01.2017
 */
public class Role implements GrantedAuthority {
    /**
     * Название роли.
     */
    private final String name;

    /**
     * Создает новый {@code Role}.
     *
     * @param name значение названия роли.
     */
    public Role(String name) {
        this.name = name;
    }

    /**
     * Метод возвращает значение поля "name".
     *
     * @return значение поля "name".
     */
    public String getAuthority() {
        return this.name;
    }
}
