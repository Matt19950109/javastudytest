package main;

import question.AnswerListFrame;
import question.ListFrame;
import login.LoginFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("楽しいJAVA-MAIN");
        setSize(300,100);
        setLocationRelativeTo(null);


        JPanel p = new JPanel(new GridLayout(2,1));
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel l1 = new JLabel(LoginFrame.userId + "さん");
        p1.add(l1);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel l2 = new JLabel("進捗率(2/5) : 40%");
        p2.add(l2);

        JButton b1 = new JButton("問題リスト");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ListFrame();
            }
        });
        JButton b2 = new JButton("履歴");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEnabled(false);
                new AnswerListFrame(MainFrame.this);
            }
        });
        p2.add(b1);
        p2.add(b2);

        p.add(p1);
        p.add(p2);
        add(p);


        setVisible(true);
    }
}