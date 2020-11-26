package LBMS;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class Login  {
	public Login() {
	}
	private static DefaultTableModel dtm;
	public static JFrame mainFrame;
	public static JPanel mainPanel, mainPanel2;
	public static JLabel mainLabelT,mainLabel, username, password, login;
	public static JTextField jTextField;
	public static JPasswordField jPasswordField;
	private static JButton submit, cancel, logout;
	public static int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 45;
	public static int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final String TITLE = "VJTI Library";
	


	private static void init() {
		mainFrame = new JFrame(TITLE);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setSize(width, height);
		mainFrame.getContentPane().setLayout(null);
		
		mainPanel = new JPanel();
		mainPanel.setBounds(0, height/5, width,4*height/5);
		mainPanel.setBackground(Color.BLACK);
		mainPanel.setLayout(null);

		mainPanel2= new JPanel();
		mainPanel2.setBounds(0, 0, width,height/5);
		mainPanel2.setBackground(Color.CYAN);
		mainPanel2.setLayout(null);
			
		mainLabelT = new JLabel("LIBRARY MANAGEMENT SYSTEM");
		mainLabelT.setIcon(new ImageIcon(Login.class.getResource("/LBMS/book.png")));
		mainLabelT.setBounds(10*width/100, 4*height/100, 80*width/100, 15*height/100);
		mainLabelT.setFont(new Font(Font.SANS_SERIF, Font.BOLD, height/25));
		mainLabelT.setHorizontalAlignment(JLabel.CENTER);
		mainLabelT.setAlignmentX(0.5f);
		mainLabelT.setForeground(Color.BLACK);
		mainLabelT.setBackground(Color.WHITE);
		
		mainLabel = new JLabel("Login");
		mainLabel.setIcon(new ImageIcon(Login.class.getResource("/LBMS/loginicon.png")));
		mainLabel.setBounds(2*width/8, height/20, 4*width/8, height/5);
		mainLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, height/25));
		mainLabel.setHorizontalAlignment(JLabel.CENTER);
		mainLabel.setAlignmentX(0.5f);
		mainLabel.setForeground(Color.BLACK);
		mainLabel.setBackground(Color.WHITE);
		
		login = new JLabel("Librarian");
		login.setIcon(new ImageIcon(Login.class.getResource("/LBMS/addperson.png")));
		login.setBounds(2*width/8, 3*height/18, 4*width/8, height/5);
		login.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 24));
		login.setHorizontalAlignment(JLabel.CENTER);
		login.setForeground(Color.GRAY);
		login.setBackground(Color.WHITE);
		
		username = new JLabel("Username");
		username.setBounds(9*width/32, 4*height/18, 2*width/8, height/5);
		username.setFont(new Font(Font.SERIF, Font.PLAIN, height/30));
		username.setHorizontalAlignment(JLabel.CENTER);
		username.setForeground(Color.GRAY);
		username.setBackground(Color.WHITE);
		
		password = new JLabel("Password");
		password.setBounds(9*width/32, 5*height/18, 2*width/8, height/5);
		password.setFont(new Font(Font.SERIF, Font.PLAIN, height/30));
		password.setHorizontalAlignment(JLabel.CENTER);
		password.setForeground(Color.GRAY);
		password.setBackground(Color.WHITE);
	
		jTextField= new JTextField("",15);
		jTextField.setBounds(15*width/32, 11*height/36, width/6, height/30);
		jTextField.setBackground(Color.CYAN);
		Border borderA=BorderFactory.createLineBorder(Color.BLACK);
		jTextField.setBorder(borderA);
		
		jPasswordField= new JPasswordField("",15);
		jPasswordField.setBounds(15*width/32, 13*height/36, width/6, height/30);
		jPasswordField.setBackground(Color.CYAN);
		jPasswordField.setBorder(borderA);
		
		submit = new JButton("Login");
		submit.setIcon(new ImageIcon(Login.class.getResource("/LBMS/hold.png")));
		submit.setBounds(27*width/64, 9*height/18, width/13, height/25);
		submit.setHorizontalAlignment(JLabel.CENTER);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				
				String uname=jTextField.getText();
				String pass=String.valueOf(jPasswordField.getPassword());
				
				ResultSet rs;
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?serverTimezone=UTC", "root", "asd123!@#");
					PreparedStatement s= c.prepareStatement ("select * from login where username=? and password=?");
					
//					 ps=MyConnection.getConnection().prepareStatement(query);
					 s.setString(1,uname);
			         s.setString(2, pass);
			         rs=s.executeQuery();
			         if(rs.next()){
			                Loading obj=new Loading();
			                setVisible(false);
			                obj.setUpLoading();
			                obj.setVisible(true);
			                
			            }
			            else{
			                JOptionPane.showMessageDialog(null,"Incorrect Username and Password");
			            }
				}catch(Exception e){
		            JOptionPane.showMessageDialog(null,e);
		        }
			}
			
		});
		
		cancel = new JButton("Cancel");
		cancel.setIcon(new ImageIcon(Login.class.getResource("/LBMS/cancelicon.png")));
		cancel.setBounds(34*width/64, 9*height/18, width/13, height/25);
		cancel.setHorizontalAlignment(JLabel.CENTER);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.login.setText("");
				Login.jTextField.setText("");
				Login.jPasswordField.setText("");		
			}
		});
		
		logout = new JButton("logout");
		logout.setBounds(59*width/64, 0, width/16, height/20);
		logout.setFont(new Font(Font.SERIF, Font.PLAIN, height/30));
		logout.setForeground(Color.decode("#0000FF"));
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.removeAll();
				mainPanel2.removeAll();
				login.setText("Logged out successfully.");
				display();
			}
		});
	}
	
	protected static void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	protected static void showMessage(String string) {
		// TODO Auto-generated method stub
		
	}

	public static void display() {
		mainFrame.getContentPane().add(mainPanel);
		mainFrame.getContentPane().add(mainPanel2);
		mainPanel2.add(mainLabelT);
		mainPanel.add(mainLabel);
		mainPanel.add(login);
		mainPanel.add(username);
		mainPanel.add(password);
		mainPanel.add(jTextField);
		mainPanel.add(jPasswordField);
		mainPanel.add(submit);
		mainPanel.add(cancel);
		mainFrame.setVisible(true);
		mainFrame.repaint();
	}
	
	public static void main(String[] args) {
		init();
		display();		
		Login.setVisible(true);
	}
}