package packagePizza;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;

import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		frame.getContentPane().setBackground(new Color(246, 201, 84));
		frame.setBounds(100, 100, 463, 605);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAddClient = new JButton("Ajouter des clients");
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceAjoutClient interfaceAjouter = new InterfaceAjoutClient();
				interfaceAjouter.frame.setVisible(true);
			}
			
		});
		btnAddClient.setBounds(59, 87, 157, 44);
		frame.getContentPane().add(btnAddClient);
		
		btnAddCommande = new JButton("Ajouter des commandes");
		btnAddCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceAjouterCommande interfaceAjouterCommande = new InterfaceAjouterCommande();
				interfaceAjouterCommande.frame.setVisible(true);
				
			}
		});
		btnAddCommande.setBounds(143, 377, 157, 44);
		frame.getContentPane().add(btnAddCommande);
		
		JButton btnAddPizza = new JButton("Ajouter des Pizzas");
		btnAddPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceAjoutPizza interfaceAjouterPizza= new InterfaceAjoutPizza();
				interfaceAjouterPizza.frame.setVisible(true);
			}
		});
		btnAddPizza.setBounds(59, 142, 157, 44);
		frame.getContentPane().add(btnAddPizza);
		
		JButton btnModifIngredient = new JButton("Gestion des ingredients");
		btnModifIngredient.setBounds(292, 498, 145, 32);
		frame.getContentPane().add(btnModifIngredient);
		
		JButton btnAddIngredient = new JButton("Ajouter des ingr\u00E9dients");
		btnAddIngredient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceAjouterIngredient interfaceAjouterIngredient = new InterfaceAjouterIngredient();
				interfaceAjouterIngredient.frame.setVisible(true);
			}
		});
		btnAddIngredient.setBounds(59, 202, 157, 44);
		frame.getContentPane().add(btnAddIngredient);
		
		JButton btnDeleteClient = new JButton("Supprimer des clients");
		btnDeleteClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceSupprimerClient interfaceSupprimerClient= new InterfaceSupprimerClient();
				interfaceSupprimerClient.frame.setVisible(true);
			}
		});
		btnDeleteClient.setBounds(235, 87, 157, 44);
		frame.getContentPane().add(btnDeleteClient);
		
		JButton btnDeletePizza = new JButton("Supprimer des Pizzas");
		btnDeletePizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceSupprimerPizza interfaceSupprimerPizza = new InterfaceSupprimerPizza();
				interfaceSupprimerPizza.frame.setVisible(true);
			}
		});
		btnDeletePizza.setBounds(235, 142, 157, 44);
		frame.getContentPane().add(btnDeletePizza);
		
		JButton btnSupprimerIngrdients = new JButton("Supprimer des ingr\u00E9dients");
		btnSupprimerIngrdients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceSupprimerIngredient interfaceSupprimerIngredient = new InterfaceSupprimerIngredient ();
				interfaceSupprimerIngredient.frame.setVisible(true);
			}
		});
		btnSupprimerIngrdients.setBounds(235, 202, 157, 44);
		frame.getContentPane().add(btnSupprimerIngrdients);
		
		JButton btnAjouterDesCuisiniers = new JButton("Ajouter des cuisiniers");
		btnAjouterDesCuisiniers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceAjoutCuisinier interfaceAjoutCuisinier = new InterfaceAjoutCuisinier();
				interfaceAjoutCuisinier.frame.setVisible(true);
			}
		});
		btnAjouterDesCuisiniers.setBounds(59, 257, 157, 44);
		frame.getContentPane().add(btnAjouterDesCuisiniers);
		
		JButton btnAjouterDesLivreurs = new JButton("Ajouter des livreurs");
		btnAjouterDesLivreurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceAjoutLivreur interfaceAjoutLivreur = new InterfaceAjoutLivreur ();
				interfaceAjoutLivreur.frame.setVisible(true);
			}
		});
		btnAjouterDesLivreurs.setBounds(59, 312, 157, 44);
		frame.getContentPane().add(btnAjouterDesLivreurs);
		
		JButton btnSupprimerDesCuisiniers = new JButton("Supprimer des cuisiniers");
		btnSupprimerDesCuisiniers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceSupprimerCuisinier interfaceSupprimerCuisinier = new InterfaceSupprimerCuisinier ();
				interfaceSupprimerCuisinier.frame.setVisible(true);
			}
		});
		btnSupprimerDesCuisiniers.setBounds(235, 257, 157, 44);
		frame.getContentPane().add(btnSupprimerDesCuisiniers);
		
		JButton btnSupprimerDesLivreurs = new JButton("Supprimer des livreurs");
		btnSupprimerDesLivreurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceSupprimerLivreur interfaceSupprimerLivreur = new InterfaceSupprimerLivreur ();
				interfaceSupprimerLivreur.frame.setVisible(true);
			}
		});
		btnSupprimerDesLivreurs.setBounds(235, 312, 157, 44);
		frame.getContentPane().add(btnSupprimerDesLivreurs);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JButton btnRetour = new JButton("Retour");
		menuBar.add(btnRetour);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfacePizzeria newFenetrePizzeria = new InterfacePizzeria();
				newFenetrePizzeria.frame.setVisible(true);
				frame.dispose();
				
			}
		});
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
