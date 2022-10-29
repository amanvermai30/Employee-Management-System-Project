package employee.management.system;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame implements ActionListener {

    Splash(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(230,20,1200,40);
        add(heading);
        heading.setFont(new Font("serif", Font.PLAIN,40));
        heading.setForeground(Color.CYAN);


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Photos/Background.jpg"));
        Image i1 = imageIcon.getImage().getScaledInstance(1140,650,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(i1);
        JLabel img = new JLabel(imageIcon2);
        img.setBounds(70,70,1000,500);
        add(img);

        JButton clickButton = new JButton("CLICK HERE TO CONTINUE");
        clickButton.setBounds(450,200,200,50);
        clickButton.setBackground(Color.BLUE);
        clickButton.setForeground(Color.WHITE);
        clickButton.addActionListener(this);

        Border black = BorderFactory.createLineBorder(Color.CYAN);
        clickButton.setBorder(black);
        img.add(clickButton);


        setSize(1170,650);
        setLocation(110,35);
        setVisible(true);

        while (true){
            heading.setVisible(false);
            try {
                  Thread.sleep(500);
            }catch (Exception ignored){

            }
            heading.setVisible(true);
            try {
                Thread.sleep(500);
            }catch (Exception ignored){

            }
        }


    }

    public static void main(String[] args) {

        new Splash();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      setVisible(false);
      new LoginPage();

    }
}
