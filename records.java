	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils; 
public class records {
	private static JTable table;
	private static JTextField textField;

	public static void main(String[] args) {
		
     showWindow();
	}

		public static void showWindow() {
			JFrame frame = new JFrame("Records");
			frame.setAlwaysOnTop(true);
			frame.setBounds(100,100,563,454);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(41, 39, 466, 108);
			frame.getContentPane().add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			textField = new JTextField();
			textField.setBounds(246, 207, 150, 37);
			frame.getContentPane().add(textField);
			textField.setColumns(10);
			
			JButton show = new JButton("Show");
			show.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 Connection conn = null ;
		                conn = sql_conector.dbconnector();
					 try {
		                    login li = new login();
		                    String query = "select * from materials Where student_id ="+textField.getText();
		                    PreparedStatement pst =conn.prepareStatement(query);
		                    ResultSet rs = pst.executeQuery();
		                    table.setModel(DbUtils.resultSetToTableModel(rs));
		                    
		                }catch (Exception e1) {
		                    e1.printStackTrace();
		                }
				}
			});
			show.setFont(new Font("Tahoma", Font.PLAIN, 17));
			show.setBounds(199, 265, 128, 29);
			frame.getContentPane().add(show);
			
		
			JLabel lblNewLabel = new JLabel("Student ID");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel.setBounds(142, 207, 102, 37);
			frame.getContentPane().add(lblNewLabel);
			
			JButton back = new JButton("Back");
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
	                String uname = null;
					student_interface s1 = new student_interface(uname);
	                s1.showWindow();
				}
			});
			back.setFont(new Font("Tahoma", Font.PLAIN, 17));
			back.setBounds(199, 343, 128, 29);
			frame.getContentPane().add(back);
			
			frame.setVisible(true);
			
			
		}
	}
