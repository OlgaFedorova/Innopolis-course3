package ru.innopolis.uni.course3.ofedorova;

import ru.innopolis.uni.course3.ofedorova.handlers.HandlerForSumOfPositiveEvenNumbers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olga on 11.12.2016.
 */
public class Main {

    public static void main(String[] args) {
        List<InputStream> resources = new ArrayList<>();
        File[] files = new File(String.format("%s/TaskOnThread/temp", System.getProperties().get("user.dir"))).listFiles();
        for (File file : files){
            try{
                InputStream resource = new FileInputStream(file);
                resources.add(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        StorageForSumOfPositiveEvenNumbers storage = new StorageForSumOfPositiveEvenNumbers();
        for (InputStream resource : resources){
            new Thread(new HandlerForSumOfPositiveEvenNumbers(storage, resource)).start();
        }

    }

}
