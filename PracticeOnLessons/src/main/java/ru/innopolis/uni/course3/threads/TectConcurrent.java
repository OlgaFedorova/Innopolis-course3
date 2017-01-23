package ru.innopolis.uni.course3.threads;

import java.util.concurrent.*;

/**
 * Created by Olga on 21.01.2017.
 */
public class TectConcurrent {

    public static void main(String[] args) {
        ExecutorService service = new ScheduledThreadPoolExecutor(5);
        Future<Integer> future = service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return null;
            }
        });

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.yield();
            }
        });
        thread.start();

        //Thread.State.

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {

            }
        });





    }
}
