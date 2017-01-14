package ru.innopolis.uni.course3.quizfultest;

/**
 * Created by Olga on 12.01.2017.
 */
public class Main {

    private static class A1 {
        private String test() {
            return "A1";
        }
    }

    public static class A2 extends A1 {
        public String test() {
            return "A2";
        }
    }

    public static class A3 extends A2 {
        public String test() {
            return "A3";
        }
    }

    public static void main(String ... arg) {
        /**
         * Private-методы не наследуются, их нельзя перекрыть (override) в классах-потомках,
         * для них не используется механизм позднего связывания.
         * Поэтому всегда будет вызываться метод test() из класса A1 — исходя из типа переменной-ссылки,
         * а не фактического типа объекта.
         */
        A1 a1 = new A1();
        System.out.println(a1.test());
        a1 = new A2();
        System.out.println(a1.test());
        a1 = new A3();
        System.out.println(a1.test());
    }
}
