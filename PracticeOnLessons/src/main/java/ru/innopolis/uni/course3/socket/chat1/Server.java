package ru.innopolis.uni.course3.socket.chat1;

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

        List<Thread> threadReads = new CopyOnWriteArrayList<>();
        List<Writer> writerList = new CopyOnWriteArrayList<>();

        try (ServerSocket serverSocket = new ServerSocket(3456);
             Socket socket = serverSocket.accept();
             Writer writer = new PrintWriter(socket.getOutputStream());) {

                BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));

                //Запускаем поток, который читает информацию от клиента
                Thread threadRead = new ThreadRead(new BufferedReader(new InputStreamReader(socket.getInputStream())));
                threadRead.start();

                //Печатаю информацию и отправляю клиентам
                while (!Thread.currentThread().isInterrupted()) {
                    String string = readerConsole.readLine();
                    if ("exit".equalsIgnoreCase(string)) {
                        Thread.currentThread().interrupt();
                        threadRead.interrupt();
                    }
                    writer.write(String.format("server: %s\n", string));
                    writer.flush();
                }


            /*
            Thread serverToClient = new ThreadServerToClient(Thread.currentThread(), threadReads, writerList);
            serverToClient.start();

            //while (!Thread.currentThread().isInterrupted()){
                try (Socket socket = serverSocket.accept();) {
                    Writer writer = new PrintWriter(socket.getOutputStream());
                    writerList.add(writer);

                    //Запускаем поток, который читает информацию от клиента
                    Thread threadRead = new ThreadReadInputData(new BufferedReader(new InputStreamReader(socket.getInputStream())));
                    threadRead.start();
                    threadReads.add(threadRead);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            //}*/

        } catch (IOException e) {
            e.printStackTrace();
        }
        }

    public static void main(String[] args) {
        new Server().start();
    }
}
