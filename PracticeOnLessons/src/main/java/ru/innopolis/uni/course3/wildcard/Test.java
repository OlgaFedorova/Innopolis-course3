package ru.innopolis.uni.course3.wildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olga on 25.01.2017.
 */
public class Test {

    public static void main(String[] args) {
        List<Number> list = new ArrayList<>();
        list.add(1);

        //производитель (producer), нужно использовать ? extends T
        List<? extends Number> list1 = new ArrayList<>();
        //list1.add(new Integer(1));
        //list1.add(new Object());


        //потребитель (consumer), нужно использовать ? super T.
        List<? super Number> list2 = new ArrayList<>();
        //list2.add(new Object());
        list2.add(new Integer(1));
    }
}
