package ru.innopolis.uni.course3.quizfultest;

import java.util.Arrays;

/**
 * Created by Olga on 12.01.2017.
 */
public class MyArray {
    public static void main(String[] args) {
        int []a = {5,5};
        int b = 1;
        a[b] = b = 0;
        System.out.println(Arrays.toString(a));
    }
}
