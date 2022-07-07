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

public class InterfaceConsulterIngredient {

	public JFrame frame;
	private JTextField textIdIngredient;
	private JTextField textQuantite;
	
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
					InterfaceConsulterIngredient window = new InterfaceConsulterIngredient();
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
	public InterfaceConsulterIngredient() {
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
		


		
		
		final JComboBox comboBoxNomIngredient = new JComboBox();
		comboBoxNomIngredient.setBounds(131, 68, 180, 21);
		frame.getContentPane().add(comboBoxNomIngredient);
		
		textIdIngredient = new JTextField();
		textIdIngredient.setBounds(131, 124, 180, 19);
		frame.getContentPane().add(textIdIngredient);
		textIdIngredient.setColumns(10);
		
		JLabel lblIdIngredient = new JLabel("Identifiant");
		lblIdIngredient.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblIdIngredient.setBounds(131, 100, 100, 13);
		frame.getContentPane().add(lblIdIngredient);
		
		textQuantite = new JTextField();
		textQuantite.setColumns(10);
		textQuantite.setBounds(131, 178, 180, 19);
		frame.getContentPane().add(textQuantite);
		
		JLabel lblNomIngredient = new JLabel("Ingredient");
		lblNomIngredient.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblNomIngredient.setBounds(131, 36, 77, 21);
		frame.getContentPane().add(lblNomIngredient);
		
		JLabel lblQuantite = new JLabel("Quantit\u00E9");
		lblQuantite.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblQuantite.setBounds(131, 154, 102, 13);
		frame.getContentPane().add(lblQuantite);
		
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
		
		String sql = "select * from ingredient";
		
		
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		
		while(result.next()) {
			comboBoxNomIngredient.addItem(result.getString(2));
		}
		
		
		}
		catch (Exception e) {
			throw new RuntimeException("Erreur d�tect�");
		
			
		}
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//InterfaceAjoutPizza interfaceAjoutPizza = new InterfaceAjoutPizza();
				//interfaceAjoutPizza.frame.setVisible(true);
				
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnNewButton.setBounds(172, 252, 102, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					selectClient(comboBoxNomIngredient.getSelectedItem().toString());
					
				} catch (Exception z) {
					throw new RuntimeException("Erreur detecte");
				}
				
				
			}
		});
	
		btnAfficher.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnAfficher.setBounds(172, 208, 102, 33);
		frame.getContentPane().add(btnAfficher);
	}
	public void selectClient(String nomIngredient) throws SQLException{
		
		String sql = "select * from ingredient where nomIngredient ="+ "'" + nomIngredient + "'";
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		if(result.next()) {
			
			
			
			String idIngredient = result.getString("idIngredient");
			String quantiteIngredient = result.getString("quantiteIngredient");
		
			
			textIdIngredient.setText(idIngredient);
			textQuantite.setText(quantiteIngredient);
			//textNomPizza.setText(nomPizza);
			
			// Debug
			
			/*System.out.println("idClient: " +idClient);
			System.out.println("nomClient: " +nomClient);
			System.out.println("prenomClient: " +prenomClient);
			System.out.println("telClient: " +telClient); 
			*/
			
		} else System.out.println("Pas de donn�es trouv�s...");
		
	}
}
