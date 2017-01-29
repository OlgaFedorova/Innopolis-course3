package ru.innopolis.uni.course3.exceptions;

import java.io.IOException;

/**
 * Created by Olga on 28.01.2017.
 */
public class TestExcp {

    static int f(){
        try{
            new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            throw e;
        }finally {
            return 1;
        }

    }

    public static void main(String[] args) {
        System.out.println(f());
    }
}
