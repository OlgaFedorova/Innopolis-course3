package ru.innopolis.uni.course3.OOP;

/**
 * Created by Olga on 09.12.2016.
 */
public class X {
    private int getX() {
        return 5;
    }

    public int get2X() {
        X x = new X();
        return 2 * x.getX();
    }
}