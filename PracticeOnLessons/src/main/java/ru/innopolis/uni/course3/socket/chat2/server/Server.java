package ru.innopolis.uni.course3.socket.chat2.server;

import ru.innopolis.uni.course3.socket.chat2.ThreadServerToClient;
import ru.innopolis.uni.course3.socket.chat2.common.ThreadReadInputData;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Olga on 21.12.2016.
 */
public class Server {

    public void start() {

        List<Writer> writerList = new CopyOnWriteArrayList<>();

        try (ServerSocket serverSocket = new ServerSocket(3456);) {

            //Запускаю поток, который передает информацию клиентам
            Thread threadWriter = new ThreadServerToClient(Thread.currentThread(), writerList);


            while (!Thread.currentThread().isInterrupted()){

                try(Socket socket = serverSocket.accept();
                    Writer writer = new PrintWriter(socket.getOutputStream());) {
                    writerList.add(writer);

                    //Запускаем поток, который читает информацию от клиента
                    new ThreadReadInputData(socket).start();

                }


            }
/*
                BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));



                //Печатаю информацию и отправляю клиентам
                while (!Thread.currentThread().isInterrupted()) {
                    String string = readerConsole.readLine();
                    if ("exit".equalsIgnoreCase(string)) {
                        Thread.currentThread().interrupt();
                    }
                    writer.write(String.format("Server: %s\n", string));
                    writer.flush();
                }
*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        }

    public static void main(String[] args) {
        new Server().start();
    }
}
