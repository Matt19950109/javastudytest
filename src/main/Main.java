package main;

import login.LoginFlame;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main() {
        setTitle("楽しい-JAVA");
        setSize(200,400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,1));
        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("進捗率");
        JLabel l2 = new JLabel("田中さん");
        JLabel blank1 = new JLabel("     ");
        JLabel blank2 = new JLabel("     ");

        p1.add(l1);
        p1.add(blank1);
        p1.add(blank2);
        p1.add(l2);
        add(p1);

        JPanel p2 = new JPanel();
        JButton l3 = new JButton("問題リスト");

        p2.add(l3);
        add(p2);

        JPanel p3 = new JPanel();
        JButton l4 = new JButton("ログ");

        p3.add(l4);
        add(p3);


        setVisible(true);

    }


}
