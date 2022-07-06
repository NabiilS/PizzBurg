package packagePizza;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class InterfaceCuisinier {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceCuisinier window = new InterfaceCuisinier();
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
	public InterfaceCuisinier() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(246, 201, 84));
		frame.setBounds(100, 100, 409, 328);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfacePizzeria newFenetrePizzeria = new InterfacePizzeria();
				newFenetrePizzeria.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(0, 0, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblAccueil = new JLabel("      Accueil");
		lblAccueil.setFont(new Font("Rockwell", Font.PLAIN, 30));
		lblAccueil.setBounds(106, 11, 248, 42);
		frame.getContentPane().add(lblAccueil);
		
		JButton btnIngrdients = new JButton("Ingr\u00E9dients");
		btnIngrdients.setFont(new Font("Rockwell", Font.PLAIN, 16));
		btnIngrdients.setBounds(126, 217, 162, 33);
		frame.getContentPane().add(btnIngrdients);
		
		JLabel lblCuisinier = new JLabel("      Cuisinier");
		lblCuisinier.setFont(new Font("Rockwell", Font.PLAIN, 24));
		lblCuisinier.setBounds(116, 45, 184, 42);
		frame.getContentPane().add(lblCuisinier);
		
		JButton btnPizza = new JButton("Pizza");
		btnPizza.setFont(new Font("Rockwell", Font.PLAIN, 16));
		btnPizza.setBounds(126, 164, 162, 33);
		frame.getContentPane().add(btnPizza);
		
		JButton btnIngrdients_1_1 = new JButton("Commande");
		btnIngrdients_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceCommande newFenetreCommande = new InterfaceCommande();
				newFenetreCommande.frame.setVisible(true);
				frame.dispose();
				
				
			}
		});
		btnIngrdients_1_1.setFont(new Font("Rockwell", Font.PLAIN, 16));
		btnIngrdients_1_1.setBounds(126, 110, 162, 33);
		frame.getContentPane().add(btnIngrdients_1_1);
	}
}
