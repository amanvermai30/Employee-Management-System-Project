package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MysqlConnectivity {

    Connection c;
    Statement s;

    public MysqlConnectivity(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///employee_management_system","root","root");
            s = c.createStatement();
        } catch (Exception e){

            e.printStackTrace();
        }
    }
}
