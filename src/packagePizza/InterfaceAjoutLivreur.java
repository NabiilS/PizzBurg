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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class InterfaceAjoutLivreur {

	public JFrame frame;
	private JTextField textNom;
	private JTextField textPrenom;
	private JTextField textTelephone;
	
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
					InterfaceAjoutLivreur window = new InterfaceAjoutLivreur();
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
	public InterfaceAjoutLivreur() {
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
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("The Next Font", Font.PLAIN, 20));
		lblNom.setBounds(160, 31, 89, 21);
		frame.getContentPane().add(lblNom);
		
		textNom = new JTextField();
		textNom.setBounds(160, 63, 138, 19);
		frame.getContentPane().add(textNom);
		textNom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("The Next Font", Font.PLAIN, 20));
		lblPrenom.setBounds(160, 89, 89, 21);
		frame.getContentPane().add(lblPrenom);
		
		textPrenom = new JTextField();
		textPrenom.setColumns(10);
		textPrenom.setBounds(160, 121, 138, 19);
		frame.getContentPane().add(textPrenom);
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setFont(new Font("The Next Font", Font.PLAIN, 20));
		lblTelephone.setBounds(160, 155, 109, 21);
		frame.getContentPane().add(lblTelephone);
		
		textTelephone = new JTextField();
		textTelephone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if (Character.isLetter(c)&&!e.isAltDown()) {
					e.consume();
					System.out.print("Le caract�re n'est pas un chiffre\n");
				}
			}
		});
		textTelephone.setColumns(10);
		textTelephone.setBounds(160, 187, 138, 19);
		frame.getContentPane().add(textTelephone);
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
				String nom = textNom.getText();
				String prenom = textPrenom.getText();
				String tel = textTelephone.getText();	
				
				String sql = "insert into livreur(nomLivreur, prenomLivreur, numTel) values (?,?,?)";
				try {
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement = connection.prepareStatement(sql);
					
					preparedStatement.setString(1, nom);
					preparedStatement.setString(2, prenom);
					preparedStatement.setString(3, tel);
					
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
		btnAjouter.setBounds(128, 212, 103, 31);
		frame.getContentPane().add(btnAjouter);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//InterfaceGestionnaire fenetreGestionnaire = new InterfaceGestionnaire();
				
				//fenetreGestionnaire.frame.dispose();
				frame.dispose();
			}
		});
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAnnuler.setBounds(241, 212, 103, 31);
		frame.getContentPane().add(btnAnnuler);
		
		JLabel labelBdd = new JLabel("Status");
		labelBdd.setForeground(Color.GRAY);
		labelBdd.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
		labelBdd.setBounds(10, 11, 60, 66);
		frame.getContentPane().add(labelBdd);
		
		JButton btnConsulterClient = new JButton("Consulter");
		btnConsulterClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceConsulterLivreur consulterLivreur = new InterfaceConsulterLivreur();
				consulterLivreur.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnConsulterClient.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConsulterClient.setBounds(179, 254, 120, 31);
		frame.getContentPane().add(btnConsulterClient);
		if (coReussi = true) {
			labelBdd.setText("Connexion r�ussi!");
			labelBdd.setForeground(Color.GREEN);
		} else {
			labelBdd.setText("La connexion � echou�");
			labelBdd.setForeground(Color.RED);
		}
		
	}
}
