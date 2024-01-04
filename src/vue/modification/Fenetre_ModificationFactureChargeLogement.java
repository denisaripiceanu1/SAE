package vue.modification;

import java.awt.Color;

import java.awt.Font;

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

import controleur.GestionTableEntrepriseFenetreFactureLogement;
import controleur.modification.GestionModificationFacturesCharges;

public class Fenetre_ModificationFactureChargeLogement extends JInternalFrame {
	// Champs de saisie
	private JTextField textField_Numero;
	private JSeparator separator_Travaux;

	// Boutons radio
	private JRadioButton rdbtnOui = new JRadioButton("Oui");
	private JRadioButton rdbtnNon = new JRadioButton("Non");
	private JComboBox<String> comboBox_Designation;

	// Boutons et libellés
	private JButton btn_ajouter_entreprise;
	private JButton btn_charger_entreprise;
	private JScrollPane scrollPane_table_entreprise;
	private JLabel lbl_Entreprise;

	// Table pour afficher les données d'entreprise
	private JTable table_entreprise;

	// Gestionnaires d'événements
	private GestionTableEntrepriseFenetreFactureLogement gteff;
	private GestionModificationFacturesCharges gestionClic;
	private JTextField textField_date_emission;
	private JTextField textField_date_paiement;
	private JTextField textField_numeroDevis;
	private JComboBox<String> comboBox_modePaiement;
	private JTextField textField_accompteVerse;
	private JTextField textField_montant;

	public Fenetre_ModificationFactureChargeLogement() {

		// Initialisation des gestionnaires d'événements
		this.gestionClic = new GestionModificationFacturesCharges(this);

		// Configuration de la fenêtre interne
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 755, 511);
		panel.setLayout(null);
		this.getContentPane().add(panel);

		// Labels
		JLabel lbl_InsererUneFacture = new JLabel("Modifier une charge ");
		lbl_InsererUneFacture.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUneFacture.setBounds(294, 26, 153, 48);
		panel.add(lbl_InsererUneFacture);

		JLabel lbl_ImputableLocataire = new JLabel("Imputable Locataire");
		lbl_ImputableLocataire.setForeground(Color.BLACK);
		lbl_ImputableLocataire.setBackground(new Color(0, 102, 204));
		lbl_ImputableLocataire.setBounds(182, 353, 132, 31);
		panel.add(lbl_ImputableLocataire);

		// Séparateurs
		JSeparator separator_titreInsererTravaux = new JSeparator();
		separator_titreInsererTravaux.setForeground(new Color(0, 102, 204));
		separator_titreInsererTravaux.setBounds(271, 72, 190, 2);
		panel.add(separator_titreInsererTravaux);

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
		textField_date_emission.setBounds(24, 157, 202, 40);
		panel.add(textField_date_emission);

		textField_date_paiement = new JTextField();
		textField_date_paiement.setColumns(10);
		textField_date_paiement.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"Date Paiement (YYYY-MM-JJ)", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_date_paiement.setBounds(247, 156, 202, 40);
		panel.add(textField_date_paiement);

		textField_numeroDevis = new JTextField();
		textField_numeroDevis.setColumns(10);
		textField_numeroDevis.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Num\u00E9ro devis",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_numeroDevis.setBounds(24, 217, 202, 40);
		panel.add(textField_numeroDevis);

		textField_accompteVerse = new JTextField();
		textField_accompteVerse.setColumns(10);
		textField_accompteVerse.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"Acompte vers\u00E9 ", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_accompteVerse.setBounds(247, 283, 200, 40);
		panel.add(textField_accompteVerse);

		textField_montant = new JTextField();
		textField_montant.setColumns(10);
		textField_montant.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Montant",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_montant.setBounds(24, 283, 202, 40);
		panel.add(textField_montant);

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

		// Menu déroulant pour la designation de la facture
		this.comboBox_Designation = new JComboBox<String>();
		this.comboBox_Designation.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "D\u00E9signation",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.comboBox_Designation.setBounds(247, 104, 200, 40);

		DefaultComboBoxModel<String> designationModel = new DefaultComboBoxModel<String>();
		designationModel.addElement("Eau");
		designationModel.addElement("Ordures ménagères");
		designationModel.addElement("Électricité parties communes");
		designationModel.addElement("????");
		this.comboBox_Designation.setModel(designationModel);
		//comboBox_Designation.addActionListener(gestionClic);
		panel.add(this.comboBox_Designation);

		// Séparateur vertical
		separator_Travaux = new JSeparator();
		separator_Travaux.setBounds(90, 401, 591, 2);
		panel.add(separator_Travaux);

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
		JButton btnAjouter = new JButton("Modifier");
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setBackground(new Color(0, 102, 204));
		btnAjouter.setBounds(248, 437, 94, 31);
		btnAjouter.addActionListener(gestionClic);
		panel.add(btnAjouter);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBackground(new Color(0, 102, 204));
		btnAnnuler.setBounds(389, 437, 94, 31);
		btnAnnuler.addActionListener(gestionClic);
		panel.add(btnAnnuler);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(new Color(0, 102, 204));
		separator.setBounds(473, 106, 20, 278);
		panel.add(separator);

		// Partie ENTREPRISE
		this.btn_ajouter_entreprise = new JButton("Insérer");
		this.btn_ajouter_entreprise.setForeground(Color.WHITE);
		this.btn_ajouter_entreprise.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.btn_ajouter_entreprise.setBackground(new Color(0, 102, 204));
		this.btn_ajouter_entreprise.setBounds(611, 142, 94, 31);
		this.btn_ajouter_entreprise.addActionListener(gestionClic);
		panel.add(this.btn_ajouter_entreprise);

		this.btn_charger_entreprise = new JButton("Charger");
		this.btn_charger_entreprise.setForeground(Color.WHITE);
		this.btn_charger_entreprise.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.btn_charger_entreprise.setBackground(new Color(0, 102, 204));
		this.btn_charger_entreprise.setBounds(505, 142, 94, 31);
		this.btn_charger_entreprise.addActionListener(gestionClic);
		panel.add(this.btn_charger_entreprise);

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
