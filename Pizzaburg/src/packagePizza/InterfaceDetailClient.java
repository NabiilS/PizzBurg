package packagePizza;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceDetailClient {

	public JFrame frame;
	private JTextField textFieldTelClient;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceDetailClient window = new InterfaceDetailClient();
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
	public InterfaceDetailClient() {
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
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceLivreur newFenetreLivreur = new InterfaceLivreur();
				frame.dispose();
			}
		});
		btnValider.setFont(new Font("Rockwell", Font.PLAIN, 15));
		btnValider.setBounds(159, 223, 98, 27);
		frame.getContentPane().add(btnValider);
		
		textFieldTelClient = new JTextField();
		textFieldTelClient.setBounds(137, 182, 142, 20);
		frame.getContentPane().add(textFieldTelClient);
		textFieldTelClient.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("TelClient");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblNewLabel.setBounds(170, 157, 84, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNomclient = new JLabel("Nom Client");
		lblNomclient.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblNomclient.setBounds(159, 104, 109, 14);
		frame.getContentPane().add(lblNomclient);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(137, 130, 142, 20);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(46, 73, 336, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblAdresse.setBounds(170, 48, 109, 14);
		frame.getContentPane().add(lblAdresse);
		
		JLabel lblLivraisonCommande = new JLabel("Livraison commande:");
		lblLivraisonCommande.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblLivraisonCommande.setBounds(46, 18, 211, 14);
		frame.getContentPane().add(lblLivraisonCommande);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"0001", "N3854F", "0002", "0005", "..."}));
		comboBox.setFont(new Font("Rockwell", Font.BOLD, 15));
		comboBox.setBounds(227, 16, 92, 22);
		frame.getContentPane().add(comboBox);
	}

}
