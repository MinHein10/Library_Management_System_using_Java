package LBMS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;

public class LibrarianGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianGUI frame = new LibrarianGUI();
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
	public LibrarianGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setIcon(new ImageIcon(LibrarianGUI.class.getResource("/LBMS/logout.png")));
		button.setToolTipText("");
		button.setText("Log Out");
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPane.add(button, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Librarian");
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		label.setBounds(300, 8, 104, 22);
		panel.add(label);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBounds(0, 41, 596, 134);
		panel.add(layeredPane_2);
		
		JButton btnAboutLibrarian = new JButton("About Librarian");
		btnAboutLibrarian.setIcon(new ImageIcon(LibrarianGUI.class.getResource("/LBMS/personalinfo.png")));
		btnAboutLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new LibrarianInfo().setVisible(true);
				dispose();
			}
		});
		btnAboutLibrarian.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAboutLibrarian.setBounds(398, 11, 184, 101);
		layeredPane_2.add(btnAboutLibrarian);
		
		JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchBookGUI().setVisible(true);
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon(LibrarianGUI.class.getResource("/LBMS/search.png")));
		button_1.setText("Search Books");
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Dialog", Font.BOLD, 14));
		button_1.setBounds(204, 11, 184, 101);
		layeredPane_2.add(button_1);
		
		JButton button_2 = new JButton();
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddBooksGUI().setVisible(true);
				dispose();
			}
		});
		button_2.setIcon(new ImageIcon(LibrarianGUI.class.getResource("/LBMS/addbook.png")));
		button_2.setText("Add a Book");
		button_2.setForeground(Color.BLACK);
		button_2.setFont(new Font("Dialog", Font.BOLD, 14));
		button_2.setBounds(10, 11, 184, 101);
		layeredPane_2.add(button_2);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 186, 184, 123);
		panel.add(layeredPane);
		
		JButton btnViewAllBook = new JButton();
		btnViewAllBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewBookGUI().setVisible(true);
				dispose();
			}
		});
		btnViewAllBook.setIcon(new ImageIcon(LibrarianGUI.class.getResource("/LBMS/book.png")));
		btnViewAllBook.setText("View All Book");
		btnViewAllBook.setForeground(Color.BLACK);
		btnViewAllBook.setFont(new Font("Dialog", Font.BOLD, 14));
		btnViewAllBook.setBounds(0, 11, 184, 101);
		layeredPane.add(btnViewAllBook);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(204, 186, 224, 123);
		panel.add(layeredPane_1);
		
		JButton btnViewBorrowerInfo = new JButton();
		btnViewBorrowerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Bookcopyitem().setVisible(true);
				dispose();
			}
		});
		btnViewBorrowerInfo.setIcon(new ImageIcon(LibrarianGUI.class.getResource("/LBMS/personalinfo.png")));
		btnViewBorrowerInfo.setText("Info of Available Book");
		btnViewBorrowerInfo.setForeground(Color.BLACK);
		btnViewBorrowerInfo.setFont(new Font("Dialog", Font.BOLD, 14));
		btnViewBorrowerInfo.setBounds(0, 11, 221, 101);
		layeredPane_1.add(btnViewBorrowerInfo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\Second Year HND Assignments\\LBMS_Assignment\\src\\LBMS\\1.jpeg"));
		lblNewLabel.setBounds(0, 11, 692, 339);
		panel.add(lblNewLabel);
	}
}
