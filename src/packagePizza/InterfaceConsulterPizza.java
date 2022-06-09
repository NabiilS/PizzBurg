package packagePizza;

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

public class InterfaceConsulterPizza {

	public JFrame frame;
	private JTextField textPrixPizza;
	private JTextField textNomPizza;
	
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
					InterfaceConsulterPizza window = new InterfaceConsulterPizza();
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
	public InterfaceConsulterPizza() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 381);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		


		
		
		final JComboBox comboBoxidPizza = new JComboBox();
		comboBoxidPizza.setBounds(131, 38, 180, 21);
		frame.getContentPane().add(comboBoxidPizza);
		
		JLabel lblTaillePizza = new JLabel("Taille");
		lblTaillePizza.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblTaillePizza.setBounds(133, 132, 46, 13);
		frame.getContentPane().add(lblTaillePizza);
		
		textPrixPizza = new JTextField();
		textPrixPizza.setColumns(10);
		textPrixPizza.setBounds(131, 207, 180, 19);
		frame.getContentPane().add(textPrixPizza);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblPrix.setBounds(131, 184, 77, 13);
		frame.getContentPane().add(lblPrix);
		
		textNomPizza = new JTextField();
		textNomPizza.setColumns(10);
		textNomPizza.setBounds(131, 103, 180, 19);
		frame.getContentPane().add(textNomPizza);
		
		JLabel lblId = new JLabel("Identifiant");
		lblId.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblId.setBounds(131, 14, 77, 13);
		frame.getContentPane().add(lblId);
		
		JLabel lblNomPizza = new JLabel("Nom");
		lblNomPizza.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblNomPizza.setBounds(131, 79, 102, 13);
		frame.getContentPane().add(lblNomPizza);
		
		/* Variable de debug pour v�rifier si la connexion a bien �t� �tabli */
		boolean coReussi = false;
		
		// Connexion
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		String dbURL = "jdbc:mysql://localhost:3306/pizzeria"; /* Commande pour savoir le port mysql: show global variables like 'PORT'; */
		String dbUsername = "root";
		String password = "";
		
		connection = DriverManager.getConnection(dbURL, dbUsername, password);
		coReussi = true;
		
		
		//int idSelect = Integer.parseInt(scanner.nextLine());
		
		String sql = "select * from pizza";
		
		
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		
		while(result.next()) {
			comboBoxidPizza.addItem(result.getString(1));
		}
		
		
		}
		catch (Exception e) {
			throw new RuntimeException("Erreur d�tect�");
		
			
		}
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceAjoutPizza interfaceAjoutPizza = new InterfaceAjoutPizza();
				interfaceAjoutPizza.frame.setVisible(true);
				
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
					selectClient(comboBoxidPizza.getSelectedItem().toString());
					
				} catch (Exception z) {
					throw new RuntimeException("Erreur detecte");
				}
				
				
			}
		});
	
		btnAfficher.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnAfficher.setBounds(172, 236, 102, 33);
		frame.getContentPane().add(btnAfficher);
		String[] taille = {"M", "L", "XL" };
		JComboBox comboBoxidPizza_1 = new JComboBox(taille);
		comboBoxidPizza_1.setToolTipText("");
		comboBoxidPizza_1.setBounds(131, 156, 180, 21);
		frame.getContentPane().add(comboBoxidPizza_1);
	}
	public void selectClient(String idPizza) throws SQLException{
		
		String sql = "select * from pizza where idPizza ="+idPizza;
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		if(result.next()) {
			
			
			
			String nomPizza = result.getString("nomPizza");
			String taillePizza = result.getString("taillePizza");
			String prixPizza = result.getString("prixPizza");
			
			
			textPrixPizza.setText(prixPizza);
			textNomPizza.setText(nomPizza);
			
			// Debug
			
			/*System.out.println("idClient: " +idClient);
			System.out.println("nomClient: " +nomClient);
			System.out.println("prenomClient: " +prenomClient);
			System.out.println("telClient: " +telClient); 
			*/
			
		} else System.out.println("Pas de donn�es trouv�s...");
		
	}
}
