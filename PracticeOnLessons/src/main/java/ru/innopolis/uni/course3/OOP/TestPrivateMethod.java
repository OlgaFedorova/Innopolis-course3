package ru.innopolis.uni.course3.OOP;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Olga on 09.12.2016.
 */
public class TestPrivateMethod {

    private static class A1 {
        private String test() {
            return "A1";
        }
    }

    public static class A2 extends A1 {
        public String test() {
            return "A2";
        }
    }

    public static class A3 extends A2 {
        public String test() {
            return "A3";
        }
    }

    public static void main(String ... arg) {
        A1 a1 = new A1();
        System.out.println(a1.test());
        a1 = new A2();
        System.out.println(a1.test());
        a1 = new A3();
        System.out.println(a1.test());

        List<String> list = new CopyOnWriteArrayList<>();
        //List<String> list = new ArrayList<>();

        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        for (String str : list) {
            if (str.equals("two")) {
                list.remove("three");
            }
        }

        System.out.println(list);
        System.out.println(3 + "1" + 2 + 3);

        try {
            URL url = new URL("https://www.google.com.ua/images/srpr/logo11w.png");
            url.openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void dfjshdf(InputStream df){}
}
