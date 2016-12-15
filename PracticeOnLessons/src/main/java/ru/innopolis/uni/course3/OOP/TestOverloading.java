package ru.innopolis.uni.course3.OOP;

/**
 * Created by Olga on 14.12.2016.
 */
public class TestOverloading {

    public static void main(String... args) {
        test("A", "B");
    }

    public static void test(String... str) {
        System.out.print("A");
    }

    public static void test(String str1, String str2) {
        System.out.print("B");
    }

    public static void test(String str1, String... str2) {
        System.out.print("C");
    }

}
