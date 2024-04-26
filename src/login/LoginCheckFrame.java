package login;

import dao.UserInfoDao;
import main.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginCheckFrame extends JFrame {
    public LoginCheckFrame(){
        setTitle("楽しいJAVA-パス変更");
        setSize(300,120);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        JPanel p1 = new JPanel(new GridLayout(5,3));

        JLabel label = new JLabel("idを入力");
        JTextField idText = new JTextField(10);

//        JLabel l0 = new JLabel("前のパスワードを入力");
//        JPasswordField beforePw = new JPasswordField(10);

        JLabel l1 = new JLabel("新パスワードを入力");
        JPasswordField t1 = new JPasswordField(10);

        JLabel l2 = new JLabel("新パスワードを再度入力");
        JPasswordField t2 = new JPasswordField(10);

        p1.add(label);
        p1.add(idText);
//        p1.add(l0);
//        p1.add(beforePw);
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);



        JPanel p2 = new JPanel();
        JButton b1 = new JButton("登録");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id = idText.getText();

//                char[] beforePwArray = t1.getPassword();
//                String beforePw = new String(beforePwArray);  // char[]를 String으로 변환

                char[] pwArray1 = t1.getPassword();
                String pw1 = new String(pwArray1);  // char[]를 String으로 변환

                char[] pwArray2 = t2.getPassword();
                String pw2 = new String(pwArray2);  // char[]를 String으로 변환

                UserInfoDao userInfoDao = new UserInfoDao();

                if(pw1.equals(pw2)){
                    JOptionPane.showMessageDialog(null, "パスワードを変更しました");

                    UserInfoDao changePw = new UserInfoDao();
                    changePw.changePassword(id, pw1);
                    setVisible(false);
                    new MainFrame();
                }
            }
        });

        p1.add(b1);
        add(p1);

        setVisible(true);
    }
}
