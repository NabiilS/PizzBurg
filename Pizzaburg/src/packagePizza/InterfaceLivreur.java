package packagePizza;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class InterfaceLivreur {

	public JFrame frame;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		lblListeDesCommandes.setBounds(118, 77, 292, 42);
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Test1", "Test2", "Test3"}));
		comboBox.setBounds(128, 112, 172, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblHeureDeLivraison = new JLabel("Heure de livraison souhait\u00E9:");
		lblHeureDeLivraison.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblHeureDeLivraison.setBounds(88, 130, 292, 42);
		frame.getContentPane().add(lblHeureDeLivraison);
		
		JLabel lblNewLabel = new JLabel("15:30");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 26));
		lblNewLabel.setBounds(171, 167, 83, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("D\u00E9tail du client");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceDetailClient newFenetreClient = new InterfaceDetailClient();
				newFenetreClient.frame.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Rockwell", Font.PLAIN, 16));
		btnNewButton.setBounds(126, 211, 162, 33);
		frame.getContentPane().add(btnNewButton);
	}
}
