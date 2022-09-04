package packagePizza;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Result;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Connexion extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private boolean coReussi;
	
	private static Connection connection = null;
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion frame = new Connexion();
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
	public Connexion() {
		initialize();
		
	}
		private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Confirmer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					
					connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/bdd_huissier","root","root");
					coReussi = true;
					
					String users = textField.getText();
					String mdp = passwordField.getText();
					
					Statement stm = connection.createStatement();
					String sql = "SELECT * FROM Connexion where users='"+users+"' AND mdp='"+mdp+"'";
					ResultSet result = stm.executeQuery(sql);
					
					if(result.next()) {
						dispose();
						InterfacePizzeria newFenetrePizzeria = new InterfacePizzeria();
						newFenetrePizzeria.frame.setVisible(true);
					} 
					else {
						JOptionPane.showInputDialog(this,"login et password faux...");
						textField.setText("");
						passwordField.setText("");
						
						
					}
					
				}catch(Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		btnNewButton.setBounds(123, 175, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Quitter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		btnNewButton_1.setBounds(241, 175, 117, 29);
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(160, 137, 145, 26);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(160, 96, 145, 29);
		contentPane.add(textField);
	
}
}