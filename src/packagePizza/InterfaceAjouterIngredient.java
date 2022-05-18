package packagePizza;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Console;


public class InterfaceAjouterIngredient {

	public JFrame frame;
	private JTextField textNomPizza;
	private JTextField textQuantiteIngredient;
	
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
					InterfaceAjouterIngredient window = new InterfaceAjouterIngredient();
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
	public InterfaceAjouterIngredient() {
		initialize();
		ClientDb connection = new ClientDb();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 477, 359);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNomIngredient = new JLabel("Ingredient");
		lblNomIngredient.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomIngredient.setFont(new Font("The Next Font", Font.PLAIN, 20));
		lblNomIngredient.setBounds(188, 33, 110, 21);
		frame.getContentPane().add(lblNomIngredient);
		
		textNomPizza = new JTextField();
		textNomPizza.setBounds(160, 63, 138, 19);
		frame.getContentPane().add(textNomPizza);
		textNomPizza.setColumns(10);
		
		JLabel lblQuantiteIngredient = new JLabel("Quantit\u00E9");
		lblQuantiteIngredient.setFont(new Font("The Next Font", Font.PLAIN, 20));
		lblQuantiteIngredient.setBounds(188, 105, 109, 21);
		frame.getContentPane().add(lblQuantiteIngredient);
		
		textQuantiteIngredient = new JTextField();
		textQuantiteIngredient.addKeyListener(new KeyAdapter() {
			/* Vérifie si le caractère de la quantité est bien un chiffre et sans espace
			pour pouvoir correctement l'insérer dans la BDD */
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c=e.getKeyChar();
				if (Character.isLetter(c)&&!e.isAltDown() || c == KeyEvent.VK_SPACE ) {
					e.consume();
					System.out.print("Le caractère n'est pas un chiffre\n");
				}
			}
			
			 
		});
		textQuantiteIngredient.setColumns(10);
		textQuantiteIngredient.setBounds(160, 125, 138, 19);
		frame.getContentPane().add(textQuantiteIngredient);
		
		boolean coReussi = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		String dbURL = "jdbc:mysql://localhost:3306/pizzeria"; /* Commande pour savoir le port mysql: show global variables like 'PORT'; */
		String dbUsername = "root";
		String password = "";
		
		connection = DriverManager.getConnection(dbURL, dbUsername, password);
		coReussi = true;
		
		
		
		}
		catch (Exception e) {
			throw new RuntimeException("Erreur detecte");
		
			
		}
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomIngredient = textNomPizza.getText();
				String quantiteIngredient = textQuantiteIngredient.getText();
			
				
				String sql = "insert into ingredient(nomIngredient, quantiteIngredient) values (?,?)";
				try {
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement = connection.prepareStatement(sql);
					
					preparedStatement.setString(1, nomIngredient);
					preparedStatement.setString(2, quantiteIngredient);
					
					int rows = preparedStatement.executeUpdate();
					
					if(rows > 0) {
						System.out.println("Insertion exécuté avec succès");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		});
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAjouter.setBounds(148, 155, 159, 39);
		frame.getContentPane().add(btnAjouter);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceGestionnaire fenetreGestionnaire = new InterfaceGestionnaire();
				fenetreGestionnaire.frame.setVisible(true);
				
				frame.dispose();
			}
		});
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAnnuler.setBounds(148, 205, 159, 39);
		frame.getContentPane().add(btnAnnuler);
		
		JLabel lblStatutBDD = new JLabel("Statut de la BDD");
		lblStatutBDD.setFont(new Font("The Next Font", Font.BOLD, 14));
		lblStatutBDD.setBounds(20, 11, 130, 21);
		frame.getContentPane().add(lblStatutBDD);
		
		JLabel labelBdd = new JLabel("Status");
		labelBdd.setForeground(Color.GRAY);
		labelBdd.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
		labelBdd.setBounds(30, 13, 187, 66);
		frame.getContentPane().add(labelBdd);
		
		JButton btnConsulterPizza = new JButton("Consulter");
		btnConsulterPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceConsulterPizza consulterPizza = new InterfaceConsulterPizza();
				consulterPizza.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnConsulterPizza.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnConsulterPizza.setBounds(160, 266, 123, 29);
		frame.getContentPane().add(btnConsulterPizza);
		

		if (coReussi = true) {
			labelBdd.setText("Connexion réussi!");
			labelBdd.setForeground(Color.GREEN);
		} else {
			labelBdd.setText("La connexion à echoué");
			labelBdd.setForeground(Color.RED);
		}
		
	}
}
