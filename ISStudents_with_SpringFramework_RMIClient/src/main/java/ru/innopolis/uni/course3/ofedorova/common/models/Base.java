package ru.innopolis.uni.course3.ofedorova.common.models;

import java.io.Serializable;

/**
 * Created by Olga on 22.12.2016.
 */
public abstract class Base implements Serializable {

    static final long SerialVersionUID = 1L;

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
