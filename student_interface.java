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
		frmStudentInterface.setBackground(new Color(240, 240, 240));
		frmStudentInterface.setTitle("Student Data");
		frmStudentInterface.setAlwaysOnTop(true);
		frmStudentInterface.setBounds(100,100,768,497);
		frmStudentInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentInterface.getContentPane().setLayout(null);
		
		JButton logout = new JButton("Logout");
		logout.setFont(new Font("Tahoma", Font.PLAIN, 17));
		logout.setBounds(38, 50, 140, 37);
		frmStudentInterface.getContentPane().add(logout);
		
		JButton showrecordes= new JButton("Show Records");
		showrecordes.setFont(new Font("Tahoma", Font.PLAIN, 17));
		showrecordes.setBounds(456, 368, 140, 37);
		frmStudentInterface.getContentPane().add(showrecordes);
		showrecordes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmStudentInterface.setVisible(false);
				records r1 = new records();
				r1.showWindow();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 178, 679, 76);
		frmStudentInterface.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(SystemColor.control);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setShowGrid(false);
		table.setBorder(null);
		scrollPane.setViewportView(table);
		
		JButton studentData = new JButton("Show Data");
		studentData.setFont(new Font("Tahoma", Font.PLAIN, 17));
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
		studentData.setBounds(137, 368, 140, 37);
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
