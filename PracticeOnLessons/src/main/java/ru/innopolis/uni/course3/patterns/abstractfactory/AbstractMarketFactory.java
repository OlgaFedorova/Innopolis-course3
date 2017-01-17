package ru.innopolis.uni.course3.patterns.abstractfactory;

/**
 * Created by Olga on 17.01.2017.
 */
public interface AbstractMarketFactory {

    Foods importFodds();
    Tech importTech();
    Weapon impotWeapon();
    Jewely importJewely();
}
