package ru.innopolis.uni.course3.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedList;

/**
 * Created by Olga on 13.12.2016.
 */
public class MyClass {


    public static void main(String[] args) {
        MyClass a = new MyClass();
        Class aclass = a.getClass();
        System.out.println(aclass);
/*
        try {
            Class c1 = Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
*/
        Integer i = new Integer(0);
        Class iclass = i.getClass();
        String iname = iclass.getName();

        System.out.println(iname);
        System.out.println(aclass.getName());

        Object obj = new Object();

        Class c = obj.getClass();
        int mods = c.getModifiers();
        if (Modifier.isPublic(mods)) {
            System.out.println("public" + mods);
        }
        if (Modifier.isAbstract(mods)) {
            System.out.println("abstract");
        }
        if (Modifier.isFinal(mods)) {
            System.out.println("final");
        }

        Class c1 = LinkedList.class;
        Class[] interfaces = c1.getInterfaces();
        for (Class cInterface : interfaces) {
            System.out.println(cInterface.getName());
        }

        Field[] publicFields = c1.getDeclaredFields();
        for (Field field : publicFields) {
            Class fieldType = field.getType();
            System.out.println("Имя: " + field.getName());
            System.out.println("Тип: " + fieldType.getName());

        }

        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class paramType : paramTypes) {
                System.out.print(paramType.getName() + " ");
                System.out.print(paramType.getTypeName() + " ");
            }
            System.out.println();
        }

        System.out.println("Методы:");

        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            System.out.println("Имя: " + method.getName());
            System.out.println("Возвращаемый тип: " + method.getReturnType().getName());

            Class[] paramTypes = method.getParameterTypes();
            System.out.print("Типы параметров: ");
            for (Class paramType : paramTypes) {
                System.out.print(" " + paramType.getName());
            }
            System.out.println();
        }
    }

}
