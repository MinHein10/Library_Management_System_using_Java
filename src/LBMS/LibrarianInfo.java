package LBMS;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class LibrarianInfo extends JFrame{
	public LibrarianInfo() {
		setBounds(100, 100, 625, 386);
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 589, 83);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		dtm = new DefaultTableModel(new Object[] {"IDLibrarian","nameLibrarian","addressLibrarian","phno"},0) {
			public boolean isCellEditable(int row,int col) {
				return false;
			}
		};
		
		table.setModel(dtm);
		
		JLabel lblLibrarianInformationIn = new JLabel("Librarian Information in Yangon College Libarary");
		lblLibrarianInformationIn.setForeground(Color.WHITE);
		lblLibrarianInformationIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibrarianInformationIn.setFont(new Font("Dialog", Font.BOLD, 18));
		lblLibrarianInformationIn.setBounds(86, 11, 438, 23);
		getContentPane().add(lblLibrarianInformationIn);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(0, 318, 609, 29);
		getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new LibrarianGUI().setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\Second Year HND Assignments\\LBMS_Assignment\\src\\LBMS\\4.jpg"));
		lblNewLabel.setBounds(0, 0, 609, 347);
		getContentPane().add(lblNewLabel);
		db();
	}
	
	public void db() {
		try {
			
			dtm.setRowCount(0);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?serverTimezone=UTC", "root", "asd123!@#");
			
			PreparedStatement s= c.prepareStatement("Select*From librarian");
			ResultSet r = s.executeQuery();
			
			while(r.next()) {
				Object data[] = {r.getString(1),r.getString(2),r.getString(3),r.getInt(4)};
				dtm.addRow(data);
			}
			
			r.close();
			s.close();
			c.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	String librarianID;
	String name;
	String address;
	int phno;
	private DefaultTableModel dtm;
	private JTable table;
	public String getLibrarianID() {
		return librarianID;
	}
	public void setLibrarianID(String librarianID) {
		this.librarianID = librarianID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhno() {
		return phno;
	}
	public void setPhno(int phno) {
		this.phno = phno;
	}
	
	public static void main(String[] args) {
		LibrarianInfo L = new LibrarianInfo();
		L.setVisible(true);
	}
}
