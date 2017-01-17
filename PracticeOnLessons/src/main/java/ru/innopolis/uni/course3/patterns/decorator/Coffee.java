package ru.innopolis.uni.course3.patterns.decorator;

/**
 * Created by Olga on 17.01.2017.
 */
public class Coffee implements CoffeComponent {
    @Override
    public void showIngridient() {
        System.out.println("Coffe");
    }
}
