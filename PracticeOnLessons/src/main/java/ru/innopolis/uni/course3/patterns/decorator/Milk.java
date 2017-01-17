package ru.innopolis.uni.course3.patterns.decorator;

/**
 * Created by Olga on 17.01.2017.
 */
public class Milk extends CoffeDecorator{

    public Milk(CoffeComponent coffeComponent) {
        super(coffeComponent);
    }

    @Override
    public void showIngridient() {
        super.showIngridient();
        System.out.println("milk");
    }
}
