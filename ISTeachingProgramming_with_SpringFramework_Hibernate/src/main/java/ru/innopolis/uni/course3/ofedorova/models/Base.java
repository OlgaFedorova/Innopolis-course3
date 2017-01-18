package ru.innopolis.uni.course3.ofedorova.models;

import javax.persistence.*;

/**
 * Класс реализует базовую модель системы.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.12.2016
 */
public class Base {
    /**
     * Идентификатор пользователя.
     */
    private int id;

    /**
     * Создает новый {@code Base}.
     *
     * @param id значение для поля "id".
     */
    public Base(int id) {
        this.id = id;
    }

    /**
     * Метод возвращает значение поля "id".
     *
     * @return значение поля "id".
     */
    public int getId() {
        return this.id;
    }

    /**
     * Метод устанавливает новое значение поля "id".
     *
     * @param id новое значение поля "id".
     */
    public void setId(int id) {
        this.id = id;
    }
}
