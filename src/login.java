import java.awt.EventQueue;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.instrument.ClassFileTransformer;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class login {

	public JFrame frmStudentRecord;
	public JTextField username;
	public JPasswordField password;
	public String uname ;
	public String pass ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmStudentRecord.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	Connection conn =null ;
	
	
	
	public login() {
		initialize();
        conn =sql_conector.dbconnector();
	}
	

	
	    /**
	     * Initialize the contents of the frame.
	     */
	    public void initialize() {
	        frmStudentRecord = new JFrame();
	        frmStudentRecord.setTitle("Student Record");
	        frmStudentRecord.getContentPane().setBackground(Color.DARK_GRAY);
	        frmStudentRecord.setBackground(Color.DARK_GRAY);
	        frmStudentRecord.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ahmed Awd Allah\\eclipse-workspace\\Student_Record\\logo.png"));
	        frmStudentRecord.setBounds(100, 100, 243, 350);
	        frmStudentRecord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frmStudentRecord.getContentPane().setLayout(null);
	        
	        JLabel lblNewLabel_1 = new JLabel("Username");
	        lblNewLabel_1.setBackground(new Color(205, 92, 92));
	        lblNewLabel_1.setForeground(new Color(240, 128, 128));
	        lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	        lblNewLabel_1.setBounds(74, 66, 81, 20);
	        frmStudentRecord.getContentPane().add(lblNewLabel_1);
	        
	        JLabel lblNewLabel_2 = new JLabel("Password");
	        lblNewLabel_2.setBackground(new Color(205, 92, 92));
	        lblNewLabel_2.setForeground(new Color(240, 128, 128));
	        lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	        lblNewLabel_2.setBounds(79, 161, 71, 20);
	        frmStudentRecord.getContentPane().add(lblNewLabel_2);
	        
	        username = new JTextField();
	        username.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
	        username.setForeground(Color.DARK_GRAY);
	        username.setBackground(new Color(245, 245, 245));
	        username.setBounds(46, 97, 136, 26);
	        frmStudentRecord.getContentPane().add(username);
	        username.setColumns(10);
	        
	        password = new JPasswordField();
	        password.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
	        password.setForeground(Color.DARK_GRAY);
	        password.setBackground(new Color(245, 245, 245));
	        password.setBounds(44, 193, 140, 26);
	        frmStudentRecord.getContentPane().add(password);
	        
	        JButton login = new JButton("Login");
	        login.setForeground(Color.DARK_GRAY);
	        login.setVerticalAlignment(SwingConstants.TOP);
	        login.setBackground(new Color(240, 128, 128));
	        login.addActionListener(new ActionListener() {
	        	
	            public void actionPerformed(ActionEvent e) {
	            
	        conn = sql_conector.dbconnector()  ; 
	        	
	                try {
	                	
	                	uname = username.getText();
	    	        	pass = password.getText();
	                    new student_interface(uname);
	    	        	
	    	        	Statement stmt=conn.createStatement();

	                   //"INSERT INTO users values(1,'17/8/2002','Emad Mohamed','Ismailia',3012537564907,'Emad_Moh',178)";
	                    String sql = "select * from admin where user_name = '"+username.getText()+"' and password ='"+password.getText()+"'";
	                    ResultSet rs = stmt.executeQuery(sql);
	                    
	                    if(rs.next()) {
	                       
	                        frmStudentRecord.setVisible(false);
	                    	
	                    	admin ad = new admin();
	                    	
	                    	ad.showWindow();
	                    	
	                    }
	                    else {    Statement stmt1=conn.createStatement();
	                    String sql1 = "select * from users where user_name = '"+username.getText()+"' and password ='"+password.getText()+"'";
	                    ResultSet rs1 = stmt1.executeQuery(sql1);
	                    if(rs1.next()) {
	                    	
	                    	frmStudentRecord.setVisible(false);
	                    	
	                    	student_interface si = new student_interface(uname);
	                    	
	                    	si.showWindow();
	                    	
	                    }else {
	                        JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
	                        }
	                    
	                   }
	                    conn.close();
	                }catch(Exception exp) {
	                    System.out.println(exp);
	                }
	            }
	        });
	        login.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
	        login.setBounds(70, 244, 89, 31);
	        frmStudentRecord.getContentPane().add(login);
	    }
	    private class SwingAction extends AbstractAction {
	        public SwingAction() {
	            putValue(NAME, "SwingAction");
	            putValue(SHORT_DESCRIPTION, "Some short description");
	        }
	        public void actionPerformed(ActionEvent e) {
	        }
	    }
	    private class SwingAction_1 extends AbstractAction {
	        public SwingAction_1() {
	            putValue(NAME, "SwingAction_1");
	            putValue(SHORT_DESCRIPTION, "Some short description");
	        }
	        public void actionPerformed(ActionEvent e) {
	        }
	    }
	}
