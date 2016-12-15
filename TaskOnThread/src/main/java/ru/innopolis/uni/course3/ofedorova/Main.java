package ru.innopolis.uni.course3.ofedorova;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для запуска программы.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 11.12.2016
 */
public class Main {

    /**
     * Метод возвращает список ресурсов, располагающихся по адресу path.
     *
     * @param path адрес расположения ресурсов.
     * @return список ресурсов.
     */
    public static List<InputStream> getResoursesInPath(String path) {

        List<InputStream> resources = new ArrayList<>();
        File[] files = new File(path).listFiles();
        for (File file : files) {
            try {
                InputStream resource = new FileInputStream(file);
                resources.add(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resources;
    }

    /**
     * Метод для запуска программы.
     *
     * @param args аргументы для запуска программы.
     */
    public static void main(String[] args) {

        new ManagerOfProgram().start(Main.getResoursesInPath(String.format("%s/TaskOnThread/temp_with_incorrect", System.getProperties().get("user.dir"))));
        //new ManagerOfProgram().start(Main.getResoursesInPath(String.format("%s/TaskOnThread/temp_without_incorrect", System.getProperties().get("user.dir"))));

    }

}
