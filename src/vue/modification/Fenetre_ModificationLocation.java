package vue.modification;

import java.awt.Color;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import controleur.modification.GestionModificationLocation;
import vue.Utils;

public class Fenetre_ModificationLocation extends JInternalFrame {
	// Déclaration des champs de texte
	private JTextField textField_IdBien;
	private JTextField textField_provision_chargeMens_TTC;
	private JTextField textField_loyer_TCC;
	private JTextField textField_caution_TTC;
	private JTextField textField_Id_Locataire;
	private JTextField textField_date_derniere_regularisation;
	private JTextField textField_loyer_paye;
	private JTextField textField_montant_reel_paye;
	private JTextField textField_date_debut;

	// Gestionnaires d'événements
	private GestionModificationLocation gestionModificationLocation;

	// Constructeur de la fenêtre de modification de location
	public Fenetre_ModificationLocation() {
		// Initialisation du gestionnaire de modification de location
		this.gestionModificationLocation = new GestionModificationLocation(this);

		// Configuration de la fenêtre
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		// Panneau principal
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(6, -22, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		// Séparateus de titre
		JSeparator separator_titreInsererBien = new JSeparator();
		separator_titreInsererBien.setForeground(new Color(0, 102, 204));
		separator_titreInsererBien.setBounds(278, 72, 190, 19);
		panel.add(separator_titreInsererBien);

		JSeparator separator_Compteur = new JSeparator();
		separator_Compteur.setBounds(81, 435, 591, 2);
		panel.add(separator_Compteur);


		// Étiquette du titre
		JLabel lbl_InsererUnBien = new JLabel("Modifier une Location");
		lbl_InsererUnBien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUnBien.setBounds(306, 26, 168, 48);
		panel.add(lbl_InsererUnBien);

		// Champs de texte
		this.textField_IdBien = Utils.creerTextField("Logement", 166, 104, 220, 40, panel);
		this.textField_IdBien.setEditable(false); // cle primaire de la table Louer non modifiable

		this.textField_provision_chargeMens_TTC =  Utils.creerTextField("Provision charges mensuelles", 425, 164, 220, 40, panel);
		this.textField_loyer_TCC =  Utils.creerTextField("Loyer", 166, 273, 220, 40, panel);
		this.textField_caution_TTC =  Utils.creerTextField("Caution", 425, 221, 120, 40, panel);

		this.textField_Id_Locataire = Utils.creerTextField("Locataire", 166, 164, 220, 40, panel);
		textField_Id_Locataire.setEditable(false); // cle primaire de la table Louer non modifiable

		this.textField_date_derniere_regularisation =  Utils.creerTextField("Date dernière régularisation", 166, 221, 220, 40, panel);

		this.textField_montant_reel_paye =  Utils.creerTextField("Montant reel payé", 425, 273, 220, 40, panel);

		this.textField_date_debut =  Utils.creerTextField("Date début", 425, 104, 220, 40, panel);
		textField_date_debut.setEditable(false); // cle primaire de la table Louer non modifiable

		// Boutons
		JButton btnModifier = Utils.creerBouton(panel, "Modifier", 246, 447, 94, 31);
		btnModifier.addActionListener(this.gestionModificationLocation);

		JButton btnAnjouter = Utils.creerBouton(panel, "Ajouter", 257, 457, 94, 31);
		btnAnjouter.addActionListener(this.gestionModificationLocation);

	}

	  // Getters pour récupérer les champs de saisie et d'autres éléments
	public JTextField getTextField_IdImmeuble() {
		return textField_IdBien;
	}
	public JTextField getTextField_provision_chargeMens_TTC() {
		return textField_provision_chargeMens_TTC;
	}

	public void setTextField_provision_chargeMens_TTC(JTextField textField_provision_chargeMens_TTC) {
		this.textField_provision_chargeMens_TTC = textField_provision_chargeMens_TTC;
	}

	public JTextField getTextField_loyer_TCC() {
		return textField_loyer_TCC;
	}

	public void setTextField_loyer_TCC(JTextField textField_loyer_TCC) {
		this.textField_loyer_TCC = textField_loyer_TCC;
	}

	public JTextField getTextField_caution_TTC() {
		return textField_caution_TTC;
	}

	public void setTextField_caution_TTC(JTextField textField_caution_TTC) {
		this.textField_caution_TTC = textField_caution_TTC;
	}

	public GestionModificationLocation getGestionModificationLocation() {
		return gestionModificationLocation;
	}

	public JTextField getTextField_Id_Locataire() {
		return textField_Id_Locataire;
	}

	public void setTextField_Id_Locataire(JTextField textField_Id_Locataire) {
		this.textField_Id_Locataire = textField_Id_Locataire;
	}

	public JTextField getTextField_date_derniere_regularisation() {
		return textField_date_derniere_regularisation;
	}

	public void setTextField_date_depart(JTextField textField_date_depart) {
		this.textField_date_derniere_regularisation = textField_date_depart;
	}

	public JTextField getTextField_loyer_paye() {
		return textField_loyer_paye;
	}

	public void setTextField_loyer_paye(JTextField textField_loyer_paye) {
		this.textField_loyer_paye = textField_loyer_paye;
	}

	public JTextField getTextField_montant_reel_paye() {
		return textField_montant_reel_paye;
	}

	public void setTextField_montant_reel_paye(JTextField textField_montant_reel_paye) {
		this.textField_montant_reel_paye = textField_montant_reel_paye;
	}

	public JTextField getTextField_date_debut() {
		return textField_date_debut;
	}

	public void setTextField_date_debut(JTextField textField_date_debut) {
		this.textField_date_debut = textField_date_debut;
	}

}
