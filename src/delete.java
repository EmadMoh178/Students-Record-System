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
import java.awt.Color;
import java.awt.Toolkit;

public class delete {
	private static JTextField id;

	public static void main(String[] args) {
	    showWindow();

	}
	Connection conn =null ;
	public static void showWindow() {
		JFrame frame = new JFrame("Delete");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBackground(Color.DARK_GRAY);
		frame.setAlwaysOnTop(true);
		frame.setBounds(100,100,315,395);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		id = new JTextField();
		id.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		id.setForeground(Color.DARK_GRAY);
		id.setBackground(new Color(245, 245, 245));
		id.setBounds(27, 118, 117, 30);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Student Id");
		lblNewLabel.setForeground(new Color(240, 128, 128));
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		lblNewLabel.setBounds(92, 60, 117, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JButton confirm = new JButton("Confirm");
		confirm.setForeground(Color.DARK_GRAY);
		confirm.setBackground(new Color(240, 128, 128));
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn =null ;
				conn =sql_conector.dbconnector();
				try {
					Statement stmt=conn.createStatement();
                    String sql = "DELETE FROM users WHERE sudent_id ="+id.getText();
                    stmt.executeQuery(sql);
					//JOptionPane.showMessageDialog(null, "Data deleted successfully.<3");
				}catch (Exception e1) {
				
					e1.printStackTrace();
				}
				try {
					Statement stmt=conn.createStatement();
                    String sql = "DELETE FROM materials WHERE student_id ="+id.getText();
                    stmt.executeQuery(sql);
					JOptionPane.showMessageDialog(null, "Data deleted successfully.<3");
				}catch (Exception e1) {
				
					e1.printStackTrace();
				}
			}
		});
		confirm.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		confirm.setBounds(171, 118, 101, 30);
		frame.getContentPane().add(confirm);
		
		JButton delete_all = new JButton("Delete All");
		delete_all.setForeground(Color.DARK_GRAY);
		delete_all.setBackground(new Color(240, 128, 128));
		delete_all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn =null ;
				conn =sql_conector.dbconnector();
				try {
					Statement stmt=conn.createStatement();
                    String sql = "DELETE FROM users ";
                    stmt.executeQuery(sql);
					//JOptionPane.showMessageDialog(null, "Data deleted successfully.<3");
				}catch (Exception e1) {
				
					e1.printStackTrace();
				}
				try {
					Statement stmt=conn.createStatement();
                    String sql = "DELETE FROM materials ";
                    stmt.executeQuery(sql);
					JOptionPane.showMessageDialog(null, "Data deleted successfully.<3");
				}catch (Exception e1) {
				
					e1.printStackTrace();
				}
			}
		});
		delete_all.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		delete_all.setBounds(88, 268, 124, 44);
		frame.getContentPane().add(delete_all);
		
		JButton back = new JButton("Back");
		back.setForeground(Color.DARK_GRAY);
		back.setBackground(new Color(240, 128, 128));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
                admin a1 = new admin();
                a1.main(null);
			}
		});
		back.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		back.setBounds(100, 200, 101, 30);
		frame.getContentPane().add(back);
		
		frame.setVisible(true);
		
		
	}
}
