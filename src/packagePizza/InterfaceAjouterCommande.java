package packagePizza;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//
// For date time
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.util.Calendar;
import java.util.Date;
import java.awt.Color;
import javax.swing.JMenuBar;


public class InterfaceAjouterCommande {

	public JFrame frame;
	private JTextField textidClient;
	private JTextField textPrenomClient;
	private JTextField textNomClient;
	
	// Ajout� pour la connexion
	private static Connection connection = null;
	private static Scanner scanner = new Scanner(System.in);
	private JTextField texNomPizza;
	private JTextField textTaillePizza;
	private JTextField textPrixPizza;
	private JTextField textIdCuisinier;
	private JTextField textPrenomCuisinier;
	private JTextField textTelCuisinier;
	private JTextField textIdLivreur;
	private JTextField textPrenomLivreur;
	private JTextField textTelLivreur;
	private JTextField textHeureLivraison;
	private JTextField textCodePostale;
	private JTextField textVille;
	private JTextField textLibAdresse;
	private JTextField textComplementAdresse;

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
		frame.getContentPane().setBackground(new Color(246, 201, 84));
		frame.setBounds(100, 100, 966, 633);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		


		
		
		final JComboBox comboBoxTelClient = new JComboBox();
		comboBoxTelClient.setBounds(155, 39, 180, 21);
		frame.getContentPane().add(comboBoxTelClient);
		
		final JComboBox comboBoxPizza = new JComboBox();
		comboBoxPizza.setBounds(345, 39, 180, 21);
		frame.getContentPane().add(comboBoxPizza);
		
		textidClient = new JTextField();
		textidClient.setBounds(155, 105, 180, 26);
		frame.getContentPane().add(textidClient);
		textidClient.setColumns(10);
		
		JLabel lblidClient = new JLabel("Identifiant");
		lblidClient.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblidClient.setBounds(155, 82, 77, 13);
		frame.getContentPane().add(lblidClient);
		
		textPrenomClient = new JTextField();
		textPrenomClient.setColumns(10);
		textPrenomClient.setBounds(155, 157, 180, 26);
		frame.getContentPane().add(textPrenomClient);
		
		JLabel lblPrenomClient = new JLabel("Prenom");
		lblPrenomClient.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblPrenomClient.setBounds(155, 134, 77, 13);
		frame.getContentPane().add(lblPrenomClient);
		
		textNomClient = new JTextField();
		textNomClient.setColumns(10);
		textNomClient.setBounds(155, 211, 180, 26);
		frame.getContentPane().add(textNomClient);
		
		JLabel lblTelClient = new JLabel("Client");
		lblTelClient.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblTelClient.setBounds(155, 16, 77, 13);
		frame.getContentPane().add(lblTelClient);
		
		JLabel lblNomClient = new JLabel("Nom");
		lblNomClient.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblNomClient.setBounds(155, 186, 102, 13);
		frame.getContentPane().add(lblNomClient);
		
		final JComboBox comboBoxNomLivreur = new JComboBox();
		comboBoxNomLivreur.setBounds(725, 39, 180, 21);
		frame.getContentPane().add(comboBoxNomLivreur);
		
		final JComboBox comboBoxNomCuisinier = new JComboBox();
		comboBoxNomCuisinier.setBounds(535, 39, 180, 21);
		frame.getContentPane().add(comboBoxNomCuisinier);
		
		JLabel lblHeureLivraison = new JLabel("Heure de livraison souhait\u00E9");
		lblHeureLivraison.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblHeureLivraison.setBounds(705, 364, 197, 13);
		frame.getContentPane().add(lblHeureLivraison);
		
		/* Variable de debug pour v�rifier si la connexion a bien �t� �tabli */
		boolean coReussi = false;
		
		// Connexion
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/pizzeria","root","root");
			coReussi = true;
			
			
			//int idSelect = Integer.parseInt(scanner.nextLine());
			
			
			String sqlPizza = "select * from pizza";
			
			Statement statementPizza = connection.createStatement();
			ResultSet resultPizza = statementPizza.executeQuery(sqlPizza);
			
			String sqlClient = "select * from client";
			Statement statementClient = connection.createStatement();
			ResultSet resultClient = statementClient.executeQuery(sqlClient);
			
			String sqlCuisinier = "select * from cuisinier";
			Statement statementCuisinier = connection.createStatement();
			ResultSet resultCuisinier = statementCuisinier.executeQuery(sqlCuisinier);
			
			String sqlLivreur = "select * from livreur";
			Statement statementLivreur = connection.createStatement();
			ResultSet resultLivreur = statementLivreur.executeQuery(sqlLivreur);
			
			
			while(resultClient.next()) {
				comboBoxTelClient.addItem(resultClient.getString("telClient"));
			}
			while (resultPizza.next()) {
				comboBoxPizza.addItem(resultPizza.getString("idPizza"));
			}
			while (resultCuisinier.next()) {
				comboBoxNomCuisinier.addItem(resultCuisinier.getString("nomCuisinier"));
			}
			while (resultLivreur.next()) {
				comboBoxNomLivreur.addItem(resultLivreur.getString("nomLivreur"));
			}
		
		}
		
		catch (Exception e) {
			throw new RuntimeException("Erreur d�tect�");
		
			
		}
		
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
		btnAfficher.setBounds(198, 240, 102, 33);
		frame.getContentPane().add(btnAfficher);
		

		
		JLabel lblListPizza = new JLabel("Pizza");
		lblListPizza.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblListPizza.setBounds(390, 16, 102, 13);
		frame.getContentPane().add(lblListPizza);
		
		JLabel lblnomPizza = new JLabel("Nom");
		lblnomPizza.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblnomPizza.setBounds(345, 82, 77, 13);
		frame.getContentPane().add(lblnomPizza);
		
		texNomPizza = new JTextField();
		texNomPizza.setColumns(10);
		texNomPizza.setBounds(345, 105, 180, 26);
		frame.getContentPane().add(texNomPizza);
		
		JLabel lblTaillePizza = new JLabel("Taille");
		lblTaillePizza.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblTaillePizza.setBounds(345, 134, 77, 13);
		frame.getContentPane().add(lblTaillePizza);
		
		textTaillePizza = new JTextField();
		textTaillePizza.setColumns(10);
		textTaillePizza.setBounds(345, 157, 180, 26);
		frame.getContentPane().add(textTaillePizza);
		
		JLabel lblPrixPizza = new JLabel("Prix");
		lblPrixPizza.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblPrixPizza.setBounds(345, 188, 77, 13);
		frame.getContentPane().add(lblPrixPizza);
		
		textPrixPizza = new JTextField();
		textPrixPizza.setColumns(10);
		textPrixPizza.setBounds(345, 211, 180, 26);
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
		btnAfficher_1.setBounds(385, 240, 102, 33);
		frame.getContentPane().add(btnAfficher_1);
		
		JButton btnAjouterCommande = new JButton("Ajouter");
		btnAjouterCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AjouterCommande(AjouterAdresse(), AjouterDateCommande());
				
				
			}
		});
		btnAjouterCommande.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnAjouterCommande.setBounds(705, 418, 197, 63);
		frame.getContentPane().add(btnAjouterCommande);
		
		
		JLabel lblListCuisinier = new JLabel("Cuisinier");
		lblListCuisinier.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblListCuisinier.setBounds(597, 16, 102, 13);
		frame.getContentPane().add(lblListCuisinier);
		
		textIdCuisinier = new JTextField();
		textIdCuisinier.setColumns(10);
		textIdCuisinier.setBounds(535, 105, 180, 26);
		frame.getContentPane().add(textIdCuisinier);
		
		JLabel lblid_1_1 = new JLabel("Identifiant");
		lblid_1_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblid_1_1.setBounds(535, 82, 77, 13);
		frame.getContentPane().add(lblid_1_1);
		
		textPrenomCuisinier = new JTextField();
		textPrenomCuisinier.setColumns(10);
		textPrenomCuisinier.setBounds(535, 157, 180, 26);
		frame.getContentPane().add(textPrenomCuisinier);
		
		JLabel lblPrenomCuisinier = new JLabel("Prenom");
		lblPrenomCuisinier.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblPrenomCuisinier.setBounds(535, 134, 77, 13);
		frame.getContentPane().add(lblPrenomCuisinier);
		
		textTelCuisinier = new JTextField();
		textTelCuisinier.setColumns(10);
		textTelCuisinier.setBounds(535, 211, 180, 26);
		frame.getContentPane().add(textTelCuisinier);
		
		JLabel lblTelCuisinier = new JLabel("T\u00E9l\u00E9phone");
		lblTelCuisinier.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblTelCuisinier.setBounds(535, 188, 102, 13);
		frame.getContentPane().add(lblTelCuisinier);
		
		JButton btnAfficher_1_1 = new JButton("Afficher");
		btnAfficher_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					selectCuisinier(comboBoxNomCuisinier.getSelectedItem().toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAfficher_1_1.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnAfficher_1_1.setBounds(583, 240, 102, 33);
		frame.getContentPane().add(btnAfficher_1_1);
		

		
		JLabel lblListLivreur = new JLabel("Livreur");
		lblListLivreur.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblListLivreur.setBounds(780, 16, 102, 13);
		frame.getContentPane().add(lblListLivreur);
		
		JLabel lblid_1_1_1 = new JLabel("Identifiant");
		lblid_1_1_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblid_1_1_1.setBounds(725, 82, 77, 13);
		frame.getContentPane().add(lblid_1_1_1);
		
		textIdLivreur = new JTextField();
		textIdLivreur.setColumns(10);
		textIdLivreur.setBounds(725, 105, 180, 26);
		frame.getContentPane().add(textIdLivreur);
		
		JLabel lblPrenomLivreur = new JLabel("Livreur");
		lblPrenomLivreur.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblPrenomLivreur.setBounds(725, 134, 77, 13);
		frame.getContentPane().add(lblPrenomLivreur);
		
		textPrenomLivreur = new JTextField();
		textPrenomLivreur.setColumns(10);
		textPrenomLivreur.setBounds(725, 157, 180, 26);
		frame.getContentPane().add(textPrenomLivreur);
		
		JLabel lblTelLivreur = new JLabel("T\u00E9l\u00E9phone");
		lblTelLivreur.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblTelLivreur.setBounds(725, 188, 102, 13);
		frame.getContentPane().add(lblTelLivreur);
		
		textTelLivreur = new JTextField();
		textTelLivreur.setColumns(10);
		textTelLivreur.setBounds(725, 211, 180, 26);
		frame.getContentPane().add(textTelLivreur);
		
		JButton btnAfficher_1_1_1 = new JButton("Afficher");
		btnAfficher_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					selectLivreur(comboBoxNomLivreur.getSelectedItem().toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAfficher_1_1_1.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnAfficher_1_1_1.setBounds(756, 240, 102, 33);
		frame.getContentPane().add(btnAfficher_1_1_1);
		
		textHeureLivraison = new JTextField();
		textHeureLivraison.setColumns(10);
		textHeureLivraison.setBounds(705, 388, 200, 26);
		frame.getContentPane().add(textHeureLivraison);
		
		textCodePostale = new JTextField();
		textCodePostale.setColumns(10);
		textCodePostale.setBounds(155, 465, 180, 26);
		frame.getContentPane().add(textCodePostale);
		
		JLabel lblCodePostale = new JLabel("Code Postale");
		lblCodePostale.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblCodePostale.setBounds(155, 441, 102, 13);
		frame.getContentPane().add(lblCodePostale);
		
		textVille = new JTextField();
		textVille.setColumns(10);
		textVille.setBounds(155, 407, 180, 26);
		frame.getContentPane().add(textVille);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblVille.setBounds(155, 393, 77, 13);
		frame.getContentPane().add(lblVille);
		
		textLibAdresse = new JTextField();
		textLibAdresse.setColumns(10);
		textLibAdresse.setBounds(155, 362, 180, 26);
		frame.getContentPane().add(textLibAdresse);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblAdresse.setBounds(155, 338, 171, 13);
		frame.getContentPane().add(lblAdresse);
		
		textComplementAdresse = new JTextField();
		textComplementAdresse.setColumns(10);
		textComplementAdresse.setBounds(155, 519, 180, 26);
		frame.getContentPane().add(textComplementAdresse);
		
		JLabel lblComplementAdresse = new JLabel("Compl\u00E9ment d'adresse");
		lblComplementAdresse.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblComplementAdresse.setBounds(155, 495, 196, 13);
		frame.getContentPane().add(lblComplementAdresse);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.setBounds(0, 0, 75, 20);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//InterfaceGestionnaire interfaceGestionnaire = new InterfaceGestionnaire();
				//interfaceGestionnaire.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Rockwell", Font.PLAIN, 14));
		

	}
	
	
	public void AjouterCommande(Integer idAdr, Integer idDatee) {
		
		
		String HeureArrivee = textHeureLivraison.getText();
		Integer idAdresse = idAdr;
		Integer idDate =idDatee;
		
		String idClient = textidClient.getText();
		String idLivreur = textIdLivreur.getText();
		String idCuisinier = textIdCuisinier.getText();
		
		String sql = "insert into Commande(HeureArrive, idAdresse, idLivreur, idCuisinier, idDate, idClient) values (?,?,?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, HeureArrivee);
			preparedStatement.setInt(2, idAdresse);
			preparedStatement.setString(3, idLivreur);
			preparedStatement.setString(4, idCuisinier);
			preparedStatement.setInt(5, idDate);
			preparedStatement.setString(6, idClient);
						
			int rows = preparedStatement.executeUpdate();
			
			if(rows > 0) {
				System.out.println("Insertion ex�cut� avec succ�s");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
public Integer AjouterAdresse() {
			
		String libAdresse = textLibAdresse.getText();
		String ville = textVille.getText();
		String codePostale = textCodePostale.getText();
		String complementAdresse = textComplementAdresse.getText();
		
		int generatedKey = 0;
		
		
		
		String sql = "insert into Adresse(libAdresse,ville,codePostale,complementAdresse) values (?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //Statement.RETURN_GENERATED_KEYS pour r�cup�rer l'id de l'insertion et le retourner
			
			preparedStatement.setString(1, libAdresse);
			preparedStatement.setString(2, ville);
			preparedStatement.setString(3, codePostale);
			preparedStatement.setString(4, complementAdresse);
			
			int rows = preparedStatement.executeUpdate();
			
			ResultSet rs = preparedStatement.getGeneratedKeys();
			
			if(rs.next()) {
				generatedKey = rs.getInt(1);
			}
			System.out.println("Insertion avec l'id: "+generatedKey);
			
			//return true;
			if(rows > 0) {
				System.out.println("Insertion ex�cut� avec succ�s = "+rows);
			}
			return generatedKey;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			return generatedKey;
		}
	}
	
	public Integer AjouterDateCommande() {
		
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		
		String sql = "insert into dateCommande(DateCommande) values (?)";
		int generatedKey = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // Statement.RETURN_GENERATED_KEYS pour r�cup�rer l'id de l'insertion et le retourner
			
			preparedStatement.setDate(1, date);
			
			
			int rows = preparedStatement.executeUpdate();
			
			ResultSet rs = preparedStatement.getGeneratedKeys();
			
			if(rs.next()) {
				generatedKey = rs.getInt(1);
			}
			System.out.println("Insertion avec l'id: "+generatedKey);
			
			//return true;
			if(rows > 0) {
				System.out.println("Insertion ex�cut� avec succ�s = "+rows);
			}
			return generatedKey;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			return generatedKey;
		}
	}
	
	
	
	
	public void selectClient(String telClient) throws SQLException{
		
		String sql = "select * from client where telClient = '"+telClient + "'";
		Statement statement = connection.createStatement();
		
		ResultSet resultClient = statement.executeQuery(sql);
		
		if(resultClient.next()) {

			String idClient = resultClient.getString("idClient");
			String prenomClient = resultClient.getString("prenomClient");
			String nomClient = resultClient.getString("nomClient");
			
			textidClient.setText(idClient);
			textPrenomClient.setText(prenomClient);
			textNomClient.setText(nomClient);
			
			// Debug
			
			/*System.out.println("idClient: " +idClient);
			System.out.println("nomClient: " +nomClient);
			System.out.println("prenomClient: " +prenomClient);
			System.out.println("telClient: " +telClient); 
			*/
			
		} else System.out.println("Pas de donn�es trouv�s pour la table client...");
	}
		public void selectPizza(String idPizza) throws SQLException{
		
			String sqlPizza = "select * from pizza where idPizza = '"+idPizza + "'";
			Statement statement = connection.createStatement();
			
			ResultSet resultPizza = statement.executeQuery(sqlPizza);
			
			if(resultPizza.next()) {
	
				String nomPizza = resultPizza.getString("nomPizza");
				String taillePizza = resultPizza.getString("taillePizza");
				String prixPizza = resultPizza.getString("prixPizza");
				
				texNomPizza.setText(nomPizza);
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
		public void selectCuisinier(String nomCuisinier) throws SQLException{
			
			String sql = "select * from cuisinier where nomCuisinier = '"+ nomCuisinier + "'";
			Statement statement = connection.createStatement();
			
			ResultSet resultCuisinier = statement.executeQuery(sql);
			
			if(resultCuisinier.next()) {

				String idCuisinier = resultCuisinier.getString("idCuisinier");
				String prenomCuisinier = resultCuisinier.getString("prenomCuisinier");
				String numTel = resultCuisinier.getString("numTel");
				
				textIdCuisinier.setText(idCuisinier);
				textPrenomCuisinier.setText(prenomCuisinier);
				textTelCuisinier.setText(numTel);
				
				// Debug
				
				/*System.out.println("idClient: " +idClient);
				System.out.println("nomClient: " +nomClient);
				System.out.println("prenomClient: " +prenomClient);
				System.out.println("telClient: " +telClient); 
				*/
		
			}
		}
		public void selectLivreur(String nomLivreur) throws SQLException{
			
			String sql = "select * from livreur where nomLivreur = '"+nomLivreur + "'";
			Statement statement = connection.createStatement();
			
			ResultSet resultLivreur = statement.executeQuery(sql);
			
			if(resultLivreur.next()) {

				String idLivreur = resultLivreur.getString("idLivreur");
				String prenomLivreur = resultLivreur.getString("prenomLivreur");
				String numTel = resultLivreur.getString("numTel");
				
				textIdLivreur.setText(idLivreur);
				textPrenomLivreur.setText(prenomLivreur);
				textTelLivreur.setText(numTel);
				
				// Debug
				
				/*System.out.println("idClient: " +idClient);
				System.out.println("nomClient: " +nomClient);
				System.out.println("prenomClient: " +prenomClient);
				System.out.println("telClient: " +telClient); 
				*/
		
			}
		}
}