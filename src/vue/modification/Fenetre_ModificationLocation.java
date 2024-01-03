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

import controleur.modification.GestionModificationLocation;

public class Fenetre_ModificationLocation extends JInternalFrame {
	private JTextField textField_IdImmeuble;
	private JTextField textField_provision_chargeMens_TTC;
	private JTextField textField_loyer_TCC;
	private JTextField textField_caution_TTC;
	private JSeparator separator_Compteur;
	private GestionModificationLocation GestionModificationLocation;
	private JTextField textField_Id_Locataire;
	private JTextField textField_date_depart;
	private JTextField textField_loyer_paye;
	private JTextField textField_montant_reel_paye;
	private JTextField textField_date_debut;

	public Fenetre_ModificationLocation() {

		this.GestionModificationLocation = new GestionModificationLocation(this);

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

		JLabel lbl_InsererUnBien = new JLabel("Modifier une Location");
		lbl_InsererUnBien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUnBien.setBounds(306, 26, 168, 48);
		panel.add(lbl_InsererUnBien);

		this.textField_IdImmeuble = new JTextField();
		this.textField_IdImmeuble.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Id Bien",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		this.textField_IdImmeuble.setBounds(166, 104, 190, 40);
		panel.add(this.textField_IdImmeuble);
		this.textField_IdImmeuble.setColumns(10);
		this.textField_IdImmeuble.setEditable(false);

		this.textField_provision_chargeMens_TTC = new JTextField();
		this.textField_provision_chargeMens_TTC.setColumns(10);
		this.textField_provision_chargeMens_TTC
				.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Provision charge mensuelle TTC",
						TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_provision_chargeMens_TTC.setBounds(425, 164, 190, 40);
		panel.add(this.textField_provision_chargeMens_TTC);

		this.textField_loyer_TCC = new JTextField();
		this.textField_loyer_TCC.setColumns(10);
		this.textField_loyer_TCC.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Loyer TTC",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_loyer_TCC.setBounds(306, 330, 190, 40);
		panel.add(this.textField_loyer_TCC);

		this.textField_caution_TTC = new JTextField();
		this.textField_caution_TTC.setColumns(10);
		this.textField_caution_TTC.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Caution TTC",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_caution_TTC.setBounds(425, 221, 190, 40);
		panel.add(this.textField_caution_TTC);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setForeground(Color.WHITE);
		btnModifier.setBackground(new Color(0, 102, 204));
		btnModifier.addActionListener(this.GestionModificationLocation);

		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModifier.setBounds(246, 447, 94, 31);
		panel.add(btnModifier);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBackground(new Color(0, 102, 204));
		btnAnnuler.addActionListener(this.GestionModificationLocation);

		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAnnuler.setBounds(398, 447, 94, 31);
		panel.add(btnAnnuler);

		this.separator_Compteur = new JSeparator();
		this.separator_Compteur.setBounds(81, 435, 591, 2);
		panel.add(this.separator_Compteur);

		textField_Id_Locataire = new JTextField();
		textField_Id_Locataire.setEditable(false);
		textField_Id_Locataire.setColumns(10);
		textField_Id_Locataire.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Id_Locataire",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_Id_Locataire.setBounds(166, 164, 190, 40);
		panel.add(textField_Id_Locataire);

		textField_date_depart = new JTextField();
		textField_date_depart.setColumns(10);
		textField_date_depart.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Date debut",

				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_date_depart.setBounds(166, 221, 190, 40);
		panel.add(textField_date_depart);

		textField_loyer_paye = new JTextField();
		textField_loyer_paye.setColumns(10);
		textField_loyer_paye.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "loyer_payé",

				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_loyer_paye.setBounds(425, 280, 190, 40);
		panel.add(textField_loyer_paye);

		textField_montant_reel_paye = new JTextField();
		textField_montant_reel_paye.setColumns(10);
		textField_montant_reel_paye
				.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Montant reel payé",

						TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_montant_reel_paye.setBounds(166, 280, 190, 40);
		panel.add(textField_montant_reel_paye);

		textField_date_debut = new JTextField();
		textField_date_debut.setEditable(false);
		textField_date_debut.setColumns(10);
		textField_date_debut.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Date début",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_date_debut.setBounds(425, 104, 190, 40);
		panel.add(textField_date_debut);

	}

	public JTextField getTextField_IdImmeuble() {
		return textField_IdImmeuble;
	}

	public void setTextField_IdImmeuble(JTextField textField_IdImmeuble) {
		this.textField_IdImmeuble = textField_IdImmeuble;
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

	public JSeparator getSeparator_Compteur() {
		return separator_Compteur;
	}

	public void setSeparator_Compteur(JSeparator separator_Compteur) {
		this.separator_Compteur = separator_Compteur;
	}

	public GestionModificationLocation getGestionModificationLocation() {
		return GestionModificationLocation;
	}

	public void setGestionModificationLocation(GestionModificationLocation gestionModificationLocation) {
		GestionModificationLocation = gestionModificationLocation;
	}

	public JTextField getTextField_Id_Locataire() {
		return textField_Id_Locataire;
	}

	public void setTextField_Id_Locataire(JTextField textField_Id_Locataire) {
		this.textField_Id_Locataire = textField_Id_Locataire;
	}

	public JTextField getTextField_date_depart() {
		return textField_date_depart;
	}

	public void setTextField_date_depart(JTextField textField_date_depart) {
		this.textField_date_depart = textField_date_depart;
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
