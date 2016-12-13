package ru.innopolis.uni.course3.OOP;

/**
 * Created by Olga on 12.12.2016.
 */
public class TestFinal {

    private String name;

    TestFinal(String name) {
        this.name =  name;
    }

    public void test(final TestFinal test) {
        //test = new TestFinal("three");
    }

    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        TestFinal t1 = new TestFinal("one");
        TestFinal t2 = new TestFinal("two");
        t1.test(t2);
        System.out.println(t2);
    }
}
