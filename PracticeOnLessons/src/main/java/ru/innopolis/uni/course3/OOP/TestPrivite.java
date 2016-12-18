package ru.innopolis.uni.course3.OOP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

/**
 * Created by Olga on 18.12.2016.
 */
class TestPrivite {

    public static void main(String... args) throws IOException{
        Integer I1 = 0;
        Integer I2 = -1;
        Integer I3 = 1;
        Formatter f = new Formatter();
        f.format("%1$b ", I1.toString())
                .format("%1$b ", I2.toString())
                .format("%1$b ", I3.toString());
        System.out.println(f.toString());

        Object obj = null;
        String str = new String("str");
        str = (String) obj;
        obj = new String("obj");
        System.out.print(obj + ", " + str);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        Integer[] array = null;
        list.toArray(array);
        System.out.println(list.get(1));


    }

}
