package ru.innopolis.uni.course3.OOP;

/**
 * Created by Olga on 16.12.2016.
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new TestThread());
        System.out.println("Hello, it's a main thread");
        thread.start();
        thread.join();
        System.out.println("Good bye");
    }


    static class TestThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello, it's a simple thread");
    }

    public void join() {
        System.out.println("Hello, it's a method join()");
    }
}
}
