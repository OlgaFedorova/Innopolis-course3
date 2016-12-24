package ru.innopolis.uni.course3.socket.chat2.clients;

import ru.innopolis.uni.course3.socket.chat2.common.ThreadReadInputData;

import java.io.*;
import java.net.Socket;

/**
 * Created by Olga on 21.12.2016.
 */
public class Client {
    private static volatile int port = 3456;
    private static volatile int count = 1;
    private static volatile int number = Client.count++;

    public void start() {
        try (Socket socket = new Socket("localhost", Client.port++);

             Writer writer = new PrintWriter(socket.getOutputStream());
             BufferedReader console = new BufferedReader(new InputStreamReader(System.in));) {

            //Запускаем поток, который читает информацию от сервера
            new ThreadReadInputData(socket).start();

            //Печатаю информацию и отправляю серверу
            while (!Thread.currentThread().isInterrupted()) {
                String string = console.readLine();
                if ("exit".equalsIgnoreCase(string)) {
                    Thread.currentThread().interrupt();
                    writer.write(String.format("Client%s: %s\n", this.number, string));
                    writer.write(string);
                }else{
                    writer.write(String.format("Client%s: %s\n", this.number, string));
                }
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Client().start();
    }
}
