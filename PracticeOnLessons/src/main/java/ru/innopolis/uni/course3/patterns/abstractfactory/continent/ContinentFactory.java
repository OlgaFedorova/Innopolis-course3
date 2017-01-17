package ru.innopolis.uni.course3.patterns.abstractfactory.continent;

import ru.innopolis.uni.course3.patterns.abstractfactory.*;

/**
 * Created by Olga on 17.01.2017.
 */
public class ContinentFactory implements AbstractMarketFactory {

    @Override
    public Foods importFodds() {
        return new ContinentFoods();
    }

    @Override
    public Tech importTech() {
        return new ContinentTech();
    }

    @Override
    public Weapon impotWeapon() {
        return new ContinentWeapon();
    }

    @Override
    public Jewely importJewely() {
        return new ContinentJewely();
    }
}
