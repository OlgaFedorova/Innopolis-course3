package ru.innopolis.uni.course3.patterns.factorymethod.baker;

import ru.innopolis.uni.course3.patterns.factorymethod.Bread;
import ru.innopolis.uni.course3.patterns.factorymethod.Creator;
import ru.innopolis.uni.course3.patterns.factorymethod.Foods;

/**
 * Created by Olga on 17.01.2017.
 */
public class Mybaker extends Creator {
    @Override
    public Foods createFoods() {
        return new Bread();
    }
}
