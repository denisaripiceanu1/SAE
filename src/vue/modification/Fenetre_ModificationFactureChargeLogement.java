package vue.modification;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controleur.GestionTableEntrepriseFenetreModificationCharge;
import controleur.modification.GestionModificationFacturesCharges;
import vue.Utils;

public class Fenetre_ModificationFactureChargeLogement extends JInternalFrame {

	// Champs de saisie
	private JTextField textField_Numero;
	private JTextField textField_date_emission;
	private JTextField textField_date_paiement;
	private JTextField textField_numeroDevis;
	private JTextField textField_accompteVerse;
	private JTextField textField_montant;

	// Boutons radio
	private JRadioButton rdbtnOui = new JRadioButton("Oui");
	private JRadioButton rdbtnNon = new JRadioButton("Non");

	// Boutons et libellés
	private JButton btn_ajouter_entreprise;
	private JButton btn_charger_entreprise;
	private JLabel lbl_Entreprise;

	// Table pour afficher les données d'entreprise
	private JTable table_entreprise;
	private JScrollPane scrollPane_table_entreprise;

	// Autres elements
	private JSeparator separator_Factures;
	private JComboBox<String> comboBox_Designation;
	private JComboBox<String> comboBox_modePaiement;

	// Gestionnaires d'événements
	private GestionTableEntrepriseFenetreModificationCharge gteff;
	private GestionModificationFacturesCharges gestionClic;

	public Fenetre_ModificationFactureChargeLogement() {

		// Initialisation des gestionnaires d'événements
		this.gestionClic = new GestionModificationFacturesCharges(this);

		// Configuration de la fenêtre interne
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		// Configuration du panel principal
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 755, 511);
		panel.setLayout(null);
		this.getContentPane().add(panel);

		// Labels
		Utils.creerLabel("Modifier un facture", 294, 26, 153, 48, 16, panel);

		JLabel lbl_ImputableLocataire = new JLabel("Imputable Locataire");
		lbl_ImputableLocataire.setForeground(Color.BLACK);
		lbl_ImputableLocataire.setBackground(new Color(0, 102, 204));
		lbl_ImputableLocataire.setBounds(182, 353, 132, 31);
		panel.add(lbl_ImputableLocataire);

		// Séparateurs
		JSeparator separator_titreInsererTravaux = new JSeparator();
		separator_titreInsererTravaux.setForeground(new Color(0, 102, 204));
		separator_titreInsererTravaux.setBounds(271, 60, 190, 15);
		panel.add(separator_titreInsererTravaux);

		separator_Factures = new JSeparator();
		separator_Factures.setBounds(90, 401, 591, 2);
		panel.add(separator_Factures);

		// Champs de saisie
		this.textField_Numero = Utils.creerTextField("Numéro", 24, 104, 202, 40, panel);
		textField_Numero.setEditable(false); // cle primaire de la table Facture non modifiable

		this.textField_date_emission = Utils.creerTextField("Date émission (YYYY-MM-DD)", 24, 168, 202, 40, panel);
		this.textField_date_paiement = Utils.creerTextField("Date Paiement (YYYY-MM-DD)", 247, 167, 202, 40, panel);
		this.textField_numeroDevis = Utils.creerTextField("Numéro devis", 24, 228, 202, 40, panel);
		this.textField_montant = Utils.creerTextField("Montant", 24, 294, 202, 40, panel);
		this.textField_accompteVerse = Utils.creerTextField("Acompte versé", 247, 283, 200, 40, panel);

		// Menu déroulant pour le mode de paiement
		comboBox_modePaiement = new JComboBox<>();
		comboBox_modePaiement.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Mode de Paiement",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		comboBox_modePaiement.setBounds(247, 219, 200, 39);

		DefaultComboBoxModel<String> modePaiementModel = new DefaultComboBoxModel<>();
		modePaiementModel.addElement("Virement bancaire");
		modePaiementModel.addElement("Espèce");
		comboBox_modePaiement.setModel(modePaiementModel);
		panel.add(comboBox_modePaiement);

		// Menu déroulant pour la designation de la facture
		this.comboBox_Designation = new JComboBox<String>();
		this.comboBox_Designation.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "D\u00E9signation",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.comboBox_Designation.setBounds(247, 104, 200, 40);

		DefaultComboBoxModel<String> designationModel = new DefaultComboBoxModel<String>();
		designationModel.addElement("Loyer");
		designationModel.addElement("Travaux");
		designationModel.addElement("Eau");
		designationModel.addElement("Ordures ménagères");
		designationModel.addElement("Électricité");
		designationModel.addElement("Entretien");
		designationModel.addElement("Autre");

		this.comboBox_Designation.setModel(designationModel);
		comboBox_Designation.addActionListener(gestionClic);
		panel.add(this.comboBox_Designation);

		// Boutons radio
		this.rdbtnOui.setForeground(new Color(0, 0, 0));
		this.rdbtnOui.setHorizontalAlignment(SwingConstants.TRAILING);
		this.rdbtnOui.setHorizontalTextPosition(SwingConstants.LEADING);
		this.rdbtnOui.setBounds(146, 382, 54, 21);
		panel.add(this.rdbtnOui);
		this.rdbtnNon.setBounds(271, 382, 112, 21);
		panel.add(this.rdbtnNon);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(this.rdbtnOui);
		buttonGroup.add(this.rdbtnNon);

		// Boutons généraux
		JButton btnModifier = Utils.creerBouton(panel, "Modifier", 248, 437, 94, 31);
		btnModifier.addActionListener(this.gestionClic);

		JButton btnAnnuler = Utils.creerBouton(panel, "Annuler", 389, 437, 94, 31);
		btnAnnuler.addActionListener(this.gestionClic);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(new Color(0, 102, 204));
		separator.setBounds(473, 106, 20, 278);
		panel.add(separator);

		// Partie ENTREPRISE
		this.btn_ajouter_entreprise = Utils.creerBouton(panel, "Insérer", 611, 142, 94, 31);
		this.btn_ajouter_entreprise.addActionListener(this.gestionClic);

		this.btn_charger_entreprise = Utils.creerBouton(panel, "Charger", 505, 142, 94, 31);
		this.btn_charger_entreprise.addActionListener(this.gestionClic);

		this.scrollPane_table_entreprise = new JScrollPane();
		this.scrollPane_table_entreprise.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
		this.scrollPane_table_entreprise.setBounds(505, 189, 195, 97);
		panel.add(this.scrollPane_table_entreprise);

		// Table pour afficher les données d'entreprise
		this.table_entreprise = new JTable();
		this.table_entreprise.setSelectionBackground(new Color(0, 102, 204));
		this.table_entreprise
				.setModel(new DefaultTableModel(new Object[][] { { null, null }, }, new String[] { "SIRET", "Nom" }));
		this.table_entreprise.setBounds(499, 80, 135, 16);
		scrollPane_table_entreprise.setViewportView(this.table_entreprise);
		this.table_entreprise.getSelectionModel().addListSelectionListener(this.gteff);

		this.lbl_Entreprise = new JLabel("Entreprise");
		this.lbl_Entreprise.setForeground(Color.BLACK);
		this.lbl_Entreprise.setBackground(new Color(0, 102, 204));
		this.lbl_Entreprise.setBounds(573, 104, 132, 31);
		panel.add(this.lbl_Entreprise);

	}

	// Getters
	public JTextField getTextField_Numero() {
		return textField_Numero;
	}

	public JTextField getTextField_date_emission() {
		return textField_date_emission;
	}

	public JTextField getTextField_date_paiement() {
		return textField_date_paiement;
	}

	public JTextField getTextField_numeroDevis() {
		return textField_numeroDevis;
	}

	public JTextField getTextField_montant() {
		return textField_montant;
	}

	public JTextField getTextField_accompteVerse() {
		return textField_accompteVerse;
	}

	public JRadioButton getRdbtnOui() {
		return rdbtnOui;
	}

	public JRadioButton getRdbtnNon() {
		return rdbtnNon;
	}

	public JComboBox<String> getComboBox_Designation() {
		return this.comboBox_Designation;
	}

	public JComboBox<String> getComboBox_modePaiement() {
		return comboBox_modePaiement;
	}

	public JTable getTable_entreprise() {
		return table_entreprise;
	}

	public JButton getBtn_ajouter_entreprise() {
		return btn_ajouter_entreprise;
	}

	public JButton getBtn_charger_entreprise() {
		return btn_charger_entreprise;
	}

	public JLabel getLbl_Entreprise() {
		return lbl_Entreprise;
	}

	public JScrollPane getScrollPane_table_entreprise() {
		return scrollPane_table_entreprise;
	}

}
