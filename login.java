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

public class login {

	public JFrame frame;
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
					window.frame.setVisible(true);
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
	        frame = new JFrame();
	        frame.setBounds(100, 100, 243, 350);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().setLayout(null);
	        
	        JLabel lblNewLabel = new JLabel("Login Form");
	        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	        lblNewLabel.setBounds(79, 11, 81, 34);
	        frame.getContentPane().add(lblNewLabel);
	        
	        JLabel lblNewLabel_1 = new JLabel("Username");
	        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	        lblNewLabel_1.setBounds(20, 66, 90, 20);
	        frame.getContentPane().add(lblNewLabel_1);
	        
	        JLabel lblNewLabel_2 = new JLabel("Password");
	        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	        lblNewLabel_2.setBounds(20, 151, 81, 20);
	        frame.getContentPane().add(lblNewLabel_2);
	        
	        username = new JTextField();
	        username.setBounds(20, 97, 136, 20);
	        frame.getContentPane().add(username);
	        username.setColumns(10);
	        
	        password = new JPasswordField();
	        password.setBounds(20, 193, 140, 20);
	        frame.getContentPane().add(password);
	        
	        JButton login = new JButton("Login");
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
	                       
	                        frame.setVisible(false);
	                    	
	                    	admin ad = new admin();
	                    	
	                    	ad.showWindow();
	                    	
	                    }
	                    else {    Statement stmt1=conn.createStatement();
	                    String sql1 = "select * from users where user_name = '"+username.getText()+"' and password ='"+password.getText()+"'";
	                    ResultSet rs1 = stmt1.executeQuery(sql1);
	                    if(rs1.next()) {
	                    	
	                    	frame.setVisible(false);
	                    	
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
	        login.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	        login.setBounds(71, 251, 89, 23);
	        frame.getContentPane().add(login);
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
