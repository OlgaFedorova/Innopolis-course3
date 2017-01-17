package ru.innopolis.uni.course3.quizfultest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Olga on 14.01.2017.
 */
public class TestSintaxys {

    public static void main(String[] args) throws IOException {
        //int goto;
        //int if;
        int then;
        //int else;

            ByteArrayOutputStream bOut = new ByteArrayOutputStream();
            ObjectOutputStream oOut = new ObjectOutputStream(bOut);
            Whole object = new Whole();
            oOut.writeObject(object);

        switch(10) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                break;
            //System.out.println("default");
        }
    }

    static class Whole implements Serializable {


        private void writeObject(ObjectOutputStream out) {
            System.out.println("Whole.writeObject()");
        }
    }
}
