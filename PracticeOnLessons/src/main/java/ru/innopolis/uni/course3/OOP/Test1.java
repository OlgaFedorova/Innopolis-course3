package ru.innopolis.uni.course3.OOP;

/**
 * Created by Olga on 22.01.2017.
 */
public class Test1 {

    public static void var(Integer x, int y) {
        System.out.println("Integer int");
    }

    public static void var(Object... x) {
        System.out.println("Object");
    }

    public static void var(int... x) {
        System.out.println("int... x");
    }

    public static void var(Integer... x) {
        System.out.println("Integer...");
    }

    public static void main(String[] args) {

        System.out.println(0./0);
        System.out.print(0./0 == 0./0);
        System.out.println(" ");
        System.out.println(1/0.);
        System.out.println(1/0. - 1/0.);
        System.out.println(1 + 1/0. - 1/0.);
        System.out.println(1 + 1/0. - 1/0. == 1);

        System.out.println("thread is "
                + Thread.currentThread().getName());

        /*byte i = 0;
        Integer i2 = 127;
        var(i, i2);*/

        doIt("");
    }

    public static void doIt(String String) { //1
        int i = 10;
        i : for (int k = 0 ; k< 10; k++) { //2
            System.out.println( String + i); //3
            if( k*k > 10) continue i; //4
        }
    }
}
