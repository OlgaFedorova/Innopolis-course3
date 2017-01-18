package ru.innopolis.uni.course3.patterns.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Olga on 18.01.2017.
 */
public class FacebookAdapter implements ISocialWeb {

    ///////////////////////////////
    // АДАПТИРУЕМОЕ

    public Map<String, String> autehth() {
        Map<String, String> result = new HashMap<>();
        result.put("userId", "1");
        result.put("Username", "user");
        result.put("currency", "RUB");
        return result;
    }

    public Map<String, String> getFriendsFacebook() {
        return null;
    }

    public float getBalanceFacebook(String current) {
        return 0;
    }

    public void addMoneyFacebook(double money, String current) {

    }

    ///////////////////////////////

    Map<String, String> authAndValidate(int userId) throws Exception {
        Map<String, String> auth = autehth();
        if (Integer.valueOf(auth.get("userId")) == userId) {
            return auth;
        } else {
            throw new Exception();
        }
    }


    @Override
    public List<String> getFriends(int userId) {
        List<String> result = new ArrayList<>();
        try {
            Map<String, String> auth = authAndValidate(userId);
            for (Map.Entry<String, String> entry : getFriendsFacebook().entrySet()) {
                if (entry.getValue() == null || entry.getValue().isEmpty()) {
                    result.add("hidden user");
                } else {
                    result.add(entry.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public float getBalance(int userId) {
        float result = 0;
        try {
            Map<String, String> auth = authAndValidate(userId);
            result = getBalanceFacebook(auth.get("currency"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void addMoney(double money, int userId) {
        try {
            Map<String, String> auth = authAndValidate(userId);
            addMoneyFacebook(money, auth.get("currency"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
