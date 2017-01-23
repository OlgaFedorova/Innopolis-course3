package ru.innopolis.uni.course3.study_jms.chat;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Olga on 23.01.2017.
 */
public class JMMChat {

    private static ActiveMQConnectionFactory connectionFactory; //управляемый объект от ApacheMQ, cлужащий для создания объекта Connection.
    private static Connection connection; //сам Connection.
    private static Session session; //контекст для посылки и приема сообщений.
    private static Destination destination; //буфер отправки и получения сообщений.

    public static void main(String[] args) {
        Thread threadSender = new Thread(new SendMessage());
        Thread threadRecieve = new Thread(new ReceiveMessage());
        threadRecieve.setDaemon(true);
        threadSender.start();
        threadRecieve.start();
    }

    /**
     * Подключаемся к серверу.
     * @return
     */
    public static Boolean Connected(){
        try {
            if (JMMChat.connection==null){
                JMMChat.connectionFactory = JMMChat.getConnectionFactory();
                JMMChat.connection=JMMChat.connectionFactory.createConnection(); //получаем экзмпляр класса подключения
                JMMChat.connection.start(); //стартуем
                JMMChat.session =JMMChat.connection.createSession(false, Session.AUTO_ACKNOWLEDGE); //создаем объект сессию без транзакций
                //параметром AUTO_ACKNOWLEDGE мы указали что отчет о доставке будет
                //отправляться автоматически при получении сообщения.
            }else{
                connection.start();
            }
            return true;
        } catch (JMSException ex) {
            return false;
        }
    }
    /**
     * Создаем ConnectionFactory ApacheMQ сервера. Вбиваем дефолтные логин и пароль.
     * @return
     */
    private static ActiveMQConnectionFactory getConnectionFactory(){
        return new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "failover://tcp://localhost:61616");
    }

    /**
     * Подключаемся к модели точка-точка.
     * @return
     */
    private static Destination getDestinationQueue(){
        try {
            return JMMChat.session.createQueue("queue");
        } catch (JMSException ex) {
            return null;
        }
    }
    /**
     * Подключаемся к модели подписчик/издатель.
     * @return
     */
    private static Destination getDestinationTopic(){
        try {
            return JMMChat.session.createTopic("queue");
        } catch (JMSException ex) {
            return null;
        }
    }

    /**
     * Поток для запуска отправки сообщений.
     */
    public static class SendMessage implements Runnable{

        @Override
        public void run() {
            //получаем имя очереди к которой необходимо подключитсья
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String message = "";
            try {
                while (!(message = reader.readLine()).equalsIgnoreCase("exit")) {
                    if (Connected() && !message.equals("")){
                        destination=getDestinationQueue();
                        //destination=getDestinationTopic();
                        if (destination!=null){
                            try {
                                MessageProducer producer = JMMChat.session.createProducer(destination);
                                producer.setDeliveryMode(DeliveryMode.PERSISTENT);//парметром PERSISTENT указываем что сообщение
                                //будет хранится до тех пор пока не будет доставлено адресату.
                                //Создаем текстовое сообщение.
                                TextMessage messageForDelivery =JMMChat.session.createTextMessage(message);
                                producer.send(messageForDelivery);
                            } catch (JMSException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Поток для получения сообщений
     */
    public static class ReceiveMessage implements Runnable{

        @Override
        public void run() {
            while (true){
                if (Connected()){
                    destination=getDestinationQueue();
                    //destination=getDestinationTopic();
                    if (destination!=null){
                        try {
                            MessageConsumer consumer=session.createConsumer(destination);
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

}
