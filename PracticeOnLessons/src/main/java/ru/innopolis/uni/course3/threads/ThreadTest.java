package ru.innopolis.uni.course3.threads;

/**
 * Created by Olga on 08.12.2016.
 */
public class ThreadTest extends Thread {

    public ThreadTest(Runnable target) {
        super(target);
    }

    @Override
    public void run() {
        System.out.println("Thread");
    }


    public static void main(String[] args) {
        Thread thread = new ThreadTest(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable");
            }
        });
        thread.start();
    }

}
