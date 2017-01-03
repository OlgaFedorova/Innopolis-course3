package ru.innopolis.uni.course3.ofedorova.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Olga on 22.12.2016.
 */
public class Settings {

    private static final Settings INSTANCE = new Settings();

    private final Properties properties = new Properties();

    public final static ApplicationContext APPLICATION_CONTEXT = new ClassPathXmlApplicationContext(new String[]{"appContext.xml"});

    private Settings() {
        try {
            properties.load(new FileInputStream(this.getClass().getClassLoader().getResource("ofedorova.properties").getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Settings getInstance() {
        return INSTANCE;
    }

    public String value(String key) {
        return this.properties.getProperty(key);
    }

}
