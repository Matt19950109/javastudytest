package login;

import main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFlame extends JFrame {

    public LoginFlame() {
        setTitle("WEAVUS-JAVA");
        setSize(300,200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,2));
        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("ID");
        JTextField t1 = new JTextField(10);

        p1.add(l1);
        p1.add(t1);
        add(p1);

        JPanel p2 = new JPanel();
        JLabel j2 = new JLabel("PW");
        JPasswordField t2 = new JPasswordField(10);

        p2.add(j2);
        p2.add(t2);
        add(p2);


        JPanel p3 = new JPanel();
        JButton b1 = new JButton("Login");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "input id " + t1.getText());

                }

        });

        p3.add(b1);
        add(p3);
        setVisible(false);
    }


    public static void main(String[] args) {
        //new LoginFlame();
        Main main = new Main();
    }
}
