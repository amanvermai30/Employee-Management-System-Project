package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class AddEmployee extends JFrame implements ActionListener {

    Random ran = new Random();
    int num = ran.nextInt(999999);

    JTextField nameField,fNameField,salaryField,addressField,phoneField,emailField,AadharField,designationField;
    JDateChooser jDateChooser;
    JComboBox cbEducation;
    JLabel empIDNumber;

    JButton addButton,backButton;
    AddEmployee(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(300,30,500,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(name);

        nameField = new JTextField();
        nameField.setBounds(230,150,150,30);
        add(nameField);

        JLabel fatherName = new JLabel("Father's Name");
        fatherName.setBounds(430,150,150,30);
        fatherName.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(fatherName);

        fNameField = new JTextField();
        fNameField.setBounds(600,150,150,30);
        add(fNameField);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(dob);

        jDateChooser = new JDateChooser();
        jDateChooser.setBounds(230,200,150,30);
        add(jDateChooser);

        JLabel salary = new JLabel("Employee Salary");
        salary.setBounds(430,200,150,30);
        salary.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(salary);

        salaryField = new JTextField();
        salaryField.setBounds(600,200,150,30);
        add(salaryField);

        JLabel address = new JLabel("Address");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(address);

        addressField = new JTextField();
        addressField.setBounds(230,250,150,30);
        add(addressField);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(430,250,150,30);
        phone.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(phone);

        phoneField = new JTextField();
        phoneField.setBounds(600,250,150,30);
        add(phoneField);

        JLabel email = new JLabel("Email");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(email);

        emailField = new JTextField();
        emailField.setBounds(230,300,150,30);
        add(emailField);

        JLabel education = new JLabel("Education");
        education.setBounds(430,300,150,30);
        education.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(education);

        String[] course = {"B.TECH","B.COM","BBA","BA","BSC","MBA","M.TECH","M.COM","MA","MCA","MSC"};

        cbEducation = new JComboBox(course);
        cbEducation.setBounds(600,300,150,30);
        cbEducation.setBackground(Color.WHITE);
        add(cbEducation);


        JLabel designation = new JLabel("Designation");
        designation.setBounds(50,350,150,30);
        designation.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(designation);

        designationField = new JTextField();
        designationField.setBounds(230,350,150,30);
        add(designationField);

        JLabel Aadhar = new JLabel("Aadhar");
        Aadhar.setBounds(430,350,150,30);
        Aadhar.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(Aadhar);

        AadharField = new JTextField();
        AadharField.setBounds(600,350,150,30);
        add(AadharField);

        JLabel empId = new JLabel("Employee ID ");
        empId.setBounds(50,400,150,30);
        empId.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(empId);

        empIDNumber = new JLabel(String.valueOf(num));
        empIDNumber.setBounds(230,400,150,30);
        empIDNumber.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(empIDNumber);

        addButton = new JButton("Add Details");
        addButton.setBounds(250,500,150,40);
        addButton.setFont(new Font("Tahoma",Font.PLAIN,17));
        addButton.setForeground(Color.white);
        addButton.setBackground(Color.BLUE);
        addButton.addActionListener(this);
        add(addButton);

        backButton = new JButton("Back");
        backButton.setBounds(450,500,150,40);
        backButton.setFont(new Font("Tahoma",Font.PLAIN,17));
        backButton.setForeground(Color.white);
        backButton.setBackground(Color.BLUE);
        backButton.addActionListener(this);
        add(backButton);

        setSize(900,650);
        setLocation(230,40);
        setVisible(true);


    }

    public static void main(String[] args) {

        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == addButton ){

            String name = nameField.getText();
            String fatherName = fNameField.getText();
            String dob = ( (JTextField) jDateChooser.getDateEditor().getUiComponent()).getText();
            String salary = salaryField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String education = ( String) cbEducation.getSelectedItem();
            String designation = designationField.getText();
            String aadhar = AadharField.getText();
            String empId = empIDNumber.getText();

            try {

                MysqlConnectivity con = new MysqlConnectivity();
                String query = "insert into employee values('"+name+"','"+fatherName+"','"+dob+"','"+salary+"'," +
                        "'"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"'," +
                        "'"+aadhar+"','"+empId+"')";

                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Added Successfully");
                setVisible(false);
                new HomePage();

            } catch (Exception ex){
                ex.printStackTrace();
            }

        } else {
            setVisible(false);
            new HomePage();
        }
    }
}
