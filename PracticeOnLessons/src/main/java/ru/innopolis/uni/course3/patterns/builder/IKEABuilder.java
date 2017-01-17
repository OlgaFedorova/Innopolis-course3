package ru.innopolis.uni.course3.patterns.builder;

import java.util.*;

/**
 * Created by Olga on 17.01.2017.
 */
public class IKEABuilder extends MebelBulder {

    @Override
    void buildName() {
        mebel.setName(UUID.randomUUID().toString());
    }

    @Override
    void buildPrice() {
        mebel.setPrice(new Random().nextInt());

    }

    @Override
    void buildWeight() {
        mebel.setWeight(5.5);

    }
}
