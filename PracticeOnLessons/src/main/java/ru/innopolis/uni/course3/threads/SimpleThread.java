package ru.innopolis.uni.course3.threads;

/**
 * Created by Olga on 08.12.2016.
 */
public class SimpleThread extends Thread {

    @Override
    public void run() {
        while (!this.isInterrupted()){
            System.out.println("Thread1");
        }
    }
}
