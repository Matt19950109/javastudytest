package list;

import main.MainFrame;
import util.DbConn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import static javax.swing.JOptionPane.YES_OPTION;

public class ListFrame extends JFrame {

    public ListFrame() {
        JPanel p = new JPanel(new GridLayout(4,1));

        JPanel p1 = new JPanel();

        DbConn dbConn = new DbConn();
        ResultSet rs = dbConn.getQuestionList();
        String content = "";
        String selection = "";

        try {
            while (rs.next()) {
                content = rs.getString("content");
                selection = rs.getString("selection");
            }

        } catch (SQLException e) {
            System.out.println("");
        }



        JTextArea t1 = new JTextArea(10,30);
        t1.append(content);

        JScrollPane scrollPane = new JScrollPane(t1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        p1.add(scrollPane);
        p.add(p1);

        setTitle("楽しいJAVA-LIST(1/10)");
        setSize(400,500);
        setLocationRelativeTo(null);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        String[] a = selection.split(",");
        // 選択肢数
        JRadioButton[] radio = new JRadioButton[a.length];
        for(int i=0; i < a.length; i++) {
            radio[i] = new JRadioButton(a[i]);
        }

        ButtonGroup bg = new ButtonGroup();
        for(int i=0; i < a.length; i++) {
            bg.add(radio[i]);
        }

        for(int i=0; i < a.length; i++) {
            p2.add(radio[i]);
        }

        p.add(p2);

        JPanel p3 = new JPanel(new GridLayout(1,3));
        JButton b1 = new JButton("前");
        b1.setEnabled(false);
        JButton b2 = new JButton("提出");
//        b2.setEnabled(false);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "お疲れ様です。メイン画面に戻ります。");
                setVisible(false);
                new MainFrame();
            }
        });

        JButton b3 = new JButton("次");
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
                if(result == YES_OPTION) {
                    new MainFrame();
                }
            }
        });
        p4.add(b4);

        p.add(p4);


        add(p);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ListFrame();
    }
}