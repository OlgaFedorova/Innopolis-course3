package ru.innopolis.uni.course3.ofedorova;

/**
 * Класс, реализующий Runnable для генерации случайных чисел в интервале [0;99].
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 12.12.2016
 */
public class CheckerNumber implements Runnable {
    /**
     * Объект для хранения сгенерированных чисел.
     */
    private final StorageForNumber storage;

    /**
     * Конструктор по умолчанию.
     *
     * @param storage ссылка на объект-хранилище сгенерированный чисел.
     */
    public CheckerNumber(StorageForNumber storage) {
        this.storage = storage;
    }

    /**
     * Метод run для запуска в потоке.
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(5000);
                System.out.println(String.format("Unique count %d, %s", this.storage.getSet().size(), this.storage.getSet().toString()));
                synchronized (this.storage) {
                    this.storage.wait();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }
}
