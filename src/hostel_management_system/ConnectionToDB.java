
package hostel_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConnectionToDB {
    Connection Con = null;
    public Connection EstablishConnection()
    {
        try{
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
             Con = DriverManager.getConnection("jdbc:ucanaccess://E:\\DATABASE1.accdb");
//             JOptionPane.showMessageDialog(null, "Connected");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return Con;
    }
}
