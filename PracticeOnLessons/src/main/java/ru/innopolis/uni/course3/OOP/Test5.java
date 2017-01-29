package ru.innopolis.uni.course3.OOP;


import java.util.Comparator;

/**
 * Created by Olga on 28.01.2017.
 */
public class Test5 implements Comparable, Comparator {

    public Test5() {
    }

    public static void main(String[] args){
        Object obj = new Object();
        System.out.println(obj);
        System.out.println(obj.hashCode());
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
