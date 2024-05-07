package login;

import dao.UserInfoDao;
import dto.UserInfoDto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PwHintFrame extends JFrame {

    public PwHintFrame(){
        setTitle("楽しいJAVA-LOGIN");
        setSize(300,120);
        setLocationRelativeTo(null);

        JPanel p1 = new JPanel(new GridLayout(3, 2));
        JLabel l1 = new JLabel("ID");
        JTextField t1 = new JTextField(10);

        JLabel l2 = new JLabel("name");
        JTextField t2 = new JTextField(10);

        JButton b1 = new JButton("認証");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = t1.getText();
                String name = t2.getText();

                UserInfoDao userInfoDao = new UserInfoDao();
                UserInfoDto user = userInfoDao.checkPasswordHintUser(id, name);
                String input = user.getPw();

                //取得した文字列の最初と最後の一文字以外をアスタリスクに変換
                char firstChar = input.charAt(0);
                char lastChar = input.charAt(input.length()-1);
                String convAstalisk = input.substring(1,input.length() - 1).replaceAll(".","*");

                String output = firstChar + convAstalisk + lastChar;

                JOptionPane.showMessageDialog(null, output);
            }
        });

        JButton b2 = new JButton("戻る");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new LoginFrame();
            }
        });

        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(b1);
        p1.add(b2);

        add(p1);

        setVisible(true);
    }
}
