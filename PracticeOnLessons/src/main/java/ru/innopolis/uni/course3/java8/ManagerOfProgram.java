package ru.innopolis.uni.course3.java8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.uni.course3.java8.handlers.HandlerForSumOfPositiveEvenNumbers;
import ru.innopolis.uni.course3.java8.handlers.HandlerOfResource;
import ru.innopolis.uni.course3.java8.parsers.Parser;
import ru.innopolis.uni.course3.java8.storages.StorageData;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Класс реализует запуск потоков для обработки ресурсов.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 11.12.2016
 */
@Component
public class ManagerOfProgram {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManagerOfProgram.class);
    @Autowired
    private StorageData storage;
    @Autowired
    private Parser parser;

    public ManagerOfProgram(StorageData storage, Parser parser) {
        this.storage = storage;
        this.parser = parser;
    }

    /**
     * Метод стартует работу потоков над обработкой ресурсов.
     *
     * @param resources список ресурсов для обработки.
     */
    public void start(List<InputStream> resources) {

        final ExecutorService executor = Executors.newFixedThreadPool(4);

        for (InputStream resource : resources) {
            HandlerOfResource handlerOfResource = new HandlerForSumOfPositiveEvenNumbers(resource, this.parser, this.storage);
            executor.submit(handlerOfResource::readResourse);
        }

        executor.shutdown();
    }
}
