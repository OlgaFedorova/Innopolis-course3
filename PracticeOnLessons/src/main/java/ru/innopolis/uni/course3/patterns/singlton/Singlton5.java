package ru.innopolis.uni.course3.patterns.singlton;

/**
 * Double-Checked Locking.
 + Ленивая инициализация
 + Высокая производительность
 - Поддерживается только с JDK 1.5 [5]
 */
public class Singlton5 {

    private static volatile Singlton5 instance;
    //private static final Singlton5 instance;

    private Singlton5() {
    }

    public static synchronized Singlton5 getInstance(){
        if (instance == null) {
            synchronized (Singlton5.class) {
                if (instance == null) {
                    instance = new Singlton5();
                }
            }
        }
        return instance;
    }
}
