//Insert class
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

 

 

 

public class insert {

 

 

 

    public static void main(String[] args) {
        showWindow();

 

 

 

    }
    Connection conn =null ;
    private static JTextField student_id;
    private static JTextField birthdate;
    private static JTextField name;
    private static JTextField address;
    private static JTextField id_number;
    private static JTextField username;
    private static JTextField password;
    public static void showWindow() {
        JFrame frame = new JFrame("Delete");
        frame.setAlwaysOnTop(true);
        frame.setBounds(100,100,583,251);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Student ID");
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(10, 11, 78, 30);
        frame.getContentPane().add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                admin a1 = new admin();
                a1.main(null);
            }
        });
        btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
        btnNewButton.setBounds(422, 156, 101, 30);
        frame.getContentPane().add(btnNewButton);
        
        student_id = new JTextField();
        student_id.setBounds(98, 18, 160, 20);
        frame.getContentPane().add(student_id);
        student_id.setColumns(10);
        
        JLabel lblBirthdate = new JLabel("Birthdate");
        lblBirthdate.setHorizontalAlignment(SwingConstants.LEFT);
        lblBirthdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblBirthdate.setBounds(10, 44, 78, 30);
        frame.getContentPane().add(lblBirthdate);
        
        birthdate = new JTextField();
        birthdate.setColumns(10);
        birthdate.setBounds(98, 51, 160, 20);
        frame.getContentPane().add(birthdate);
        
        JButton btnAdd = new JButton("Add Student to Database");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection conn = null ;
                conn = sql_conector.dbconnector();
                //"select * from admin where user_name = '"+username.getText()+"' and password ='"+password.getText()+"'" 
                //"INSERT INTO users values(1,'17/8/2002','Emad Mohamed','Ismailia',3012537564907,'Emad_Moh',178)";
                try {
                    Statement stmt=conn.createStatement();
                    String sql = "INSERT INTO users values("+student_id.getText()+",'"+birthdate.getText()+"','"+name.getText()+"','"+address.getText()+"',"+id_number.getText()+",'"+username.getText()+"',"+password.getText()+")";
                    ResultSet rs =stmt.executeQuery(sql);  
                    /*if(rs.next()) {
                    	JOptionPane.showMessageDialog(null, "Added successfully");
                    }*/
                    
                }catch (Exception e1) {
                    e1.printStackTrace();
                }
                
            }
        });
        btnAdd.setFont(new Font("Arial", Font.PLAIN, 15));
        btnAdd.setBounds(20, 156, 195, 30);
        frame.getContentPane().add(btnAdd);
        
        JLabel lblFullName = new JLabel("Full Name");
        lblFullName.setHorizontalAlignment(SwingConstants.LEFT);
        lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblFullName.setBounds(10, 79, 78, 30);
        frame.getContentPane().add(lblFullName);
        
        name = new JTextField();
        name.setColumns(10);
        name.setBounds(98, 82, 160, 20);
        frame.getContentPane().add(name);
        
        JLabel LabelAddress = new JLabel("Address");
        LabelAddress.setHorizontalAlignment(SwingConstants.LEFT);
        LabelAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        LabelAddress.setBounds(10, 112, 78, 30);
        frame.getContentPane().add(LabelAddress);
        
        address = new JTextField();
        address.setColumns(10);
        address.setBounds(98, 119, 160, 20);
        frame.getContentPane().add(address);
        
        JLabel lblIdNumber = new JLabel("ID Number");
        lblIdNumber.setHorizontalAlignment(SwingConstants.LEFT);
        lblIdNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblIdNumber.setBounds(291, 11, 88, 30);
        frame.getContentPane().add(lblIdNumber);
        
        id_number = new JTextField();
        id_number.setColumns(10);
        id_number.setBounds(394, 18, 160, 20);
        frame.getContentPane().add(id_number);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblUsername.setBounds(291, 44, 93, 30);
        frame.getContentPane().add(lblUsername);
        
        username = new JTextField();
        username.setColumns(10);
        username.setBounds(394, 51, 160, 20);
        frame.getContentPane().add(username);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPassword.setBounds(291, 79, 93, 30);
        frame.getContentPane().add(lblPassword);
        
        password = new JTextField();
        password.setColumns(10);
        password.setBounds(394, 86, 160, 20);
        frame.getContentPane().add(password);
        
        JButton records = new JButton("Add Grades");
        records.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                add_records a1 = new add_records();
                a1.showWindow();
            }
        });
        records.setFont(new Font("Arial", Font.PLAIN, 15));
        records.setBounds(252, 156, 125, 30);
        frame.getContentPane().add(records);
        
        frame.setVisible(true);
        
        
    }
}