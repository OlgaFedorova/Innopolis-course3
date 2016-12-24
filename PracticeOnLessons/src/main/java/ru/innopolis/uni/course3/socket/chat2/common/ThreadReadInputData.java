package ru.innopolis.uni.course3.socket.chat2.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Olga on 21.12.2016.
 */
public class ThreadReadInputData extends Thread {

    private final Socket socket;

    public ThreadReadInputData(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
            String line = null;
            while (true) {
                line = reader.readLine();
                if ("exit".equalsIgnoreCase(line)) {
                    break;
                }
                System.out.println(line);
            }
        } catch (IOException e) {}
    }
}
