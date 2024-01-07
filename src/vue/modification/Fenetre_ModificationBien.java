package vue.modification;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controleur.modification.GestionModificationBien;

public class Fenetre_ModificationBien extends JInternalFrame {
	// Champs de saisie
	private JTextField textField_IdImmeuble;
	private JTextField textField_adresse;
	private JTextField textField_codePostal;
	private JTextField textField_ville;
	private JTextField textField_periodeDeConstruction;
	private JTextField textField_nbLogement;
	private JTextField textField_dateAcquisition;
	// Autres elements
	private JSeparator separator_Compteur;
	private JButton btn_ajouterCompteur;
	private JComboBox comboBox_typeDeBien;

	// Gestionnaires d'événements
	private GestionModificationBien gestionModificationBien;

	public Fenetre_ModificationBien() {
		// Initialisation des gestionnaires d'événements
		this.gestionModificationBien = new GestionModificationBien(this);
		// Configuration de la fenêtre interne
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

		JLabel lbl_InsererUnBien = new JLabel("Modifier un Bien");
		lbl_InsererUnBien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUnBien.setBounds(308, 26, 117, 48);
		panel.add(lbl_InsererUnBien);

		this.textField_IdImmeuble = new JTextField();
		this.textField_IdImmeuble.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Id Bien",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		this.textField_IdImmeuble.setBounds(110, 104, 190, 40);
		panel.add(this.textField_IdImmeuble);
		this.textField_IdImmeuble.setColumns(10);
		this.textField_IdImmeuble.setEditable(false);  // cle primaire de la table Immeuble non modifiable

		this.textField_adresse = new JTextField();
		this.textField_adresse.setColumns(10);
		this.textField_adresse.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Adresse",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_adresse.setBounds(110, 168, 190, 40);
		panel.add(this.textField_adresse);

		this.textField_codePostal = new JTextField();
		this.textField_codePostal.setColumns(10);
		this.textField_codePostal.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Code Postal",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_codePostal.setBounds(427, 168, 190, 40);
		panel.add(this.textField_codePostal);

		this.textField_ville = new JTextField();
		this.textField_ville.setColumns(10);
		this.textField_ville.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Ville",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_ville.setBounds(110, 228, 190, 40);
		panel.add(this.textField_ville);

		this.textField_periodeDeConstruction = new JTextField();
		this.textField_periodeDeConstruction.setColumns(10);
		this.textField_periodeDeConstruction
				.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "P\u00E9riode de construction",
						TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_periodeDeConstruction.setBounds(427, 228, 190, 40);
		panel.add(this.textField_periodeDeConstruction);

		this.comboBox_typeDeBien = new JComboBox();
		this.comboBox_typeDeBien.setModel(new DefaultComboBoxModel(new String[] { "Immeuble", "Maison" }));
		this.comboBox_typeDeBien.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Type",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		this.comboBox_typeDeBien.setBounds(427, 104, 189, 39);
		panel.add(this.comboBox_typeDeBien);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setForeground(Color.WHITE);
		btnModifier.setBackground(new Color(0, 102, 204));
		btnModifier.addActionListener(this.gestionModificationBien);

		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModifier.setBounds(246, 447, 94, 31);
		panel.add(btnModifier);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBackground(new Color(0, 102, 204));
		btnAnnuler.addActionListener(this.gestionModificationBien);

		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAnnuler.setBounds(398, 447, 94, 31);
		panel.add(btnAnnuler);

		this.separator_Compteur = new JSeparator();
		this.separator_Compteur.setBounds(82, 354, 591, 2);
		panel.add(this.separator_Compteur);

		this.btn_ajouterCompteur = new JButton("Ajouter un compteur");
		this.btn_ajouterCompteur.setForeground(Color.WHITE);
		this.btn_ajouterCompteur.setBackground(new Color(0, 102, 204));
		this.btn_ajouterCompteur.addActionListener(this.gestionModificationBien);

		this.btn_ajouterCompteur.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.btn_ajouterCompteur.setBounds(246, 378, 246, 31);
		panel.add(this.btn_ajouterCompteur);

	}

	public JTextField getTextField_IdImmeuble() {
		return this.textField_IdImmeuble;
	}

	public JTextField getTextField_adresse() {
		return this.textField_adresse;
	}

	public JTextField getTextField_codePostal() {
		return this.textField_codePostal;
	}

	public JTextField getTextField_ville() {
		return this.textField_ville;
	}

	public JTextField getTextField_periodeDeConstruction() {
		return this.textField_periodeDeConstruction;
	}

	public JTextField getTextField_nbLogement() {
		return this.textField_nbLogement;
	}

	public JTextField getTextField_dateAcquisition() {
		return this.textField_dateAcquisition;
	}

	public JComboBox getComboBox_typeDeBien() {
		return this.comboBox_typeDeBien;
	}

}
