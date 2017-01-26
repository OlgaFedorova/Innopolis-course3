package ru.innopolis.uni.course3.quizfultest;

/**
 * Created by Olga on 24.01.2017.
 */
public class Test4 {

    static class Copier<T extends A> {
        public T copy(T param) throws CloneNotSupportedException {
            return  (T) param.clone();                            //1
        }
    }

    static class A  implements Cloneable{
        public int i=10;
        @Override
        public A clone() throws CloneNotSupportedException {
            return (A) super.clone();                             //2
        }
    }

    static class B extends A{
        public int i=20;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        B b = new B();
        Copier<B> copier = new Copier<>();                //3
        A a = copier.copy(b);                                //4
        System.out.println(a.i);
    }
}
