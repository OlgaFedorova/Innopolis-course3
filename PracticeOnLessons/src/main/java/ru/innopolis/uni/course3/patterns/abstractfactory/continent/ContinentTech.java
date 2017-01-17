package ru.innopolis.uni.course3.patterns.abstractfactory.continent;

import ru.innopolis.uni.course3.patterns.abstractfactory.Tech;

/**
 * Created by Olga on 17.01.2017.
 */
public class ContinentTech extends Tech {

    private boolean isSale;

    public boolean isSale() {
        return isSale;
    }

    public void setSale(boolean sale) {
        isSale = sale;
    }
}
