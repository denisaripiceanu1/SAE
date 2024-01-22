package vue.modification;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controleur.modification.GestionModificationBien;
import vue.Utils;

public class Fenetre_ModificationBien extends JInternalFrame {
	// Champs de saisie
	private JTextField textField_IdImmeuble;
	private JTextField textField_adresse;
	private JTextField textField_codePostal;
	private JTextField textField_ville;
	private JTextField textField_periodeDeConstruction;
	private JTextField textField_nbLogement;
	private JTextField textField_dateAcquisition;
	
	// Menu déroulant pour le type de compteur
	private JComboBox<String> comboBox_typeDeBien;

	// Gestionnaires d'événements
	private GestionModificationBien gestionModificationBien;

	public Fenetre_ModificationBien() {
		// Initialisation des gestionnaires d'événements
		this.gestionModificationBien = new GestionModificationBien(this);
		
		// Configuration de la fenêtre interne
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		// Panneau principal
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		// Titre et séparateur
		Utils.creerLabel("Modifier un Bien", 308, 26, 117, 48, 16, panel);

		JSeparator separator_titreInsererBien = new JSeparator();
		separator_titreInsererBien.setForeground(new Color(0, 102, 204));
		separator_titreInsererBien.setBounds(271, 72, 190, 12);
		panel.add(separator_titreInsererBien);
		
		JSeparator separator_Compteur = new JSeparator();
		separator_Compteur.setBounds(82, 354, 591, 2);
		panel.add(separator_Compteur);

		// Initialisation et configuration des champs de saisie
		textField_IdImmeuble = Utils.creerTextField("Id Bien", 110, 104, 190, 40, panel);
		textField_IdImmeuble.setEditable(false);  // cle primaire de la table Immeuble non modifiable

		textField_adresse = Utils.creerTextField("Adresse", 110, 168, 190, 40, panel);
		textField_codePostal = Utils.creerTextField("Code Postal", 427, 168, 190, 40, panel);
		textField_ville = Utils.creerTextField("Ville", 110, 228, 190, 40, panel);
		textField_periodeDeConstruction = Utils.creerTextField("Période de construction", 427, 228, 190, 40, panel);

		// Menu déroulant
		this.comboBox_typeDeBien = new JComboBox<String>();
		this.comboBox_typeDeBien.setModel(new DefaultComboBoxModel<String>(new String[] { "Immeuble", "Maison" }));
		this.comboBox_typeDeBien.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Type",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		this.comboBox_typeDeBien.setBounds(427, 104, 189, 39);
		panel.add(this.comboBox_typeDeBien);

		// Configuration des boutons et de la séparation
		JButton btnAnnuler = Utils.creerBouton(panel, "Annuler", 398, 447, 94, 31);
		btnAnnuler.addActionListener(this.gestionModificationBien);

		JButton btnModifier = Utils.creerBouton(panel, "Modifier", 246, 447, 94, 31);
		btnModifier.addActionListener(this.gestionModificationBien);

		JButton btnAjouterCompteur = Utils.creerBouton(panel, "Ajouter un compteur", 246, 378, 246, 31);
		btnAjouterCompteur.addActionListener(this.gestionModificationBien);

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

	public JComboBox<String> getComboBox_typeDeBien() {
		return this.comboBox_typeDeBien;
	}

}
