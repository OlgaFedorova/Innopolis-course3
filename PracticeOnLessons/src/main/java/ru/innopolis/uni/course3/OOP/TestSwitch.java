package ru.innopolis.uni.course3.OOP;

import java.io.IOException;

/**
 * Created by Olga on 10.12.2016.
 */
public class TestSwitch {

    public static void main(String[] args) {
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

        /*ry {
            System.out.println("Inside try-block");
        }
        catch(IOException e) { }*/

        try {
            System.out.println("Inside try-block");
        } catch(Exception e) {}
    }
}
