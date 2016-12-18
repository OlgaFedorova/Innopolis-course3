package ru.innopolis.uni.course3.ofedorova.storages;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
     * Объект для блокировки.
     */
    private final Lock lock = new ReentrantLock(true);

    /**
     * Геттер для хранения результата.
     *
     * @return значение результата обработки.
     */
    public abstract T getStorageData();

    /**
     * Getter for lock.
     * @return object for lock.
     */
    public Lock getLock() {
        return lock;
    }

    /**
     * Геттер для поля "isInterrupted".
     *
     * @return значение поля "isInterrupted" .
     */
    public boolean isInterrupted() {
        boolean result = false;
        while(true){
            if(this.lock.tryLock()){
                try{
                    result = this.isInterrupted;
                } finally{
                    this.lock.unlock();
                }
                break;
            }
        }
        return result;
    }

    /**
     * Устанавливает поле "isInterrupted" на переданное значение.
     *
     * @param interrupted значение для поля "isInterrupted".
     */
    public void setInterrupted(boolean interrupted) {
        while(true){
            if(this.lock.tryLock()){
                try{
                    this.isInterrupted = interrupted;
                } finally{
                    this.lock.unlock();
                }
                break;
            }
        }
    }
}
