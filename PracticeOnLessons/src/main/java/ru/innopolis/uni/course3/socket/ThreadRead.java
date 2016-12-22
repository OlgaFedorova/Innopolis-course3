package ru.innopolis.uni.course3.socket;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Olga on 21.12.2016.
 */
public class ThreadRead extends Thread {
    private BufferedReader reader;

    public ThreadRead(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        try {
            while (!this.isInterrupted()) {
                String line = null;
                line = this.reader.readLine();
                if(line == null) {
                    break;
                }
                System.out.println(line);
            }
        } catch (IOException e) {
            //e.printStackTrace();
        } finally {
            try {
                this.reader.close();
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
    }
}
