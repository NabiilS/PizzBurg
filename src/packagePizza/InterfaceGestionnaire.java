package packagePizza;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceGestionnaire {

	public JFrame frame;
	private JButton btnAddCommande;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceGestionnaire window = new InterfaceGestionnaire();
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
	public InterfaceGestionnaire() {
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
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfacePizzeria newFenetrePizzeria = new InterfacePizzeria();
				newFenetrePizzeria.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		btnRetour.setBounds(0, 0, 89, 23);
		frame.getContentPane().add(btnRetour);
		
		JButton btnAddClient = new JButton("Ajouter des clients");
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceAjoutClient interfaceAjouter = new InterfaceAjoutClient();
				interfaceAjouter.frame.setVisible(true);
			}
			
		});
		btnAddClient.setBounds(138, 40, 139, 44);
		frame.getContentPane().add(btnAddClient);
		
		btnAddCommande = new JButton("Ajouter des commandes");
		btnAddCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceAjouterCommande interfaceAjouterCommande = new InterfaceAjouterCommande();
				interfaceAjouterCommande.frame.setVisible(true);
				
			}
		});
		btnAddCommande.setBounds(132, 161, 157, 44);
		frame.getContentPane().add(btnAddCommande);
	}
}
