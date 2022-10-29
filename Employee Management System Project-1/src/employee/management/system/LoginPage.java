package employee.management.system;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame {

    LoginPage(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel username = new JLabel("User Name");
        username.setBounds(40,20,100,30);
        add(username);

        JTextField textFieldUser = new JTextField();
        textFieldUser.setBounds(150,20,150,30);
        add(textFieldUser);

        JLabel passWord = new JLabel("Password");
        passWord.setBounds(40,60,100,30);
        add(passWord);

        JTextField textFieldPassWord = new JTextField();
        textFieldPassWord.setBounds(150,60,150,30);
        add(textFieldPassWord);

        JButton loginButton = new JButton("Login For Admin");
        loginButton.setBounds(150,110,150,30);
        loginButton.setBackground(Color.BLUE);
        loginButton.setForeground(Color.WHITE);
        add(loginButton);

        ImageIcon loginImg = new ImageIcon(ClassLoader.getSystemResource("Photos/login.png"));
        Image i1 = loginImg.getImage().getScaledInstance(250,150,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(i1);
        JLabel img = new JLabel(imageIcon2);
        img.setBounds(320,0,250,150);
        add(img);

        setSize(600,250);
        setLocation(110,35);
        setVisible(true);
    }

    public static void main(String[] args) {

        new LoginPage();
    }
}
