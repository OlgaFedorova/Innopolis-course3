package ru.innopolis.uni.course3.quizfultest;

/**
 * Created by Olga on 16.01.2017.
 */
public class Name {

    public static void main(String[] args) {
        int _cb;
        int _1c$ac;
        int if_;
        //int 1ab;
        int $ac;
        int abc;
    }

    /*
    class A { A(int i) {} }  // 1
    class B extends A {}   // 2
    */

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
}
