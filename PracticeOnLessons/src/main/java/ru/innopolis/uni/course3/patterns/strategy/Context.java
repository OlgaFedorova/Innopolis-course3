package ru.innopolis.uni.course3.patterns.strategy;

/**
 * Created by Olga on 18.01.2017.
 */
public class Context {
    private FinancialStrategy strategy;
    private int systemLoad;

    public FinancialStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(FinancialStrategy strategy) {
        this.strategy = strategy;
    }

    public int getSystemLoad() {
        return systemLoad;
    }

    public void setSystemLoad(int systemLoad) {
        this.systemLoad = systemLoad;
        calculateStrategy();
    }

    public void excutePay(int money){
        strategy.pay(money);
    }

    public void excuteSetMoney(int money){
        strategy.setMoney(money);

    }

    public void ecuteReject(long transactionId){
        strategy.reject(transactionId);
    }

    private void calculateStrategy(){
        if (systemLoad > 0){
            strategy = new FastFinancialStrategy();
        }else {
            strategy = new MediumFinancialStrategy();
        }
    }
}
