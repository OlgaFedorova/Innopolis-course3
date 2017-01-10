package ru.innopolis.uni.course3.profilers;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Olga on 10.01.2017.
 */
public class ThreadMain {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Waiting for start");
        scanner.next();
        System.out.println("Waiting for command...");
        for (int i = 0; i < 1_000; i++){
            final int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(j + " start");
                    Random random = new Random();
                    try {
                        Thread.sleep(10_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(j + " end");
                }
            }).start();
        }
    }
}
