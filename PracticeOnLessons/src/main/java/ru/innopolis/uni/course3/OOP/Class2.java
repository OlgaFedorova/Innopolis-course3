package ru.innopolis.uni.course3.OOP;

/**
 * Created by Olga on 19.12.2016.
 */
public class Class2 extends Class1 {
    Class2(double d) {              // 1
        this((int) d);
        System.out.println("Class2(double)");
    }

    Class2(int i) {  // 2
        super(i);
        System.out.println("Class2(int)");
    }

    public static void main(String[] args) {
        new Class2(0.0);
    }
}
