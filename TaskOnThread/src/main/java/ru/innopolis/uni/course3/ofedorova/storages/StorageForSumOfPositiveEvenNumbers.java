package ru.innopolis.uni.course3.ofedorova.storages;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Класс реализует хранилище для результата суммы всех положительных четных чисел из ресурсов.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 11.12.2016
 */
@Component
public class StorageForSumOfPositiveEvenNumbers extends StorageData<AtomicLong> {

    /**
     * Переменная для хранения результата.
     */
    private AtomicLong sum = new AtomicLong();

    /**
     * Геттер для хранения результата.
     *
     * @return значение поля "sum".
     */
    @Override
    public AtomicLong getStorageData() {
        AtomicLong result = null;
        while(true){
            if(this.getLock().tryLock()){
                try{
                    result = this.sum;
                } finally{
                    this.getLock().unlock();
                }
                break;
            }
        }
        return result;
    }

}
