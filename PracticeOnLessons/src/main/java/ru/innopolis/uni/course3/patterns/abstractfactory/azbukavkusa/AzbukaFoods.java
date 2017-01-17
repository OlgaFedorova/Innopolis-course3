package ru.innopolis.uni.course3.patterns.abstractfactory.azbukavkusa;

import ru.innopolis.uni.course3.patterns.abstractfactory.Foods;

import java.util.Random;

/**
 * Created by Olga on 17.01.2017.
 */
public class AzbukaFoods extends Foods {

    private double veryHighOrice;

    public double getVeryHighOrice() {
        return veryHighOrice;
    }

    public void setVeryHighOrice() {
        this.veryHighOrice = new Random().nextDouble();
    }
}
