package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployees extends JFrame implements ActionListener {

    JTable table;
    Choice chEmployeeId;

    JButton searchBtn,printBtn,updateBtn,backBtn;
    ViewEmployees(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        chEmployeeId = new Choice();
        chEmployeeId.setBounds(180,20,150,20);
        add(chEmployeeId);

        JLabel search = new JLabel("Search by Employee Id");
        search.setBounds(20,20,150,20);
        add(search);

        try {

            MysqlConnectivity con = new MysqlConnectivity();
            ResultSet resultSet = con.s.executeQuery("select * from employee");
            while (resultSet.next()){
                chEmployeeId.add(resultSet.getString("empId"));
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }


        table = new JTable();

        try {

            MysqlConnectivity con = new MysqlConnectivity();
            ResultSet resultSet = con.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception ex){
            ex.printStackTrace();
        }

        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(0,100,1000,600);
        add(jScrollPane);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(20,50,80,20);
        searchBtn.setFont(new Font("Tahoma",Font.BOLD,10));
        searchBtn.addActionListener(this);
        add(searchBtn);

        printBtn = new JButton("Print");
        printBtn.setBounds(120,50,80,20);
        printBtn.setFont(new Font("Tahoma",Font.BOLD,10));
        printBtn.addActionListener(this);
        add(printBtn);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(20,80,80,20);
        updateBtn.setFont(new Font("Tahoma",Font.BOLD,10));
        updateBtn.addActionListener(this);
        add(updateBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(120,80,80,20);
        backBtn.setFont(new Font("Tahoma",Font.BOLD,10));
        backBtn.addActionListener(this);
        add(backBtn);

        setSize(1000,600);
        setLocation(200,60);
        setVisible(true);

    }

    public static void main(String[] args) {

        new ViewEmployees();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == searchBtn){

            String query = "Select * from employee where empId =  '"+chEmployeeId.getSelectedItem()+"' ";
            try {

                MysqlConnectivity con = new MysqlConnectivity();
               ResultSet resultSet =  con.s.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(resultSet));

            } catch (Exception ex){
                ex.printStackTrace();
            }

        } else if (e.getSource() == printBtn) {

            try {

                table.print();
            }catch (Exception ex){
                ex.printStackTrace();
            }

        } else if (e.getSource() == updateBtn) {

        } else {
            setVisible(false);
            new HomePage();
        }
    }
}
