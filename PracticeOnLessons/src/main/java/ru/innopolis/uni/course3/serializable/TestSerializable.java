package ru.innopolis.uni.course3.serializable;

import ru.innopolis.uni.course3.wildcard.Test;

import java.io.*;

/**
 * Created by Olga on 28.01.2017.
 */
public class TestSerializable implements Serializable {

    private A a;

    public TestSerializable(A a) throws IOException {
        this.a = a;
        File file = new File("D:\\1.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
    }

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\1.txt");
        TestSerializable testSerializable = new TestSerializable(new A());
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        outputStream.writeObject(testSerializable);
        outputStream.close();
        file.delete();

        //new Exception().
    }
}
