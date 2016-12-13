package ru.innopolis.uni.course3.ofedorova;

/**
 * Класс, реализующий Runnable для вывода информации о количестве сгенерированных чисел.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 12.12.2016
 */
public class GeneratorNumber implements Runnable {
    /**
     * Константа для проверки максимального значения в диапазоне чисел.
     */
    private static int max = 99;
    /**
     * Объект для хранения сгенерированных чисел.
     */
    private final StorageForNumber storage;


    /**
     * Конструктор по умолчанию.
     *
     * @param storage ссылка на объект-хранилище сгенерированный чисел.
     */
    public GeneratorNumber(StorageForNumber storage) {
        this.storage = storage;
    }

    /**
     * Метод run для запуска в потоке.
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
                this.storage.addNumber((int) (Math.random() * GeneratorNumber.max + 1));
                synchronized (this.storage) {
                    this.storage.notifyAll();
                }
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
