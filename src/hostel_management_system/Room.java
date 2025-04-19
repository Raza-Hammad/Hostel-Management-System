
package hostel_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;

public class Room extends Allotees implements Rent {
    private String Room_NO;

    public int getR_Bill() {
        return R_Bill;
    }

    public String getRoom_NO() {
        return Room_NO;
    }

    public void setRoom_NO(String Room_NO) {
        this.Room_NO = Room_NO;
    }
    
    public Room() {
    }

    String Name, Address, Contact;
    ConnectionToDB Con1 = new ConnectionToDB();
    Connection Conn = Con1.EstablishConnection();

    Statement Smt = null;
    PreparedStatement PSmt = null;
    ResultSet Res = null;
    
    public boolean AddRoom(String AlloteeName, String Address, String Contact) {
        String Str = "insert into Room_tbl(AlloteeName,Address,Contact)values('" +AlloteeName+ "','" +Address+ "','" +Contact+ "')";
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
    
    public boolean UpdateRoom(String UName, String Address, String Contact, int ID) {
     
        String Str = "Update Room_tbl set AlloteeName = '"+UName+"',Address = '"+Address+"', Contact = '" +Contact+"' where ID = '" + ID + "'";
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
    
    public boolean SearchRoomDetails(int ID) {
        String Str = "select * from Room_tbl where ID = '" + ID + "'";
        boolean A = false ;
        try {
            PSmt = Conn.prepareStatement(Str);
            Res = PSmt.executeQuery();
            while(Res.next())
            {
               Name = Res.getString("AlloteeName");
               Address = Res.getString("Address");
               Contact = Res.getString("Contact");
               A = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            A = false;
        }
        return A;
    }
    
    public boolean DeleteRoomDetails(int ID) {
        String Str = "delete from Room_tbl where ID = '" + ID + "'";
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

    @Override
    public int GenerateBills(boolean A) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
