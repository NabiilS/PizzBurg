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
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class InterfaceAjouterCommande {

	public JFrame frame;
	private JTextField textidClient;
	private JTextField textPrenomClient;
	private JTextField textNomClient;
	
	// Ajout� pour la connexion
	private static Connection connection = null;
	private static Scanner scanner = new Scanner(System.in);
	private JTextField textIdPizza;
	private JTextField textTaillePizza;
	private JTextField textPrixPizza;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceAjouterCommande window = new InterfaceAjouterCommande();
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
	public InterfaceAjouterCommande() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1128, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		


		
		
		final JComboBox comboBoxTelClient = new JComboBox();
		comboBoxTelClient.setBounds(10, 39, 180, 21);
		frame.getContentPane().add(comboBoxTelClient);
		
		final JComboBox comboBoxPizza = new JComboBox();
		comboBoxPizza.setBounds(329, 39, 180, 21);
		frame.getContentPane().add(comboBoxPizza);
		
		textidClient = new JTextField();
		textidClient.setBounds(10, 105, 180, 19);
		frame.getContentPane().add(textidClient);
		textidClient.setColumns(10);
		
		JLabel lblidClient = new JLabel("Identifiant");
		lblidClient.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblidClient.setBounds(10, 82, 77, 13);
		frame.getContentPane().add(lblidClient);
		
		textPrenomClient = new JTextField();
		textPrenomClient.setColumns(10);
		textPrenomClient.setBounds(10, 157, 180, 19);
		frame.getContentPane().add(textPrenomClient);
		
		JLabel lblPrenomClient = new JLabel("Prenom");
		lblPrenomClient.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblPrenomClient.setBounds(10, 134, 77, 13);
		frame.getContentPane().add(lblPrenomClient);
		
		textNomClient = new JTextField();
		textNomClient.setColumns(10);
		textNomClient.setBounds(10, 211, 180, 19);
		frame.getContentPane().add(textNomClient);
		
		JLabel lblTelClient = new JLabel("T\u00E9l\u00E9phone");
		lblTelClient.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblTelClient.setBounds(10, 16, 77, 13);
		frame.getContentPane().add(lblTelClient);
		
		JLabel lblNomClient = new JLabel("Nom");
		lblNomClient.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblNomClient.setBounds(10, 186, 102, 13);
		frame.getContentPane().add(lblNomClient);
		
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
		
		
		String sqlPizza = "select * from pizza";
		
		Statement statementPizza = connection.createStatement();
		ResultSet resultPizza = statementPizza.executeQuery(sqlPizza);
		
		String sqlClient = "select * from client";
		Statement statementClient = connection.createStatement();
		ResultSet resultClient = statementClient.executeQuery(sqlClient);
		
		
		while(resultClient.next()) {
			comboBoxTelClient.addItem(resultClient.getString("nomClient"));
		}
		while (resultPizza.next()) {
			//comboboxPizza.addItem(resultPizza.getString(0));
			
		}
		
		
		}
		catch (Exception e) {
			throw new RuntimeException("Erreur d�tect�");
		
			
		}
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//InterfaceGestionnaire interfaceGestionnaire = new InterfaceGestionnaire();
				//interfaceGestionnaire.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnNewButton.setBounds(191, 355, 122, 49);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					selectClient(comboBoxTelClient.getSelectedItem().toString());
				} catch (Exception z) {
					throw new RuntimeException("Erreur detecte");
				}
			}
		});
	
		btnAfficher.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnAfficher.setBounds(48, 251, 102, 33);
		frame.getContentPane().add(btnAfficher);
		

		
		JLabel lblListPizza = new JLabel("Pizza");
		lblListPizza.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblListPizza.setBounds(329, 16, 102, 13);
		frame.getContentPane().add(lblListPizza);
		
		JLabel lblid_1 = new JLabel("Identifiant");
		lblid_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblid_1.setBounds(329, 82, 77, 13);
		frame.getContentPane().add(lblid_1);
		
		textIdPizza = new JTextField();
		textIdPizza.setColumns(10);
		textIdPizza.setBounds(329, 106, 180, 19);
		frame.getContentPane().add(textIdPizza);
		
		JLabel lblTaillePizza = new JLabel("Taille");
		lblTaillePizza.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblTaillePizza.setBounds(329, 134, 77, 13);
		frame.getContentPane().add(lblTaillePizza);
		
		textTaillePizza = new JTextField();
		textTaillePizza.setColumns(10);
		textTaillePizza.setBounds(329, 158, 180, 19);
		frame.getContentPane().add(textTaillePizza);
		
		JLabel lblPrixPizza = new JLabel("Prix");
		lblPrixPizza.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblPrixPizza.setBounds(329, 189, 77, 13);
		frame.getContentPane().add(lblPrixPizza);
		
		textPrixPizza = new JTextField();
		textPrixPizza.setColumns(10);
		textPrixPizza.setBounds(329, 212, 180, 19);
		frame.getContentPane().add(textPrixPizza);
		
		JButton btnAfficher_1 = new JButton("Afficher");
		btnAfficher_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					selectPizza(comboBoxPizza.getSelectedItem().toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} 
		});
		btnAfficher_1.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnAfficher_1.setBounds(363, 251, 102, 33);
		frame.getContentPane().add(btnAfficher_1);
		
		JButton btnAjouterCommande = new JButton("Ajouter");
		btnAjouterCommande.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnAjouterCommande.setBounds(191, 296, 122, 49);
		frame.getContentPane().add(btnAjouterCommande);
	}
	public void selectClient(String nomClient) throws SQLException{
		
		String sql = "select * from client where nomClient = '"+nomClient + "'";
		Statement statement = connection.createStatement();
		
		ResultSet resultClient = statement.executeQuery(sql);
		
		if(resultClient.next()) {

			String idClient = resultClient.getString("idClient");
			String prenomClient = resultClient.getString("prenomClient");
			String telClient = resultClient.getString("telClient");
			
			textidClient.setText(idClient);
			textPrenomClient.setText(prenomClient);
			textNomClient.setText(telClient);
			
			// Debug
			
			/*System.out.println("idClient: " +idClient);
			System.out.println("nomClient: " +nomClient);
			System.out.println("prenomClient: " +prenomClient);
			System.out.println("telClient: " +telClient); 
			*/
			
		} else System.out.println("Pas de donn�es trouv�s pour la table client...");
	}
		public void selectPizza(String nomPizza) throws SQLException{
		
			String sqlPizza = "select * from pizza where nomPizza = '"+nomPizza + "'";
			Statement statement = connection.createStatement();
			
			ResultSet resultPizza = statement.executeQuery(sqlPizza);
			
			if(resultPizza.next()) {
	
				String idPizza = resultPizza.getString("idPizza");
				String taillePizza = resultPizza.getString("taillePizza");
				String prixPizza = resultPizza.getString("prixPizza");
				
				textIdPizza.setText(idPizza);
				textTaillePizza.setText(taillePizza);
				textPrixPizza.setText(prixPizza);
				
				// Debug
				
				/*System.out.println("idClient: " +idClient);
				System.out.println("nomClient: " +nomClient);
				System.out.println("prenomClient: " +prenomClient);
				System.out.println("telClient: " +telClient); 
				*/
				
			} else System.out.println("Pas de donn�es trouv�s...");
	}
}