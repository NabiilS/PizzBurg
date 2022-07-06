package packagePizza;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.JSeparator;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JTextField;

public class AfficherCommandeCuisinier {

	JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfficherCommandeCuisinier window = new AfficherCommandeCuisinier();
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
	public AfficherCommandeCuisinier() {
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
		
		Button button = new Button("retour");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceCommande newFenetrePizzeria = new InterfaceCommande();
				newFenetrePizzeria.frame.setVisible(true);
				frame.dispose();
			
			}
		});
		button.setBounds(219, 213, 104, 22);
		frame.getContentPane().add(button);
		
		Button button_1 = new Button("Valider");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(97, 213, 104, 22);
		frame.getContentPane().add(button_1);
		
		Panel panel = new Panel();
		panel.setBounds(97, 56, 243, 99);
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel);
		
		JLabel lblCommande = new JLabel("Commande N°");
		lblCommande.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblCommande.setBounds(97, 26, 141, 21);
		frame.getContentPane().add(lblCommande);
		
		textField = new JTextField();
		textField.setBounds(236, 27, 104, 20);
		textField.setEditable(false);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
	}
}
