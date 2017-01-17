package ru.innopolis.uni.course3.patterns.decorator;

/**
 * Created by Olga on 17.01.2017.
 */
public abstract class CoffeDecorator implements CoffeComponent {

    protected CoffeComponent coffeComponent;

    public CoffeDecorator(CoffeComponent coffeComponent) {
        this.coffeComponent = coffeComponent;
    }

    @Override
    public void showIngridient() {
        coffeComponent.showIngridient();
    }
}
