package ru.innopolis.uni.course3.ofedorova.handlers;

import org.junit.Before;
import org.junit.Test;
import ru.innopolis.uni.course3.ofedorova.StorageForSumOfPositiveEvenNumbers;

import java.io.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by Olga on 11.12.2016.
 */
public class HandlerForSumOfPositiveEvenNumbersTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void beforeTesting() throws FileNotFoundException {
        System.setOut(new PrintStream(out));
    }

    @Test
    public void whenHandleUncorrectResourse() throws IOException {
        final StorageForSumOfPositiveEvenNumbers storage = new StorageForSumOfPositiveEvenNumbers();
        try(InputStream resource = new FileInputStream(String.format("%s/temp/Resource2", System.getProperties().get("user.dir")));) {
            final HandlerOfResource handler = new HandlerForSumOfPositiveEvenNumbers(storage, resource);
            handler.handleResource();
            final int actualSum = storage.getSumma();
            final int expectedSum = 0;
            assertTrue(actualSum == expectedSum);
        }
    }

    @Test
    public void whenHandleCorrectResourse() throws IOException {
        final StorageForSumOfPositiveEvenNumbers storage = new StorageForSumOfPositiveEvenNumbers();
        try(InputStream resource = new FileInputStream(String.format("%s/temp/Resource1", System.getProperties().get("user.dir")));) {
            final HandlerOfResource handler = new HandlerForSumOfPositiveEvenNumbers(storage, resource);
            handler.handleResource();
            final int actualSum = storage.getSumma();
            final String actualOut = this.out.toString();
            final int expectedSum = 1642;
            final String expectOut = String.format("66%1$s100%1$s976%1$s1030%1$s1486%1$s1542%1$s1554%1$s1638%1$s%2$d%1$s", System.getProperty("line.separator"), expectedSum);

            assertTrue(actualSum == expectedSum && expectOut.equals(actualOut));
        }
    }

}