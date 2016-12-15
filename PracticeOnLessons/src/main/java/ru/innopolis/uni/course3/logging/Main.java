package ru.innopolis.uni.course3.logging;

import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Olga on 11.12.2016.
 */
public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.warn("Main2");
        login("USER");

    }

    static void login(String user){
        try{
            MDC.put("user", user);
        }finally {
            MDC.clear();
        }
    }


}

