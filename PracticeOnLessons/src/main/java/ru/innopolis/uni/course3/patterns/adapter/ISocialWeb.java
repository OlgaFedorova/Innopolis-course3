package ru.innopolis.uni.course3.patterns.adapter;

import java.util.List;

/**
 * Created by Olga on 18.01.2017.
 */
public interface ISocialWeb {

    List<String> getFriends(int userId);
    float getBalance(int iserId);
    void addMoney(double money, int userId);
}
