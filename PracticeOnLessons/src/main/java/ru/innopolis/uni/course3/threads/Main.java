package ru.innopolis.uni.course3.threads;

/**
 * Created by Olga on 08.12.2016.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Start");
        Thread thread = new SimpleThread();
        thread.start();
        // thread.run();


        while (true){
            System.out.println("Main");
            thread.interrupt();
        }
    }
}
