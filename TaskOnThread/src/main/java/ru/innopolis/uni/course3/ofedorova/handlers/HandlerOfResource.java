package ru.innopolis.uni.course3.ofedorova.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.course3.ofedorova.parsers.Parser;
import ru.innopolis.uni.course3.ofedorova.storages.StorageData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Абстрактный класс, реализующий модель обработки ресурса, который можно запускать для работы в отдельном потоке.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 11.12.2016
 */
public abstract class HandlerOfResource implements Runnable {

    /**
     * Объект для логгирования.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HandlerOfResource.class);

    /**
     * Ресур для обработки.
     */
    private final InputStream resource;
    /**
     * Объект для парсинга данных из ресурса.
     */
    private final Parser parser;
    /**
     * Объект для храненения информации.
     */
    private final StorageData storageData;

    /**
     * Создает новый {@code HandlerOfResource}.
     *
     * @param resource    значение поля "resource".
     * @param parser      значение поля "parser".
     * @param storageData значение поля "storageData".
     */
    public HandlerOfResource(InputStream resource, Parser parser, StorageData storageData) {
        this.resource = resource;
        this.parser = parser;
        this.storageData = storageData;
    }

    /**
     * Геттер для поля "parser".
     *
     * @return значение поля "parser".
     */
    public Parser getParser() {
        return this.parser;
    }

    /**
     * Метод читает переданный ресурс, и вызывает его обработку.
     */
    public void readResourse() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource));) {
            String stringRead = "";
            while (stringRead != null) {
                if (this.storageData.isInterrupted()) {
                    break;
                }
                stringRead = reader.readLine();
                if (stringRead != null) {
                    this.handleResource(stringRead);
                }
            }
        } catch (IOException e) {
            LOGGER.error("Read resource.", e);
        }
    }

    /**
     * Метод для запуска в отдельном потоке.
     */
    @Override
    public void run() {
        this.readResourse();
    }

    /**
     * Метод реализует конкретный механизм обработки.
     */
    public abstract void handleResource(String list);
}
