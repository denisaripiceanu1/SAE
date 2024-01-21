package vue.modification;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controleur.modification.GestionModificationTravauxImmeuble;
import vue.Utils;

public class Fenetre_ModificationTravauxImmeuble extends JInternalFrame {

	// Champs de saisie
	private JTextField textField_Numero;
	private JTextField textField_designation;
	private JTextField textField_dateEmission;
	private JTextField textField_montant;
	private JTextField textField_paye;
	private JTextField textField_prestataire;
	private JTextField textField_adresse;
	private JTextField textField_Bien_Logement;

	// Gestionnaire d'événements
	private GestionModificationTravauxImmeuble gestionModificationTravauxImmeuble;

	public Fenetre_ModificationTravauxImmeuble() {
		// Initialisation du gestionnaire d'événements
		this.gestionModificationTravauxImmeuble = new GestionModificationTravauxImmeuble(this);

		// Configuration de la fenêtre interne
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		// Configuration du panel principal
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		// Separateurs
		JSeparator separator_titreInsererBien = new JSeparator();
		separator_titreInsererBien.setForeground(new Color(0, 102, 204));
		separator_titreInsererBien.setBounds(271, 72, 190, 2);
		panel.add(separator_titreInsererBien);

		JSeparator separator_Compteur = new JSeparator();
		separator_Compteur.setBounds(82, 354, 591, 2);
		panel.add(separator_Compteur);

		// Label
		Utils.creerLabel("Modifier un travaux", 298, 26, 149, 48, 16, panel);

		// Champs de saisie
		this.textField_Numero = Utils.creerTextField("Numéro", 110, 104, 190, 40, panel);
		this.textField_Numero.setEditable(false); // cle primaire de la table Facture non modifiable

		this.textField_designation = Utils.creerTextField("Designation", 110, 228, 190, 40, panel);
		this.textField_dateEmission = Utils.creerTextField("Date émission (YYYY-MM-DD)", 427, 168, 190, 40, panel);
		this.textField_paye = Utils.creerTextField("Date paiement (YYYY-MM-DD)", 427, 228, 190, 40, panel);
		this.textField_prestataire = Utils.creerTextField("Prestataire", 110, 294, 190, 40, panel);
		this.textField_montant = Utils.creerTextField("Montant", 110, 168, 190, 400, panel);
		this.textField_adresse = Utils.creerTextField("Adresse", 427, 294, 190, 40, panel);
		this.textField_Bien_Logement = Utils.creerTextField("Bien/Logement", 427, 104, 190, 40, panel);

		// Boutons généraux
		JButton btnAjouter = Utils.creerBouton(panel, "Modifier", 246, 447, 94, 31);
		btnAjouter.addActionListener(this.gestionModificationTravauxImmeuble);

		JButton btnAnnuler = Utils.creerBouton(panel, "Annuler", 398, 447, 94, 31);
		btnAnnuler.addActionListener(this.gestionModificationTravauxImmeuble);
	}
	
	// Getters et setters 
	public void setTextField_Numero(JTextField textField_Numero) {
		this.textField_Numero = textField_Numero;
	}

	public void setTextField_designation(JTextField textField_designation) {
		this.textField_designation = textField_designation;
	}

	public void setTextField_dateEmission(JTextField textField_dateEmission) {
		this.textField_dateEmission = textField_dateEmission;
	}

	public void setTextField_montant(JTextField textField_montant) {
		this.textField_montant = textField_montant;
	}

	public void setTextField_paye(JTextField textField_paye) {
		this.textField_paye = textField_paye;
	}

	public void setTextField_prestataire(JTextField textField_prestataire) {
		this.textField_prestataire = textField_prestataire;
	}

	public void setTextField_adresse(JTextField textField_adresse) {
		this.textField_adresse = textField_adresse;
	}

	public JTextField getTextField_Numero() {
		return textField_Numero;
	}

	public JTextField getTextField_designation() {
		return textField_designation;
	}

	public JTextField getTextField_dateEmission() {
		return textField_dateEmission;
	}

	public JTextField getTextField_montant() {
		return textField_montant;
	}

	public JTextField getTextField_paye() {
		return textField_paye;
	}

	public JTextField getTextField_prestataire() {
		return textField_prestataire;
	}

	public JTextField getTextField_adresse() {
		return textField_adresse;
	}

	public JTextField getTextField_Bien_Logement() {
		return textField_Bien_Logement;
	}

}
