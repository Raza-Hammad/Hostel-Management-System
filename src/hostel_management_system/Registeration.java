
package hostel_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Registeration {
    
    String Name,Pass;
    ConnectionToDB Con1 = new ConnectionToDB();
    Connection Conn = Con1.EstablishConnection();

    Statement Smt = null;
    PreparedStatement PSmt = null;
    ResultSet Res = null;
    
    
    public boolean AddUser(String UserName, String UserPass, String Age, String Gender, String Contact, String Email, String Address) {
        String Str = "insert into StudentLogin_tbl(UserName,UserPass,Age,Gender,Contact,Email,Address)values('" + UserName + "','" + UserPass + "','" + Age + "','" + Gender + "','" + Contact + "','" + Email + "','" + Address + "')";
        boolean A = false;
        try {
            Smt = Conn.createStatement();
            int Res = Smt.executeUpdate(Str);
            if (Res > 0) {
//                JOptionPane.showMessageDialog(null, "Inserted");
                A = true;
            } else {
//               JOptionPane.showMessageDialog(null, "Error");
                A = false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return A;
    }
}
