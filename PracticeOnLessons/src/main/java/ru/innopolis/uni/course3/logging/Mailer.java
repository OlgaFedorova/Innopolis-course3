package ru.innopolis.uni.course3.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Olga on 14.12.2016.
 */
public class Mailer {

    private static final Logger logger = LoggerFactory.getLogger(Mailer.class);

    public void logMail(String mailString) {
        logger.info(mailString);
    }

    public static void main(String[] args) {
        new Mailer().logMail("This mail should be sent");
    }
}
