package ru.innopolis.uni.course3.OOP;

/**
 * Created by Olga on 14.12.2016.
 */
public class Program {

    static class Base {
        private String name = "Base";
        public String getName() {
            return name;
        }
    }

    static class Sub extends Base {
        private String name = "Sub";
        /*
        public StringTest getName() {
            return name;
        }*/
    }

    public static void main(String[] args) {
        Sub s = new Sub();
        Base b = s;
        System.out.println(b.getName());
    }
}
