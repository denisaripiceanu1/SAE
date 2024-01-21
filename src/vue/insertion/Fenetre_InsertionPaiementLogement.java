package vue.insertion;

import javax.swing.*;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controleur.GestionTableEntrepriseFenetreFactureLogement;
import controleur.insertion.GestionInsertionPaiementLogement;

public class Fenetre_InsertionPaiementLogement extends JInternalFrame {

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
	private JComboBox<String> comboBox_Designation;

	// Boutons et libellés
	private JButton btn_ajouter_entreprise;
	private JButton btn_charger_entreprise;
	private JLabel lbl_Entreprise;

	// Table pour afficher les données d'entreprise
	private JTable table_entreprise;

	// Gestionnaires d'événements
	private GestionTableEntrepriseFenetreFactureLogement gteff;
	private GestionInsertionPaiementLogement gestionClic;

	// Autres elements
	private JScrollPane scrollPane_table_entreprise;
	private JComboBox<String> comboBox_modePaiement;

	public Fenetre_InsertionPaiementLogement(boolean isAjouterFacture) {

		// Initialisation des gestionnaires d'événements
		this.gestionClic = new GestionInsertionPaiementLogement(this);
		this.gteff = new GestionTableEntrepriseFenetreFactureLogement(this);

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
		Utils.creerLabel("Insérer un facture", 294, 26, 153, 48, 16, panel);

		JLabel lbl_ImputableLocataire = new JLabel("Imputable Locataire");
		lbl_ImputableLocataire.setForeground(Color.BLACK);
		lbl_ImputableLocataire.setBackground(new Color(0, 102, 204));
		lbl_ImputableLocataire.setBounds(182, 353, 132, 31);
		panel.add(lbl_ImputableLocataire);

		// Séparateurs
		JSeparator separator_titreInsererTravaux = new JSeparator();
		separator_titreInsererTravaux.setForeground(new Color(0, 102, 204));
		separator_titreInsererTravaux.setBounds(271, 72, 190, 20);
		panel.add(separator_titreInsererTravaux);

		JSeparator separator_vertical = new JSeparator();
		separator_vertical.setOrientation(SwingConstants.VERTICAL);
		separator_vertical.setBackground(new Color(0, 102, 204));
		separator_vertical.setBounds(473, 106, 20, 278);
		panel.add(separator_vertical);

		// Champs de saisie
		Utils.creerTextField("Numéro", 24, 104, 202, 40, panel);
		Utils.creerTextField("Date émission (YYYY-MM-DD)", 24, 168, 202, 40, panel);
		Utils.creerTextField("Date Paiement (YYYY-MM-DD)", 247, 167, 202, 40, panel);
		Utils.creerTextField("Numéro devis", 24, 228, 202, 40, panel);
		Utils.creerTextField("Montant", 24, 294, 202, 40, panel);
		Utils.creerTextField("Acompte versé", 247, 283, 200, 40, panel);

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

		// Si la page est ouverte depuis "Ajouter une facture", ajouter uniquement
		// "Loyer"
		if (isAjouterFacture) {
			designationModel.addElement("Loyer");
		} else {
			// Ajouter tous les éléments
			// Faut laisser l'element vide
			designationModel.addElement("Loyer");
			designationModel.addElement("Travaux");
			designationModel.addElement("Eau");
			designationModel.addElement("Ordures ménagères");
			designationModel.addElement("Électricité");
			designationModel.addElement("Entretien");
			designationModel.addElement("Autre");
		}
		this.comboBox_Designation.setModel(designationModel);
		comboBox_Designation.addActionListener(gestionClic);
		panel.add(this.comboBox_Designation);

		// Partie ENTREPRISE
		this.btn_ajouter_entreprise = Utils.creerBouton(panel, "Insérer", 611, 142, 94, 31);
		this.btn_ajouter_entreprise.addActionListener(this.gestionClic);

		this.btn_charger_entreprise = Utils.creerBouton(panel, "Charger", 505, 142, 94, 31);
		this.btn_charger_entreprise.addActionListener(this.gestionClic);

		// ScrollPane et Table pour afficher les données d'entreprise
		this.scrollPane_table_entreprise = new JScrollPane();
		this.scrollPane_table_entreprise.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
		this.scrollPane_table_entreprise.setBounds(505, 189, 195, 97);
		panel.add(this.scrollPane_table_entreprise);

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
		JButton btnAjouter = Utils.creerBouton(panel, "Ajouter", 248, 437, 94, 31);
		btnAjouter.addActionListener(this.gestionClic);

		JButton btnAnnuler = Utils.creerBouton(panel, "Annuler", 389, 437, 94, 31);
		btnAnnuler.addActionListener(this.gestionClic);

		// Masquer les composants liés à l'entreprise au début
		this.btn_ajouter_entreprise.setVisible(false);
		this.btn_charger_entreprise.setVisible(false);
		this.scrollPane_table_entreprise.setVisible(false);
		this.table_entreprise.setVisible(false);
		lbl_Entreprise.setVisible(false);
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

	public JScrollPane getScrollPane_table_entreprise() {
		return scrollPane_table_entreprise;
	}

	public JLabel getLbl_Entreprise() {
		return lbl_Entreprise;
	}
}
