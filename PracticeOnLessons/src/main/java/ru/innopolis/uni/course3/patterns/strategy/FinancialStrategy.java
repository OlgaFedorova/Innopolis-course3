package ru.innopolis.uni.course3.patterns.strategy;

/**
 * Created by Olga on 18.01.2017.
 */
public interface FinancialStrategy {
    void pay(int money);
    void setMoney(int money);
    int reject(long transactionId);
}
