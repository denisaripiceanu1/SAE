package vue.insertion;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controleur.GestionTableEntrepriseFenetreFacture;
import controleur.insertion.GestionInsertionPaiementBien;

public class Fenetre_InsertionPaiementBien extends JInternalFrame {

	private JTextField textField_Numero;
	private JTextField textField_date_emission;
	private JTextField textField_date_paiement;
	private JTextField textField_numeroDevis;
	private JTextField textField_montant;
	private JTextField textField_accompteVerse;
	private JSeparator separator_Travaux;
	private JTable table_entreprise; // Utilisé pour afficher une table, mais non initialisé dans le constructeur
	JRadioButton rdbtnOui = new JRadioButton("Oui");
	JRadioButton rdbtnNon = new JRadioButton("Non");
	private JComboBox<String> comboBox_modePaiement;
	private JComboBox<String> comboBox_Designation;

	private GestionTableEntrepriseFenetreFacture gteff;
	private GestionInsertionPaiementBien gestionClic;

	public Fenetre_InsertionPaiementBien() {

		this.gestionClic = new GestionInsertionPaiementBien(this);

		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

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
		separator_titreInsererTravaux.setBounds(271, 72, 190, 2);
		panel.add(separator_titreInsererTravaux);

		// Champs de saisie
		textField_Numero = new JTextField();
		textField_Numero.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Num\u00E9ro",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_Numero.setBounds(24, 104, 190, 40);
		panel.add(textField_Numero);
		textField_Numero.setColumns(10);

		textField_date_emission = new JTextField();
		textField_date_emission.setColumns(10);
		textField_date_emission.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"Date \u00E9mission  ", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_date_emission.setBounds(24, 168, 190, 40);
		panel.add(textField_date_emission);

		textField_date_paiement = new JTextField();
		textField_date_paiement.setColumns(10);
		textField_date_paiement.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Date Paiement",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_date_paiement.setBounds(247, 167, 190, 40);
		panel.add(textField_date_paiement);

		textField_numeroDevis = new JTextField();
		textField_numeroDevis.setColumns(10);
		textField_numeroDevis.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Num\u00E9ro devis",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_numeroDevis.setBounds(24, 228, 190, 40);
		panel.add(textField_numeroDevis);

		// Menu déroulant pour la designation de la facture
		comboBox_Designation = new JComboBox<>();
		comboBox_Designation.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "D\u00E9signation",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		comboBox_Designation.setBounds(247, 104, 190, 40);

		DefaultComboBoxModel<String> designationModel = new DefaultComboBoxModel<>();
		designationModel.addElement("Travaux");
		designationModel.addElement("???");
		comboBox_Designation.setModel(designationModel);
		panel.add(comboBox_Designation);

		textField_montant = new JTextField();
		textField_montant.setColumns(10);
		textField_montant.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Montant",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_montant.setBounds(24, 294, 190, 40);
		panel.add(textField_montant);

		textField_accompteVerse = new JTextField();
		textField_accompteVerse.setColumns(10);
		textField_accompteVerse.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"Acompte vers\u00E9 ", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_accompteVerse.setBounds(247, 294, 190, 40);
		panel.add(textField_accompteVerse);

		separator_Travaux = new JSeparator();
		separator_Travaux.setBounds(90, 401, 591, 2);
		panel.add(separator_Travaux);

		// Menu déroulant pour le mode de paiement
		comboBox_modePaiement = new JComboBox<>();
		comboBox_modePaiement.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Mode de Paiement",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		comboBox_modePaiement.setBounds(247, 230, 189, 39);

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
		JButton btnAjouter = new JButton("Ajouter");
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

		JButton btn_ajouter_entreprise = new JButton("Ajouter");
		btn_ajouter_entreprise.setForeground(Color.WHITE);
		btn_ajouter_entreprise.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_ajouter_entreprise.setBackground(new Color(0, 102, 204));
		btn_ajouter_entreprise.setBounds(505, 142, 94, 31);
		panel.add(btn_ajouter_entreprise);

		JButton btn_charger_entreprise = new JButton("Charger");
		btn_charger_entreprise.setForeground(Color.WHITE);
		btn_charger_entreprise.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_charger_entreprise.setBackground(new Color(0, 102, 204));
		btn_charger_entreprise.setBounds(611, 142, 94, 31);
		panel.add(btn_charger_entreprise);

		JScrollPane scrollPane_table_entreprise = new JScrollPane();
		scrollPane_table_entreprise.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
		scrollPane_table_entreprise.setBounds(505, 189, 195, 97);
		panel.add(scrollPane_table_entreprise);

		this.table_entreprise = new JTable();
		this.table_entreprise.setSelectionBackground(new Color(0, 102, 204));
		this.table_entreprise.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
				new String[] { "Annee", "Trimestre", "ICC" }));
		this.table_entreprise.setBounds(499, 80, 135, 16);
		scrollPane_table_entreprise.setViewportView(this.table_entreprise);
		this.table_entreprise.getSelectionModel().addListSelectionListener(this.gteff);

		JLabel lbl_Entreprise = new JLabel("Entreprise");
		lbl_Entreprise.setForeground(Color.BLACK);
		lbl_Entreprise.setBackground(new Color(0, 102, 204));
		lbl_Entreprise.setBounds(573, 104, 132, 31);
		panel.add(lbl_Entreprise);
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
	
}
