package ru.innopolis.uni.course3.ofedorova.models;

/**
 * Created by Olga on 22.12.2016.
 */
public class Student extends Base {

    private String name;
    private String group;

    public Student(int id, String name, String group) {
        super(id);
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
