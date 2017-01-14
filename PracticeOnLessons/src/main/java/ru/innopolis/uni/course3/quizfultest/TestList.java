package ru.innopolis.uni.course3.quizfultest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olga on 12.01.2017.
 */
public class TestList {

    public static void main(String[] args) {
        List a = new ArrayList<Double>();// 4
        a.add("1.5");// 5
        List<Double> b = new ArrayList();// 6
        //b.add("1.5");// 7 error compile
        System.out.println(a + " " + b);
    }
}
