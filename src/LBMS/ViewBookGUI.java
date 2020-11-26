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
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ViewBookGUI extends JFrame{
	private JTable table;
	private DefaultTableModel dtm;
	public ViewBookGUI() {
		setBounds(100, 100, 845, 460);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 809, 239);
		panel.add(table);
		
		dtm = new DefaultTableModel(new Object[] {"booktitle","author","edition","idCategory","bookracknum","publisher","yearofpublication","ISBN","numberofPages","dateofPurchase","price"},0) {
			public boolean isCellEditable(int row,int col) {
				return false;
			}
		};
		
		table.setModel(dtm);
		
		JButton button = new JButton("Back");
		button.setIcon(new ImageIcon(ViewBookGUI.class.getResource("/LBMS/hold.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LibrarianGUI().setVisible(true);
				dispose();
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 16));
		button.setBounds(467, 348, 294, 29);
		panel.add(button);
		
		JButton btnInsertBook = new JButton("Insert Book");
		btnInsertBook.setIcon(new ImageIcon(ViewBookGUI.class.getResource("/LBMS/addbook.png")));
		btnInsertBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AddBooksGUI().setVisible(true);
				dispose();
			}
		});
		btnInsertBook.setFont(new Font("Dialog", Font.BOLD, 16));
		btnInsertBook.setBounds(54, 348, 294, 29);
		panel.add(btnInsertBook);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\Second Year HND Assignments\\LBMS_Assignment\\src\\LBMS\\6.jpg"));
		lblNewLabel.setBounds(0, 11, 829, 410);
		panel.add(lblNewLabel);
		db();
	}
	public void db() {
		try {
			
			dtm.setRowCount(0);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?serverTimezone=UTC", "root", "asd123!@#");
			
			PreparedStatement s= c.prepareStatement("Select * From book");
			
			ResultSet r = s.executeQuery();
			Object col[]= {"BookTitle","Author","Edition","Category","BookRackNum","Publisher","YearOfPublication","ISBN","NumberOfPages","DateOfPurchase","Price"};
			dtm.addRow(col);
			while(r.next()) {
				System.out.println(r.getString(1));
				Object data[] = {r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6),r.getString(7),r.getString(8),r.getInt(9),r.getString(10),r.getInt(11)};
				dtm.addRow(data);
			}
			
			r.close();
			s.close();
			c.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ViewBookGUI viewbook = new ViewBookGUI();
		viewbook.setVisible(true);
	}
}
