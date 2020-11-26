package LBMS;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AddBooksGUI extends javax.swing.JFrame{
	private JTextField title;
	private JTextField category;
	private JTextField publisher;
	private JTextField price;
	private JTextField pages;
	private JTextField author;
	private JTextField racknum;
	private JTextField publicationdate;
	private JTextField ISBN;
	private JTextField purchasedate;
	private DefaultTableModel dtm;
	private JTable table;
	private JTextField edition;
	public AddBooksGUI() {
		setBounds(50, 10, 759, 663);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblBookTitle = new JLabel();
		lblBookTitle.setForeground(Color.BLACK);
		lblBookTitle.setIcon(new ImageIcon(AddBooksGUI.class.getResource("/LBMS/book.png")));
		lblBookTitle.setText("Book Title");
		lblBookTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBookTitle.setBounds(35, 11, 122, 30);
		panel.add(lblBookTitle);
		
		title = new JTextField();
		title.setBounds(199, 11, 124, 30);
		panel.add(title);
		
		category = new JTextField();
		category.setBounds(199, 61, 124, 30);
		panel.add(category);
		
		JLabel label_2 = new JLabel();
		label_2.setIcon(new ImageIcon(AddBooksGUI.class.getResource("/LBMS/update.png")));
		label_2.setText("Edition");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(35, 165, 104, 20);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel();
		label_3.setIcon(new ImageIcon(AddBooksGUI.class.getResource("/LBMS/addperson.png")));
		label_3.setText("Publisher");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_3.setBounds(35, 213, 114, 20);
		panel.add(label_3);
		
		publisher = new JTextField();
		publisher.setBounds(199, 210, 124, 30);
		panel.add(publisher);
		
		JLabel lblPrice = new JLabel();
		lblPrice.setText("$$   Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPrice.setBounds(35, 260, 104, 20);
		panel.add(lblPrice);
		
		price = new JTextField();
		price.setBounds(199, 260, 124, 30);
		panel.add(price);
		
		JLabel label_5 = new JLabel();
		label_5.setIcon(new ImageIcon(AddBooksGUI.class.getResource("/LBMS/book.png")));
		label_5.setText("Pages");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_5.setBounds(393, 260, 94, 20);
		panel.add(label_5);
		
		pages = new JTextField();
		pages.setBounds(558, 257, 124, 30);
		panel.add(pages);
		
		JLabel lblAuthor = new JLabel();
		lblAuthor.setIcon(new ImageIcon(AddBooksGUI.class.getResource("/LBMS/author.png")));
		lblAuthor.setText("Author");
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAuthor.setBounds(35, 113, 89, 32);
		panel.add(lblAuthor);
		
		author = new JTextField();
		author.setBounds(199, 113, 124, 32);
		panel.add(author);
		author.setColumns(10);
		
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					dtm.setRowCount(0);
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?serverTimezone=UTC", "root", "asd123!@#");
					
					PreparedStatement s= c.prepareStatement ("Insert Into book (booktitle,author,edition,idCategory,bookracknum,publisher,yearofpublication,ISBN,numberofPages,dateofPurchase,price) values(?,?,?,?,?,?,?,?,?,?,?)");
					s.setString(1,title.getText().trim());
					s.setString(2,author.getText().trim());
					s.setString(3,edition.getText().trim());
					s.setString(4,category.getText().trim());
					s.setString(5,racknum.getText().trim());
					s.setString(6,publisher.getText().trim());
					s.setDate(7,Date.valueOf(publicationdate.getText()));
					s.setString(8,ISBN.getText().trim());
					s.setInt(9,Integer.parseInt(pages.getText().trim()));
					s.setDate(10,Date.valueOf(purchasedate.getText()));
					s.setInt(11,Integer.parseInt(price.getText().trim()));
					
					s.executeUpdate( ); // Start Working
					
					s.close();
					c.close(); 
					
				}catch(Exception ie) {
					ie.printStackTrace();
				}
				db();
			}
		});
		button.setText("Add");
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBackground(new Color(0, 204, 102));
		button.setBounds(199, 330, 110, 40);
		panel.add(button);
		
		JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LibrarianGUI().setVisible(true);
				dispose();
			}
		});
		button_1.setText("Back");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBackground(new Color(255, 51, 51));
		button_1.setBounds(380, 330, 110, 40);
		panel.add(button_1);
		
		JLabel lblCategory = new JLabel();
		lblCategory.setIcon(new ImageIcon(AddBooksGUI.class.getResource("/LBMS/subj.png")));
		lblCategory.setText("Category");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCategory.setBounds(35, 59, 122, 30);
		panel.add(lblCategory);
		
		JLabel lblBookracknum = new JLabel();
		lblBookracknum.setIcon(new ImageIcon(AddBooksGUI.class.getResource("/LBMS/addr.png")));
		lblBookracknum.setText("RackNum");
		lblBookracknum.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBookracknum.setBounds(393, 16, 118, 20);
		panel.add(lblBookracknum);
		
		JLabel lblYearofpublication = new JLabel();
		lblYearofpublication.setIcon(new ImageIcon(AddBooksGUI.class.getResource("/LBMS/date.png")));
		lblYearofpublication.setText("PublicationDate");
		lblYearofpublication.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblYearofpublication.setBounds(360, 64, 168, 20);
		panel.add(lblYearofpublication);
		
		JLabel lblIsbn = new JLabel();
		lblIsbn.setIcon(new ImageIcon(AddBooksGUI.class.getResource("/LBMS/book.png")));
		lblIsbn.setText("ISBN");
		lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIsbn.setBounds(393, 125, 94, 20);
		panel.add(lblIsbn);
		
		JLabel lblPurchasedate = new JLabel();
		lblPurchasedate.setIcon(new ImageIcon(AddBooksGUI.class.getResource("/LBMS/date.png")));
		lblPurchasedate.setText("PurchaseDate");
		lblPurchasedate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPurchasedate.setBounds(393, 191, 118, 20);
		panel.add(lblPurchasedate);
		
		racknum = new JTextField();
		racknum.setBounds(558, 13, 124, 30);
		panel.add(racknum);
		
		publicationdate = new JTextField();
		publicationdate.setBounds(558, 61, 124, 30);
		panel.add(publicationdate);
		
		ISBN = new JTextField();
		ISBN.setBounds(558, 122, 124, 30);
		panel.add(ISBN);
		
		purchasedate = new JTextField();
		purchasedate.setBounds(558, 188, 124, 30);
		panel.add(purchasedate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 489, 720, 124);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		dtm = new DefaultTableModel(new Object[] {"BookTitle","Author","Edition","Category","BookRackNum","Publisher","YearOfPublication","ISBN","NumberOfPages","DateOfPurchase","Price"},0) {
			public boolean isCellEditable(int row,int col) {
				return false;
			}
		};
		
		table.setModel(dtm);
		
		edition = new JTextField();
		edition.setColumns(10);
		edition.setBounds(199, 156, 124, 32);
		panel.add(edition);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\Second Year HND Assignments\\LBMS_Assignment\\src\\LBMS\\3.jpg"));
		lblNewLabel.setBounds(0, 0, 743, 624);
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
		 AddBooksGUI main = new  AddBooksGUI();
		 main.setVisible(true);
	}
}
