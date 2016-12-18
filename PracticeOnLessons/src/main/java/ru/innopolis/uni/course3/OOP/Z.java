package ru.innopolis.uni.course3.OOP;

/**
 * Created by Olga on 16.12.2016.
 */
public class Z {
    public void print( Object o ) {
        System.out.println( "Object" );
    }

    public void print( String str ) {
        System.out.println( "String" );
    }

    public void print( Integer i ) {
        System.out.println( "Integer" );
    }

    public static void main(String[] args) {
        Z z = new Z();
        Object o = null;
        z.print(o);
    }
}
