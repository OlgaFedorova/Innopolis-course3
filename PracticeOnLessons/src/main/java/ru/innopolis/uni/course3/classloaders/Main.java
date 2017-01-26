package ru.innopolis.uni.course3.classloaders;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Olga on 23.12.2016.
 */
public class Main {

    public static void doCompilation(String nameFile) throws IOException, ClassNotFoundException {
        File outputDir = new File(String.format("D:/myclasses/%s.java", nameFile));

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, outputDir.getPath());
    }

    static class A{
        public A() {
            System.out.println("");
            //super();
        }

        public void tA(){}
    }

    static class B extends A{
        public B() {
            super();
        }

        @Override
        public void tA() {
            super.tA();
        }

        public void tB() {
        }
    }

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){

            try {
                System.out.println("Введите имя класса:");
                String nameClass = reader.readLine();
                if("exit".equalsIgnoreCase(nameClass)){
                    break;
                }

                System.out.println("Введите имя файла:");
                String nameFile = reader.readLine();
                if("exit".equalsIgnoreCase(nameFile)){
                    break;
                }

                doCompilation(nameFile);

                System.out.println("Введите аргумент:");
                String argument = reader.readLine();
                if("exit".equalsIgnoreCase(argument)){
                    break;
                }

                Class myClass = new MyClassLoader(Main.class.getClassLoader()).loadClass(nameClass, nameFile);

                Method main = myClass.getMethod("excute", String.class);
                System.out.format("invoking %s.excute()%n", myClass.getName());
                main.invoke(myClass.newInstance(), argument);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }

        B b = ((B)new A());
    }

}
