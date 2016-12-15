package ru.innopolis.uni.course3.exceptions;

import java.io.IOException;

/**
 * Created by Olga on 07.12.2016.
 */
public class MyResource implements AutoCloseable {

    @Override
    public void close() throws IOException {
        System.out.println("close");
        throw new IOException();
    }
}
