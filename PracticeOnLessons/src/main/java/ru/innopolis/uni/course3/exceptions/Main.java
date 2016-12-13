package ru.innopolis.uni.course3.exceptions;

import java.io.IOException;

/**
 * Created by Olga on 07.12.2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        try(MyResource myResource = new MyResource();
        MyResource myResource1 = null;) {
            System.out.println("try");
        } catch (IOException e) {
            System.out.println("catch");
            //e.printStackTrace();
            throw e;
        }finally {
            System.out.println("finally");
            throw new NullPointerException();
        }
        //System.out.println("end");
    }
}
