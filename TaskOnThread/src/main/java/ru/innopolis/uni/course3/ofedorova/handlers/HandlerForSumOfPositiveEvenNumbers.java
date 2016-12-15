package ru.innopolis.uni.course3.ofedorova.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.course3.ofedorova.IllegalResourceException;
import ru.innopolis.uni.course3.ofedorova.StorageForSumOfPositiveEvenNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс реализует обработку ресурса, для которого считает сумму всех положительных четных чисел.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 11.12.2016
 */
public class HandlerForSumOfPositiveEvenNumbers extends HandlerOfResource {

    /**
     * Объект для логирования.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HandlerForSumOfPositiveEvenNumbers.class);

    /**
     * Хранилище для суммы всех положительных четных чисел ресурсов.
     */
    private final StorageForSumOfPositiveEvenNumbers storageForSum;

    /**
     * Создает новый {@code HandlerForSumOfPositiveEvenNumbers}.
     *
     * @param sum      значение хранилища для суммы всех положительных четных чисел.
     * @param resource значение ресурса для обработки.
     */
    public HandlerForSumOfPositiveEvenNumbers(StorageForSumOfPositiveEvenNumbers sum, InputStream resource) {
        super(resource);
        this.storageForSum = sum;
    }

    /**
     * Метод обрабатывает ресурс.
     *
     * @throws IllegalResourceException ошибка о некорректном формате ресурса.
     */
    @Override
    public void handleResource() throws IllegalResourceException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.getResource()));) {
            String stringRead = "";
            String regexNumber = "(-?\\d+)\\s*";
            Matcher matcher = Pattern.compile(regexNumber).matcher(stringRead);
            while (stringRead != null) {
                stringRead = reader.readLine();
                if (stringRead != null) {
                    if (stringRead.matches(String.format("(%s){1,}", regexNumber))) {
                        matcher.reset(stringRead);
                        this.checkStringResource(matcher);
                    } else {
                        throw new IllegalResourceException();
                    }

                }
            }
        } catch (IOException e) {
            LOGGER.error("Handle resource.", e);
        }
    }

    /**
     * Метод для запуска в отдельном потоке.
     */
    @Override
    public void run() {
        try {
            this.handleResource();
        } catch (IllegalResourceException e) {
            LOGGER.error("Run.", e);
        }
    }

    /**
     * Метод проверяет строку ресурса, считывает все положительные четные числа и суммирует их.
     * Если строка ресурса содержит не только числа, унарный оператор "-" и пробелы, то будет выброшено исключение.
     *
     * @param matcher объект для поиска цифр в строке.
     */
    private void checkStringResource(Matcher matcher) {
        while (matcher.find()) {
            final Integer number = Integer.valueOf(matcher.group(1));
            if (number > 0 && number % 2 == 0) {
                this.storageForSum.addToSum(number);
                System.out.printf("Сумма: %s%s", this.storageForSum.getSumma(), System.getProperty("line.separator"));
            }
        }
    }
}
