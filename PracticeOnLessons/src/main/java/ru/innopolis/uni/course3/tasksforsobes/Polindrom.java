package ru.innopolis.uni.course3.tasksforsobes;

/**
 * Created by Olga on 29.01.2017.
 */
public class Polindrom {

    static boolean isPolindrom(String str){
        return new StringBuilder(str).reverse().toString().equalsIgnoreCase(str);
    }

    static boolean isPolindrom2(String str){
        boolean isPolindrom = true;
        for(int i = 0; i < str.length()/2; i++){

        }
        return isPolindrom;
    }

    public static void main(String[] args) {
        System.out.println(isPolindrom("Кок"));
        System.out.println(isPolindrom("вымвым"));

        char a = 'a';
        char b = 'b';
        System.out.println(a + " " + b);
        a = (char) (a + b);
        b = (char) (a - b);
        a = (char) (a-b);
        System.out.println(a + " " + + (char)b);
    }
}
