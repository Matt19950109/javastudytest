package login;

import admin.AdminMainFrame;
import dao.UserInfoDao;
import dto.UserInfoDto;
import main.MainFrame;
import util.DbConn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

                UserInfoDao userInfoDao = new UserInfoDao();
                boolean login_success = userInfoDao.login(id, pw);
                UserInfoDto userInfoDto = userInfoDao.checkAuthUser(id, pw);

                if(login_success) {
                    //管理者の有無で表示画面を変更
                    if(userInfoDto.getAuth() == 1){
                        JOptionPane.showMessageDialog(null, "success");

                        //初期パスワードの条件変更
                        if(userInfoDto.getPw().equals("weavus")){
                            JOptionPane.showMessageDialog(null, "パスワードを変更してください");
                            setVisible(false);

                            //weavusパスワードのユーザーを取得
                            new LoginCheckFrame();

                        } else {
                            setVisible(false);
                            new MainFrame();
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "管理者ですね");
                        setVisible(false);
                        new AdminMainFrame();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "failure");
                }
            }
        });

        p2.add(b1);
        add(p2, BorderLayout.SOUTH);

        JPanel forgetPanel = new JPanel();
        JLabel forgetPw = new JLabel("パスワードを忘れた場合");
        forgetPw.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        forgetPw.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setVisible(false);
                new PwHintFrame();
            }
        });

        forgetPanel.add(forgetPw);
        p2.add(forgetPanel);

        // 最後の行に置くこと
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}