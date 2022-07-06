package packagePizza;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class InterfaceCommande {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

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
					InterfaceCommande window = new InterfaceCommande();
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
	public InterfaceCommande() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JComboBox comboBoxTelephoneLivreur = new JComboBox();
		comboBoxTelephoneLivreur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					selectClient(comboBoxTelephoneLivreur.getSelectedItem().toString());
					
				} catch (Exception z) {
					throw new RuntimeException("Erreur detecte");
				}
			}
		});
		comboBoxTelephoneLivreur.setBounds(84, 53, 172, 22);
		frame.getContentPane().add(comboBoxTelephoneLivreur);
		
		JLabel lblListeDesCommandes = new JLabel("Liste des commandes");
		lblListeDesCommandes.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblListeDesCommandes.setBounds(84, 11, 222, 42);
		frame.getContentPane().add(lblListeDesCommandes);
		
		JLabel lblnomPizza = new JLabel("Pizza");
		lblnomPizza.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblnomPizza.setBounds(84, 86, 89, 21);
		frame.getContentPane().add(lblnomPizza);
		
		JLabel lblTempsPrparation = new JLabel("Temps préparation");
		lblTempsPrparation.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblTempsPrparation.setBounds(84, 153, 172, 21);
		frame.getContentPane().add(lblTempsPrparation);
		
		Button button = new Button("Afficher commande");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfficherCommandeCuisinier afficherCommandeCuisinier = new AfficherCommandeCuisinier();
				afficherCommandeCuisinier.frame.setVisible(true);
				frame.dispose();
			}
		});
		button.setBounds(320, 229, 104, 22);
		frame.getContentPane().add(button);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(84, 120, 172, 22);
		frame.getContentPane().add(textField);
		textField.setEditable(false);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(84, 185, 172, 22);
		frame.getContentPane().add(textField_1);
		
		boolean coReussi = false;
		
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
			comboBoxTelephoneLivreur.addItem(result.getString(1));
		}
		
		
		}
		catch (Exception e) {
			throw new RuntimeException("Erreur d�tect�");
		
			
		}
	}
	
public void selectClient(String idPizza) throws SQLException{
		
		String sql = "select * from pizza where idPizza ="+idPizza;
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		if(result.next()) {
			
			
			
			String nomPizza = result.getString("nomPizza");
			
			textField.setText(nomPizza);
			
			// Debug
			
			/*System.out.println("idClient: " +idClient);
			System.out.println("nomClient: " +nomClient);
			System.out.println("prenomClient: " +prenomClient);
			System.out.println("telClient: " +telClient); 
			*/
			
		} else System.out.println("Pas de donn�es trouv�s...");
		
	}
}
