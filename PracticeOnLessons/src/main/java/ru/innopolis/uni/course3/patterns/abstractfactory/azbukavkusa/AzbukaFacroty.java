package ru.innopolis.uni.course3.patterns.abstractfactory.azbukavkusa;

import ru.innopolis.uni.course3.patterns.abstractfactory.*;

/**
 * Created by Olga on 17.01.2017.
 */
public class AzbukaFacroty implements AbstractMarketFactory {

    @Override
    public Foods importFodds() {
        return new AzbukaFoods();
    }

    @Override
    public Tech importTech() {
        return new AzbuksTech();
    }

    @Override
    public Weapon impotWeapon() {
        return new AzbukaWeapon();
    }

    @Override
    public Jewely importJewely() {
        return new AzbukaJewely();
    }
}
