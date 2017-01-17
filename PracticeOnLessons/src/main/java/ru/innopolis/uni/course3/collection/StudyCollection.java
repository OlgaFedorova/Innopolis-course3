package ru.innopolis.uni.course3.collection;

import java.util.*;

/**
 * Created by Olga on 15.01.2017.
 */
public class StudyCollection {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        System.out.println(map.put("1", "1"));
        System.out.println(map.put("1", "2"));
        for (Map.Entry<String, String> entry: map.entrySet()){
            System.out.println(entry.setValue("3"));
        }

        Map<String, String> hashmap = new HashMap<String, String>();

        System.out.println("HashMap");
        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(2, 2);
        map1.put(1,1);
        map1.put(0,0);

        for (Map.Entry<Integer, Integer> entry: map1.entrySet()){
            System.out.println(entry.getValue());
        }

        System.out.println("LinkedHashMap");
        Map<Integer, Integer> map2 = new LinkedHashMap<>();
        map2.put(2,2);
        map2.put(1,1);
        map2.put(0,0);

        for (Map.Entry<Integer, Integer> entry: map2.entrySet()){
            System.out.println(entry.getValue());
        }

        Map<Integer, Integer> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        LinkedList linkedList = new LinkedList();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add(1, "3");

        linkedList.remove(1);

        System.out.println(linkedList);

        MyClass myClass1 = new MyClass(1,1);
        MyClass myClass2 = new MyClass(2,2);

        HashMap<MyClass, Integer> map3 = new HashMap<>();
        map3.put(myClass1, 1);
        map3.put(myClass2, 2);

        System.out.println(map3.get(myClass1));

        myClass1.setY(10);

        System.out.println(map3.get(myClass1));

    }

    private static class MyClass{
        private int i;
        private int y;

        public MyClass(int i, int y) {
            this.i = i;
            this.y = y;
        }

        public void setI(int i) {
            this.i = i;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MyClass myClass = (MyClass) o;

            if (i != myClass.i) return false;
            return y == myClass.y;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + y;
            return result;
        }
    }
}
