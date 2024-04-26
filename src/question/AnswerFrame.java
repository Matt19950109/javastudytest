package question;

import dao.QuestionDao;
import dto.QuestionDto;
import list.CategoryListFrame;
import main.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AnswerFrame extends JFrame {

    JButton b2 = new JButton("一覧へ");


    public AnswerFrame(int index, int category) {

        QuestionDao questionDao = new QuestionDao();
        List<QuestionDto> questionDtoList = questionDao.getQuestionList(category);
        if(questionDtoList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "問題がない！！");
            setVisible(false);
            new CategoryListFrame(1);
            return;
        }

        JPanel mainPanel = new JPanel(new GridLayout(2,1));

        JPanel topPanel = new JPanel(new BorderLayout());

        JPanel correctionRatePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        int participantCount = questionDtoList.get(index).getParticipantCount();
        int correctionCount = questionDtoList.get(index).getCorrectionCount();
        //int rate = (correctionCount/participantCount) * 100;

//        JLabel correctionRateLabel = new JLabel(rate + "%");
//        correctionRatePanel.add(correctionRateLabel);
//        topPanel.add(correctionRatePanel, BorderLayout.NORTH);




        JTextArea t1 = new JTextArea(10,30);
        t1.setEditable(false);
        t1.append(questionDtoList.get(index).getContent());

        JScrollPane scrollPane = new JScrollPane(t1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        topPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(topPanel);

        int size = questionDtoList.size();

        setTitle("楽しいJAVA-LIST(" + (index+1) + "/" + size + ")");
        setSize(400,500);
        setLocationRelativeTo(null);

        // BorderLayout Panel
        JPanel bottomPanel = new JPanel(new BorderLayout());

        // ラジオボタングループ Start
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        String[] selectionArr = questionDtoList.get(index).getSelection().split(",");
        // 選択肢数
        JRadioButton[] radioArr = new JRadioButton[selectionArr.length];
        for(int i=0; i < selectionArr.length; i++) {
            radioArr[i] = new JRadioButton(selectionArr[i]);
            radioArr[i].setEnabled(false);
            radioArr[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(index == questionDtoList.size()-1) {
                        b2.setEnabled(true);
                    }
                }
            });
        }

        ButtonGroup bg = new ButtonGroup();
        for(int i=0; i < selectionArr.length; i++) {
            bg.add(radioArr[i]);
        }

        for(int i=0; i < selectionArr.length; i++) {
            p2.add(radioArr[i]);
        }

        topPanel.add(p2, BorderLayout.SOUTH);

        // ラジオボタングループ END
        // 解答 Start
        JPanel answPanel = new JPanel(new BorderLayout());
        JLabel answLabel = new JLabel("解答　：　" + "");
        JTextArea descTextArea = new JTextArea(questionDtoList.get(index).getContent());
        descTextArea.setEditable(false);

        JScrollPane scrollPane2 = new JScrollPane(descTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        answPanel.add(answLabel, BorderLayout.NORTH);
        answPanel.add(scrollPane2, BorderLayout.CENTER);
        bottomPanel.add(answPanel, BorderLayout.CENTER);

        // 解答 End

        // Button Start
        JPanel buttonPanel = new JPanel(new GridLayout(1,3));
        JButton b1 = new JButton("前");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AnswerFrame(index -1, category);
            }
        });
        // 見てるidx 0であれば、非活性
        if(index == 0) {
            b1.setEnabled(false);
        } else {
            b1.setEnabled(true);
        }


        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new CategoryListFrame(1);
            }
        });

        // 見てるidxが最後であれば、非活性
        JButton b3 = new JButton("次");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AnswerFrame(index + 1, category);
            }
        });
        if(index == questionDtoList.size()-1) {
            b3.setEnabled(false);
        } else {
            b3.setEnabled(true);
        }
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);

        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(bottomPanel);

        add(mainPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AnswerFrame(0,0);
    }

}