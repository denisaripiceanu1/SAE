package vue.insertion;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controleur.insertion.GestionInsertionPaiementBien;

import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class Fenetre_InsertionPaiementBien extends JInternalFrame {
	
	private JTextField textField_Numero;
	private JTextField textField_date_emission;
	private JTextField textField_date_paiement;
	private JTextField textField_numeroDevis;
	private JTextField textField_montant;
	private JTextField textField_accompteVerse;
	private JSeparator separator_Travaux;
	JRadioButton rdbtnOui = new JRadioButton("Oui");
	JRadioButton rdbtnNon = new JRadioButton("Non");
	private JComboBox<String> comboBox_modePaiement;
	private JComboBox<String> comboBox_Designation;
	
	private GestionInsertionPaiementBien gestionClic;

	public Fenetre_InsertionPaiementBien() {

		this.gestionClic = new GestionInsertionPaiementBien(this);

		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		// Labels
		JLabel lbl_InsererUnTravaux = new JLabel("Ajouter une facture ");
		lbl_InsererUnTravaux.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUnTravaux.setBounds(294, 26, 153, 48);
		panel.add(lbl_InsererUnTravaux);

		JLabel lbl_ImputableLocataire = new JLabel("Imputable Locataire");
		lbl_ImputableLocataire.setForeground(Color.BLACK);
		lbl_ImputableLocataire.setBackground(new Color(0, 102, 204));
		lbl_ImputableLocataire.setBounds(311, 337, 132, 31);
		panel.add(lbl_ImputableLocataire);

		// Séparateurs
		JSeparator separator_titreInsererTravaux = new JSeparator();
		separator_titreInsererTravaux.setForeground(new Color(0, 102, 204));
		separator_titreInsererTravaux.setBounds(271, 72, 190, 2);
		panel.add(separator_titreInsererTravaux);

		// Champs de saisie
		textField_Numero = new JTextField();
		textField_Numero.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Num\u00E9ro", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_Numero.setBounds(110, 104, 190, 40);
		panel.add(textField_Numero);
		textField_Numero.setColumns(10);

		textField_date_emission = new JTextField();
		textField_date_emission.setColumns(10);
		textField_date_emission.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Date \u00E9mission  ", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_date_emission.setBounds(110, 168, 190, 40);
		panel.add(textField_date_emission);

		textField_date_paiement = new JTextField();
		textField_date_paiement.setColumns(10);
		textField_date_paiement.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Date Paiement",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_date_paiement.setBounds(427, 168, 190, 40);
		panel.add(textField_date_paiement);

		textField_numeroDevis = new JTextField();
		textField_numeroDevis.setColumns(10);
		textField_numeroDevis.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Num\u00E9ro devis", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_numeroDevis.setBounds(110, 228, 190, 40);
		panel.add(textField_numeroDevis);

		// Menu déroulant pour la designation de la facture
		comboBox_Designation = new JComboBox<>();
		comboBox_Designation.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "D\u00E9signation", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		comboBox_Designation.setBounds(427, 105, 190, 40);

		DefaultComboBoxModel<String> designationModel = new DefaultComboBoxModel<>();
		designationModel.addElement("Travaux");
		designationModel.addElement("Eau");
		designationModel.addElement("Électricité parties communes ");
		designationModel.addElement("....");
		comboBox_Designation.setModel(designationModel);
		panel.add(comboBox_Designation);

		textField_montant = new JTextField();
		textField_montant.setColumns(10);
		textField_montant.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Montant",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_montant.setBounds(110, 294, 190, 40);
		panel.add(textField_montant);

		textField_accompteVerse = new JTextField();
		textField_accompteVerse.setColumns(10);
		textField_accompteVerse.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Acompte vers\u00E9 ", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_accompteVerse.setBounds(427, 294, 190, 40);
		panel.add(textField_accompteVerse);

		separator_Travaux = new JSeparator();
		separator_Travaux.setBounds(90, 401, 591, 2);
		panel.add(separator_Travaux);

		// Menu déroulant pour le mode de paiement
		comboBox_modePaiement = new JComboBox<>();
		comboBox_modePaiement.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Mode de Paiement",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		comboBox_modePaiement.setBounds(427, 230, 189, 39);

		DefaultComboBoxModel<String> modePaiementModel = new DefaultComboBoxModel<>();
		modePaiementModel.addElement("Virement bancaire");
		modePaiementModel.addElement("Liquide");
		comboBox_modePaiement.setModel(modePaiementModel);
		panel.add(comboBox_modePaiement);

		// Boutons radio
		this.rdbtnOui.setForeground(new Color(0, 0, 0));
		this.rdbtnOui.setHorizontalAlignment(SwingConstants.TRAILING);
		this.rdbtnOui.setHorizontalTextPosition(SwingConstants.LEADING);
		this.rdbtnOui.setBounds(286, 374, 54, 21);
		panel.add(this.rdbtnOui);
		this.rdbtnNon.setBounds(389, 374, 112, 21);
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


}
