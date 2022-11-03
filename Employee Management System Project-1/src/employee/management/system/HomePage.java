package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame implements ActionListener {

    JButton addButton,viewButton,updateButton,removeButton;
    HomePage(){


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Photos/Background.jpg"));
        Image i1 = imageIcon.getImage().getScaledInstance(920,630,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(i1);
        JLabel img = new JLabel(imageIcon2);
        img.setBounds(0,0,920,630);
        add(img);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(120,20,400,40);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        img.add(heading);

        addButton = new JButton("Add Employee");
        addButton.setBounds(150,100,150,40);
        addButton.setFont(new Font("Tahoma",Font.BOLD,10));
        addButton.addActionListener(this);
        img.add(addButton);

        viewButton = new JButton("View Employees");
        viewButton.setBounds(340,100,150,40);
        viewButton.setFont(new Font("Tahoma",Font.BOLD,10));
        viewButton.addActionListener(this);
        img.add(viewButton);

        updateButton = new JButton("Update Employee");
        updateButton.setBounds(150,170,150,40);
        updateButton.setFont(new Font("Tahoma",Font.BOLD,10));
        updateButton.addActionListener(this);
        img.add(updateButton);

        removeButton = new JButton("Remove Employee");
        removeButton.setBounds(340,170,150,40);
        removeButton.setFont(new Font("Tahoma",Font.BOLD,10));
        removeButton.addActionListener(this);
        img.add(removeButton);




        setLayout(null);
        setSize(920,630);
        setLocation(250,70);
        setVisible(true);
    }

    public static void main(String[] args){
        new HomePage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == addButton ){
            setVisible(false);
            new AddEmployee();
            
        } else if (e.getSource() == viewButton) {
            setVisible(false);
            new ViewEmployees();
            
        } else if (e.getSource() == updateButton) {
            setVisible(false);
            new ViewEmployees();
            
        } else {
            new RemoveEmployee();
        }
    }
}
