package ru.innopolis.uni.course3.OOP;

/**
 * Created by Olga on 19.12.2016.
 */
public class Test {
    final String s;

    public Test() {
        s = "default";
    }

    public Test(String s) {
        this.s = s;
    }

    public static void main(String[] args) {
        System.out.println(new Test().s);
    }

    private class A{
        public void test(int i, double d){}

        private boolean b;

        public A(boolean b) {
            this.b = b;
        }
    }

    private class B extends A{
        private int i;

        public B(int i) {
            super(false);
            this.i = i;
        }
    }
}
