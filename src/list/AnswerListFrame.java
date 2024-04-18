package list;

import main.MainFlame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.YES_OPTION;

public class AnswerListFrame extends JFrame {

    public AnswerListFrame() {
        JPanel p = new JPanel(new GridLayout(3,1));

        JPanel p1 = new JPanel();
        JTextArea t1 = new JTextArea(10,30);
        t1.append("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n");
        t1.append("1aaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n");
        t1.append("2aaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n");
        t1.append("3aaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n");
        t1.append("4aaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n");
        t1.append("5aaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n");
        t1.append("6aaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n");
        t1.append("7aaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n");
        t1.append("8aaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n");
        t1.append("9aaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n");
        JScrollPane scrollPane = new JScrollPane(t1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        p1.add(scrollPane);
        p.add(p1);

        setTitle("楽しいJAVA-LIST(1/10)");
        setSize(400,500);
        setLocationRelativeTo(null);

        JPanel p2 = new JPanel(new GridLayout(2,1));

        JPanel p2_1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        // 選択肢数
        JRadioButton[] radio = new JRadioButton[4];
        radio[0] = new JRadioButton("aaa");
        radio[1] = new JRadioButton("bbb");
        radio[2] = new JRadioButton("ccc");
        radio[3] = new JRadioButton("ddd");

        radio[2].setSelected(true);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radio[0]);
        bg.add(radio[1]);
        bg.add(radio[2]);
        bg.add(radio[3]);

        p2_1.add(radio[0]);
        p2_1.add(radio[1]);
        p2_1.add(radio[2]);
        p2_1.add(radio[3]);

        JPanel p2_2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel l1 = new JLabel("解答：aaa");
        p2_2.add(l1);


        p2.add(p2_1);
        p2.add(p2_2);



        p.add(p2);

        JPanel p3 = new JPanel(new GridLayout(1,3));
        JButton b1 = new JButton("前");
        b1.setEnabled(false);
        JButton b2 = new JButton("一覧へ");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
//                new HistoryFrame();
            }
        });


        JButton b3 = new JButton("次");
        p3.add(b1);
        p3.add(b2);
        p3.add(b3);

        p.add(p3);


        add(p);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AnswerListFrame();
    }
}