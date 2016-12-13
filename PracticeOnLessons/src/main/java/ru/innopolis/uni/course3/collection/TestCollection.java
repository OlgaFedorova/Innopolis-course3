package ru.innopolis.uni.course3.collection;

import java.util.*;

/**
 * Created by Olga on 11.12.2016.
 */
public class TestCollection {

    public static void main(String[] args) {
        try {
            ArrayList<Integer> ar = new ArrayList<Integer>();
            //List temp = ar; //1
            List temp = Collections.checkedList(ar, Integer.class);
            temp.add(new java.util.Date()); //2
            temp.add(new Float(1.66));
            Iterator it = ar.iterator();
            while (it.hasNext())
                System.out.println(it.next());
            System.out.println(ar.get(0));
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }

}
