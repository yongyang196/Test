package Mysql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Mysql {
    static String url = null;
    static String user = null;
    static String password = null;
    static String driver = null;

    static {
        try {
            Properties properties = new Properties();
            InputStream in = Mysql.class.getResourceAsStream("/Mysql.properties");
            properties.load(in);

            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");

            Class.forName(driver);
            //Class.forName("com.mysql.jdbc.Driver");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

