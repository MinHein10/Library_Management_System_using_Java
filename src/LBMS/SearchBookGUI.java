package LBMS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class SearchBookGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField search;
	private DefaultTableModel dtm;
	JRadioButton rbtnTitle,rbtnAuthor,rbtnSubject;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton button;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBookGUI frame = new SearchBookGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchBookGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 675, 208);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		 rbtnTitle = new JRadioButton();
		buttonGroup.add(rbtnTitle);
		rbtnTitle.setText("By Title");
		rbtnTitle.setSelected(true);
		rbtnTitle.setFont(new Font("Dialog", Font.BOLD, 14));
		rbtnTitle.setBounds(30, 301, 77, 27);
		contentPane.add(rbtnTitle);
		
		rbtnAuthor = new JRadioButton();
		buttonGroup.add(rbtnAuthor);
		rbtnAuthor.setText("By Author");
		rbtnAuthor.setFont(new Font("Dialog", Font.BOLD, 14));
		rbtnAuthor.setBounds(125, 301, 93, 27);
		contentPane.add(rbtnAuthor);
		
		 rbtnSubject = new JRadioButton();
		buttonGroup.add(rbtnSubject); 
		rbtnSubject.setText("By Subject");
		rbtnSubject.setFont(new Font("Dialog", Font.BOLD, 14));
		rbtnSubject.setBounds(236, 301, 99, 27);
		contentPane.add(rbtnSubject);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(20, 230, 665, 61);
		contentPane.add(layeredPane);
		
		JButton btnSearch = new JButton();
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dtm.setRowCount(0);
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?serverTimezone=UTC", "root", "asd123!@#");
					String searchText=search.getText();
					
					if(rbtnTitle.isSelected()) {
						PreparedStatement s= c.prepareStatement("Select*From book where booktitle='"+searchText+"'");
						ResultSet r = s.executeQuery();
						
						while(r.next()) {
							Object data[] = {r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6),r.getString(7),r.getString(8),r.getInt(9),r.getString(10),r.getInt(11)};
							dtm.addRow(data);
						}
					}
					else if(rbtnAuthor.isSelected()) {
						JOptionPane.showMessageDialog(null, "You selected author ");
						PreparedStatement s= c.prepareStatement("Select*From book where author='"+searchText+"'");
						ResultSet r = s.executeQuery();
						
						while(r.next()) {
							Object data[] = {r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6),r.getString(7),r.getString(8),r.getInt(9),r.getString(10),r.getInt(11)};
							dtm.addRow(data);
						}
						
					}
					else if(rbtnSubject.isSelected()) {
						JOptionPane.showMessageDialog(null, "You selected subject ");
						PreparedStatement s= c.prepareStatement("Select*From book,category where book.idCategory=category.idCategory and category.NameCategory='"+searchText+"'");
						ResultSet r = s.executeQuery();
						
						while(r.next()) {
							Object data[] = {r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6),r.getString(7),r.getString(8),r.getInt(9),r.getString(10),r.getInt(11)};
							dtm.addRow(data);
						}
						
					}
					
				}catch(Exception ie) {
					ie.printStackTrace();
				}
				
			}
		});
		btnSearch.setBounds(377, 11, 110, 40);
		layeredPane.add(btnSearch);
		btnSearch.setText("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearch.setBackground(new Color(0, 204, 102));
		
		search = new JTextField();
		search.setBounds(10, 11, 357, 40);
		layeredPane.add(search);
		
		JButton btnRefresh = new JButton();
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db();
				
			}
		});
		btnRefresh.setText("Refresh");
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRefresh.setBackground(new Color(0, 204, 102));
		btnRefresh.setBounds(545, 11, 110, 40);
		layeredPane.add(btnRefresh);
		
		dtm = new DefaultTableModel(new Object[] {"BookTitle","Author","Edition","Category","BookRackNum","Publisher","YearOfPublication","ISBN","NumberOfPages","DateOfPurchase","Price"},0) {
			public boolean isCellEditable(int row,int col) {
				return false;
			}
		};
		
		table.setModel(dtm);
		
		button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LibrarianGUI().setVisible(true);
				dispose();
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 16));
		button.setBounds(0, 379, 695, 29);
		contentPane.add(button);
		db();
	}
	public void db() {
		try {
			
			dtm.setRowCount(0);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?serverTimezone=UTC", "root", "asd123!@#");
			
			PreparedStatement s= c.prepareStatement("Select * From book");
			ResultSet r = s.executeQuery();
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
}
