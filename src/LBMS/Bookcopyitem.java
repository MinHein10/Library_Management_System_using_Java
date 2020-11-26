package LBMS;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bookcopyitem extends JFrame{
	
	public Bookcopyitem() {
		setBounds(100, 100, 638, 574);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 49, 602, 185);
		panel.add(table);
		
		dtm = new DefaultTableModel(new Object[] {"BookID","BookTitle","Available Book Copies"},0) {
			public boolean isCellEditable(int row,int col) {
				return false;
			}
		};
		
		table.setModel(dtm);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 356, 602, 137);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		table_1 = new JTable();
		table_1.setBounds(10, 11, 582, 115);
		panel_1.add(table_1);
		
		dtm2 = new DefaultTableModel(new Object[] {"BookID","BookTitle","Number OF Book Copy Item"},0) {
			public boolean isCellEditable(int row,int col) {
				return false;
			}
		};
		
		table_1.setModel(dtm2);
		
		JLabel lblBorrowerInformation = new JLabel();
		lblBorrowerInformation.setText("Available Book For Borrowing");
		lblBorrowerInformation.setIcon(new ImageIcon(Bookcopyitem.class.getResource("/LBMS/book.png")));
		lblBorrowerInformation.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBorrowerInformation.setBounds(149, 11, 339, 30);
		panel.add(lblBorrowerInformation);
		
		JLabel lblCopyOfBook = new JLabel();
		lblCopyOfBook.setIcon(new ImageIcon(Bookcopyitem.class.getResource("/LBMS/book.png")));
		lblCopyOfBook.setText("Copy Of Book Information");
		lblCopyOfBook.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCopyOfBook.setBounds(162, 323, 300, 30);
		panel.add(lblCopyOfBook);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LibrarianGUI().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(0, 504, 622, 30);
		panel.add(btnNewButton);
		db();
		dbnew();
	}
	
	public void db() {
		try {
			
			dtm.setRowCount(0);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?serverTimezone=UTC", "root", "asd123!@#");
			
			PreparedStatement s= c.prepareStatement("SELECT b.idbook, booktitle, (numberofcopyitem - IF(i.idbook IS NULL, 0, IF(returnDate IS NULL, 1, 0) )) FROM bookcopyitem b \r\n" + 
					"LEFT OUTER JOIN issuebooks i ON b.idbook = i.idbook;");
			ResultSet r = s.executeQuery();
			Object col[]= {"BookID","BookTitle","Available Book Copies"};
			dtm.addRow(col);
			
			while(r.next()) {
				Object data[] = {r.getString(1),r.getString(2),r.getInt(3)};
				dtm.addRow(data);
			}
			
			r.close();
			s.close();
			c.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void dbnew() {
		try {
			
			dtm2.setRowCount(0);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?serverTimezone=UTC", "root", "asd123!@#");
			
			PreparedStatement s= c.prepareStatement("Select idbook,booktitle,numberofcopyitem From bookcopyitem");
			ResultSet r = s.executeQuery();
			Object col[]= {"BookID","BookTitle","Number OF Book Copy Item"};
			dtm2.addRow(col);
			
			while(r.next()) {
				Object data[] = {r.getString(1),r.getString(2),r.getInt(3)};
				dtm2.addRow(data);
			}
			
			r.close();
			s.close();
			c.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	int bookID;
	Book title;
	String bookstatus;
	private JTable table;
	private DefaultTableModel dtm;
	private DefaultTableModel dtm2;
	private JTable table_1;
	
	public static void main(String[] args) {
		Bookcopyitem main = new Bookcopyitem();
		main.setVisible(true);
	}
}
