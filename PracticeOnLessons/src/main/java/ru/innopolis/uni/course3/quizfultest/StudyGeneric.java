package ru.innopolis.uni.course3.quizfultest;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Olga on 21.01.2017.
 */
public class StudyGeneric {

    static class Generic<T extends Number> {
        //private T arr[] = {1, 2, 3, 4, 5};
        private T arr[];

        public String toString(){
            return Arrays.toString(arr);
        }
    }

    static class Alien {
        String invade(short ships) { return "a few"; }
        String invade(short... ships) { return "many"; }
    }

    static class Base {
        public String name = "Base";
        public String getName() {
            return name;
        }
    }

    static class Sub extends Base {
        public String name = "Sub";
        public String getName() {
            return name;
        }
    }

    public static void main(String [] args) {
        Generic<Double> obj = new Generic<Double>();
        System.out.println(obj);

        System.out.println(new Alien().invade((short) 7));


        boolean b = false;
        if (b == false)
            if (b = false)
                System.out.println("if statement");
        else
                System.out.println("else statement");


        Sub s = new Sub();
        Base c = s;
        System.out.println(c.name);

        String[] str = new String[] { "1", "2", "3" };

        List list = Arrays.asList(str);
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            Object object = (Object) iterator.next();
            iterator.remove();
        }
        System.out.println(list.size());
    }
}
