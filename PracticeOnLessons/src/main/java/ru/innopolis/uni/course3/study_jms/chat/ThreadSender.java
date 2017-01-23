package ru.innopolis.uni.course3.study_jms.chat;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Поток для запуска отправки сообщений.
 */
public class ThreadSender extends Thread {

    Thread threadReceive;

    public ThreadSender(Thread threadReceive) {
        this.threadReceive = threadReceive;
    }

    @Override
    public void run() {
        //получаем имя очереди к которой необходимо подключитсья
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String message = "";
        try {
            while (true) {
                message = reader.readLine();
                if (!message.equalsIgnoreCase("exit")){
                    if (CommonSettings.Connected() && !message.equals("")){
                        CommonSettings.destination=CommonSettings.getDestinationQueue();
                        //destination=getDestinationTopic();
                        if (CommonSettings.destination!=null){
                            try {
                                MessageProducer producer = CommonSettings.session.createProducer(CommonSettings.destination);
                                producer.setDeliveryMode(DeliveryMode.PERSISTENT);//парметром PERSISTENT указываем что сообщение
                                //будет хранится до тех пор пока не будет доставлено адресату.
                                //Создаем текстовое сообщение.
                                TextMessage messageForDelivery =CommonSettings.session.createTextMessage(message);
                                producer.send(messageForDelivery);
                            } catch (JMSException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }else {
                    threadReceive.interrupt();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
