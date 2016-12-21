package ru.innopolis.uni.course3.generic.simplearray;

/**
 * Class for testing create new instance with reflection.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 21.12.2016
 */
public class Stack extends SimpleArray<String> {

    /**
     * Allocates a new {@code SimpleArray}.
     *
     * @param capacity value of field "capacity".
     */
    public Stack(int capacity) {
        super(capacity);
    }
}
