package ru.innopolis.uni.course3.generic;

import java.util.*;

/**
 * Created by Olga on 24.12.2016.
 */
public class TestGeneric {

    public static void main(String[] args) {

        List list = new LinkedList();
        list.add("First");
        list.add("Second");
        list.add(10);
        List<String> list2 = list;
        for(Iterator<String> itemItr = list2.iterator(); itemItr.hasNext();)
            System.out.println(itemItr.next());

        /*
        List<String> list = new LinkedList<String>();
        list.add("First");
        //list.add("Second");
        //list.add(10);
        List list2 = list;
        for(Iterator<String> itemItr = list2.iterator(); itemItr.hasNext();)
            System.out.println(itemItr.next());
            */

        List<?> intList = new ArrayList<Integer>();
        //intList.add(new Integer(10)); ошибка компиляции

        List<? extends A> numList = new ArrayList<A>();
        //numList.add(new A());

        List<? super A> numList1 = new ArrayList<Object>();
        numList1.add(new A());
        numList1.add(new B());
        //numList1.add(new Object()); ошибка компиляции
    }

    public static Double sum(List<? extends Number> numList) {
        Double result = 0.0;
        for (Number num : numList) {
            result += num.doubleValue();
        }
        return result;
    }

    static class A{}
    static class B extends A{}
    static class C extends B{}

    static void printList(List<?> list) {
        for (Object l : list)
            System.out.println("{" + l + "}");
    }

    public static <T> T foo() {
        try {
            return (T) new Integer(42);
        } catch (ClassCastException e) {
            return (T) "habr";
        }
    }
}
