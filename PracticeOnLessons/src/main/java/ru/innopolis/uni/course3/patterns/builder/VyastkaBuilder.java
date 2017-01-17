package ru.innopolis.uni.course3.patterns.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olga on 17.01.2017.
 */
public class VyastkaBuilder extends MebelBulder {
    List<String> nameList = new ArrayList<>();
    List<Integer> priceList = new ArrayList<>();

    @Override
    void buildName() {
        mebel.setName(nameList.get(0));
    }

    @Override
    void buildPrice() {
        mebel.setPrice(priceList.get(0));
    }

    @Override
    void buildWeight() {
        mebel.setWeight(mebel.getPrice() * 10);
    }
}
