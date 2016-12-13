package ru.innopolis.uni.course3.ofedorova;

import java.util.HashSet;
import java.util.Set;

/**
 * Класс для хранения множества уникальных сгенерированных чисел.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 12.12.2016
 */
public class StorageForNumber {
    /**
     * Множество уникальных сгенерированных чисел.
     */
    private final Set<Integer> set = new HashSet<>();

    /**
     * Геттер для множества.
     *
     * @return
     */
    public synchronized Set<Integer> getSet() {
        return this.set;
    }

    /**
     * Метод добавляет число в множество.
     *
     * @param number число для добавления.
     */
    public synchronized void addNumber(int number) {
        this.set.add(number);
    }

    @Override
    public synchronized String toString() {
        return this.set.toString();
    }
}
