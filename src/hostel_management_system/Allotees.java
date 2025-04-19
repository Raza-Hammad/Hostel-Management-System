
package hostel_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Allotees {
    
    ConnectionToDB Con1 = new ConnectionToDB();
    Connection Conn = Con1.EstablishConnection();

    Statement Smt = null;
    PreparedStatement PSmt = null;
    ResultSet Res = null;
    
    public boolean UpdateUser(String UName, String UPass, String Contact, String Address, int ID) {
     
        String Str = "Update StudentLogin_tbl set UserName = '"+UName+"',UserPass = '"+UPass+"',Contact = '"+Contact+"',Address = '"+Address+"' where ID = '" + ID + "'";
        boolean A = false;
        try {
            Smt = Conn.createStatement();
            int Res = Smt.executeUpdate(Str);
            if (Res > 0) {

                A = true;
            } else {

                A = false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return A;
    } 
}
