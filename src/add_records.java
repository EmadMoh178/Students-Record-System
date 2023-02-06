//add_records class
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

 


public class add_records {
    private static JTextField id;
    public static void main(String[] args) {
        showWindow();
    }
    
    Connection conn =null ;
    private static JTextField cs;
    private static JTextField is;
    private static JTextField programming;
    private static JTextField oop;
    private static JTextField db;
    private static JTextField calculus;
    private static JTextField stat;
    private static JTextField discrete;
    private static JTextField algebra;
    public static void showWindow() {
        JFrame frame = new JFrame("add_Records");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ahmed Awd Allah\\eclipse-workspace\\Student_Record\\logo.png"));
        frame.getContentPane().setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        frame.getContentPane().setForeground(new Color(240, 128, 128));
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setBackground(Color.DARK_GRAY);
        frame.setAlwaysOnTop(true);
        frame.setBounds(100,100,598,378);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        id = new JTextField();
        id.setBackground(new Color(245, 245, 245));
        id.setForeground(Color.DARK_GRAY);
        id.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        id.setBounds(183, 14, 92, 30);
        frame.getContentPane().add(id);
        id.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Student Id");
        lblNewLabel.setForeground(new Color(240, 128, 128));
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblNewLabel.setBounds(10, 11, 117, 30);
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
                    String sql = "INSERT INTO materials values("+id.getText()+","+cs.getText()+","+is.getText()+","+programming.getText()+","+oop.getText()+","+db.getText()+","+calculus.getText()+","+stat.getText()+","+discrete.getText()+","+algebra.getText()+")";
                    ResultSet rs=stmt.executeQuery(sql);
                }catch (Exception e1) {
                
                    e1.printStackTrace();
                }
            }
        });
        confirm.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        confirm.setBounds(183, 258, 92, 30);
        frame.getContentPane().add(confirm);
        
        JButton btnNewButton = new JButton("Back");
        btnNewButton.setForeground(Color.DARK_GRAY);
        btnNewButton.setBackground(new Color(240, 128, 128));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                insert i1 = new insert();
                i1.main(null);
            }
        });
        btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        btnNewButton.setBounds(450, 260, 92, 30);
        frame.getContentPane().add(btnNewButton);
        
        JLabel lblComputerScience = new JLabel("Computer Science");
        lblComputerScience.setForeground(new Color(240, 128, 128));
        lblComputerScience.setHorizontalAlignment(SwingConstants.LEFT);
        lblComputerScience.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblComputerScience.setBounds(10, 52, 141, 30);
        frame.getContentPane().add(lblComputerScience);
        
        cs = new JTextField();
        cs.setBackground(new Color(245, 245, 245));
        cs.setForeground(Color.DARK_GRAY);
        cs.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        cs.setColumns(10);
        cs.setBounds(183, 52, 92, 30);
        frame.getContentPane().add(cs);
        
        JLabel lblInformationSystem = new JLabel("Information System");
        lblInformationSystem.setForeground(new Color(240, 128, 128));
        lblInformationSystem.setHorizontalAlignment(SwingConstants.LEFT);
        lblInformationSystem.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblInformationSystem.setBounds(10, 93, 156, 30);
        frame.getContentPane().add(lblInformationSystem);
        
        is = new JTextField();
        is.setBackground(new Color(245, 245, 245));
        is.setForeground(Color.DARK_GRAY);
        is.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        is.setColumns(10);
        is.setBounds(183, 93, 92, 30);
        frame.getContentPane().add(is);
        
        JLabel lblIntroductionToProgramming = new JLabel("Programming ");
        lblIntroductionToProgramming.setForeground(new Color(240, 128, 128));
        lblIntroductionToProgramming.setHorizontalAlignment(SwingConstants.LEFT);
        lblIntroductionToProgramming.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblIntroductionToProgramming.setBounds(10, 133, 117, 30);
        frame.getContentPane().add(lblIntroductionToProgramming);
        
        JLabel lblOop = new JLabel("OOP");
        lblOop.setForeground(new Color(240, 128, 128));
        lblOop.setHorizontalAlignment(SwingConstants.LEFT);
        lblOop.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblOop.setBounds(10, 174, 156, 30);
        frame.getContentPane().add(lblOop);
        
        programming = new JTextField();
        programming.setBackground(new Color(245, 245, 245));
        programming.setForeground(Color.DARK_GRAY);
        programming.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        programming.setColumns(10);
        programming.setBounds(183, 136, 92, 30);
        frame.getContentPane().add(programming);
        
        oop = new JTextField();
        oop.setBackground(new Color(245, 245, 245));
        oop.setForeground(Color.DARK_GRAY);
        oop.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        oop.setColumns(10);
        oop.setBounds(183, 177, 92, 30);
        frame.getContentPane().add(oop);
        
        JLabel lblDatabase = new JLabel("Database");
        lblDatabase.setForeground(new Color(240, 128, 128));
        lblDatabase.setHorizontalAlignment(SwingConstants.LEFT);
        lblDatabase.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblDatabase.setBounds(323, 14, 117, 30);
        frame.getContentPane().add(lblDatabase);
        
        db = new JTextField();
        db.setBackground(new Color(245, 245, 245));
        db.setForeground(Color.DARK_GRAY);
        db.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        db.setColumns(10);
        db.setBounds(450, 14, 92, 30);
        frame.getContentPane().add(db);
        
        JLabel LabelCalc = new JLabel("Calculus");
        LabelCalc.setForeground(new Color(240, 128, 128));
        LabelCalc.setHorizontalAlignment(SwingConstants.LEFT);
        LabelCalc.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        LabelCalc.setBounds(323, 52, 117, 30);
        frame.getContentPane().add(LabelCalc);
        
        calculus = new JTextField();
        calculus.setBackground(new Color(245, 245, 245));
        calculus.setForeground(Color.DARK_GRAY);
        calculus.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        calculus.setColumns(10);
        calculus.setBounds(450, 55, 92, 30);
        frame.getContentPane().add(calculus);
        
        JLabel lblStatistics = new JLabel("Statistics");
        lblStatistics.setForeground(new Color(240, 128, 128));
        lblStatistics.setHorizontalAlignment(SwingConstants.LEFT);
        lblStatistics.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblStatistics.setBounds(323, 93, 117, 30);
        frame.getContentPane().add(lblStatistics);
        
        stat = new JTextField();
        stat.setBackground(new Color(245, 245, 245));
        stat.setForeground(Color.DARK_GRAY);
        stat.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        stat.setColumns(10);
        stat.setBounds(450, 96, 92, 30);
        frame.getContentPane().add(stat);
        
        JLabel lblDiscrete = new JLabel("Discrete");
        lblDiscrete.setForeground(new Color(240, 128, 128));
        lblDiscrete.setHorizontalAlignment(SwingConstants.LEFT);
        lblDiscrete.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblDiscrete.setBounds(323, 133, 117, 30);
        frame.getContentPane().add(lblDiscrete);
        
        discrete = new JTextField();
        discrete.setBackground(new Color(245, 245, 245));
        discrete.setForeground(Color.DARK_GRAY);
        discrete.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        discrete.setColumns(10);
        discrete.setBounds(450, 136, 92, 30);
        frame.getContentPane().add(discrete);
        
        JLabel lblAlgebra = new JLabel("Algebra");
        lblAlgebra.setForeground(new Color(240, 128, 128));
        lblAlgebra.setHorizontalAlignment(SwingConstants.LEFT);
        lblAlgebra.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblAlgebra.setBounds(323, 174, 117, 30);
        frame.getContentPane().add(lblAlgebra);
        
        algebra = new JTextField();
        algebra.setBackground(new Color(245, 245, 245));
        algebra.setForeground(Color.DARK_GRAY);
        algebra.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        algebra.setColumns(10);
        algebra.setBounds(450, 177, 92, 30);
        frame.getContentPane().add(algebra);       
        frame.setVisible(true);        
    }
}