package ru.innopolis.uni.course3.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Olga on 26.01.2017.
 */
public class jdbc {

    public static void main(String[] args) {
       // Class.forName("jdbc");
        try {
            Connection connection = DriverManager.getConnection("", "", "") ;
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
