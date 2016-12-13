package ru.innopolis.uni.course3.ofedorova.handlers;

import java.io.InputStream;

/**
 * Abstract class implements of model handling resource.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 11.12.2016
 */
public abstract class HandlerOfResource implements Runnable {
    /**
     * Object of resource for handling.
     */
    private final InputStream resource;

    /**
     * Allocates a new {@code HandlerOfResource}.
     * @param resource value of field "resource".
     */
    public HandlerOfResource(InputStream resource) {
        this.resource = resource;
    }

    /**
     * Getter for field "resource".
     * @return value of field "resource".
     */
    public InputStream getResource() {
        return this.resource;
    }

    /**
     * Method implements a specific handling model.
     */
    public abstract void handleResource();
}
