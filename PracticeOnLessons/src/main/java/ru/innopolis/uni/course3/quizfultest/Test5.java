package ru.innopolis.uni.course3.quizfultest;

/**
 * Created by Olga on 24.01.2017.
 */
public class Test5 {

    public static void go(short n) { System.out.print("short "); }
    public static void go(Short n) { System.out.print("SHORT "); }
    public static void go(Long n) { System.out.print("LONG"); }

    public static void main(String[] args) {
        Short y = 6;
        int z = 7;
        go(y);
        go((long)z);
    }

    static class A{
        final static void t(){}
        final static void t(int i){}
    }
    static class B extends A{
        //static void t(){}
    }


}
