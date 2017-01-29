package ru.innopolis.uni.course3.exceptions;

/**
 * Created by Olga on 28.01.2017.
 */
public class App {

    public static void main(String[] args) {
        f(null);
    }
    public static void f(NullPointerException e) {
        try {
            throw e;
        } catch (NullPointerException npe) {
            f(npe);
        }
    }

}
