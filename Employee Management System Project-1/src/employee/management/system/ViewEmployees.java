package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class ViewEmployees extends JFrame {

    JTable table;
    Choice chEmployeeId;
    ViewEmployees(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        chEmployeeId = new Choice();
        chEmployeeId.setBounds(180,20,150,20);
        add(chEmployeeId);

        JLabel search = new JLabel("Search by Employee Id");
        search.setBounds(20,20,150,20);
        add(search);


        table = new JTable();

        try {

            MysqlConnectivity con = new MysqlConnectivity();
            ResultSet resultSet = con.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

            JScrollPane jScrollPane = new JScrollPane(table);
            jScrollPane.setBounds(0,100,1000,600);
            add(jScrollPane);

        }catch (Exception ex){
            ex.printStackTrace();
        }

        setSize(1000,600);
        setLocation(200,60);
        setVisible(true);

    }

    public static void main(String[] args) {

        new ViewEmployees();
    }
}
