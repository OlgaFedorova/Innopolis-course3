package ru.innopolis.uni.course3.testing;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by Olga on 15.12.2016.
 */
public class HelloWordTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWordTest.class);

    private HelloWord helloWord = new HelloWord();




    @Test(expected = IOException.class)
    public void doSum() throws Exception {
        helloWord.doSum();


    }

    @Test
    public void testSum() {
        final int expect = 7;
        final int actual = helloWord.sum(3, 4);

        assertTrue(expect == actual);

    }

}