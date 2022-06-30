import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class search {
	private static JTextField id;

	public static void main(String[] args) {
	    showWindow();

	}
	Connection conn =null ;
	private static JTable student_data;
	private static JTable results;
	public static void showWindow() {
		JFrame frame = new JFrame("Delete");
		frame.setAlwaysOnTop(true);
		frame.setBounds(100,100,644,395);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		id = new JTextField();
		id.setBounds(252, 218, 117, 30);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Student Id");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(111, 218, 117, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Connection conn = null ;
                conn = sql_conector.dbconnector();
                try {
                    login li = new login();
                    String query = "select * from users where sudent_id ="+id.getText();
                    PreparedStatement pst =conn.prepareStatement(query);
                    ResultSet rs = pst.executeQuery();
                    student_data.setModel(DbUtils.resultSetToTableModel(rs));
                    
                }catch (Exception e1) {
                    e1.printStackTrace();
                }
                try {
                    login li = new login();
                    String query = "select * from materials where student_id ="+id.getText() ;
                    PreparedStatement pst =conn.prepareStatement(query);
                    ResultSet rs = pst.executeQuery();
                    results.setModel(DbUtils.resultSetToTableModel(rs));
                    
                }catch (Exception e1) {
                    e1.printStackTrace();
                }
			}
		});
		confirm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		confirm.setBounds(400, 218, 101, 30);
		frame.getContentPane().add(confirm);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
                admin a1 = new admin();
                a1.main(null);
			}
		});
		back.setFont(new Font("Tahoma", Font.PLAIN, 14));
		back.setBounds(264, 290, 101, 30);
		frame.getContentPane().add(back);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 35, 496, 72);
		frame.getContentPane().add(scrollPane);
		
		student_data = new JTable();
		scrollPane.setViewportView(student_data);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(55, 129, 497, 65);
		frame.getContentPane().add(scrollPane_1);
		
		results = new JTable();
		scrollPane_1.setViewportView(results);
		
		frame.setVisible(true);
		
		
	}
}
