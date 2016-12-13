package ru.innopolis.uni.course3.threads;

/**
 * Created by Olga on 08.12.2016.
 */
public class TestInterrupt {

    static class Clock implements Runnable
    {
        public void run()
        {
            Thread current = Thread.currentThread();

            while (!current.isInterrupted())
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(current.isInterrupted());
                    e.printStackTrace();
                    break;
                }
                System.out.println("Tik");
            }
            //System.out.println(current.isInterrupted());
        }
    }

    public static void main(String[] args)
    {
        Clock clock = new Clock();
        Thread clockThread = new Thread(clock);
        clockThread.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clockThread.interrupt();
    }




}
