package ru.innopolis.uni.course3.patterns.decorator;

/**
 * Created by Olga on 17.01.2017.
 */
public class Main {

    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        Sugar sugar = new Sugar(coffee);
        Milk milk = new Milk(sugar);
        Vanil vanil = new Vanil(milk);

        vanil.showIngridient();
    }
}
