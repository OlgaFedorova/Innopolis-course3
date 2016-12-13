package ru.innopolis.uni.course3.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Olga on 10.12.2016.
 */
public class OverrideThrowsTest {
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception
    // 1
    {
        A a = new A();
        a.method();
        A ab = new B();
        ab.method();
        B b = new B();
        b.method();
    }
}

class A {
    public void method() throws IOException {}
}

class B extends A {
    public void method() throws FileNotFoundException {}
}
