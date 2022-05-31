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
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class InterfaceSupprimerPizza {

	public JFrame frame;
	private JTextField textTaillePizza;
	private JTextField textPrixPizza;
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
					InterfaceSupprimerPizza window = new InterfaceSupprimerPizza();
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
	public InterfaceSupprimerPizza() {
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
		


		
		
		final JComboBox comboBoxidPizza = new JComboBox();
		comboBoxidPizza.setBounds(131, 38, 180, 21);
		frame.getContentPane().add(comboBoxidPizza);
		
		textTaillePizza = new JTextField();
		textTaillePizza.setBounds(131, 155, 180, 19);
		frame.getContentPane().add(textTaillePizza);
		textTaillePizza.setColumns(10);
		
		JLabel lblTaillePizza = new JLabel("Taille");
		lblTaillePizza.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblTaillePizza.setBounds(133, 132, 46, 13);
		frame.getContentPane().add(lblTaillePizza);
		
		textPrixPizza = new JTextField();
		textPrixPizza.setColumns(10);
		textPrixPizza.setBounds(131, 207, 180, 19);
		frame.getContentPane().add(textPrixPizza);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblPrix.setBounds(131, 184, 77, 13);
		frame.getContentPane().add(lblPrix);
		
		textNomPizza = new JTextField();
		textNomPizza.setColumns(10);
		textNomPizza.setBounds(131, 103, 180, 19);
		frame.getContentPane().add(textNomPizza);
		
		JLabel lblId = new JLabel("Identifiant");
		lblId.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblId.setBounds(131, 14, 77, 13);
		frame.getContentPane().add(lblId);
		
		JLabel lblNomPizza = new JLabel("Nom");
		lblNomPizza.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		lblNomPizza.setBounds(131, 79, 102, 13);
		frame.getContentPane().add(lblNomPizza);
		
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
		
		String sql = "select * from pizza";
		
		
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		
		while(result.next()) {
			comboBoxidPizza.addItem(result.getString(1));
		}
		
		
		}
		catch (Exception e) {
			throw new RuntimeException("Erreur détecté");
		
			
		}
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		final JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSupprimer.setEnabled(false); 
				try {
					delete(comboBoxidPizza.getSelectedItem().toString());
					refresh(comboBoxidPizza);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSupprimer.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnSupprimer.setEnabled(false);
		btnSupprimer.setBounds(158, 276, 122, 33);
		frame.getContentPane().add(btnSupprimer);
		
		btnNewButton.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnNewButton.setBounds(0, 5, 102, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					selectPizza(comboBoxidPizza.getSelectedItem().toString());
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
	public void selectPizza(String idPizza) throws SQLException{
		
		String sql = "select * from pizza where idPizza ="+idPizza;
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		if(result.next()) {
			
			
			
			String nomPizza = result.getString("nomPizza");
			String taillePizza = result.getString("taillePizza");
			String prixPizza = result.getString("prixPizza");
			
			textTaillePizza.setText(taillePizza);
			textPrixPizza.setText(prixPizza);
			textNomPizza.setText(nomPizza);
			
			// Debug
			
			/*System.out.println("idClient: " +idClient);
			System.out.println("nomClient: " +nomClient);
			System.out.println("prenomClient: " +prenomClient);
			System.out.println("telClient: " +telClient); 
			*/
			
		} else System.out.println("Pas de données trouvés...");
		
	}
	
	public void delete (String idPizza) throws SQLException{
		String sql = "DELETE FROM pizza WHERE idPizza = ?";
		
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		pstmt.setString(1, idPizza);
		pstmt.executeUpdate();
		System.out.println("Suppression effectué");
	}
	
	public void refresh (JComboBox comboBox) throws SQLException{
		
		try {
			comboBox.removeAllItems();
;
            String sql = "select * from pizza";
    		
    		
    		Statement statement = connection.createStatement();
    		
    		ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            String val = result.getString("idPizza");
            comboBox.addItem(val);
        }
    } catch (SQLException ex) {
        
    }
		
	}
}
