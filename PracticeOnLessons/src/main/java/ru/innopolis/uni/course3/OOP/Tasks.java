package ru.innopolis.uni.course3.OOP;

/**
 * Created by Olga on 10.12.2016.
 */
public class Tasks {

    public static Tasks instance = new Tasks();
    private static final int DELTA = 5;
    private static int BASE = 7;
    private int x;

    public Tasks() {
        x = BASE + DELTA;
    }
    public static int getBASE() {
        return BASE;
    }
    public static void main(String[] args) {
        System.out.println(Tasks.instance.x);
    }

}
