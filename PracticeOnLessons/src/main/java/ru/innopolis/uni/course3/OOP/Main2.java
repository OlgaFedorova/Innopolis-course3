package ru.innopolis.uni.course3.OOP;

import java.util.*;

/**
 * Created by Olga on 22.01.2017.
 */
public class Main2 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        NavigableSet<String> set = new TreeSet<>(list);

        Iterator<String> iter = set.descendingIterator();
        StringBuilder sb = new StringBuilder("Set: ");
        while (iter.hasNext()) {
            String m = iter.next();
            sb.append(m + " ");
        }
        System.out.println(sb);
        System.out.println("Less c: " + set.lower("c"));
        System.out.println("Greater c: " + set.higher("c"));

    }
}
