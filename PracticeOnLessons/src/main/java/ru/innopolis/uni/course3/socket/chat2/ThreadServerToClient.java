package ru.innopolis.uni.course3.socket.chat2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.List;

/**
 * Created by Olga on 21.12.2016.
 */
public class ThreadServerToClient extends Thread {

    private final List<Writer> writerList;
    private final Thread main;

    public ThreadServerToClient(Thread main, List<Writer> writerList) {
        this.main = main;
        this.writerList = writerList;
    }

    @Override
    public void run() {
        try (BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));) {

            while (!Thread.currentThread().isInterrupted()) {
                String string = readerConsole.readLine();
                if ("exit".equalsIgnoreCase(string)) {
                    Thread.currentThread().interrupt();
                    main.interrupt();
                    for (Writer writer : this.writerList) {
                        writer.write(String.format("Server: %s\n", string));
                        writer.write(string);
                        writer.flush();
                    }
                } else {
                    for (Writer writer : this.writerList) {
                        writer.write(String.format("Server: %s\n", string));
                        writer.flush();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
