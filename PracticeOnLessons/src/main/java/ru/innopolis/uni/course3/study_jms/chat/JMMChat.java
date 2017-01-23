package ru.innopolis.uni.course3.study_jms.chat;

import ru.innopolis.uni.course3.patterns.decorator.Coffee;

import javax.jms.JMSException;

/**
 * Created by Olga on 23.01.2017.
 */
public class JMMChat {

    public static void main(String[] args) {
        try {
            Thread threadRecieve = new ThreadReceiver();
            Thread threadSender = new ThreadSender(threadRecieve);
            threadSender.start();
            threadRecieve.start();
            threadRecieve.join();
            threadSender.join();
            System.out.println(threadRecieve.isAlive());
            System.out.println(threadSender.isAlive());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                CommonSettings.connection.close();
                CommonSettings.session.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

}
