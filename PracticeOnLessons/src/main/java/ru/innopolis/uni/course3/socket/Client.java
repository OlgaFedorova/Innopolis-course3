package ru.innopolis.uni.course3.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by Olga on 21.12.2016.
 */
public class Client {
    private static volatile int port = 3456;
    private static volatile int count = 1;

    public void start() {
        int number = Client.count++;
        boolean isExit = false;
        try (Socket socket = new Socket("localhost", Client.port++);
             Writer writer = new PrintWriter(socket.getOutputStream());) {

            BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));

            //Запускаем поток, который читает информацию от сервера
            Thread threadRead = new ThreadRead(new BufferedReader(new InputStreamReader(socket.getInputStream())));
            threadRead.start();

            //Печатаю информацию и отправляю серверу
            while (!Thread.currentThread().isInterrupted()) {
                String string = readerConsole.readLine();
                if ("exit".equalsIgnoreCase(string)) {
                    Thread.currentThread().interrupt();
                    threadRead.interrupt();
                }
                writer.write(String.format("Client%s: %s\n", number, string));
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
