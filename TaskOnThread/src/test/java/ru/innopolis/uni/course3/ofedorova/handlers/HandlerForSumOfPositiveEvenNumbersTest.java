package ru.innopolis.uni.course3.ofedorova.handlers;

import org.junit.Test;
import ru.innopolis.uni.course3.ofedorova.parsers.IllegalResourceException;
import ru.innopolis.uni.course3.ofedorova.parsers.Parser;
import ru.innopolis.uni.course3.ofedorova.parsers.ParserForNumber;
import ru.innopolis.uni.course3.ofedorova.storages.StorageData;
import ru.innopolis.uni.course3.ofedorova.storages.StorageForSumOfPositiveEvenNumbers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;

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
     * Тестирование обработки корректного ресурса.
     *
     * @throws IllegalResourceException ошибка о некорректном формате ресурса.
     * @throws IOException              ошибка работы с потоком.
     */
    @Test
    public void whenHandleCorrectResourse() throws IOException, IllegalResourceException {
        final StorageData<AtomicLong> storage = new StorageForSumOfPositiveEvenNumbers();
        final Parser parser = new ParserForNumber();
        try (InputStream resource = new FileInputStream(String.format("%s/temp_with_incorrect/Resource1", System.getProperties().get("user.dir")));) {
            final HandlerOfResource handler = new HandlerForSumOfPositiveEvenNumbers(resource, parser, storage);
            handler.readResourse();
            final long actualSum = storage.getStorageData().get();
            final long expectedSum = 12;
            assertTrue(actualSum == expectedSum);
        }
    }

}