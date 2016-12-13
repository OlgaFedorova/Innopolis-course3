package ru.innopolis.uni.course3.reflection.Task;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olga on 12.12.2016.
 */
public class Main {

    public static void main(String[] args) {
        final Serializator serializator = new Serializator();
        final List<Student> listOfStudent = new ArrayList<>();
        listOfStudent.add(new Student("Ivan", 23));
        listOfStudent.add(new Student("Igor", 21));
        listOfStudent.add(new Student("Irina", 25));
        String fileName = String.format("%s/PracticeOnLessons/src/main/java/ru/innopolis/uni/course3/reflection/Task/temp/student.xml", System.getProperties().get("user.dir"));
        serializator.serialize(fileName, listOfStudent);

        final Deserializator deserializator = new Deserializator();
        List list = deserializator.deserialize(fileName);

        System.out.println(list);
    }
}
