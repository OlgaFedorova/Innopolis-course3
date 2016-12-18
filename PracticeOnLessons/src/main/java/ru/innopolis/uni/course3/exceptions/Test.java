package ru.innopolis.uni.course3.exceptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Olga on 18.12.2016.
 */
public class Test {

    static class TestMap extends HashMap{
        @Override
        public Set keySet(){
            return  null;
        }
    }

    public static void main(String[] args){
        Map map = new TestMap();
        for(Object o: map.keySet()){
            System.out.println(o);
        }
    }

}
