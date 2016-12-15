package ru.innopolis.uni.course3.testing;

import java.io.IOException;

/**
 * Created by Olga on 15.12.2016.
 */
public class HelloWord {

    public void doSum() throws IOException{
        throw  new IOException();
    }

    public int sum(int a1, int b1){
        return a1+b1;
    }

}
