package util;

import login.LoginFrame;

import java.sql.*;

public class DbConn {

    private Connection getConn() {

        String url = "jdbc:mysql://localhost:3306/weavus";
        String user = "root";
        String password = "";

        // MySQL 데이터베이스 연결
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
            String sql = "SELECT * FROM userinfo where id=? and pw=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            ps.setString(2,pw);
            ResultSet rs = ps.executeQuery();

            boolean result = rs.next();
            if(result) {
                LoginFrame.userId = rs.getString("id");
            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getQuestionList() {

        Connection conn = getConn();

        try {
            String sql = "SELECT * FROM question where category=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "0");
            ResultSet rs = ps.executeQuery();

            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}