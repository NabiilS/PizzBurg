package packagePizza;

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

public class InterfaceLivreur {

	public JFrame frame;
	
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
		frame.setBounds(100, 100, 461, 548);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JComboBox comboBoxTelephoneLivreur = new JComboBox();
		comboBoxTelephoneLivreur.setBounds(127, 126, 172, 22);
		frame.getContentPane().add(comboBoxTelephoneLivreur);
		
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
		
		String sql = "select * from Livreur";
		
		
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		
		while(result.next()) {
			comboBoxTelephoneLivreur.addItem(result.getString(4));
			}

		}
		catch (Exception e) {
			throw new RuntimeException("Erreur détecté");
		
			
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
		lblListeDesCommandes.setBounds(117, 254, 292, 42);
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
		
		JComboBox comboBoxListCommande = new JComboBox();
		comboBoxListCommande.setModel(new DefaultComboBoxModel(new String[] {"Test1", "Test2", "Test3"}));
		comboBoxListCommande.setBounds(127, 289, 172, 22);
		frame.getContentPane().add(comboBoxListCommande);
		
		JLabel lblHeureDeLivraison = new JLabel("Heure de livraison souhait\u00E9:");
		lblHeureDeLivraison.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblHeureDeLivraison.setBounds(87, 307, 292, 42);
		frame.getContentPane().add(lblHeureDeLivraison);
		
		JLabel lblNewLabel = new JLabel("15:30");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 26));
		lblNewLabel.setBounds(170, 344, 83, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("D\u00E9tail du client");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceDetailClient newFenetreClient = new InterfaceDetailClient();
				newFenetreClient.frame.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Rockwell", Font.PLAIN, 16));
		btnNewButton.setBounds(125, 388, 162, 33);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblListeTelLivreur = new JLabel("Mon t\u00E9l\u00E9phone");
		lblListeTelLivreur.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblListeTelLivreur.setBounds(136, 91, 263, 42);
		frame.getContentPane().add(lblListeTelLivreur);
		

		
		JButton btnLivreurValider = new JButton("Valider");
		btnLivreurValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					// Debug pour vérifier si le numéro de téléphone est bon
					//System.out.print(selectLivreur(comboBoxTelephoneLivreur.getSelectedItem().toString()));
					selectLivreur(comboBoxTelephoneLivreur.getSelectedItem().toString());
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnLivreurValider.setFont(new Font("Rockwell", Font.PLAIN, 16));
		btnLivreurValider.setBounds(153, 158, 100, 30);
		frame.getContentPane().add(btnLivreurValider);
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
			
		} else System.out.println("Pas de données trouvés...");
		return "Pas de donnée...";
		
	}
}
