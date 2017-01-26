package ru.innopolis.uni.course3.quizfultest;

/**
 * Created by Olga on 24.01.2017.
 */
public class Test6 {

    public void method(Object o) {
        System.out.println("Object");
    }
    /*
    public void method(java.io.FileNotFoundException f) {
        System.out.println("FileNotFoundException");
    }*/

    public void method(java.io.IOException i) {
        System.out.println("IOException");
    }

    public void method(java.io.EOFException i) {
        System.out.println("EOFException");
    }

    /*public void method(java.io.EOFException ...i) {
        System.out.println("EOFException object");
    }*/

    public static void main(String args[]) {
        Test6 test = new Test6();
        test.method(null);
    }

}
