package login;

import main.MainFrame;
import util.DbConn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    public static String userId;

    public LoginFrame() {
        setTitle("楽しいJAVA-LOGIN");
        setSize(300,120);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JPanel p1 = new JPanel(new GridLayout(2,3));
        JLabel l1 = new JLabel("ID");
        JTextField t1 = new JTextField(10);

        JLabel l2 = new JLabel("PW");
        JPasswordField t2 = new JPasswordField(10);
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);

        add(p1, BorderLayout.CENTER);
        JPanel p2 = new JPanel();
        JButton b1 = new JButton("login");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = t1.getText();
                char[] pwArray = t2.getPassword();
                String pw = new String(pwArray);  // char[]를 String으로 변환

                DbConn dbConn = new DbConn();
                boolean login_success = dbConn.login(id, pw);

                if(login_success) {
                    JOptionPane.showMessageDialog(null, "success");
                    setVisible(false);
                    new MainFrame();
                } else {
                    JOptionPane.showMessageDialog(null, "failure");
                }
            }
        });

        p2.add(b1);
        add(p2, BorderLayout.SOUTH);

        // 最後の行に置くこと
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}