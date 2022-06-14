package packagePizza;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceCommande {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceCommande window = new InterfaceCommande();
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
	public InterfaceCommande() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBoxTelephoneLivreur = new JComboBox();
		comboBoxTelephoneLivreur.setBounds(84, 53, 172, 22);
		frame.getContentPane().add(comboBoxTelephoneLivreur);
		
		JLabel lblListeDesCommandes = new JLabel("Liste des commandes");
		lblListeDesCommandes.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblListeDesCommandes.setBounds(84, 11, 222, 42);
		frame.getContentPane().add(lblListeDesCommandes);
		
		JLabel lblnomPizza = new JLabel("Pizza");
		lblnomPizza.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblnomPizza.setBounds(84, 86, 89, 21);
		frame.getContentPane().add(lblnomPizza);
		
		JComboBox comboBoxTelephoneLivreur_1 = new JComboBox();
		comboBoxTelephoneLivreur_1.setBounds(84, 120, 172, 22);
		frame.getContentPane().add(comboBoxTelephoneLivreur_1);
		
		JLabel lblTempsPrparation = new JLabel("Temps préparation");
		lblTempsPrparation.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblTempsPrparation.setBounds(84, 153, 172, 21);
		frame.getContentPane().add(lblTempsPrparation);
		
		JComboBox comboBoxTelephoneLivreur_1_1 = new JComboBox();
		comboBoxTelephoneLivreur_1_1.setBounds(84, 185, 172, 22);
		frame.getContentPane().add(comboBoxTelephoneLivreur_1_1);
		
		Button button = new Button("Afficher commande");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfficherCommandeCuisinier afficherCommandeCuisinier = new AfficherCommandeCuisinier();
				afficherCommandeCuisinier.frame.setVisible(true);
				frame.dispose();
			}
		});
		button.setBounds(320, 229, 104, 22);
		frame.getContentPane().add(button);
	}
}
