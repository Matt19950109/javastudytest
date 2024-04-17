package main;

import javax.swing.*;
import java.awt.*;

public class MainFlame extends JFrame {

    public MainFlame() {
        setTitle("楽しいJAVA-MAIN");
        setSize(300,100);
        setLocationRelativeTo(null);


        JPanel p = new JPanel(new GridLayout(2,1));
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel l1 = new JLabel("キムジョンファさん");
        p1.add(l1);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel l2 = new JLabel("進捗率(2/5) : 40%");
        p2.add(l2);

        JButton b1 = new JButton("問題リスト");
        JButton b2 = new JButton("履歴");
        p2.add(b1);
        p2.add(b2);

        p.add(p1);
        p.add(p2);
        add(p);


        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFlame();
    }
}
