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
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class InterfaceConsulterCommande {

	public JFrame frame;
	private JTextField textTaillePizza;
	private JTextField textNomPizza;
	
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
					InterfaceConsulterCommande window = new InterfaceConsulterCommande();
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
	public InterfaceConsulterCommande() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 948, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		


		
		
		final JComboBox comboBoxIdCommande = new JComboBox();
		comboBoxIdCommande.setBounds(174, 132, 180, 21);
		frame.getContentPane().add(comboBoxIdCommande);
		
		textTaillePizza = new JTextField();
		textTaillePizza.setBounds(604, 157, 180, 19);
		frame.getContentPane().add(textTaillePizza);
		textTaillePizza.setColumns(10);
		
		JLabel lblTaillePizza = new JLabel("Taille");
		lblTaillePizza.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblTaillePizza.setBounds(670, 134, 46, 13);
		frame.getContentPane().add(lblTaillePizza);
		
		textNomPizza = new JTextField();
		textNomPizza.setColumns(10);
		textNomPizza.setBounds(604, 105, 180, 19);
		frame.getContentPane().add(textNomPizza);
		
		JLabel lblId = new JLabel("Identifiant Commande");
		lblId.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblId.setBounds(174, 109, 191, 13);
		frame.getContentPane().add(lblId);
		
		JLabel lblNomPizza = new JLabel("Nom");
		lblNomPizza.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblNomPizza.setBounds(664, 82, 102, 13);
		frame.getContentPane().add(lblNomPizza);
		
		final JComboBox comboBoxHeureLivraisonSouhaite = new JComboBox();
		comboBoxHeureLivraisonSouhaite.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//System.out.print("Item changé");

			}
		});
		comboBoxHeureLivraisonSouhaite.setBounds(10, 219, 198, 21);
		frame.getContentPane().add(comboBoxHeureLivraisonSouhaite);
		
		JLabel lblHeureDeLivraison = new JLabel("Heure de livraison souhait\u00E9");
		lblHeureDeLivraison.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblHeureDeLivraison.setBounds(10, 199, 198, 13);
		frame.getContentPane().add(lblHeureDeLivraison);
		
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
		
		String sql = "select idCommande from commande";
		
		
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		
		while(result.next()) {
			comboBoxIdCommande.addItem(result.getString(1));
		}
		
		
		}
		catch (Exception e) {
			throw new RuntimeException("Erreur détecté");
		
			
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
		btnNewButton.setBounds(10, 5, 102, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					selectCommande(comboBoxIdCommande.getSelectedItem().toString());
					
				} catch (Exception z) {
					throw new RuntimeException("Erreur detecte");
				}
				
				
			}
		});
	
		btnAfficher.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnAfficher.setBounds(214, 163, 102, 33);
		frame.getContentPane().add(btnAfficher);
		

	}

	
	
	public void selectCommande(String idCommande) throws SQLException{
		
		String sql = "select * from commande c inner join pizza p on c.idPizza=p.idPizza inner join adresse a on c.idAdresse=a.idAdresse inner join client cl on c.idClient=cl.idClient where idCommande ="+idCommande+"order by HeureArrive";
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		if(result.next()) {
			
			
			
			String nomPizza = result.getString("pizza.nomPizza");
			String taillePizza = result.getString("pizza.taillePizza");
			
			textTaillePizza.setText(taillePizza);
			textNomPizza.setText(nomPizza);
			
			// Debug
			
			/*System.out.println("idClient: " +idClient);
			System.out.println("nomClient: " +nomClient);
			System.out.println("prenomClient: " +prenomClient);
			System.out.println("telClient: " +telClient); 
			*/
			
		} else System.out.println("Pas de données trouvés...");
		
	}
}
