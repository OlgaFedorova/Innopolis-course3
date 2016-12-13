package ru.innopolis.uni.course3.OOP;

/**
 * Created by Olga on 12.12.2016.
 */
public class InnerClassDemo {

    class Outer {
        int outer_x = 100;
        void test() {
            for(int i = 0; i < 5; i ++) {
                class Inner{
                    void display() {
                        System.out.print("outer_x = " + outer_x + "; ");
                    }
                }
                Inner inner = new Inner();
                inner.display();
            }
        }
    }

    public static void main(String args[]) {
        Outer outer = new InnerClassDemo().new Outer();
        outer.test();

        System.out.println("");

        int[] array1 = {1, 2};
        for (long x : array1) {
            System.out.println(x);
        }
    }

}
