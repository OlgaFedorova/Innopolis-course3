package ru.innopolis.uni.course3.study_jms.chat;

import javax.jms.*;

/**
 * Поток для получения сообщений
 */
public class ThreadReceiver extends Thread {

    @Override
    public void run() {
        while (!this.isInterrupted()){
            if (CommonSettings.Connected()){
                CommonSettings.destination=CommonSettings.getDestinationQueue();
                //destination=getDestinationTopic();
                if (CommonSettings.destination!=null){
                    try {
                        MessageConsumer consumer=CommonSettings.session.createConsumer(CommonSettings.destination);
                        consumer.setMessageListener(new MessageListener() {

                            @Override
                            public void onMessage(Message msg) {
                                TextMessage textmessage=(TextMessage)msg;
                                try {
                                    System.out.println("recieve: " + textmessage.getText());
                                } catch (JMSException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        });
                    } catch (JMSException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
