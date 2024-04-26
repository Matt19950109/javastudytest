package util;

import java.sql.*;

public class DbConn {

    public static Connection getConn() {

        String url = "jdbc:mysql://localhost:3306/weavus";
        String user = "root";
        String password = "";

        Connection conn;

        try {
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
