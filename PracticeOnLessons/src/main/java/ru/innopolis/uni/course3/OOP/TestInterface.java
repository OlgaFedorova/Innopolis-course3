package ru.innopolis.uni.course3.OOP;

/**
 * Created by Olga on 17.01.2017.
 */
public class TestInterface extends AbstracTestClass implements Interface1, Interface2 {

    public static void main(String[] args) {
        TestInterface testInterface = new TestInterface();
    }

    @Override
    public String getName1() {
        return ((Interface1) this).name1;
    }
}
