package ru.innopolis.uni.course3.classloaders;

/**
 * Created by Olga on 23.12.2016.
 */
public class MyExcutable2 implements Excutable {

    @Override
    public void excute(String str) {
        System.out.println(String.format("%s : %s", 2, str));
    }

}
