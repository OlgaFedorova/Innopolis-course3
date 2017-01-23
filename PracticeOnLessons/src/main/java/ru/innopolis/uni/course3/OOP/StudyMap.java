package ru.innopolis.uni.course3.OOP;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Olga on 20.01.2017.
 */
public class StudyMap {

    enum Types { A, B, C }
    static Integer value;
    enum Wrong { A }

    public static void main(String[] args) {
        Map<Types, Integer> m = new EnumMap<Types, Integer>(Types.class);
        m.put(Types.A, value);
        //m.put(Wrong.A, value);
        System.out.println(m);

        /*Map<Types, Integer> m2 = new HashMap<>();
        m2.put(Types.A, value);
        m2.put(Wrong.A, value);
        System.out.println(m2);*/

        ArrayList<Integer> array = new ArrayList<Integer>(2);
        array.add(5);
        array.add(6);
        array.add(1, 7);
        System.out.print(array.indexOf(6));

        array.remove(1);
        System.out.println(array.indexOf(6));
    }
}
