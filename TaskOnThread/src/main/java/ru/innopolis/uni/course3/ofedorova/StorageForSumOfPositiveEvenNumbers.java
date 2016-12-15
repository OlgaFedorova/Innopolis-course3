package ru.innopolis.uni.course3.ofedorova;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Класс реализует хранилище для результата суммы всех положительных четных чисел из ресурсов.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 11.12.2016
 */
public class StorageForSumOfPositiveEvenNumbers {

    /**
     * Переменная для хранения результата.
     */
    private AtomicLong sum = new AtomicLong();

    /**
     * Геттер для результата  суммы.
     *
     * @return значение поля "sum".
     */
    public long getSumma() {
        return this.sum.get();
    }

    /**
     * Суммирует переданное число к результату поля "sum".
     *
     * @param number значение для суммирования.
     */
    public void addToSum(int number) {
        this.sum.addAndGet(number);
    }

}
