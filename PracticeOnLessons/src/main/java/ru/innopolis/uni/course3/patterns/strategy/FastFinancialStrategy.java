package ru.innopolis.uni.course3.patterns.strategy;

/**
 * Created by Olga on 18.01.2017.
 */
public class FastFinancialStrategy implements FinancialStrategy {
    @Override
    public void pay(int money) {
        System.out.println("I pay fast");
    }

    @Override
    public void setMoney(int money) {
        System.out.println("I set money fast");
    }

    @Override
    public int reject(long transactionId) {
        System.out.println("I reject transaction " + transactionId + " fast");
        return 0;
    }
}
