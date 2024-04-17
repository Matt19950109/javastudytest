package util;

import java.sql.*;

public class DbConn {

    public static void main(String[] args) {


        String url = "jdbc:mysql://localhost:3306/weavus";
        String user = "root";
        String password = "";

        // MySQL 데이터베이스 연결
        Connection conn;

        {
            try {
                conn = DriverManager.getConnection(url, user, password);

                Statement stmt = conn.createStatement();
                // 쿼리 실행
                String sql = "SELECT * FROM userinfo";
                ResultSet rs = stmt.executeQuery(sql);

                // 결과 출력
                while (rs.next()) {
                    System.out.println(rs.getString("id") + " " + rs.getString("name"));
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


}