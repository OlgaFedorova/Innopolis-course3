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
    private final Lock lock = new ReentrantLock();

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
    public synchronized boolean isInterrupted() {
        boolean result = false;
        while(true){
            if(lock.tryLock()){
                try{
                    result = this.isInterrupted;
                } finally{
                    lock.unlock();
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
            if(lock.tryLock()){
                try{
                    this.isInterrupted = interrupted;
                } finally{
                    lock.unlock();
                }
                break;
            }
        }
    }
}
