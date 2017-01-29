package ru.innopolis.uni.course3.collection;

import java.util.*;

/**
 * Created by Olga on 29.01.2017.
 */
public class StudyCollection1 {

    private class MyComparable implements Comparable{

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }

    private class MyComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            return 0;
        }
    }

    public static void studyQueue(){
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println("queue: " + queue);
        System.out.println("queue.peek(): " + queue.peek()); //возвращает элелемент первый в очереди
        System.out.println("queue: " + queue);
        System.out.println("queue.element(): " + queue.element()); //возвращает элелемент первый в очереди
        System.out.println("queue: " + queue);
        System.out.println("queue.poll(): " + queue.poll()); //возвращает элелемент первый в очереди и удаляет иго из нее
        System.out.println("queue: " + queue);
        System.out.println("queue.remove(): " + queue.remove()); //возвращает элелемент первый в очереди и удаляет иго из нее
        System.out.println("queue: " + queue);
        System.out.println("");
    }

    public static void studyDequeue(){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);
        deque.add(6);
        deque.add(7);
        System.out.println("deque: " + deque);
        System.out.println("deque.element(): " + deque.element()); //возвращает первый элеменгт в очереди
        System.out.println("deque: " + deque);
        System.out.println("deque.peek(): " + deque.peek());
        System.out.println("deque: " + deque);//возвращает первый элемент в очереди
        System.out.println("deque.poll(): " + deque.poll());//возвращает первый элемент в очереди и удалил его
        System.out.println("deque: " + deque);
        System.out.println("deque.pop(): " + deque.pop());//возвращает первый элементв очереди и удаляет его
        System.out.println("deque: " + deque);
        System.out.println("deque.peekLast(): " + deque.peekLast()); //возвращает последний элемент в очереди
        System.out.println("deque: " + deque);
        System.out.println("deque.pollLast(): " + deque.pollLast());//возвращает последний элемент и удаляет его
        System.out.println("deque: " + deque);
        System.out.println("");
    }

    public static void studyStack(){
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        stack.add(6);
        stack.add(7);
        System.out.println("stack: " + stack);
        System.out.println("stack.peek(): " + stack.peek());//возвращает последний элемент, добавленный в стек
        System.out.println("stack: " + stack);
        System.out.println("stack.pop(): " + stack.pop());//возвращает последний элемент, добавленный в стек и удаляет его из стека
        System.out.println("stack: " + stack);
        System.out.println("stack.push(): " + stack.push(8));//добавляет элемент в стек
        System.out.println("stack: " + stack);
        System.out.println("");
    }

    public static void studyHashMap(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        int h;
        System.out.println("key = 1");
        System.out.println(h = "1".hashCode());
        System.out.println(h >>> 16);
        System.out.println((h = "1".hashCode()) ^ (h >>> 16));
        System.out.println((16 - 1) & (h = "1".hashCode()) ^ (h >>> 16));
        System.out.println("key = 2");
        System.out.println(h = "2".hashCode());
        System.out.println(h >>> 16);
        System.out.println((h = "2".hashCode()) ^ (h >>> 16));
        System.out.println((16 - 1) & (h = "2".hashCode()) ^ (h >>> 16));

        //HashMap<Integer, Integer> map1 = new HashMap<>(15, 0.4f);

        LinkedHashMap<Integer, Integer> map1 = new LinkedHashMap<>();

    }

    public static void main(String[] args) {
        studyQueue();
        studyDequeue();
        studyStack();
        studyHashMap();

    }
}
