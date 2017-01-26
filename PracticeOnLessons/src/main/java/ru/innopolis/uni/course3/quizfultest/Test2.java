package ru.innopolis.uni.course3.quizfultest;

/**
 * Created by Olga on 24.01.2017.
 */
public class Test2 {

    static class A extends B {
        static Integer q = 2;
        static {
            System.out.print("A");
            A.q = 4;
        }
    }

    static class B {
        static {
            System.out.print("B");
            A.q++;
        }
    }

    public static void main(String[] args) {
        System.out.println(A.q);
    }

}
