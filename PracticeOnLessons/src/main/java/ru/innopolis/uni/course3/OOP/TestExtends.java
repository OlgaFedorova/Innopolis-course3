package ru.innopolis.uni.course3.OOP;

/**
 * Created by Olga on 10.12.2016.
 */
public class TestExtends {

    abstract class A{
        public abstract void print();
    }
    class B extends A{
        public void print(){
            System.out.println("B");
        }
    }

    abstract class C extends B{
        public abstract void print();
    }

    class D extends C{

        public void print() {
            System.out.println("D");
        }
    }

    public static void main(String[] args) {
        new TestExtends().new D().print();
    }
}
