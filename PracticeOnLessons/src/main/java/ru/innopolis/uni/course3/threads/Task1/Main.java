package ru.innopolis.uni.course3.threads.Task1;

/**
 * Created by Olga on 08.12.2016.
 */
public class Main {

    public static void main(String[] args) {

        Time timeObject = new Time();
        Thread threadTimer = new ThreadTimer(timeObject);
        threadTimer.start();
        Thread threadMessage5 = new ThreadMessage(timeObject, 5);
        threadMessage5.start();
        Thread threadMessage7 = new ThreadMessage(timeObject, 7);
        threadMessage7.start();

        try {
            Thread.sleep(40_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadTimer.interrupt();
        threadMessage5.interrupt();
        threadMessage7.interrupt();
    }

}
