package ru.innopolis.uni.course3.OOP.assa;

/**
 * Created by Olga on 22.01.2017.
 */
public class X <X>{
    X x;
    public X(){  }
    public X(X x){
        this.x=x;
    }
    public <Y extends X> Y Y(Y y){
        return y;
    }
}

class Y<Y extends X> extends X{
    private static Integer Y = 5;
    public static void main(String...X){
        System.out.print(new X().Y(Y).toString());
    }
}
