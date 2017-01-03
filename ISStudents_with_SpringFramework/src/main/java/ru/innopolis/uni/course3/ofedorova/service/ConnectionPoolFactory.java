package ru.innopolis.uni.course3.ofedorova.service;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Olga on 23.12.2016.
 */
public class ConnectionPoolFactory {
    private static DataSource ds = null;

    static {
        try {
            InitialContext initContext= new InitialContext();
            ds = (DataSource) initContext.lookup("java:comp/env/jdbc/is-students");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException{
        Connection conn = ds.getConnection();
        return conn;
    }
}
