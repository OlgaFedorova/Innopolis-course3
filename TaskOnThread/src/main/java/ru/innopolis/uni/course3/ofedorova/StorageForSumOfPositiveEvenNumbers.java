package ru.innopolis.uni.course3.ofedorova;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Olga on 11.12.2016.
 */
public class StorageForSumOfPositiveEvenNumbers {

    private AtomicInteger sum = new AtomicInteger();

    public int getSumma() {
        return this.sum.get();
    }

    public void addToSum(int number){
        this.sum.addAndGet(number);
    }

}
