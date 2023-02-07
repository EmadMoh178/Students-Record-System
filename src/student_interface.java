import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class student_interface {
	private static JTable table;
	static String username;
	public student_interface(String uname) {
		this.username = uname;
	}

	public static void main(String[] args) {
		showWindow();
		
		
	}

	public static void showWindow() {
		JFrame frmStudentInterface = new JFrame("WINDOW 1");
		frmStudentInterface.getContentPane().setBackground(Color.DARK_GRAY);
		frmStudentInterface.setBackground(Color.DARK_GRAY);
		frmStudentInterface.setTitle("Student Data");
		frmStudentInterface.setAlwaysOnTop(true);
		frmStudentInterface.setBounds(100,100,768,497);
		frmStudentInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentInterface.getContentPane().setLayout(null);
		
		JButton logout = new JButton("Logout");
		logout.setForeground(Color.DARK_GRAY);
		logout.setBackground(new Color(240, 128, 128));
		logout.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		logout.setBounds(307, 336, 140, 37);
		frmStudentInterface.getContentPane().add(logout);
		
		JButton showrecordes= new JButton("Show Records");
		showrecordes.setForeground(Color.DARK_GRAY);
		showrecordes.setBackground(new Color(240, 128, 128));
		showrecordes.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		showrecordes.setBounds(456, 222, 140, 37);
		frmStudentInterface.getContentPane().add(showrecordes);
		
		
		showrecordes.addActionListener(new ActionListener() {
			int getID() {
				Connection conn = null ;
				conn = sql_conector.dbconnector();
				try {
					login li = new login();
					String query = "select sudent_id from users Where user_name ='"+username+"'";
					PreparedStatement pst =conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					return rs.getInt("sudent_id");
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				return 0;
			}
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = null ;
				conn = sql_conector.dbconnector();
				try {
					login li = new login();
					int id = getID();
					String query = "select * from materials Where student_id ="+id;
					PreparedStatement pst =conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(37, 87, 679, 76);
		frmStudentInterface.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(240, 128, 128));
		table.setBackground(Color.DARK_GRAY);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setShowGrid(false);
		table.setBorder(null);
		scrollPane.setViewportView(table);
		
		JButton studentData = new JButton("Show Data");
		studentData.setForeground(Color.DARK_GRAY);
		studentData.setBackground(new Color(240, 128, 128));
		studentData.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		studentData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null ;
				conn = sql_conector.dbconnector();
				try {
					login li = new login();
					String query = "select full_name ,address ,birth_date , id_number ,sudent_id from users Where user_name ='"+username+"'";
					PreparedStatement pst =conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		studentData.setBounds(158, 222, 140, 37);
		frmStudentInterface.getContentPane().add(studentData);
		
		logout.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				frmStudentInterface.setVisible(false);
				login l1 = new login();
				l1.main(null);
			}
		});
		
		
		frmStudentInterface.setVisible(true);
		
	}
}
