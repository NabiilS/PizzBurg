package packagePizza;
// Interface Pizzeria
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Toolkit;

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
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
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
		frame.getColorModel();
		frame.setTitle("PizzBurg");
		
		frame.getContentPane().setBackground(new Color(246, 201, 84));
		frame.setBounds(100, 100, 450, 308);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		 //creation de l'icon
		
	
			//connexionDB connection = new connexionDB(); connexion � la base de donn�e
		
		JLabel lblConnexion = new JLabel("      Connexion");
		lblConnexion.setFont(new Font("Rockwell", Font.PLAIN, 30));
		lblConnexion.setBounds(103, 11, 215, 39);
		frame.getContentPane().add(lblConnexion);
		
		JLabel lblVoustes = new JLabel("    Vous \u00EAtes:");
		lblVoustes.setToolTipText("");
		lblVoustes.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblVoustes.setBounds(0, 121, 129, 38);
		frame.getContentPane().add(lblVoustes);
		
		JButton btnLivreur = new JButton("Livreur");
		btnLivreur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceLivreur fenetreLivreur = new InterfaceLivreur();
				fenetreLivreur.frame.setVisible(true);
				frame.dispose();
				
			
			}
		});
		btnLivreur.setFont(new Font("Dialog", Font.BOLD, 17));
		btnLivreur.setBounds(153, 164, 145, 40);
		frame.getContentPane().add(btnLivreur);
		
		JButton btnCuisinier = new JButton("Cuisinier");
		btnCuisinier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceCuisinier newFenetreCuisinier = new InterfaceCuisinier();
				newFenetreCuisinier.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnCuisinier.setFont(new Font("Dialog", Font.BOLD, 17));
		btnCuisinier.setBounds(153, 112, 145, 40);
		frame.getContentPane().add(btnCuisinier);
		
		JButton btnGestionnaire = new JButton("Gestionnaire");
		btnGestionnaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceGestionnaire newFenetreGestion = new InterfaceGestionnaire();
				newFenetreGestion.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnGestionnaire.setFont(new Font("Dialog", Font.BOLD, 17));
		btnGestionnaire.setBounds(153, 61, 145, 40);
		frame.getContentPane().add(btnGestionnaire);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(336, 244, 88, 14);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("fonctionnalit\u00E9 \u00E0 venir...");
		lblNewLabel.setBounds(206, 244, 129, 14);
		frame.getContentPane().add(lblNewLabel);
		

	}
}
