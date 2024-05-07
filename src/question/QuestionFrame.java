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

import static javax.swing.JOptionPane.YES_OPTION;

public class QuestionFrame extends JFrame {
    JButton b1 = new JButton("前");
    JButton b2 = new JButton("提出");
    JButton b3 = new JButton("次");


    public QuestionFrame(int index, int category) {
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);

        JPanel p = new JPanel(new GridLayout(4,1));

        JPanel p1 = new JPanel();

        QuestionDao questionDao = new QuestionDao();

        List<QuestionDto> questionDtoList = questionDao.getQuestionList(category);

        if(questionDtoList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "問題がない！！");
            setVisible(false);
            new CategoryListFrame(0);
            return;
        }


        JTextArea t1 = new JTextArea(10,30);
        t1.append(questionDtoList.get(index).getContent());

        JScrollPane scrollPane = new JScrollPane(t1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        p1.add(scrollPane);
        p.add(p1);

        int size = questionDtoList.size();

        setTitle("楽しいJAVA-LIST(" + (index+1) + "/" + size + ")");
        setSize(400,500);
        setLocationRelativeTo(null);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        String[] selectionArr = questionDtoList.get(index).getSelection().split(",");
        // 選択肢数
        JRadioButton[] radioArr = new JRadioButton[selectionArr.length];
        for(int i=0; i < selectionArr.length; i++) {
            radioArr[i] = new JRadioButton(selectionArr[i]);
            int selected = i;
            radioArr[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    MainFrame.myAnswerMap.put(questionDtoList.get(index).getNo(), selected);

                    if(index == questionDtoList.size()-1) {
                        b1.setEnabled(true);
                        b2.setEnabled(true);
                    } else if(index == 0) {
                        b3.setEnabled(true);
                    } else {
                        b1.setEnabled(true);
                        b3.setEnabled(true);
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

        p.add(p2);

        JPanel p3 = new JPanel(new GridLayout(1,3));

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new QuestionFrame(index -1, category);
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for(QuestionDto questionDto : questionDtoList) {
                    MainFrame.dbAnswerMap.put(questionDto.getNo(), questionDto.getAnswer());
                }

                for(int no : MainFrame.dbAnswerMap.keySet()) {
                    int correction = MainFrame.dbAnswerMap.get(no);
                    int selection = MainFrame.myAnswerMap.get(no);

                    if(correction == selection) {
                        System.out.printf("正解");
                    } else {
                        System.out.printf("誤答　NO:%d, CORRECTION:%d, SELCTION:%d", no, correction, selection);
                    }


                }

                JOptionPane.showMessageDialog(null, "お疲れ様です。メイン画面に戻ります。");
                MainFrame.count = questionDtoList.size();
                setVisible(false);
                new MainFrame();
            }
        });

        // 見てるidxが最後であれば、非活性
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new QuestionFrame(index + 1, category);
            }
        });
        p3.add(b1);
        p3.add(b2);
        p3.add(b3);

        p.add(p3);

        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton b4 = new JButton("テスト中断");
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "中断します。よろしいですか？", "確認" , 2);
                MainFrame.count = questionDtoList.size();
                if(result == YES_OPTION) {
                    setVisible(false);
                    new CategoryListFrame(0);
                }
            }
        });
        p4.add(b4);

        p.add(p4);


        add(p);
        setVisible(true);
    }

}