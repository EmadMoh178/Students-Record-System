
import java.sql.*;
import javax.swing.*;

 

public class sql_conector {
    
    Connection conn = null;    
    
    public static Connection dbconnector() {
        try {
            
            Class.forName("org.sqlite.JDBC");
            Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\dodoe\\OneDrive\\Documents\\Student-Record-System\\database.db");
            return conn;
            
        }catch(Exception e) {            
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
