package ru.innopolis.uni.course3.patterns.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olga on 18.01.2017.
 */

public class VKAdapter implements ISocialWeb {

    List<String> getFriendsVK(int userId) {
        return null;
    }

    @Override
    public List<String> getFriends(int userId) {
        List<String> friends = getFriendsVK(userId);
        List<String> result = new ArrayList<>();

        for (String friend : friends){
            result.add(friend.substring(0, friend.indexOf("_")));
        }

        return result;
    }

    public int getVKBalance(int iserId) {
        return 100;
    }

    public float getMarja() {
        return 0.11f;
    }

    public int getCurenceCurse() {
        return 60;
    }

    @Override
    public float getBalance(int iserId) {
        return getVKBalance(iserId)/getCurenceCurse();
    }

    public void addMoneyVK(int userId, double money) {

    }

    @Override
    public void addMoney(double money, int userId) {
        addMoneyVK(userId, money * getMarja());
    }
}
