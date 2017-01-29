package ru.innopolis.uni.course3.tasksforsobes;

/**
 * Created by Olga on 29.01.2017.
 */
public class Polindrom {

    static boolean isPolindrom(String str){
        return new StringBuilder(str).reverse().toString().equalsIgnoreCase(str);
    }

    public static void main(String[] args) {
        System.out.println(isPolindrom("Кок"));
        System.out.println(isPolindrom("вымвым"));
    }
}
