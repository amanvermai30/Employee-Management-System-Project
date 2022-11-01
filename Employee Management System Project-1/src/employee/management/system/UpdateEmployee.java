package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class UpdateEmployee extends JFrame implements ActionListener {


    JTextField educationField, nameField,fNameField,salaryField,addressField,phoneField,emailField,AadharField,designationField;
    JDateChooser jDateChooser;
    JComboBox cbEducation;
    JLabel empIDNumber;

    JButton addButton,backButton;
    String empId;
    UpdateEmployee( String empId ){
        this.empId = empId;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(300,30,500,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(name);

        JLabel labelName = new JLabel();
        labelName.setBounds(230,150,150,30);
        add(labelName);

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

        JLabel labelDob = new JLabel();
        labelDob.setBounds(230,200,150,30);
        add(labelDob);

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


        educationField = new JTextField();
        educationField.setBounds(600,300,150,30);
        educationField.setBackground(Color.WHITE);
        add(educationField);


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

        JLabel labelAadhar = new JLabel();
        labelAadhar.setBounds(600,350,150,30);
        add(labelAadhar);

        JLabel EmpId = new JLabel("Employee ID ");
        EmpId.setBounds(50,400,150,30);
        EmpId.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(EmpId);

        empIDNumber = new JLabel();
        empIDNumber.setBounds(230,400,150,30);
        empIDNumber.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(empIDNumber);

        addButton = new JButton("Update Details");
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

        try {
            MysqlConnectivity con = new MysqlConnectivity();
            String query = "Select * from employee where empId = '"+empId+"' ";
            ResultSet resultSet =  con.s.executeQuery(query);
            while (resultSet.next()){

                labelName.setText(resultSet.getString("name"));
                fNameField.setText(resultSet.getString("fatherName"));
                labelDob.setText(resultSet.getString("dob"));
                salaryField.setText(resultSet.getString("salary"));
                addressField.setText(resultSet.getString("address"));
                emailField.setText(resultSet.getString("email"));
                educationField.setText(resultSet.getString("education"));
                designationField.setText(resultSet.getString("designation"));
                phoneField.setText(resultSet.getString("phone"));
                labelAadhar.setText(resultSet.getString("aadhar"));

            }

        } catch (Exception ex ){
            ex.printStackTrace();
        }

        setSize(900,650);
        setLocation(230,40);
        setVisible(true);


    }

    public static void main(String[] args) {

       new UpdateEmployee("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == addButton ){

            String fatherName = fNameField.getText();
            String salary = salaryField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String education = String.valueOf(educationField.getText());
            String designation = designationField.getText();

            try {

                MysqlConnectivity con = new MysqlConnectivity();
                String query = "update employee set fatherName = '"+fatherName+"', salary = '"+salary+"'," +
                        "address = '"+address+"', phone = '"+phone+"', email = '"+email+"'," +
                        "education = '"+education+"',designation = '"+designation+"' where empId = '"+empId+"' " ;

                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated Successfully");
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
