package ru.innopolis.uni.course3.profilers;

import java.util.*;

/**
 * Created by Olga on 10.01.2017.
 */
public class Main {

    static List<Object> cache = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Waiting for start");
        scanner.next();
        System.out.println("Waiting for command...");
        switch (scanner.next()){
            case "collectable":
                System.out.println("Creating collectable...");
                createBigObject();
                System.out.println("Collectable created");
                break;
            case "leakable":
                System.out.println("Creating leakable...");
                cache.add(createBigObject());
                System.out.println("Leakable created");
                break;
            default:
                break;
        }
    }

    public static Object createBigObject(){
        List<String> stringList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 1_000_000_000; i++){
            stringList.add(random.nextInt() + " | " + i);
        }
        return stringList;
    }
}
