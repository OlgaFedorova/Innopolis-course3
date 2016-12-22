package ru.innopolis.uni.course3.ofedorova.models;

/**
 * Created by Olga on 22.12.2016.
 */
public abstract class Base {

    private int id;

    public Base(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
