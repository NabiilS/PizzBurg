package packagePizza;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPasswordField;

public class InterfacePizzeria {

	public JFrame frame;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfacePizzeria window = new InterfacePizzeria();
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
	public InterfacePizzeria() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 308);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
			//connexionDB connection = new connexionDB(); connexion à la base de donnée
		
		JLabel lblConnexion = new JLabel("      Connexion");
		lblConnexion.setFont(new Font("Rockwell", Font.PLAIN, 30));
		lblConnexion.setBounds(87, 0, 248, 72);
		frame.getContentPane().add(lblConnexion);
		
		JLabel lblVoustes = new JLabel("    Vous \u00EAtes:");
		lblVoustes.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblVoustes.setBounds(149, 70, 129, 49);
		frame.getContentPane().add(lblVoustes);
		
		JButton btnLivreur = new JButton("Livreur");
		btnLivreur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceLivreur fenetreLivreur = new InterfaceLivreur();
				fenetreLivreur.frame.setVisible(true);
				frame.dispose();
				
			
			}
		});
		btnLivreur.setFont(new Font("Rockwell", Font.BOLD, 18));
		btnLivreur.setBounds(10, 130, 120, 49);
		frame.getContentPane().add(btnLivreur);
		
		JButton btnCuisinier = new JButton("Cuisinier");
		btnCuisinier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceCuisinier newFenetreCuisinier = new InterfaceCuisinier();
				newFenetreCuisinier.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnCuisinier.setFont(new Font("Rockwell", Font.BOLD, 18));
		btnCuisinier.setBounds(304, 130, 120, 49);
		frame.getContentPane().add(btnCuisinier);
		
		JButton btnGestionnaire = new JButton("Gestionnaire");
		btnGestionnaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceGestionnaire newFenetreGestion = new InterfaceGestionnaire();
				newFenetreGestion.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnGestionnaire.setFont(new Font("Rockwell", Font.BOLD, 18));
		btnGestionnaire.setBounds(130, 180, 177, 49);
		frame.getContentPane().add(btnGestionnaire);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(336, 244, 88, 14);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("fonctionnalit\u00E9 \u00E0 venir...");
		lblNewLabel.setBounds(206, 244, 129, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnClose = new JButton("Fermer");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				
			}
		});
		btnClose.setBounds(345, 0, 89, 23);
		frame.getContentPane().add(btnClose);
		

	}
}
