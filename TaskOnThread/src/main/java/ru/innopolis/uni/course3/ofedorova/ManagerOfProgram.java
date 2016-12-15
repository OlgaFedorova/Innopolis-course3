package ru.innopolis.uni.course3.ofedorova;

import ru.innopolis.uni.course3.ofedorova.handlers.HandlerForSumOfPositiveEvenNumbers;

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
public class ManagerOfProgram {

    /**
     * Метод стартует работу потоков над обработкой ресурсов.
     *
     * @param resources список ресурсов для обработки.
     */
    public void start(List<InputStream> resources) {

        final StorageForSumOfPositiveEvenNumbers storage = new StorageForSumOfPositiveEvenNumbers();
        final ExecutorService service = Executors.newFixedThreadPool(4);

        for (InputStream resource : resources) {
            service.submit(new HandlerForSumOfPositiveEvenNumbers(storage, resource));
        }
    }
}
