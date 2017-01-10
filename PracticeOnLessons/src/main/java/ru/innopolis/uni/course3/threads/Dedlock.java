package ru.innopolis.uni.course3.threads;

import java.util.Scanner;

/**
 * Created by Olga on 08.12.2016.
 */
public class Dedlock{

    private Object lock1 = new Object();
    private Object lock2 = new Object();


    public void methodA(){
        synchronized (lock1){
            System.out.println("lock1 get");
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.methodB();
        }
        System.out.println("lock1 push");
    }

    public void methodB(){
        synchronized (lock2){
            System.out.println("lock2 get");
            try {
                Thread.currentThread().sleep(1002);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.methodA();
        }
        System.out.println("lock2 push");
    }

    public static void main(String[] args) {

        System.out.println("Start");
        Scanner scanner = new Scanner(System.in);
        scanner.next();

        Dedlock dedlock = new Dedlock();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                dedlock.methodA();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                dedlock.methodB();
            }
        });

        thread1.start();
        thread2.start();

        System.out.println("End");
    }

}
