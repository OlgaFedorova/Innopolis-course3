package ru.innopolis.uni.course3.OOP;

import java.util.Arrays;

/**
 * Created by Olga on 20.12.2016.
 */
public class GoodbyeWorld {

    static class A {
        static {
            i = 2;
        }
        static int i = 1;
    };

    static class B {
        static int i = 1;
        static {
            i = 2;
        }
    };

    public static void main(String[] args) {
        System.out.print(A.i);
        System.out.print(B.i);

        int []a = {5,5};
        int b = 1;
        a[b] = b = 0;
        System.out.println();
        System.out.println(Arrays.toString(a));

        byte c = 8;
        m(c);
        m((byte) 7);
    }

    static void m(byte b) {
        System.out.print("byte");
    }
}
