package ru.innopolis.uni.course3.OOP;

/**
 * Created by Olga on 10.12.2016.
 */
public class LocalVsInstance {

    String s;

    public static void main(String[] args) {
        String s = null;
        System.out.println(s.toUpperCase());
        LocalVsInstance localVsInstance = new  LocalVsInstance();
        System.out.println(localVsInstance.s.toUpperCase());
    }
}
