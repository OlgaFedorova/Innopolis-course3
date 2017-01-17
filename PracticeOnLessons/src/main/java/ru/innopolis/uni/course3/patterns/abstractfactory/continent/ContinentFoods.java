package ru.innopolis.uni.course3.patterns.abstractfactory.continent;

import ru.innopolis.uni.course3.patterns.abstractfactory.Foods;

/**
 * Created by Olga on 17.01.2017.
 */
public class ContinentFoods extends Foods {

    private boolean vkusno;

    public boolean isVkusno() {
        return vkusno;
    }

    public void setVkusno(boolean vkusno) {
        this.vkusno = vkusno;
    }
}
