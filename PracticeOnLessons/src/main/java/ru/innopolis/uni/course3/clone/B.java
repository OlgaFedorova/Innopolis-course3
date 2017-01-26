package ru.innopolis.uni.course3.clone;

/**
 * Created by Olga on 24.01.2017.
 */
class B extends A implements Cloneable{
    public int i=20;
    @Override
    public B clone() throws CloneNotSupportedException {
        A cloneA = super.clone();
        B cloneB = (B) cloneA;
        System.out.print(cloneB.i+" ");
        return cloneB;
    }
}