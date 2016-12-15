package ru.innopolis.uni.course3.ofedorova;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.course3.ofedorova.handlers.HandlerForSumOfPositiveEvenNumbers;
import ru.innopolis.uni.course3.ofedorova.parsers.Parser;
import ru.innopolis.uni.course3.ofedorova.parsers.ParserForNumber;
import ru.innopolis.uni.course3.ofedorova.storages.StorageData;
import ru.innopolis.uni.course3.ofedorova.storages.StorageForSumOfPositiveEvenNumbers;

import java.io.InputStream;
import java.util.List;

/**
 * Класс реализует запуск потоков для обработки ресурсов.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 11.12.2016
 */
public class ManagerOfProgram {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManagerOfProgram.class);

    /**
     * Метод стартует работу потоков над обработкой ресурсов.
     *
     * @param resources список ресурсов для обработки.
     */
    public void start(List<InputStream> resources) {

        final StorageData storage = new StorageForSumOfPositiveEvenNumbers();
        final Parser parser = new ParserForNumber();

        for (InputStream resource : resources) {
            new Thread(new HandlerForSumOfPositiveEvenNumbers(resource, parser, storage)).start();
        }

    }
}
