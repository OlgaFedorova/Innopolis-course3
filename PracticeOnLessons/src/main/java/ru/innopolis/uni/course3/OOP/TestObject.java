package ru.innopolis.uni.course3.OOP;

/**
 * Created by Olga on 14.12.2016.
 */
public class TestObject {

    public static void main(String[] args) {
        Object obj = new String("String object");
        String str = (String) new Object();
        System.out.println(obj);
        System.out.println(str);
    }
}
