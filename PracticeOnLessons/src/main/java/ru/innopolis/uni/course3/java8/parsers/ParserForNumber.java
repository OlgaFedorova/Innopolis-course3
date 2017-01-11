package ru.innopolis.uni.course3.java8.parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс реализует модель парсера для чисел.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 11.12.2016
 */
public class ParserForNumber implements Parser {

    /**
     * Метод разделяет строку на числа.
     *
     * @param stringForParse строка для парсинга.
     * @return список чисел, созданных в результате парсинга.
     * @throws IllegalResourceException ошибка о некорректном формате ресурса.
     */
    @Override
    public List<String> parse(String stringForParse) throws IllegalResourceException {
        List<String> listNumbers = new ArrayList<>();
        String regexNumber = "(-?\\d+)\\s*";
        Matcher matcher = Pattern.compile(regexNumber).matcher(stringForParse);
        if (stringForParse != null) {
            if (stringForParse.matches(String.format("(%s){1,}", regexNumber))) {
                matcher.reset(stringForParse);
                while (matcher.find()) {
                    listNumbers.add(matcher.group(1));
                }
            } else {
                throw new IllegalResourceException();
            }
        }
        return listNumbers;
    }
}
