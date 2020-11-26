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

public class End  {
	public End() {
	}
	private static DefaultTableModel dtm;
	public static JFrame mainFrame;
	public static JPanel mainPanel, mainPanel2;
	public static JLabel mainLabelT, login;
	private static JButton logout;
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
		
		login = new JLabel("Thank You For Using Library Management System");
		login.setIcon(new ImageIcon(Login.class.getResource("/LBMS/addperson.png")));
		login.setBounds(302, 120, 807, 144);
		login.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
		login.setHorizontalAlignment(JLabel.CENTER);
		login.setForeground(Color.GRAY);
		login.setBackground(Color.WHITE);
		Border borderA=BorderFactory.createLineBorder(Color.BLACK);
		
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
		mainPanel.add(login);
		mainFrame.setVisible(true);
		mainFrame.repaint();
	}
	
	public static void main(String[] args) {
		init();
		display();		
		Login.setVisible(true);
	}
}