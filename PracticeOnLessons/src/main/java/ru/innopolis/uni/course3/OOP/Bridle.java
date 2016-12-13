package ru.innopolis.uni.course3.OOP;

/**
 * Created by Olga on 12.12.2016.
 */
class Tack {
    static short s = 17;
    public Tack(short ss) {
        new Tack();
        s *= ss;
    }
    public Tack() { ; }
}

public class Bridle extends Tack {
    public Bridle(int s) { System.out.println(s + 1); }
    public static void main(String[] args) {
        Bridle b = new Bridle(3);
    }
}
