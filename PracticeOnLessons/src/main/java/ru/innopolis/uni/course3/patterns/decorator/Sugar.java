package ru.innopolis.uni.course3.patterns.decorator;

/**
 * Created by Olga on 17.01.2017.
 */
public class Sugar extends CoffeDecorator {

    public Sugar(CoffeComponent coffeComponent) {
        super(coffeComponent);
    }

    @Override
    public void showIngridient() {
        super.showIngridient();
        System.out.println("sugar");
    }
}
