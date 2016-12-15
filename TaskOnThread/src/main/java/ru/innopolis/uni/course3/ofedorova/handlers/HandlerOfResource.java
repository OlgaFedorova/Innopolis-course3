package ru.innopolis.uni.course3.ofedorova.handlers;

import ru.innopolis.uni.course3.ofedorova.IllegalResourceException;

import java.io.InputStream;

/**
 * Абстрактный класс, реализующий модель обработки ресурса, который можно запускать для работы в отдельном потоке.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 11.12.2016
 */
public abstract class HandlerOfResource implements Runnable {
    /**
     * Ресур для обработки.
     */
    private final InputStream resource;

    /**
     * Создает новый {@code HandlerOfResource}.
     *
     * @param resource значение поля "resource".
     */
    public HandlerOfResource(InputStream resource) {
        this.resource = resource;
    }

    /**
     * Геттер для поля "resource".
     *
     * @return значение поля "resource".
     */
    public InputStream getResource() {
        return this.resource;
    }

    /**
     * Метод реализует конкретный механизм обработки.
     */
    public abstract void handleResource() throws IllegalResourceException;
}
