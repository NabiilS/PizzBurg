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
		frame.setBounds(100, 100, 463, 605);
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
		btnAddCommande.setBounds(132, 329, 157, 44);
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
		btnModifIngredient.setBounds(294, 526, 145, 32);
		frame.getContentPane().add(btnModifIngredient);
		
		JButton btnAddIngredient = new JButton("Ajouter des ingr\u00E9dients");
		btnAddIngredient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceAjouterIngredient interfaceAjouterIngredient = new InterfaceAjouterIngredient();
				interfaceAjouterIngredient.frame.setVisible(true);
			}
		});
		btnAddIngredient.setBounds(31, 149, 157, 44);
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
		btnSupprimerIngrdients.setBounds(230, 149, 157, 44);
		frame.getContentPane().add(btnSupprimerIngrdients);
		
		JButton btnAjouterDesCuisiniers = new JButton("Ajouter des cuisiniers");
		btnAjouterDesCuisiniers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceAjoutCuisinier interfaceAjoutCuisinier = new InterfaceAjoutCuisinier();
				interfaceAjoutCuisinier.frame.setVisible(true);
			}
		});
		btnAjouterDesCuisiniers.setBounds(31, 203, 157, 44);
		frame.getContentPane().add(btnAjouterDesCuisiniers);
		
		JButton btnAjouterDesLivreurs = new JButton("Ajouter des livreurs");
		btnAjouterDesLivreurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceAjoutLivreur interfaceAjoutLivreur = new InterfaceAjoutLivreur ();
				interfaceAjoutLivreur.frame.setVisible(true);
			}
		});
		btnAjouterDesLivreurs.setBounds(31, 257, 157, 44);
		frame.getContentPane().add(btnAjouterDesLivreurs);
		
		JButton btnSupprimerDesCuisiniers = new JButton("Supprimer des cuisiniers");
		btnSupprimerDesCuisiniers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceSupprimerCuisinier interfaceSupprimerCuisinier = new InterfaceSupprimerCuisinier ();
				interfaceSupprimerCuisinier.frame.setVisible(true);
			}
		});
		btnSupprimerDesCuisiniers.setBounds(230, 203, 157, 44);
		frame.getContentPane().add(btnSupprimerDesCuisiniers);
		
		JButton btnSupprimerDesLivreurs = new JButton("Supprimer des livreurs");
		btnSupprimerDesLivreurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceSupprimerLivreur interfaceSupprimerLivreur = new InterfaceSupprimerLivreur ();
				interfaceSupprimerLivreur.frame.setVisible(true);
			}
		});
		btnSupprimerDesLivreurs.setBounds(230, 257, 157, 44);
		frame.getContentPane().add(btnSupprimerDesLivreurs);
	}
}
