package ru.innopolis.uni.course3.overloading;

/**
 * Created by Olga on 25.01.2017.
 */
public class Test {

    /*private static short t(short i){
        System.out.println("short");
        return i;
    }*/

    /*
    private static int t(int i){
        System.out.println("int");
        return i;
    }*/

    /*
    private static long t(long i){
        System.out.println("long");
        return i;
    }*/


    private static double t(double i){
        System.out.println("double");
        return i;
    }

    private static Integer t(Integer i){
        System.out.println("integer");
        return i;
    }

    private static void s(Object obj){
        System.out.println("object");
    }

    private static void s(String obj){
        System.out.println("string");
    }


    public static void main(String[] args) {
        t((short) 1);
        t(1);
        t(new Integer(1));
        t(new Short("1"));
        Object obj = "";
        s(obj);
        s(null);
        s("");
    }

}
