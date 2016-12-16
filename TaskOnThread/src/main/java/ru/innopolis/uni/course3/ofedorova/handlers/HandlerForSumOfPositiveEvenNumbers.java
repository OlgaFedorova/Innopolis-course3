package ru.innopolis.uni.course3.ofedorova.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.course3.ofedorova.parsers.IllegalResourceException;
import ru.innopolis.uni.course3.ofedorova.parsers.Parser;
import ru.innopolis.uni.course3.ofedorova.storages.StorageData;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Класс реализует обработку ресурса, для которого считает сумму всех положительных четных чисел.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 11.12.2016
 */
public class HandlerForSumOfPositiveEvenNumbers extends HandlerOfResource {
    /**
     * Объект для логгирования.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HandlerForSumOfPositiveEvenNumbers.class);
    /**
     * Объект для храненения информации.
     */
    private final StorageData<AtomicLong> storageData;


    /**
     * Создает новый {@code HandlerForSumOfPositiveEvenNumbers}.
     *
     * @param resource    значение поля "resource".
     * @param parser      значение поля "parser".
     * @param storageData значение поля "storageData".
     */
    public HandlerForSumOfPositiveEvenNumbers(InputStream resource, Parser parser, StorageData<AtomicLong> storageData) {
        super(resource, parser, storageData);
        this.storageData = storageData;
    }

    /**
     * Метод обрабатывает ресурс.
     */
    @Override
    public void handleResource(String stringRead) {
        try {
            List<String> list = this.getParser().parse(stringRead);
            for (String string : list) {
                final Integer number = Integer.valueOf(string);
                if (!this.storageData.isInterrupted()) {
                    if (number > 0 && number % 2 == 0) {
                        System.out.printf("Sum is %s%s", this.storageData.getStorageData().addAndGet(number), System.getProperty("line.separator"));
                    }
                } else {
                    break;
                }
            }
        } catch (IllegalResourceException e) {
            this.storageData.setInterrupted(true);
            System.out.printf("Program is stopped. Has incorrect resource%s", System.getProperty("line.separator"));
            LOGGER.error("Parse resource.", e);
        }
    }

}
