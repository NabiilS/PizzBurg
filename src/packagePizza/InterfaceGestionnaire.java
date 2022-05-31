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
		frame.setBounds(100, 100, 463, 348);
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
		btnAddClient.setBounds(31, 41, 157, 44);
		frame.getContentPane().add(btnAddClient);
		
		btnAddCommande = new JButton("Ajouter des commandes");
		btnAddCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceAjouterCommande interfaceAjouterCommande = new InterfaceAjouterCommande();
				interfaceAjouterCommande.frame.setVisible(true);
				
			}
		});
		btnAddCommande.setBounds(118, 149, 157, 44);
		frame.getContentPane().add(btnAddCommande);
		
		JButton btnAddPizza = new JButton("Ajouter des Pizzas");
		btnAddPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceAjoutPizza interfaceAjouterPizza= new InterfaceAjoutPizza();
				interfaceAjouterPizza.frame.setVisible(true);
			}
		});
		btnAddPizza.setBounds(31, 95, 157, 44);
		frame.getContentPane().add(btnAddPizza);
		
		JButton btnModifIngredient = new JButton("Gestion des ingredients");
		btnModifIngredient.setBounds(287, 253, 145, 32);
		frame.getContentPane().add(btnModifIngredient);
		
		JButton btnAddIngredient = new JButton("Ajouter des ingr\u00E9dients");
		btnAddIngredient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceAjouterIngredient interfaceAjouterIngredient = new InterfaceAjouterIngredient();
				interfaceAjouterIngredient.frame.setVisible(true);
			}
		});
		btnAddIngredient.setBounds(31, 203, 157, 44);
		frame.getContentPane().add(btnAddIngredient);
		
		JButton btnDeleteClient = new JButton("Supprimer des clients");
		btnDeleteClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceSupprimerClient interfaceSupprimerClient= new InterfaceSupprimerClient();
				interfaceSupprimerClient.frame.setVisible(true);
			}
		});
		btnDeleteClient.setBounds(230, 41, 157, 44);
		frame.getContentPane().add(btnDeleteClient);
		
		JButton btnDeletePizza = new JButton("Supprimer des Pizzas");
		btnDeletePizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceSupprimerPizza interfaceSupprimerPizza = new InterfaceSupprimerPizza();
				interfaceSupprimerPizza.frame.setVisible(true);
			}
		});
		btnDeletePizza.setBounds(230, 96, 157, 44);
		frame.getContentPane().add(btnDeletePizza);
		
		JButton btnSupprimerIngrdients = new JButton("Supprimer des ingr\u00E9dients");
		btnSupprimerIngrdients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceSupprimerIngredient interfaceSupprimerIngredient = new InterfaceSupprimerIngredient ();
				interfaceSupprimerIngredient.frame.setVisible(true);
			}
		});
		btnSupprimerIngrdients.setBounds(230, 199, 157, 44);
		frame.getContentPane().add(btnSupprimerIngrdients);
	}
}
