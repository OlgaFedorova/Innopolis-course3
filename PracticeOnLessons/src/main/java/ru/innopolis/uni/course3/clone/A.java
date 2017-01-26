package ru.innopolis.uni.course3.clone;

/**
 * Created by Olga on 24.01.2017.
 */
class A implements Cloneable{
    public int i=10;
    @Override
    public A clone() throws CloneNotSupportedException {
        Object obj = super.clone();
        return (A) obj;
    }
}
