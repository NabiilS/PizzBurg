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

public class InterfaceConsulterClient {

	public JFrame frame;
	private JTextField textNomClient;
	private JTextField textPrenomClient;
	private JTextField textTelClient;
	
	// Ajouté pour la connexion
	private static Connection connection = null;
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceConsulterClient window = new InterfaceConsulterClient();
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
	public InterfaceConsulterClient() {
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
		


		
		
		final JComboBox comboBoxIdClient = new JComboBox();
		comboBoxIdClient.setBounds(131, 38, 180, 21);
		frame.getContentPane().add(comboBoxIdClient);
		
		textNomClient = new JTextField();
		textNomClient.setBounds(131, 98, 180, 19);
		frame.getContentPane().add(textNomClient);
		textNomClient.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblNom.setBounds(131, 82, 46, 13);
		frame.getContentPane().add(lblNom);
		
		textPrenomClient = new JTextField();
		textPrenomClient.setColumns(10);
		textPrenomClient.setBounds(131, 143, 180, 19);
		frame.getContentPane().add(textPrenomClient);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblPrenom.setBounds(131, 127, 77, 13);
		frame.getContentPane().add(lblPrenom);
		
		textTelClient = new JTextField();
		textTelClient.setColumns(10);
		textTelClient.setBounds(131, 188, 180, 19);
		frame.getContentPane().add(textTelClient);
		
		JLabel lblTel = new JLabel("T\u00E9l\u00E9phone");
		lblTel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblTel.setBounds(131, 172, 77, 13);
		frame.getContentPane().add(lblTel);
		
		JLabel lblIdClient = new JLabel("Identifiant");
		lblIdClient.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblIdClient.setBounds(172, 15, 102, 13);
		frame.getContentPane().add(lblIdClient);
		
		/* Variable de debug pour vérifier si la connexion a bien été établi */
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
		
		String sql = "select * from client";
		
		
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		
		while(result.next()) {
			comboBoxIdClient.addItem(result.getString(1));
		}
		
		
		}
		catch (Exception e) {
			throw new RuntimeException("Erreur détecté");
		
			
		}
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceAjoutClient interfaceAjoutClient = new InterfaceAjoutClient();
				interfaceAjoutClient.frame.setVisible(true);
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
					selectClient(comboBoxIdClient.getSelectedItem().toString());
					
				} catch (Exception z) {
					throw new RuntimeException("Erreur detecte");
				}
				
				
			}
		});
	
		btnAfficher.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnAfficher.setBounds(172, 236, 102, 33);
		frame.getContentPane().add(btnAfficher);
	}
	public void selectClient(String idClient) throws SQLException{
		
		String sql = "select * from client where idClient ="+idClient;
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		if(result.next()) {
			
			
			
			String nomClient = result.getString("nomClient");
			String prenomClient = result.getString("prenomClient");
			String telClient = result.getString("telClient");
			
			textNomClient.setText(nomClient);
			textPrenomClient.setText(prenomClient);
			textTelClient.setText(telClient);
			
			// Debug
			
			/*System.out.println("idClient: " +idClient);
			System.out.println("nomClient: " +nomClient);
			System.out.println("prenomClient: " +prenomClient);
			System.out.println("telClient: " +telClient); 
			*/
			
		} else System.out.println("Pas de données trouvés...");
		
	}
}
