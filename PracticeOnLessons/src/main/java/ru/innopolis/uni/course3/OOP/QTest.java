package ru.innopolis.uni.course3.OOP;

/**
 * Created by Olga on 18.12.2016.
 */
public class QTest {
    {
        System.out.print("1");
    }

    public static void main(String[] args) {
        System.out.print("2");
        new QTest();
    }

    static {
        System.out.print("3");
    }
}
