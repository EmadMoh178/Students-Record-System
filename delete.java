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

public class delete {
	private static JTextField id;

	public static void main(String[] args) {
	    showWindow();

	}
	Connection conn =null ;
	public static void showWindow() {
		JFrame frame = new JFrame("Delete");
		frame.setAlwaysOnTop(true);
		frame.setBounds(100,100,315,395);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		id = new JTextField();
		id.setBounds(27, 118, 117, 30);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Student Id");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(92, 60, 117, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JButton confirm = new JButton("Confirm");
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
		confirm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		confirm.setBounds(171, 118, 101, 30);
		frame.getContentPane().add(confirm);
		
		JButton delete_all = new JButton("Delete All");
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
		delete_all.setFont(new Font("Tahoma", Font.PLAIN, 14));
		delete_all.setBounds(88, 268, 124, 44);
		frame.getContentPane().add(delete_all);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
                admin a1 = new admin();
                a1.main(null);
			}
		});
		back.setFont(new Font("Tahoma", Font.PLAIN, 14));
		back.setBounds(103, 200, 101, 30);
		frame.getContentPane().add(back);
		
		frame.setVisible(true);
		
		
	}
}
