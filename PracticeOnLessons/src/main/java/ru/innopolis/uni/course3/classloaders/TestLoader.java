package ru.innopolis.uni.course3.classloaders;

/**
 * Created by Olga on 23.12.2016.
 */
public class TestLoader {

    public static void main(String[] args) {
        ClassLoader loader1 = new StringTest().getClass().getClassLoader();
        System.out.println(loader1);

        ClassLoader loader2 = new java.lang.String().getClass().getClassLoader();
        System.out.println(loader2);
    }
}
