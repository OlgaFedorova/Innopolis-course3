package ru.innopolis.uni.course3.exceptions.Lab1;

import java.io.Serializable;

/**
 * Created by Olga on 07.12.2016.
 */
public class Student implements Serializable {
    private String name;
    private int age;
    static final long serialVersionUID = 1L;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
