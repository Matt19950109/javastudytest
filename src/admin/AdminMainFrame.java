package admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMainFrame extends JFrame {
    public AdminMainFrame(){
        setTitle("楽しい-JAVA管理者");
        setSize(300,200);
        setLocationRelativeTo(null);

        JPanel p = new JPanel();
        JButton registration = new JButton("ユーザー登録");
        registration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEnabled(false);
                new AdminUserRegFrame();
            }
        });

        p.add(registration);
        add(p);

        setVisible(true);

    }

}
