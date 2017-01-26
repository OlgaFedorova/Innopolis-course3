package ru.innopolis.uni.course3.clone;

/**
 * Created by Olga on 24.01.2017.
 */
public class MyClass {

        public static void main(String[] args) throws CloneNotSupportedException {
            B b = new B();
            A a = b.clone();
            System.out.println(a.clone().i);
        }

}
