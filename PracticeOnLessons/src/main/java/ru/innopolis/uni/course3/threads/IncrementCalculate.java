package ru.innopolis.uni.course3.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RunnableFuture;

/**
 * Created by Olga on 08.12.2016.
 */
public class IncrementCalculate {

    static int count;

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            final Object lock = new Object();
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0; j < 10_000_000; j++){
                        synchronized (lock){
                            IncrementCalculate.count++;
                        }
                    }
                }
            });
            threads.add(t);
        }

        for (Thread thread : threads){
            thread.start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(IncrementCalculate.count);

    }

}
