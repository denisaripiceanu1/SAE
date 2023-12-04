package vue.insertion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class Fenetre_InsertionCompteur extends JInternalFrame {
	private JTextField textField_IdCompteur;
	private JTextField textField_IndiceCompteur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre_InsertionCompteur frame = new Fenetre_InsertionCompteur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Fenetre_InsertionCompteur() {
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JSeparator separator_titreInsererCompteur = new JSeparator();
		separator_titreInsererCompteur.setForeground(new Color(0, 102, 204));
		separator_titreInsererCompteur.setBounds(271, 72, 190, 2);
		panel.add(separator_titreInsererCompteur);
		
		JLabel lbl_InsererUnCompteur = new JLabel("Ajouter un Compteur");
		lbl_InsererUnCompteur.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUnCompteur.setBounds(286, 26, 160, 48);
		panel.add(lbl_InsererUnCompteur);
		
		JComboBox comboBox_typeDeCompteur = new JComboBox();
		comboBox_typeDeCompteur.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Type", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		comboBox_typeDeCompteur.setBounds(272, 108, 189, 39);
		panel.add(comboBox_typeDeCompteur);
		
		textField_IdCompteur = new JTextField();
		textField_IdCompteur.setColumns(10);
		textField_IdCompteur.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Id Compteur", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_IdCompteur.setBounds(271, 166, 190, 40);
		panel.add(textField_IdCompteur);
		
		textField_IndiceCompteur = new JTextField();
		textField_IndiceCompteur.setColumns(10);
		textField_IndiceCompteur.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Indice du Compteur", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_IndiceCompteur.setBounds(271, 227, 190, 40);
		panel.add(textField_IndiceCompteur);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAjouter.setBounds(246, 447, 94, 31);
		panel.add(btnAjouter);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAnnuler.setBounds(398, 447, 94, 31);
		panel.add(btnAnnuler);
		

	}
}
