package util;

import login.LoginFlame;

import java.sql.*;

public class DbConn {
    private Connection getConn() {
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

    public boolean login(String id, String pw) {
        Connection conn = getConn();

        try {
            String sql1 = "select * FROM userinfo where id = ? and pw = ?";
            PreparedStatement ps = conn.prepareStatement(sql1);
            ps.setString(1, id);
            ps.setString(2, pw);
            ResultSet rs = ps.executeQuery();

            boolean result = rs.next();
            if (result) {
                LoginFlame.userId = rs.getString(id);
            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}