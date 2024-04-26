package list;

import dao.CategoryDao;
import dto.CategoryDto;
import main.MainFrame;
import question.AnswerFrame;
import question.QuestionFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

public class CategoryListFrame extends JFrame {

    static final int QUESTION_BUTTON = 0;

    public CategoryListFrame(int buttonType) {

        setTitle("楽しいJAVA-QUESTION LIST");
        setSize(400,500);
        setLocationRelativeTo(null);

        setVisible(true);

        // data 取得
        CategoryDao categoryDao = new CategoryDao();

        List<CategoryDto> categoryDtoList;

        try {
            categoryDtoList = categoryDao.getCategoryList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //
        JPanel p = new JPanel(new GridLayout(0,1));

        JLabel[] titleArr = new JLabel[categoryDtoList.size()];

        for(int i=0; i < categoryDtoList.size(); i++) {
            String title = categoryDtoList.get(i).getTitle();
            int id = categoryDtoList.get(i).getId();

            titleArr[i] = new JLabel(title);
            titleArr[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            titleArr[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    setVisible(false);
                    if(buttonType == QUESTION_BUTTON) {
                        new QuestionFrame(0, id);
                    } else {
                        new AnswerFrame(0, id);
                    }
                }
            });
            p.add(titleArr[i]);
        }

        JButton b1 = new JButton("戻る");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new MainFrame();
            }
        });
        p.add(b1);


        add(p);

    }
}