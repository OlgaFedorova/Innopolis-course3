package ru.innopolis.uni.course3.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Olga on 21.12.2016.
 */
public class Client {

    private volatile boolean isExit = false;

    public void start(){
        try(Socket socket = new Socket("localhost", 3456);
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader readerForRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));){

            // Send data
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String outputMessage = "";
                    do {
                        try {
                            outputMessage = readerConsole.readLine();
                            outputStream.write(("Client: " + outputMessage).getBytes());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } while ("exit".equalsIgnoreCase(outputMessage));
                    Client.this.isExit = true;
                }
            }).start();

            //Read data
            String inputMessage = "";
            while (!this.isExit) {
                try {
                    inputMessage = readerForRead.readLine();
                    System.out.println(inputMessage);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Client().start();
    }
}
