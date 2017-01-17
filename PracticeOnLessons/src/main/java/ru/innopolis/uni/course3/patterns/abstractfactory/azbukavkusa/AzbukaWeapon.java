package ru.innopolis.uni.course3.patterns.abstractfactory.azbukavkusa;

import ru.innopolis.uni.course3.patterns.abstractfactory.Weapon;

/**
 * Created by Olga on 17.01.2017.
 */
public class AzbukaWeapon extends Weapon {

    private boolean isSraziky;

    public boolean isSraziky() {
        return isSraziky;
    }

    public void setSraziky(boolean sraziky) {
        isSraziky = sraziky;
    }
}
