package ru.innopolis.uni.course3.generator;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Olga on 27.12.2016.
 */
public class Generator {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        while (set.size() < 5){
            set.add((int) ((Math.random() * 5) + 1));
        }
        System.out.println(set);

        int i = 0;
        while ((i = (int)(Math.random() * 6) )!= 5){
            //set.add((int) ((Math.random() * 5) + 1));
        }
        System.out.println(i);
    }
}
