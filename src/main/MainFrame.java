package main;

import list.CategoryListFrame;
import login.LoginFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {

    public static Map<Integer, Integer> myAnswerMap = new HashMap<>();
    public static Map<Integer, Integer> dbAnswerMap = new HashMap<>();

    public static int count = 1;


    public MainFrame() {
        setTitle("楽しいJAVA-MAIN");
        setSize(300,100);
        setLocationRelativeTo(null);


        JPanel p = new JPanel(new GridLayout(2,1));
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel l1 = new JLabel(LoginFrame.userId + "さん");
        p1.add(l1);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        double a = myAnswerMap.size();

        JLabel l2 = new JLabel("進捗率" + Math.round(a/count*100) + "%");
        System.out.println(a/count*100);
        p2.add(l2);

        JButton b1 = new JButton("問題リスト");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new CategoryListFrame(0);
            }
        });
        JButton b2 = new JButton("履歴");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new CategoryListFrame(1);
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