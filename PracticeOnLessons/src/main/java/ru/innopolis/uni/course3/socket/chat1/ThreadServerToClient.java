package ru.innopolis.uni.course3.socket.chat1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.List;

/**
 * Created by Olga on 21.12.2016.
 */
public class ThreadServerToClient extends Thread {

    private List<Thread> threadReads;
    private List<Writer> writerList;
    private Thread main;

    public ThreadServerToClient(Thread main, List<Thread> threadReads, List<Writer> writerList) {
        this.threadReads = threadReads;
        this.writerList = writerList;
        this.main = main;

    }

    @Override
    public void run() {
        try {

            BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));

            //Печатаю информацию и отправляю клиентам
            while (!Thread.currentThread().isInterrupted()) {
                String string = readerConsole.readLine();
                if ("exit".equalsIgnoreCase(string)) {
                    Thread.currentThread().interrupt();
                    for (Thread threadRead: threadReads) {
                        threadRead.interrupt();
                    }
                    main.interrupt();
                }
                for (Writer writer : writerList) {
                    writer.write(String.format("server: %s\n", string));
                    writer.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            for (Writer writer : writerList) {
                try {
                    writer.close();
                } catch (IOException e) {
                    //e.printStackTrace();
                }
            }
        }
    }
}
