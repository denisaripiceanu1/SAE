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

	private JSeparator separator_Compteur;

	// Gestionnaire d'événements
	private GestionModificationTravauxImmeuble gestionModificationTravauxImmeuble;

	public Fenetre_ModificationTravauxImmeuble() {

		this.gestionModificationTravauxImmeuble = new GestionModificationTravauxImmeuble(this);

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

		JLabel lbl_InsererUnTravaux = new JLabel("Modifier un Travaux");
		lbl_InsererUnTravaux.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUnTravaux.setBounds(298, 26, 149, 48);
		panel.add(lbl_InsererUnTravaux);

		this.textField_Numero = new JTextField();
		this.textField_Numero.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Numero",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_Numero.setBounds(110, 104, 190, 40);
		panel.add(this.textField_Numero);
		this.textField_Numero.setColumns(10);
		this.textField_Numero.setEditable(false); // cle primaire de la table Facture non modifiable

		this.textField_designation = new JTextField();
		this.textField_designation.setColumns(10);
		this.textField_designation.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Designation",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_designation.setBounds(110, 228, 190, 40);
		panel.add(this.textField_designation);

		this.textField_dateEmission = new JTextField();
		this.textField_dateEmission.setColumns(10);
		this.textField_dateEmission.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"Date \u00E9mission", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_dateEmission.setBounds(427, 168, 190, 40);
		panel.add(this.textField_dateEmission);

		this.textField_montant = new JTextField();
		this.textField_montant.setColumns(10);
		this.textField_montant.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Montant",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_montant.setBounds(110, 168, 190, 40);
		panel.add(this.textField_montant);

		this.textField_paye = new JTextField();
		textField_paye.setEditable(false);
		this.textField_paye.setColumns(10);
		this.textField_paye.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Date paiement",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_paye.setBounds(427, 228, 190, 40);
		panel.add(this.textField_paye);

		this.textField_prestataire = new JTextField();
		textField_prestataire.setEditable(false);
		this.textField_prestataire.setColumns(10);
		this.textField_prestataire.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Prestataire",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_prestataire.setBounds(110, 294, 190, 40);
		panel.add(this.textField_prestataire);

		this.textField_adresse = new JTextField();
		textField_adresse.setEditable(false);
		this.textField_adresse.setColumns(10);
		this.textField_adresse.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Adresse",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_adresse.setBounds(427, 294, 190, 40);
		panel.add(this.textField_adresse);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setForeground(Color.WHITE);
		btnModifier.setBackground(new Color(0, 102, 204));
		btnModifier.addActionListener(this.gestionModificationTravauxImmeuble);

		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModifier.setBounds(246, 447, 94, 31);
		panel.add(btnModifier);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBackground(new Color(0, 102, 204));
		btnAnnuler.addActionListener(this.gestionModificationTravauxImmeuble);

		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAnnuler.setBounds(398, 447, 94, 31);
		panel.add(btnAnnuler);

		this.separator_Compteur = new JSeparator();
		this.separator_Compteur.setBounds(82, 354, 591, 2);
		panel.add(this.separator_Compteur);

		textField_Bien_Logement = new JTextField();
		textField_Bien_Logement.setEditable(false);
		textField_Bien_Logement.setColumns(10);
		textField_Bien_Logement.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Bien/Logement",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_Bien_Logement.setBounds(427, 104, 190, 40);
		panel.add(textField_Bien_Logement);

	}

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

	public void setSeparator_Compteur(JSeparator separator_Compteur) {
		this.separator_Compteur = separator_Compteur;
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

	public JSeparator getSeparator_Compteur() {
		return separator_Compteur;
	}

	public GestionModificationTravauxImmeuble getGestionModificationTravauxImmeuble() {
		return gestionModificationTravauxImmeuble;
	}

	public JTextField getTextField_Bien_Logement() {
		return textField_Bien_Logement;
	}

}
