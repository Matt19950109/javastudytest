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

                UserInfoDao userInfoDao = new UserInfoDao();
                UserInfoDto user = userInfoDao.checkPasswordHintUser(id);
                JOptionPane.showMessageDialog(null, user.getPw());
            }
        });

        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(b1);

        add(p1);

        setVisible(true);
    }
}
