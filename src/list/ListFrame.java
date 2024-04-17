package list;

import javax.swing.*;
import java.awt.*;

public class ListFrame extends JFrame {

    public ListFrame() {
        JPanel p = new JPanel(new GridLayout(3, 1));

        JPanel p1 = new JPanel();
        JTextArea t1 = new JTextArea(10, 30);
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
        setSize(400, 500);
        setLocationRelativeTo(null);

        JPanel p2 = new JPanel(new SpringLayout());
        // 選択肢数
        JRadioButton[] radio = new JRadioButton[4];
        radio[0] = new JRadioButton("aaa");
        radio[1] = new JRadioButton("bbb");
        radio[2] = new JRadioButton("ccc");
        radio[3] = new JRadioButton("ccc");

        ButtonGroup bg = new ButtonGroup();
        bg.add(radio[0]);
        bg.add(radio[1]);
        bg.add(radio[2]);
        bg.add(radio[3]);

        p2.add(radio[0]);
        p2.add(radio[1]);
        p2.add(radio[2]);
        p2.add(radio[3]);
        p.add(p2);

        add(p);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ListFrame();
    }
}