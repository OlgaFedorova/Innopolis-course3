package ru.innopolis.uni.course3.overriding;

/**
 * Created by Olga on 25.01.2017.
 */
public class Test
{
    public static class A{

        private int i;
        public int j = 3;

        public final int l = 3;
        public static final int y = 3;

        public A(int i) {
            this.i = i;
        }

        public int test(int k){
            return 0;
        }

        public A getInstance(){
            return this;
        }

        public final void testFinal(){}

        public static final void testStaticFinal(){}
    }

    public static class B extends A{
        public int j = 5;
        public final int l = 5;
        public static final int y = 3;

        public B(short i) {
            super(i);
        }

        @Override
        public int test(int k) {
            byte b = 2;
            return b;
        }

        @Override
        public B getInstance() {
            return this;
        }
    }


    public static void main(String[] args) {
        A a = new B((short) 1);
        System.out.println(((B)a).j);
    }


}
