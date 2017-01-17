package ru.innopolis.uni.course3.OOP;

/**
 * Created by Olga on 17.01.2017.
 */
class TestPrivateClass {

    public static void test1(){

    }

    public void test1(int i){
    }

    //public int test1(int i)
    public int test1(int i, int i2){
        return 1;
    }

    public static void main(String[] args) {
        //assert false;
        new StringBuilder().append("");
        StringBuilder s1 = new StringBuilder("1");
        StringBuilder s2 = new StringBuilder("1");
        System.out.println(s1.equals(s2));

        class MyLocalClass{};
        MyLocalClass myLocalClass = new MyLocalClass();

        int i = 1;

        boolean b = false;
        if (b == false)
            if (b = false)
                System.out.println("if statement");
            else
                System.out.println("else statement");


    }

    private static class A{
        static void method1(){

        }

    }

}
