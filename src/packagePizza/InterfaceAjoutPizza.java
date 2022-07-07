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


public class InterfaceAjoutPizza {

	public JFrame frame;
	private JTextField textNomPizza;
	private JTextField textPrix;
	
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
					InterfaceAjoutPizza window = new InterfaceAjoutPizza();
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
	public InterfaceAjoutPizza() {
		initialize();
		ClientDb connection = new ClientDb();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(246, 201, 84));
		frame.setBounds(100, 100, 477, 359);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblnomPizza = new JLabel("Pizza");
		lblnomPizza.setFont(new Font("The Next Font", Font.PLAIN, 20));
		lblnomPizza.setBounds(161, 31, 89, 21);
		frame.getContentPane().add(lblnomPizza);
		
		textNomPizza = new JTextField();
		textNomPizza.setBounds(161, 62, 138, 26);
		frame.getContentPane().add(textNomPizza);
		textNomPizza.setColumns(10);
		
		JLabel lblTaillePizza = new JLabel("Taille");
		lblTaillePizza.setFont(new Font("The Next Font", Font.PLAIN, 20));
		lblTaillePizza.setBounds(161, 92, 46, 21);
		frame.getContentPane().add(lblTaillePizza);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setFont(new Font("The Next Font", Font.PLAIN, 20));
		lblPrix.setBounds(161, 156, 109, 21);
		frame.getContentPane().add(lblPrix);
		
		textPrix = new JTextField();
		textPrix.setColumns(10);
		textPrix.setBounds(161, 179, 138, 26);
		frame.getContentPane().add(textPrix);
		
		final JComboBox comboBoxTaillePizza = new JComboBox();
		comboBoxTaillePizza.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBoxTaillePizza.setModel(new DefaultComboBoxModel(new String[] {"Petite", "Moyenne", "Grande"}));
		comboBoxTaillePizza.setMaximumRowCount(3);
		comboBoxTaillePizza.setBounds(160, 124, 138, 21);
		frame.getContentPane().add(comboBoxTaillePizza);
		
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
				String nom = textNomPizza.getText();
				String taille = comboBoxTaillePizza.getSelectedItem().toString();
				String prix = textPrix.getText();	
				
				String sql = "insert into pizza(nomPizza, taillePizza, prixPizza) values (?,?,?)";
				try {
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement = connection.prepareStatement(sql);
					
					preparedStatement.setString(1, nom);
					preparedStatement.setString(2, taille);
					preparedStatement.setString(3, prix);
					
					int rows = preparedStatement.executeUpdate();
					
					if(rows > 0) {
						System.out.println("Insertion ex�cut� avec succ�s");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAjouter.setBounds(135, 216, 103, 31);
		frame.getContentPane().add(btnAjouter);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//InterfaceGestionnaire fenetreGestionnaire = new InterfaceGestionnaire();
				//fenetreGestionnaire.frame.setVisible(true);
				
				frame.dispose();
			}
		});
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAnnuler.setBounds(248, 216, 103, 31);
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
		btnConsulterPizza.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConsulterPizza.setBounds(188, 258, 120, 31);
		frame.getContentPane().add(btnConsulterPizza);
		

		if (coReussi = true) {
			labelBdd.setText("Connexion r�ussi!");
			labelBdd.setForeground(Color.GREEN);
		} else {
			labelBdd.setText("La connexion � echou�");
			labelBdd.setForeground(Color.RED);
		}
		
	}
}
