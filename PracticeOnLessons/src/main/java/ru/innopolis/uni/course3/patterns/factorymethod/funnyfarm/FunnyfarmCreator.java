package ru.innopolis.uni.course3.patterns.factorymethod.funnyfarm;

import ru.innopolis.uni.course3.patterns.factorymethod.Bread;
import ru.innopolis.uni.course3.patterns.factorymethod.Creator;
import ru.innopolis.uni.course3.patterns.factorymethod.Foods;
import ru.innopolis.uni.course3.patterns.factorymethod.Milk;

/**
 * Created by Olga on 17.01.2017.
 */
public class FunnyfarmCreator extends Creator {
    @Override
    public Foods createFoods() {
        return new Milk();
    }
}
