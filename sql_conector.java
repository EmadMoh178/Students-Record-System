
import java.sql.*;
import javax.swing.*;

 

public class sql_conector {
    
    Connection conn = null;    
    
    public static Connection dbconnector() {
        try {
            
            Class.forName("org.sqlite.JDBC");
            Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ahmed Awd Allah\\eclipse-workspace\\Student_Database1.db");
            //JOptionPane.showMessageDialog(null, "DataBase connected");
            return conn;
            
        }catch(Exception e) {            
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}