package ru.innopolis.uni.course3.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Olga on 06.12.2016.
 */
public class Main {

    public static void main(String[] args) {

        Map map = new HashMap();
        Human human1 = new Human("Ivan", 12);
        Car car1 = new Car("Vesta", 2016);

        map.put(human1, car1);

        System.out.println("dsfasfafa");

    }

}
