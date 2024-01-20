package vue.insertion;

import javax.swing.*;


import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controleur.GestionTableEntrepriseFenetreFactureBien;
import controleur.insertion.GestionInsertionPaiementBien;

public class Fenetre_InsertionPaiementBien extends JInternalFrame {

	// Champs de saisie
	private JTextField textField_Numero;
	private JTextField textField_date_emission;
	private JTextField textField_date_paiement;
	private JTextField textField_numeroDevis;
	private JTextField textField_montant;
	private JTextField textField_accompteVerse;
	private JSeparator separator_Travaux;

	// Table pour afficher les données d'entreprise
	private JTable table_entreprise;

	// Boutons radio
	private JRadioButton rdbtnOui = new JRadioButton("Oui");
	private JRadioButton rdbtnNon = new JRadioButton("Non");

	// Menu déroulant
	private JComboBox<String> comboBox_modePaiement;
	private JComboBox<String> comboBox_Designation;

	// Boutons et libellés
	private JButton btn_ajouter_entreprise;
	private JButton btn_charger_entreprise;
	private JScrollPane scrollPane_table_entreprise;
	private JLabel lbl_Entreprise;

	// Gestionnaires d'événements
	private GestionTableEntrepriseFenetreFactureBien gteff;
	private GestionInsertionPaiementBien gestionClic;

	public Fenetre_InsertionPaiementBien() {
		// Initialisation des gestionnaires
		this.gestionClic = new GestionInsertionPaiementBien(this);
		this.gteff = new GestionTableEntrepriseFenetreFactureBien(this);
		
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
		JLabel lbl_InsererUnTravaux = new JLabel("Ajouter une facture ");
		lbl_InsererUnTravaux.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUnTravaux.setBounds(294, 26, 153, 48);
		panel.add(lbl_InsererUnTravaux);

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

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(new Color(0, 102, 204));
		separator.setBounds(473, 106, 20, 278);
		panel.add(separator);

		// Champs de saisie
		textField_Numero = new JTextField();
		textField_Numero.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Num\u00E9ro",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_Numero.setBounds(24, 104, 202, 40);
		panel.add(textField_Numero);
		textField_Numero.setColumns(10);

		textField_date_emission = new JTextField();
		textField_date_emission.setColumns(10);
		textField_date_emission
				.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Date \u00E9mission (YYYY-MM-JJ)",
						TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_date_emission.setBounds(24, 168, 202, 40);
		panel.add(textField_date_emission);

		textField_date_paiement = new JTextField();
		textField_date_paiement.setColumns(10);
		textField_date_paiement.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"Date Paiement (YYYY-MM-JJ)", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_date_paiement.setBounds(247, 167, 202, 40);
		panel.add(textField_date_paiement);

		textField_numeroDevis = new JTextField();
		textField_numeroDevis.setColumns(10);
		textField_numeroDevis.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Num\u00E9ro devis",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_numeroDevis.setBounds(24, 228, 202, 40);
		panel.add(textField_numeroDevis);

		// Menu déroulant pour la designation de la facture
		comboBox_Designation = new JComboBox<>();
		comboBox_Designation.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "D\u00E9signation",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		comboBox_Designation.setBounds(247, 104, 200, 40);

		DefaultComboBoxModel<String> designationModel = new DefaultComboBoxModel<>();
		designationModel.addElement("Travaux");
		designationModel.addElement("Eau");
		designationModel.addElement("Électricité");
		designationModel.addElement("Entretien");
		designationModel.addElement("Autre");
		comboBox_Designation.setModel(designationModel);
		panel.add(comboBox_Designation);

		textField_montant = new JTextField();
		textField_montant.setColumns(10);
		textField_montant.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Montant",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_montant.setBounds(24, 294, 202, 40);
		panel.add(textField_montant);

		textField_accompteVerse = new JTextField();
		textField_accompteVerse.setColumns(10);
		textField_accompteVerse.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"Acompte vers\u00E9 ", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_accompteVerse.setBounds(247, 294, 200, 40);
		panel.add(textField_accompteVerse);

		separator_Travaux = new JSeparator();
		separator_Travaux.setBounds(90, 401, 591, 2);
		panel.add(separator_Travaux);

		// Menu déroulant pour le mode de paiement
		comboBox_modePaiement = new JComboBox<>();
		comboBox_modePaiement.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Mode de Paiement",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		comboBox_modePaiement.setBounds(247, 230, 200, 39);

		DefaultComboBoxModel<String> modePaiementModel = new DefaultComboBoxModel<>();
		modePaiementModel.addElement("Virement bancaire");
		modePaiementModel.addElement("Espèce");
		comboBox_modePaiement.setModel(modePaiementModel);
		panel.add(comboBox_modePaiement);

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
		createButton("Ajouter", 248, 437, 94, 31, "Ajouter", gestionClic, panel);
		createButton("Annuler", 389, 437, 94, 31, "Annuler", gestionClic, panel);

		// Partie ENTREPRISE
		createButton("Insérer", 611, 142, 94, 31, "Insérer", gestionClic, panel);
		createButton("Charger", 505, 142, 94, 31, "Charger", gestionClic, panel);

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

	// Méthode pour créer un bouton avec une couleur de texte, de fond et un
	// gestionnaire d'événements spécifiques
	private JButton createButton(String label, int x, int y, int width, int height, String actionCommand,
			GestionInsertionPaiementBien listener, JPanel panel) {
		JButton button = new JButton(label);
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 102, 204));
		button.setBounds(x, y, width, height);
		button.setActionCommand(actionCommand);
		button.addActionListener(listener);
		panel.add(button);
		return button;
	}

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

	public JSeparator getSeparator_Travaux() {
		return separator_Travaux;
	}

	public JRadioButton getRdbtnOui() {
		return rdbtnOui;
	}

	public JRadioButton getRdbtnNon() {
		return rdbtnNon;
	}

	public GestionInsertionPaiementBien getGestionClic() {
		return gestionClic;
	}

	public JComboBox<String> getComboBox_Designation() {
		return comboBox_Designation;
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
