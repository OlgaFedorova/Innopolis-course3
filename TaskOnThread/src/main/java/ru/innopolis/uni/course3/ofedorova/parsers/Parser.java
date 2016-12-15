package ru.innopolis.uni.course3.ofedorova.parsers;

import java.util.List;

/**
 * Класс реализует абстрактную модель парсера.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 11.12.2016
 */
public interface Parser {
    /**
     * Метод разделяет строку на составные части по заданному алгоритму.
     *
     * @param stringForParse строка для парсинга.
     * @return список данных, созданных в результате парсинга.
     * @throws IllegalResourceException ошибка о некорректном формате ресурса.
     */
    List<String> parse(String stringForParse) throws IllegalResourceException;

}
