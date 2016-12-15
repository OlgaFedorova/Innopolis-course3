package ru.innopolis.uni.course3.ofedorova.parsers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс для тестирования класса "ParserForNumber".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 11.12.2016
 */
public class ParserForNumberTest {

    /**
     * Тест парсинга с ожиданием исключительной ситуации.
     *
     * @throws IllegalResourceException
     */
    @Test(expected = IllegalResourceException.class)
    public void whenParseWithException() throws IllegalResourceException {
        final Parser parser = new ParserForNumber();
        parser.parse("678   -89  gdss 45");
    }

    /**
     * Тест парсинга без ожидания исключительной ситуации.
     *
     * @throws IllegalResourceException
     */
    @Test
    public void whenParseWithoutException() throws IllegalResourceException {
        final Parser parser = new ParserForNumber();
        final List<String> expectedList = new ArrayList<>();
        final String number1 = "-9";
        final String number2 = "08";
        final String number3 = "78";
        final String number4 = "-67";
        final String space = " ";
        expectedList.add(number1);
        expectedList.add(number2);
        expectedList.add(number3);
        expectedList.add(number4);
        final StringBuilder stringForParse = new StringBuilder();
        stringForParse.append(number1);
        stringForParse.append(space);
        stringForParse.append(space);
        stringForParse.append(space);
        stringForParse.append(number2);
        stringForParse.append(space);
        stringForParse.append(number3);
        stringForParse.append(space);
        stringForParse.append(number4);
        stringForParse.append(space);
        final List<String> actualList = parser.parse(stringForParse.toString());

        assertThat(actualList, is(expectedList));
    }

}