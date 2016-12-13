package ru.innopolis.uni.course3.OOP;

/**
 * Created by Olga on 11.12.2016.
 */
public class TestBoolean {

    private static Boolean b1, b2;

    public static void main (String[] args) {
        if (b1 || !b2 || !b1 || b2) {
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
    }

}
