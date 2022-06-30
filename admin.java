import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;

 

public class admin {
    private static JTable table;
    private static JTable table_1;
    public static void main(String[] args) {
        showWindow();
    }

 

 

 

    public static void showWindow() {
        JFrame frame = new JFrame("Admin");
        frame.setAlwaysOnTop(true);
        frame.setBounds(100,100,674,428);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JButton show = new JButton("Show ");
        show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection conn = null ;
                conn = sql_conector.dbconnector();
                try {
                    login li = new login();
                    String query = "select * from users ";
                    PreparedStatement pst =conn.prepareStatement(query);
                    ResultSet rs = pst.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    
                }catch (Exception e1) {
                    e1.printStackTrace();
                }
                try {
                    login li = new login();
                    String query = "select * from materials ";
                    PreparedStatement pst =conn.prepareStatement(query);
                    ResultSet rs = pst.executeQuery();
                    table_1.setModel(DbUtils.resultSetToTableModel(rs));
                    
                }catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        show.setFont(new Font("Tahoma", Font.PLAIN, 18));
        show.setBounds(29, 323, 128, 37);
        frame.getContentPane().add(show);
        
        JButton add = new JButton("Add");
        add.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                insert i1 = new insert();
                i1.showWindow();
            }
        });
        add.setBounds(343, 323, 128, 37);
        frame.getContentPane().add(add);
        
        JButton delete = new JButton("Delete");
        delete.setFont(new Font("Tahoma", Font.PLAIN, 18));
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                delete d1 = new delete();
                d1.showWindow();
            }
        });
        delete.setBounds(500, 323, 128, 37);
        frame.getContentPane().add(delete);
        
        JScrollPane results = new JScrollPane();
        results.setBounds(53, 206, 554, 90);
        frame.getContentPane().add(results);
        
        table_1 = new JTable();
        results.setViewportView(table_1);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(52, 87, 556, 96);
        frame.getContentPane().add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);   
        
        JButton search = new JButton("Search");
        search.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.setVisible(false);
        		search s1 = new search();
        		s1.main(null);
        	}
        });
        search.setFont(new Font("Tahoma", Font.PLAIN, 18));
        search.setBounds(186, 323, 128, 37);
        frame.getContentPane().add(search);
        
        JButton logout = new JButton("Logout");
        logout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.setVisible(false);
				login l1 = new login();
				l1.main(null);
        	}
        });
        logout.setFont(new Font("Tahoma", Font.PLAIN, 18));
        logout.setBounds(28, 31, 128, 37);
        frame.getContentPane().add(logout);
        frame.setVisible(true);
    }        
}