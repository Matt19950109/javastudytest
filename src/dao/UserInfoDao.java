package dao;

import dto.QuestionDto;
import dto.UserInfoDto;
import login.LoginFrame;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static util.DbConn.getConn;

public class UserInfoDao {

    public boolean login(String id, String pw) {

        Connection conn = getConn();

        String sql = "SELECT * FROM userinfo where id=? and pw=?";

        try {
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

    public UserInfoDto checkAuthUser(String id, String pw){
        Connection conn = getConn();

        String sql = "SELECT * FROM userinfo where id=? and pw=?";



        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            ps.setString(2,pw);
            ResultSet rs = ps.executeQuery();

            UserInfoDto userInfoDto = new UserInfoDto();

            while(rs.next()){
                userInfoDto.setId(rs.getString("id"));
                userInfoDto.setPw(rs.getString("pw"));
                userInfoDto.setName(rs.getString("name"));
                userInfoDto.setAuth(rs.getInt("auth"));
            }

            return userInfoDto;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void registerUser(String id, String name){
        Connection conn = getConn();

        String sql = "INSERT INTO userinfo VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            ps.setString(2,"weavus");
            ps.setString(3,name);
            ps.setInt(4,1);

            int i = ps.executeUpdate();
            if(i > 0){
                JOptionPane.showMessageDialog(null, "登録成功");
            } else {
                JOptionPane.showMessageDialog(null, "登録失敗");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void changePassword(String id, String pw){
        Connection conn = getConn();

        String sql = "UPDATE userinfo SET pw=? where id=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,pw);
            ps.setString(2,id);

            int i = ps.executeUpdate();
            if(i > 0){
                JOptionPane.showMessageDialog(null, "パスワード変更が成功しました");
            } else {
                JOptionPane.showMessageDialog(null, "再度登録しなおしてください");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public UserInfoDto checkPasswordHintUser(String id, String name){
        Connection conn = getConn();

        String sql = "SELECT * FROM userinfo where id=? AND name=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            ps.setString(2,name);
            ResultSet rs = ps.executeQuery();

            UserInfoDto userInfoDto = new UserInfoDto();

            while(rs.next()){
                userInfoDto.setId(rs.getString("id"));
                userInfoDto.setPw(rs.getString("pw"));
                userInfoDto.setName(rs.getString("name"));
                userInfoDto.setAuth(rs.getInt("auth"));
            }

            return userInfoDto;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}