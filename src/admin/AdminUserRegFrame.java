package admin;

import dao.UserInfoDao;
import login.LoginFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminUserRegFrame extends JFrame {
    public AdminUserRegFrame(){
        setTitle("ユーザー登録");
        setSize(500,250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2,1));

        JPanel userRegister = new JPanel(new GridLayout(4,2));
        JLabel id = new JLabel("ID");
        JTextField idText = new JTextField();
        JLabel name = new JLabel("名前");
        JTextField nameText = new JTextField();

        JLabel auth = new JLabel("権限(通常、管理者)");
        JTextField authText = new JTextField();

        userRegister.add(id);
        userRegister.add(idText);
        userRegister.add(name);
        userRegister.add(nameText);

        add(userRegister);

        JPanel p1 = new JPanel();
        JButton registerButton = new JButton("登録");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idText.getText();
                String name = nameText.getText();

                UserInfoDao userInfoDao = new UserInfoDao();
                userInfoDao.registerUser(id, name);
                setVisible(false);
                new LoginFrame();
            }
        });

        p1.add(registerButton);

        add(p1);

        //add.(userRegister);

        setVisible(true);
    }

}
