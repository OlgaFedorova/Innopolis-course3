package ru.innopolis.uni.course3.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Olga on 14.12.2016.
 */
public class HelloWorld {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        LOGGER.warn("Hello word2");

    }
}
