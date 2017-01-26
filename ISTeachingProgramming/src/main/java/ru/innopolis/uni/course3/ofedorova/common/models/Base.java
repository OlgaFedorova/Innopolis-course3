package ru.innopolis.uni.course3.ofedorova.common.models;

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
    private final int id;

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

}
