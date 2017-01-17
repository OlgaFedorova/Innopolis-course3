package ru.innopolis.uni.course3.patterns.builder;

/**
 * Created by Olga on 17.01.2017.
 */
public abstract class MebelBulder {

    protected  Mebel mebel;

    public Mebel  getMebel(){
        return  this.mebel;
    }

    public void createMebel(){
        mebel= new Mebel();
    }

    abstract void buildName();
    abstract void buildPrice();
    abstract void buildWeight();
}
