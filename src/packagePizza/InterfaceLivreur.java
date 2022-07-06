package packagePizza;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class InterfaceLivreur {

	public JFrame frame;
	
	// Ajout� pour la connexion
	private static Connection connection = null;
	private static Scanner scanner = new Scanner(System.in);
	private JTextField textfieldLibAdresse;
	private JTextField textfieldTelephoneClient;
	private JTextField textfieldVille;
	private JTextField textfieldCodePostale;
	private JTextField textfieldComplementAdresse;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceLivreur window = new InterfaceLivreur();
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
	public InterfaceLivreur() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceLivreur.class.getResource("/packagePizza/PizzBurg_logo.ico")));
		frame.getContentPane().setBackground(new Color(246, 201, 84));
		frame.setBounds(100, 100, 432, 659);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JComboBox comboBoxTelephoneLivreur = new JComboBox();
		comboBoxTelephoneLivreur.setBounds(127, 126, 172, 22);
		frame.getContentPane().add(comboBoxTelephoneLivreur);
		
		final JLabel lblHeureLivraison = new JLabel("15:30");
		lblHeureLivraison.setFont(new Font("Rockwell", Font.BOLD, 26));
		lblHeureLivraison.setBounds(170, 326, 83, 33);
		lblHeureLivraison.setVisible(false);
		frame.getContentPane().add(lblHeureLivraison);
		
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
		
		String sql = "select * from Livreur";
		
		
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		
		while(result.next()) {
			comboBoxTelephoneLivreur.addItem(result.getString(4));
			}
		}
		catch (Exception e) {
			throw new RuntimeException("Erreur d�tect�");
		}
		
		JLabel lblAccueil = new JLabel("      Accueil");
		lblAccueil.setFont(new Font("Rockwell", Font.PLAIN, 30));
		lblAccueil.setBounds(106, 11, 248, 42);
		frame.getContentPane().add(lblAccueil);
		
		JLabel lblLivreur = new JLabel("      Livreur");
		lblLivreur.setFont(new Font("Rockwell", Font.PLAIN, 26));
		lblLivreur.setBounds(126, 39, 248, 42);
		frame.getContentPane().add(lblLivreur);
		
		JLabel lblListeDesCommandes = new JLabel("Liste des commandes");
		lblListeDesCommandes.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblListeDesCommandes.setBounds(127, 199, 222, 42);
		frame.getContentPane().add(lblListeDesCommandes);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfacePizzeria newFenetrePizzeria = new InterfacePizzeria();
				newFenetrePizzeria.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		btnRetour.setBounds(7, 11, 89, 23);
		frame.getContentPane().add(btnRetour);
		
		final JComboBox comboBoxListCommande = new JComboBox();
		comboBoxListCommande.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					lblHeureLivraison.setText(getHeureArrive(comboBoxListCommande.getSelectedItem().toString()));
					textfieldTelephoneClient.setText(getTelClient(comboBoxListCommande.getSelectedItem().toString()));
					textfieldLibAdresse.setText(getLibAdresse(comboBoxListCommande.getSelectedItem().toString()));
					textfieldVille.setText(getVille(comboBoxListCommande.getSelectedItem().toString()));
					textfieldCodePostale.setText(getCodePostale(comboBoxListCommande.getSelectedItem().toString()));
					textfieldComplementAdresse.setText(getComplementAdresse(comboBoxListCommande.getSelectedItem().toString()));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		comboBoxListCommande.setBounds(127, 248, 172, 22);
		frame.getContentPane().add(comboBoxListCommande);
		
		JLabel lblHeureDeLivraison = new JLabel("Heure de livraison souhait\u00E9:");
		lblHeureDeLivraison.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblHeureDeLivraison.setBounds(82, 292, 292, 42);
		frame.getContentPane().add(lblHeureDeLivraison);
		
		JLabel lblListeTelLivreur = new JLabel("T\u00E9l\u00E9phone du livreur");
		lblListeTelLivreur.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblListeTelLivreur.setBounds(125, 81, 263, 42);
		frame.getContentPane().add(lblListeTelLivreur);
		

		
		JButton btnLivreurValider = new JButton("Valider");
		btnLivreurValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					// Debug pour v�rifier si le num�ro de t�l�phone est bon
					//System.out.print(selectLivreur(comboBoxTelephoneLivreur.getSelectedItem().toString()));
					
					comboBoxListCommande.removeAllItems();		
					selectLivreur(comboBoxTelephoneLivreur.getSelectedItem().toString());
					selectCommande(comboBoxListCommande,comboBoxTelephoneLivreur.getSelectedItem().toString(),lblHeureLivraison );
					lblHeureLivraison.setVisible(true);
					

					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnLivreurValider.setFont(new Font("Rockwell", Font.PLAIN, 16));
		btnLivreurValider.setBounds(166, 159, 100, 30);
		frame.getContentPane().add(btnLivreurValider);
		
		JLabel lblAdresseDeLivraison = new JLabel("Adresse de livraison");
		lblAdresseDeLivraison.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblAdresseDeLivraison.setBounds(7, 358, 292, 42);
		frame.getContentPane().add(lblAdresseDeLivraison);
		
		textfieldLibAdresse = new JTextField();
		textfieldLibAdresse.setBounds(7, 394, 180, 19);
		frame.getContentPane().add(textfieldLibAdresse);
		textfieldLibAdresse.setColumns(10);
		
		textfieldTelephoneClient = new JTextField();
		textfieldTelephoneClient.setColumns(10);
		textfieldTelephoneClient.setBounds(87, 495, 267, 19);
		frame.getContentPane().add(textfieldTelephoneClient);
		
		JLabel lblTlphoneDuClient = new JLabel("T\u00E9l\u00E9phone du client");
		lblTlphoneDuClient.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblTlphoneDuClient.setBounds(113, 452, 292, 42);
		frame.getContentPane().add(lblTlphoneDuClient);
		
		textfieldVille = new JTextField();
		textfieldVille.setColumns(10);
		textfieldVille.setBounds(197, 394, 115, 19);
		frame.getContentPane().add(textfieldVille);
		
		textfieldCodePostale = new JTextField();
		textfieldCodePostale.setColumns(10);
		textfieldCodePostale.setBounds(322, 394, 83, 19);
		frame.getContentPane().add(textfieldCodePostale);
		
		textfieldComplementAdresse = new JTextField();
		textfieldComplementAdresse.setColumns(10);
		textfieldComplementAdresse.setBounds(7, 422, 248, 19);
		frame.getContentPane().add(textfieldComplementAdresse);
	}
	public String getComplementAdresse(String idCommande) throws SQLException {
		
		String sql = "select * from commande c inner join adresse a on c.idAdresse=a.idAdresse where idCommande ="+idCommande;
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		if(result.next()) {
			return result.getString("a.complementAdresse");
		}
		else System.out.println("Pas de donn�es trouv�s...");
		return "Pas de donn�e";
	}
	
	
	
	public String getCodePostale(String idCommande) throws SQLException {
		
		String sql = "select * from commande c inner join adresse a on c.idAdresse=a.idAdresse where idCommande ="+idCommande;
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		if(result.next()) {
			return result.getString("a.codePostale");
		}
		else System.out.println("Pas de donn�es trouv�s...");
		return "Pas de donn�e";
	}
	
	public String getVille(String idCommande) throws SQLException {
		
		String sql = "select * from commande c inner join adresse a on c.idAdresse=a.idAdresse where idCommande ="+idCommande;
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		if(result.next()) {
			return result.getString("a.ville");
		}
		else System.out.println("Pas de donn�es trouv�s...");
		return "Pas de donn�e";
	}
	
	public String getLibAdresse(String idCommande) throws SQLException {
		
		String sql = "select * from commande c inner join adresse a on c.idAdresse=a.idAdresse where idCommande ="+idCommande;
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		if(result.next()) {
			return result.getString("a.libAdresse");
		}
		else System.out.println("Pas de donn�es trouv�s...");
		return "Pas de donn�e";
	}
	
	
	public String getTelClient(String idCommande) throws SQLException {
		
		String sql = "select cl.idClient, cl.telClient,c.idCommande from commande c inner join client cl on c.idClient=cl.idClient where idCommande ="+idCommande;
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		if(result.next()) {
			return result.getString("cl.telClient");
		}
		else System.out.println("Pas de donn�es trouv�s...");
		return "Pas de donn�e";
	}
	
	
	public String getHeureArrive(String idCommande) throws SQLException {
		
		String sql = "select HeureArrive from commande where idCommande ="+idCommande;
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		if(result.next()) {
			return result.getString("HeureArrive");
		}
		else System.out.println("Pas de donn�es trouv�s...");
		return "Pas de donn�e";
	}
	
	
	public void selectCommande(final JComboBox comboBoxListCommande, String telLivreur, final JLabel lblHeureLivraison  ) throws SQLException{
		
		String sql = "select * from livreur l inner join commande c on l.idLivreur = c.idLivreur inner join client cl on c.idClient = cl.idClient where l.numTel = "+ "'"+telLivreur+"'";
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		if(result.next()) {
			
			lblHeureLivraison.setText(result.getString("HeureArrive"));
			
			while(result.next())  {
				comboBoxListCommande.addItem(result.getString("idCommande"));
			}
			
			
			
			
			// Debug
			
			/*System.out.println("idClient: " +idClient);
			System.out.println("nomClient: " +nomClient);
			System.out.println("prenomClient: " +prenomClient);
			System.out.println("telClient: " +telClient); 
			*/
			
		} else System.out.println("Pas de donn�es trouv�s...");
		
	}
	
	public String selectLivreur(String telLivreur ) throws SQLException{
		
		String sql = "select * from livreur where numTel ="+ "'" + telLivreur+ "'";
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		if(result.next()) {
			
			
			
			String numTel = result.getString("numTel");
			return numTel;
			
			
			// Debug
			
			/*System.out.println("idClient: " +idClient);
			System.out.println("nomClient: " +nomClient);
			System.out.println("prenomClient: " +prenomClient);
			System.out.println("telClient: " +telClient); 
			*/
			
		} else System.out.println("Pas de donn�es trouv�s...");
		return "Pas de donn�e...";
		
	}
}
