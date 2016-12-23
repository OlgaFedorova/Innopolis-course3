package ru.innopolis.uni.course3.jdbctest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by d.sapaev on 22.11.2016.
 */
public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            LOG.error("Can't load jdbc driver", e);
            throw new RuntimeException(e);
        }
    }

    public static final String CREATE_TABLE_QUERY = "CREATE TABLE PRODUCT (ID INTEGER PRIMARY KEY, NAME VARCHAR(10));";
    public static final String SELECT_QUERY = "SELECT * FROM PRODUCT;";
    public static final String INSERT_QUERY_PREFIX = "INSERT INTO PRODUCT (ID, NAME) VALUES (";
    public static final String INSERT_QUERY_SUFFIX = ");";
    public static final String PREPARED_INSERT_QUERY = "INSERT INTO PRODUCT (ID, NAME) VALUES (?,?);";

    public static final String DATABASE_URL = "jdbc:h2:~/test6";

    public void createTable() throws SQLException {
        try(Connection conn = DriverManager.getConnection(DATABASE_URL);
            Statement statement = conn.createStatement()){
            statement.execute(CREATE_TABLE_QUERY);
            LOG.info("Database successfully created");
        }

    }

    public void showRows() throws SQLException {
        try(Connection conn = DriverManager.getConnection(DATABASE_URL); 
            Statement statement = conn.createStatement()){
            ResultSet resultSet = statement.executeQuery(SELECT_QUERY);
            while(resultSet.next()) {
                LOG.info(new StringBuilder().append(resultSet.getInt(1)).append(" | ").append(resultSet.getString(2)).toString());
            }
        }
    }

    public void insertRows() throws SQLException {
        try(Connection conn = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement statement = conn.prepareStatement(PREPARED_INSERT_QUERY)){
            int count;
            for (int i = 0; i < 100; i++) {
                statement.setInt(1,i);
                statement.setString(2, "name" + i);
                count = statement.executeUpdate();
                LOG.info("{} rows inserted", count);
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Main main = new Main();
        main.createTable();
        main.insertRows();
        main.showRows();
    }
}
