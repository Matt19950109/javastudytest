package dao;

import dto.CategoryDto;
import util.DbConn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    public List<CategoryDto> getCategoryList() throws SQLException {

        Connection conn = DbConn.getConn();

        String sql = "select * from category";

        Statement sm = conn.createStatement();

        ResultSet rs = sm.executeQuery(sql);

        List<CategoryDto> categoryDtoList = new ArrayList<>();

        while(rs.next()) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(rs.getInt("id"));
            categoryDto.setTitle(rs.getString("title"));

            categoryDtoList.add(categoryDto);
        }



        return categoryDtoList;
    }
}