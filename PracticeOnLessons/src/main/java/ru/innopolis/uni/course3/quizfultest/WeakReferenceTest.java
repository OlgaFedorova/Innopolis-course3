package ru.innopolis.uni.course3.quizfultest;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by Olga on 12.01.2017.
 */
public class WeakReferenceTest {

    public static void main(String[] args) {
        Map map = new WeakHashMap();
        Object obj = new Object(); // создаём объект
        map.put(obj, "object"); // кладём его в мапу
        System.out.println(map.size()); // в мапе один элемент
        obj = null; // чистим ссылку
        System.gc(); // играемся со сборщиком мусора
        System.runFinalization();
        System.out.println(map.size()); // мапа должна стать пустой
    }
}
