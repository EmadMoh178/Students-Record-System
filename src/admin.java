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
import java.awt.Color;
import java.awt.Toolkit;

 

public class admin {
    private static JTable table;
    private static JTable table_1;
    public static void main(String[] args) {
        showWindow();
    }

 

 

 

    public static void showWindow() {
        JFrame frame = new JFrame("Admin");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ahmed Awd Allah\\eclipse-workspace\\Student_Record\\logo.png"));
        frame.setBackground(Color.DARK_GRAY);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setAlwaysOnTop(true);
        frame.setBounds(100,100,735,467);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JButton show = new JButton("Show ");
        show.setBackground(new Color(240, 128, 128));
        show.setForeground(Color.DARK_GRAY);
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
        show.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
        show.setBounds(30, 256, 128, 37);
        frame.getContentPane().add(show);
        
        JButton add = new JButton("Add");
        add.setBackground(new Color(240, 128, 128));
        add.setForeground(Color.DARK_GRAY);
        add.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                insert i1 = new insert();
                i1.showWindow();
            }
        });
        add.setBounds(30, 110, 128, 37);
        frame.getContentPane().add(add);
        
        JButton delete = new JButton("Delete");
        delete.setBackground(new Color(240, 128, 128));
        delete.setForeground(Color.DARK_GRAY);
        delete.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                delete d1 = new delete();
                d1.showWindow();
            }
        });
        delete.setBounds(30, 37, 128, 37);
        frame.getContentPane().add(delete);
        
        JScrollPane results = new JScrollPane();
        results.setBounds(186, 176, 495, 117);
        frame.getContentPane().add(results);
        
        table_1 = new JTable();
        table_1.setForeground(new Color(240, 128, 128));
        table_1.setBackground(Color.DARK_GRAY);
        results.setViewportView(table_1);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(186, 36, 495, 117);
        frame.getContentPane().add(scrollPane);
        
        table = new JTable();
        table.setForeground(new Color(240, 128, 128));
        table.setBackground(Color.DARK_GRAY);
        scrollPane.setViewportView(table);   
        
        JButton search = new JButton("Search");
        search.setBackground(new Color(240, 128, 128));
        search.setForeground(Color.DARK_GRAY);
        search.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.setVisible(false);
        		search s1 = new search();
        		s1.main(null);
        	}
        });
        search.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
        search.setBounds(30, 183, 128, 37);
        frame.getContentPane().add(search);
        
        JButton logout = new JButton("Logout");
        logout.setBackground(new Color(240, 128, 128));
        logout.setForeground(Color.DARK_GRAY);
        logout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.setVisible(false);
				login l1 = new login();
				l1.main(null);
        	}
        });
        logout.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
        logout.setBounds(30, 342, 128, 37);
        frame.getContentPane().add(logout);
        frame.setVisible(true);
    }        
}