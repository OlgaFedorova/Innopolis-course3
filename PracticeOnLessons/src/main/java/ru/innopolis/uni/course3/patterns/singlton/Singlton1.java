package ru.innopolis.uni.course3.patterns.singlton;

/**
 * Подходит для работы в одном потоке.
 */
public class Singlton1 {

    private static Singlton1 instance;

    private Singlton1() {
    }

    public static Singlton1 getInstance(){
        if(instance == null){
            instance = new Singlton1();
        }
        return instance;
    }
}
