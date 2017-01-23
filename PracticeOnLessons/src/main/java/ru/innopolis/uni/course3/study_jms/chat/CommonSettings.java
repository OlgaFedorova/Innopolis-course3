package ru.innopolis.uni.course3.study_jms.chat;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

/**
 * Created by Olga on 23.01.2017.
 */
public class CommonSettings {

    private static ActiveMQConnectionFactory connectionFactory; //управляемый объект от ApacheMQ, cлужащий для создания объекта Connection.
    public static Connection connection; //сам Connection.
    public static Session session; //контекст для посылки и приема сообщений.
    public static Destination destination; //буфер отправки и получения сообщений.

    /**
     * Подключаемся к серверу.
     * @return
     */
    public static Boolean Connected(){
        try {
            if (CommonSettings.connection==null){
                CommonSettings.connectionFactory = CommonSettings.getConnectionFactory();
                CommonSettings.connection=CommonSettings.connectionFactory.createConnection(); //получаем экзмпляр класса подключения
                CommonSettings.connection.start(); //стартуем
                CommonSettings.session =CommonSettings.connection.createSession(false, Session.AUTO_ACKNOWLEDGE); //создаем объект сессию без транзакций
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
    public static Destination getDestinationQueue(){
        try {
            return CommonSettings.session.createQueue("queue");
        } catch (JMSException ex) {
            return null;
        }
    }
    /**
     * Подключаемся к модели подписчик/издатель.
     * @return
     */
    public static Destination getDestinationTopic(){
        try {
            return CommonSettings.session.createTopic("queue");
        } catch (JMSException ex) {
            return null;
        }
    }
}
