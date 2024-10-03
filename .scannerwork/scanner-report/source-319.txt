package vue.insertion;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;


import controleur.insertion.GestionInsertionEntreprise;
import vue.Utils;

public class Fenetre_InsertionEntreprise extends JInternalFrame {

	// Champs de saisie
	private JTextField textField_Nom;
	private JTextField textField_SIRET;
	private JTextField textField_Telephone;
	private JTextField textField_Mail;
	private JTextField textField_Adresse;
	private JTextField textField_CP;
	private JTextField textField_Ville;
	private JTextField textField_IBAN;

	// Gestionnaires d'événements
	private GestionInsertionEntreprise gestionClic;

	public Fenetre_InsertionEntreprise() {

		// Initialisation des gestionnaires d'événements
		this.gestionClic = new GestionInsertionEntreprise(this);

		// Configuration de la fenêtre interne
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		// Configuration du panel principal
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		// Séparateur
		JSeparator separator_titreInsererEntreprise = new JSeparator();
		separator_titreInsererEntreprise.setForeground(new Color(0, 102, 204));
		separator_titreInsererEntreprise.setBounds(263, 99, 190, 19);
		panel.add(separator_titreInsererEntreprise);

		// Label titre
		Utils.creerLabel("Ajouter un Prestataire", 275, 53, 163, 48, 16, panel);

		// Champs de saisie
		textField_Nom = Utils.creerTextField("Nom", 131, 166, 190, 40, panel);
		textField_SIRET = Utils.creerTextField("SIRET", 381, 166, 190, 40, panel);
		textField_Telephone = Utils.creerTextField("n° Téléphone", 131, 218, 190, 40, panel);
		textField_Mail = Utils.creerTextField("Mail", 381, 218, 190, 40, panel);
		textField_Adresse = Utils.creerTextField("Adresse", 131, 270, 190, 40, panel);
		textField_CP = Utils.creerTextField("Code Postal", 381, 270, 190, 40, panel);
		textField_Ville = Utils.creerTextField("Ville", 131, 322, 190, 40, panel);
		textField_IBAN = Utils.creerTextField("IBAN", 381, 322, 190, 40, panel);
		
		// Boutons généraux
		JButton btnAnnuler = Utils.creerBouton(panel, "Annuler", 396, 395, 94, 31);
		btnAnnuler.addActionListener(this.gestionClic);

		JButton btnAnjouter = Utils.creerBouton(panel, "Ajouter", 244, 395, 94, 31);
		btnAnjouter.addActionListener(this.gestionClic);
	}

	// Getters pour récupérer les valeurs des champs
	public JTextField getTextField_Nom() {
		return this.textField_Nom;
	}

	public JTextField getTextField_SIRET() {
		return this.textField_SIRET;
	}

	public JTextField getTextField_Telephone() {
		return this.textField_Telephone;
	}

	public JTextField getTextField_Mail() {
		return this.textField_Mail;
	}

	public JTextField getTextField_Adresse() {
		return this.textField_Adresse;
	}

	public JTextField getTextField_CP() {
		return this.textField_CP;
	}

	public JTextField getTextField_Ville() {
		return this.textField_Ville;
	}

	public JTextField getTextField_IBAN() {
		return this.textField_IBAN;
	}
}
