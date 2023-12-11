package vue.insertion;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controleur.insertion.GestionInsertionBien;

import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Fenetre_InsertionBien extends JInternalFrame {
	private JTextField textField_IdImmeuble;
	private JTextField textField_adresse;
	private JTextField textField_codePostal;
	private JTextField textField_ville;
	private JTextField textField_periodeDeConstruction;
	private JTextField textField_nbLogement;
	private JTextField textField_dateAcquisition;
	private JTextField textField_IdCompteur;
	private JTextField textField_IndexCompteur;
	private JSeparator separator_Compteur;
	private JButton btn_ajouterCompteur;
	
	private GestionInsertionBien gestionInsertionBien;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Fenetre_InsertionBien frame = new Fenetre_InsertionBien();
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
	public Fenetre_InsertionBien() {
		
		this.gestionInsertionBien = new GestionInsertionBien(this);
		
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JSeparator separator_titreInsererBien = new JSeparator();
		separator_titreInsererBien.setForeground(new Color(0, 102, 204));
		separator_titreInsererBien.setBounds(271, 72, 190, 2);
		panel.add(separator_titreInsererBien);
		
		JLabel lbl_InsererUnBien = new JLabel("Ajouter un Bien");
		lbl_InsererUnBien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUnBien.setBounds(308, 26, 117, 48);
		panel.add(lbl_InsererUnBien);
		
		textField_IdImmeuble = new JTextField();
		textField_IdImmeuble.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Id Bien", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		textField_IdImmeuble.setBounds(110, 104, 190, 40);
		panel.add(textField_IdImmeuble);
		textField_IdImmeuble.setColumns(10);
		
		textField_adresse = new JTextField();
		textField_adresse.setColumns(10);
		textField_adresse.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Adresse", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_adresse.setBounds(110, 168, 190, 40);
		panel.add(textField_adresse);
		
		textField_codePostal = new JTextField();
		textField_codePostal.setColumns(10);
		textField_codePostal.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Code Postal", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_codePostal.setBounds(427, 168, 190, 40);
		panel.add(textField_codePostal);
		
		textField_ville = new JTextField();
		textField_ville.setColumns(10);
		textField_ville.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Ville", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_ville.setBounds(110, 228, 190, 40);
		panel.add(textField_ville);
		
		textField_periodeDeConstruction = new JTextField();
		textField_periodeDeConstruction.setColumns(10);
		textField_periodeDeConstruction.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "P\u00E9riode de construction", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_periodeDeConstruction.setBounds(427, 228, 190, 40);
		panel.add(textField_periodeDeConstruction);
		
		textField_nbLogement = new JTextField();
		textField_nbLogement.setColumns(10);
		textField_nbLogement.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Nombre de logements", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_nbLogement.setBounds(110, 294, 190, 40);
		panel.add(textField_nbLogement);
		
		textField_dateAcquisition = new JTextField();
		textField_dateAcquisition.setColumns(10);
		textField_dateAcquisition.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Date d'acquisition", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_dateAcquisition.setBounds(427, 294, 190, 40);
		panel.add(textField_dateAcquisition);
		
		JComboBox comboBox_typeDeBien = new JComboBox();
		comboBox_typeDeBien.setModel(new DefaultComboBoxModel(new String[] {"Immeuble", "Maison"}));
		comboBox_typeDeBien.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Type", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		comboBox_typeDeBien.setBounds(427, 104, 189, 39);
		panel.add(comboBox_typeDeBien);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setBackground(new Color(0, 102, 204));
		btnAjouter.addActionListener(this.gestionInsertionBien);
		
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAjouter.setBounds(246, 447, 94, 31);
		panel.add(btnAjouter);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBackground(new Color(0, 102, 204));
		btnAnnuler.addActionListener(this.gestionInsertionBien);
		
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAnnuler.setBounds(398, 447, 94, 31);
		panel.add(btnAnnuler);
		
		separator_Compteur = new JSeparator();
		separator_Compteur.setBounds(82, 354, 591, 2);
		panel.add(separator_Compteur);
		
		btn_ajouterCompteur = new JButton("Ajouter un compteur");
		btn_ajouterCompteur.setForeground(Color.WHITE);
		btn_ajouterCompteur.setBackground(new Color(0, 102, 204));
		btn_ajouterCompteur.addActionListener(this.gestionInsertionBien);
		
		btn_ajouterCompteur.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_ajouterCompteur.setBounds(246, 378, 246, 31);
		panel.add(btn_ajouterCompteur);
		

	}
}
