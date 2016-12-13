package ru.innopolis.uni.course3.exceptions.Lab1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Olga on 07.12.2016.
 */
public class Main {

    private static void commandSerialize(String file) {

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Ivan", 19));
        studentList.add(new Student("Iliy", 21));
        studentList.add(new Student("Irina", 23));
        studentList.add(new Student("Olga", 23));
        studentList.add(new Student("Alexander", 20));

        try {
            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));) {
                for (Student student : studentList) {
                    try {
                        outputStream.writeObject(student);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void commandDeserialize(String file) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));) {
            while (true) {
                try {
                    Object objectRead = inputStream.readObject();
                    if (objectRead == null) {
                        break;
                    }
                    Student student = (Student) objectRead;
                    System.out.println(student);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (EOFException e) {
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void commandParse(String file) {
        String regex = "^Name=(\\w+?) age=(\\d+?)$";
        Pattern pattern = Pattern.compile(regex);
        BufferedReader reader = null;
        List<Student> studentList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String stringRead = "";
            Matcher matcher = pattern.matcher(stringRead);
            while (stringRead != null) {
                stringRead = reader.readLine();
                if(stringRead != null){
                    matcher.reset(stringRead);
                    while (matcher.find()) {
                        String name = matcher.group(1);
                        int age = Integer.valueOf(matcher.group(2));
                        studentList.add(new Student(name, age));
                    }
                 }
            }
            System.out.println(studentList);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // IOUtils.closeQuietly
            //http://commons.apache.org/io/api-1.2/org/apache/commons/io/IOUtils.html#closeQuietly(java.io.InputStream)
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String readString = "";
            while (true) {
                System.out.println("Input command:");
                readString = reader.readLine();
                String[] parseReadString = readString.split(" ");
                if (readString.equalsIgnoreCase("exit")) {
                    break;
                }
                String command = parseReadString[0];
                String file = parseReadString[1];
                if (command.equals("parse")) {
                    Main.commandParse(file);
                } else if (command.equals("serialize")) {
                    Main.commandSerialize(file);
                } else if (command.equals("deserialize")) {
                    Main.commandDeserialize(file);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
