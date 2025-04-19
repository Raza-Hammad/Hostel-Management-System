
package hostel_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Hostel implements Rent{
    private String Name;
    private String Contact;
    private String Address;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Hostel() {
    }
           
    @Override
    public int GenerateBills(boolean A) {
        Room Ro = new Room();
        Mess Me = new Mess();

        if (A == true) {
            return Ro.getR_Bill() + Me.getM_Bill();
        } else {
            return Ro.getR_Bill();
        }
    }
    
    ConnectionToDB Con1 = new ConnectionToDB();
    Connection Conn = Con1.EstablishConnection();

    Statement Smt = null;
    PreparedStatement PSmt = null;
    ResultSet Res = null;
    
    public boolean AddComplain(String Complain) {
        String Str = "insert into Complain_tbl(Complain)values('" +Complain+ "')";
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
    
    public boolean DeleteComplain(int ID) {
        String Str = "delete from Complain_tbl where ID = '" + ID + "'";
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
