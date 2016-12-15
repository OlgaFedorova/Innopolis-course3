package ru.innopolis.uni.course3.log4j;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/**
 * Created by Olga on 14.12.2016.
 */
public class MailAppender extends AppenderSkeleton {

    @Override
    protected void append(LoggingEvent event) {
        System.out.printf("SEND MAIL: %s", event.getMessage());
    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}
