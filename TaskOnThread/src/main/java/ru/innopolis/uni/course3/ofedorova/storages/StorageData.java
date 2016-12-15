package ru.innopolis.uni.course3.ofedorova.storages;

/**
 * Абстрактный класс для хранения результата обработки.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 11.12.2016
 */
public abstract class StorageData<T> {
    /**
     * Признак, что обработка прервана.
     */
    private boolean isInterrupted;

    /**
     * Геттер для хранения результата.
     *
     * @return значение результата обработки.
     */
    public abstract T getStorageData();

    /**
     * Геттер для поля "isInterrupted".
     *
     * @return значение поля "isInterrupted" .
     */
    public boolean isInterrupted() {
        return this.isInterrupted;
    }

    /**
     * Устанавливает поле "isInterrupted" на переданное значение.
     *
     * @param interrupted значение для поля "isInterrupted".
     */
    public void setInterrupted(boolean interrupted) {
        this.isInterrupted = interrupted;
    }
}
