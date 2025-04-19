
package hostel_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Login {
    
    String Name,Pass;
    ConnectionToDB Con1 = new ConnectionToDB();
    Connection Conn = Con1.EstablishConnection();

    Statement Smt = null;
    PreparedStatement PSmt = null;
    ResultSet Res = null;

    public boolean AdminLogin(String UserName, String UserPass) {
        String Str = "select * from Login_tbl where UserName = '" + UserName + "' and UserPass = '" + UserPass + "'";
        boolean A;
        try {
            PSmt = Conn.prepareStatement(Str);
            Res = PSmt.executeQuery();
            if (Res.next()) {
                A = true;
            } else {
                A = false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            A = false;
        }
        return A;
    }
    
    public boolean StudentLogin(String UserName, String UserPass) {
        String Str = "select * from StudentLogin_tbl where UserName = '" + UserName + "' and UserPass = '" + UserPass + "'";
        boolean A;
        try {
            PSmt = Conn.prepareStatement(Str);
            Res = PSmt.executeQuery();
            if (Res.next()) {
                A = true;
            } else {
                A = false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            A = false;
        }
        return A;
    }
}
