package ru.innopolis.uni.course3.quizfultest;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Olga on 23.01.2017.
 */
public class Test1 {

    static class A {}
    static class B extends A {}
    static class C1 extends B {}
    static class C2 extends B {}
    static class B1 extends A {}
    static class B2 extends A {}

    /*
    class A1$ {
        class B {
        }
    }
    class A1 {
        class $B {
        }
    }
    */
    public static void main(String[] args) {
        int j = 'ъ';

        List<A> list1 = Arrays.asList(new B(), new B1(), new B2());
        System.out.println(list1);
        List<A> list2 = new ArrayList<>();
        Collections.addAll(list2, new C1(), new C2());
        System.out.println(list2);
        List<A> list3 = Arrays.asList(new C1(), new C2());
        System.out.println(list3);

        int x = Integer.MIN_VALUE;
        System.out.println(x);
        System.out.println(-x);

        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        Class c3 = new ArrayList<Number>().getClass();

        System.out.println(c1 == c2);
        System.out.println(c2 == c3);
        System.out.println(c1 == c3);

        List<?> list = new ArrayList<String>();
        //list.add("a");
        list.add(null);
        Test<?> testObject = new Test<Integer>();
        //testObject.test(1);
        testObject.test(null);
        new Test1().call();
    }

    static class Test<T> {
        void test(T t) {}
    }

    public void test3(){
        try{ }
        catch(Exception e){System.out.println("test3");}
    }

    String c;
    void m(Object o) { c = "Object"; }
    void m(Number n) { c = "Number"; }
    //void m(Float s) { c = "Float"; }
    void m(Integer s) { c = "Integer"; }
    void call() {
        m(null);
        System.out.println(c);
    }

}
