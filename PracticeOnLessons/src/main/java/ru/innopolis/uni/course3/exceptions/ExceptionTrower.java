package ru.innopolis.uni.course3.exceptions;

import java.io.IOException;

/**
 * Created by Olga on 07.12.2016.
 */
public class ExceptionTrower extends Parent {

    public void doSome() throws IOException{
        throw new IOException();
    }
}
