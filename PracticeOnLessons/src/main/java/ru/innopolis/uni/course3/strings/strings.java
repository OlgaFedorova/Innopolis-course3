package ru.innopolis.uni.course3.strings;

/**
 * Created by Olga on 11.01.2017.
 */
public class strings {

    private int getX() {
        return 5;
    }

    public int get2X() {
        strings x = new strings();
        return 2 * x.getX();
    }

    public static void main(String[] args) {
        String s = "10";
        System.out.println(s.intern());
    }
}
