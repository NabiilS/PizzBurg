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

public class InterfaceSupprimerClient {

	public JFrame frame;
	private JTextField textNomClient;
	private JTextField textPrenomClient;
	private JTextField textIdClient;
	
	// Ajouté pour la connexion
	private static Connection connection = null;
	private static Scanner scanner = new Scanner(System.in);
	public boolean deleteEnabled;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceSupprimerClient window = new InterfaceSupprimerClient();
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
	public InterfaceSupprimerClient() {
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
		


		
		
		final JComboBox comboBoxTelClient = new JComboBox();
		comboBoxTelClient.setBounds(131, 38, 180, 21);
		frame.getContentPane().add(comboBoxTelClient);
		
		textNomClient = new JTextField();
		textNomClient.setBounds(131, 155, 180, 19);
		frame.getContentPane().add(textNomClient);
		textNomClient.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblNom.setBounds(133, 132, 46, 13);
		frame.getContentPane().add(lblNom);
		
		textPrenomClient = new JTextField();
		textPrenomClient.setColumns(10);
		textPrenomClient.setBounds(131, 207, 180, 19);
		frame.getContentPane().add(textPrenomClient);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblPrenom.setBounds(131, 184, 77, 13);
		frame.getContentPane().add(lblPrenom);
		
		textIdClient = new JTextField();
		textIdClient.setColumns(10);
		textIdClient.setBounds(131, 103, 180, 19);
		frame.getContentPane().add(textIdClient);
		
		JLabel lblId = new JLabel("Identifiant");
		lblId.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblId.setBounds(131, 80, 77, 13);
		frame.getContentPane().add(lblId);
		
		JLabel lblTelClient = new JLabel("T\u00E9l\u00E9phone");
		lblTelClient.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblTelClient.setBounds(172, 15, 102, 13);
		frame.getContentPane().add(lblTelClient);
		
		final JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSupprimer.setEnabled(false); 
				try {
					deleteClient(comboBoxTelClient.getSelectedItem().toString());
					refresh(comboBoxTelClient);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSupprimer.setEnabled(false);
		btnSupprimer.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnSupprimer.setBounds(165, 279, 122, 33);
		frame.getContentPane().add(btnSupprimer);
		
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
			comboBoxTelClient.addItem(result.getString(4));
		}
		
		
		}
		catch (Exception e) {
			throw new RuntimeException("Erreur détecté");
		
			
		}
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//InterfaceGestionnaire interfaceGestionnaire = new InterfaceGestionnaire();
				//interfaceGestionnaire.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnNewButton.setBounds(0, 6, 102, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					selectClient(comboBoxTelClient.getSelectedItem().toString());
					btnSupprimer.setEnabled(true); 
					
				} catch (Exception z) {
					throw new RuntimeException("Erreur detecte");
				}
				
				
			}
			
		});
		btnAfficher.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnAfficher.setBounds(172, 236, 102, 33);
		frame.getContentPane().add(btnAfficher);
		
	}
	public void selectClient(String telClient) throws SQLException{
		
		String sql = "select * from client where telClient ="+ "'" + telClient + "'";
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		if(result.next()) {
			
			
			
			String nomClient = result.getString("nomClient");
			String prenomClient = result.getString("prenomClient");
			String idClient = result.getString("idClient");
			
			textNomClient.setText(nomClient);
			textPrenomClient.setText(prenomClient);
			textIdClient.setText(idClient);
			
			// Debug
			
			/*System.out.println("idClient: " +idClient);
			System.out.println("nomClient: " +nomClient);
			System.out.println("prenomClient: " +prenomClient);
			System.out.println("telClient: " +telClient); 
			*/
			
		} else System.out.println("Pas de données trouvés...");
		
	}
	public void deleteClient (String telClient) throws SQLException{
		String sql = "DELETE FROM client WHERE telClient = ?";
		
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		pstmt.setString(1, telClient);
		pstmt.executeUpdate();
		System.out.println("Suppression effectué");
		
		
	}
	public void refresh (JComboBox comboBoxTelClient) throws SQLException{
		
		try {
			comboBoxTelClient.removeAllItems();
;
            String sql = "select * from client";
    		
    		
    		Statement statement = connection.createStatement();
    		
    		ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            String val = result.getString("telClient");
            comboBoxTelClient.addItem(val);
        }
    } catch (SQLException ex) {
        
    }
		
	}
	
}
