package ru.innopolis.uni.course3.ofedorova.handlers;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.innopolis.uni.course3.ofedorova.IllegalResourceException;
import ru.innopolis.uni.course3.ofedorova.StorageForSumOfPositiveEvenNumbers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertTrue;

/**
 * Класс для тестирования класса "HandlerForSumOfPositiveEvenNumbers".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 11.12.2016
 */
public class HandlerForSumOfPositiveEvenNumbersTest {

    /**
     * Ожидаемая исключительная ситуация.
     */
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * Тестирование обработки некорректного ресурса.
     *
     * @throws IllegalResourceException ошибка о некорректном формате ресурса.
     * @throws IOException              ошибка работы с потоком.
     */
    @Test
    public void whenHandleUncorrectResourse() throws IllegalResourceException, IOException {
        final StorageForSumOfPositiveEvenNumbers storage = new StorageForSumOfPositiveEvenNumbers();
        try (InputStream resource = new FileInputStream(String.format("%s/temp_with_incorrect/Resource2", System.getProperties().get("user.dir")));) {
            final HandlerOfResource handler = new HandlerForSumOfPositiveEvenNumbers(storage, resource);
            exception.expect(IllegalResourceException.class);
            handler.handleResource();
        }
    }

    /**
     * Тестирование обработки корректного ресурса.
     *
     * @throws IllegalResourceException ошибка о некорректном формате ресурса.
     * @throws IOException              ошибка работы с потоком.
     */
    @Test
    public void whenHandleCorrectResourse() throws IOException, IllegalResourceException {
        final StorageForSumOfPositiveEvenNumbers storage = new StorageForSumOfPositiveEvenNumbers();
        try (InputStream resource = new FileInputStream(String.format("%s/temp_with_incorrect/Resource1", System.getProperties().get("user.dir")));) {
            final HandlerOfResource handler = new HandlerForSumOfPositiveEvenNumbers(storage, resource);
            handler.handleResource();
            final long actualSum = storage.getSumma();
            final long expectedSum = 1642;
            assertTrue(actualSum == expectedSum);
        }
    }

}