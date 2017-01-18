package ru.innopolis.uni.course3.patterns.strategy;

/**
 * Created by Olga on 18.01.2017.
 */
public class HighFinancialStrategy implements FinancialStrategy {
    @Override
    public void pay(int money) {
        System.out.println("I pay high");
    }

    @Override
    public void setMoney(int money) {
        System.out.println("I set money high");
    }

    @Override
    public int reject(long transactionId) {
        System.out.println("I reject transaction " + transactionId + " high");
        return 0;
    }
}
