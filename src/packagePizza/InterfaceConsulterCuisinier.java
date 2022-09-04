package packagePizza;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class InterfaceConsulterCuisinier {

	public JFrame frame;
	private JTextField textTelCuisinier;
	private JTextField textPrenom;
	private JTextField textId;
	
	// Ajout� pour la connexion
	private static Connection connection = null;
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceConsulterCuisinier window = new InterfaceConsulterCuisinier();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceConsulterCuisinier() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(246, 201, 84));
		frame.setBounds(100, 100, 450, 381);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		


		
		
		final JComboBox comboBoxNomCuisinier = new JComboBox();
		comboBoxNomCuisinier.setBounds(131, 38, 180, 21);
		frame.getContentPane().add(comboBoxNomCuisinier);
		
		textTelCuisinier = new JTextField();
		textTelCuisinier.setBounds(131, 155, 180, 26);
		frame.getContentPane().add(textTelCuisinier);
		textTelCuisinier.setColumns(10);
		
		JLabel lblTel = new JLabel("T\u00E9l\u00E9phone");
		lblTel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblTel.setBounds(133, 132, 100, 13);
		frame.getContentPane().add(lblTel);
		
		textPrenom = new JTextField();
		textPrenom.setColumns(10);
		textPrenom.setBounds(131, 207, 180, 26);
		frame.getContentPane().add(textPrenom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblPrenom.setBounds(131, 184, 77, 13);
		frame.getContentPane().add(lblPrenom);
		
		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(131, 103, 180, 26);
		frame.getContentPane().add(textId);
		
		JLabel lblId = new JLabel("Identifiant");
		lblId.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblId.setBounds(131, 80, 77, 13);
		frame.getContentPane().add(lblId);
		
		JLabel lblNomCuisinier = new JLabel("Nom");
		lblNomCuisinier.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblNomCuisinier.setBounds(131, 15, 102, 13);
		frame.getContentPane().add(lblNomCuisinier);
		
		/* Variable de debug pour v�rifier si la connexion a bien �t� �tabli */
		boolean coReussi = false;
		
		// Connexion
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/pizzeria","root","root");
		coReussi = true;
		
		
		//int idSelect = Integer.parseInt(scanner.nextLine());
		
		String sql = "select * from cuisinier";
		
		
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		
		while(result.next()) {
			comboBoxNomCuisinier.addItem(result.getString(2));
		}
		
		
		}
		catch (Exception e) {
			throw new RuntimeException("Erreur d�tect�");
		
			
		}
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceAjoutCuisinier interfaceAjoutCuisinier = new InterfaceAjoutCuisinier();
				interfaceAjoutCuisinier.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnNewButton.setBounds(172, 286, 102, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					select(comboBoxNomCuisinier.getSelectedItem().toString());
					
				} catch (Exception z) {
					throw new RuntimeException("Erreur detecte");
				}
				
				
			}
		});
	
		btnAfficher.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnAfficher.setBounds(172, 236, 102, 33);
		frame.getContentPane().add(btnAfficher);
	}
	public void select(String nomCuisinier) throws SQLException{
		
		String sql = "select * from cuisinier where nomCuisinier ="+ "'" + nomCuisinier+ "'";
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		if(result.next()) {
			
			
			
			String nomClient = result.getString("numTel");
			String prenomClient = result.getString("prenomCuisinier");
			String idClient = result.getString("idCuisinier");
			
			textTelCuisinier.setText(nomClient);
			textPrenom.setText(prenomClient);
			textId.setText(idClient);
			
			// Debug
			
			/*System.out.println("idClient: " +idClient);
			System.out.println("nomClient: " +nomClient);
			System.out.println("prenomClient: " +prenomClient);
			System.out.println("telClient: " +telClient); 
			*/
			
		} else System.out.println("Pas de donn�es trouv�s...");
		
	}
}
