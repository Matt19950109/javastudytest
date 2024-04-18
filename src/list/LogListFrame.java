package list;

import login.LoginFlame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LogListFrame extends JFrame {

    public LogListFrame(){

        setTitle("楽しいJAVA-履歴");
        setSize(400,500);
        setLocationRelativeTo(null);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        JLabel l1 = new JLabel("問題1");
        l1.setForeground(Color.BLUE);
        p.add(l1);
        l1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 新しい画面を開く処理
                AnswerListFrame a1 = new AnswerListFrame();
                a1.setVisible(true);
            }
        });


        JLabel l2 = new JLabel("問題2");
        l2.setForeground(Color.BLUE);
        p.add(l2);


        add(p);
        setVisible(true);

        //(new BoxLayout(p1, BoxLayout.Y_AXIS));
    }

    public static void main(String[] args) {
        new LogListFrame();
    }


}