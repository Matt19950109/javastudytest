package dao;

import dto.QuestionDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static util.DbConn.getConn;

public class QuestionDao {

    public List<QuestionDto> getQuestionList(int category) {

        Connection conn = getConn();

        try {
            String sql = "SELECT * FROM question where category=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, category);
            ResultSet rs = ps.executeQuery();

            // 変換 ResultSet -> List<UserInfodto>
            List<QuestionDto> questionDtoList = new ArrayList<QuestionDto>();

            while(rs.next()) {
                QuestionDto questionDto = new QuestionDto();
                questionDto.setNo(rs.getInt("no"));
                questionDto.setContent(rs.getString("content"));
                questionDto.setSelection(rs.getString("selection"));
                questionDto.setCategory(rs.getInt("category"));
                questionDto.setAnswer(rs.getInt("answer"));
                questionDto.setParticipantCount(rs.getInt("participant_count"));
                questionDto.setCorrectionCount(rs.getInt("correction_count"));

                questionDtoList.add(questionDto);
            }

            return questionDtoList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}