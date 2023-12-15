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
	private JTextField textField_ville;
	private JTextField textField_periodeDeConstruction;
	private JTextField textField_nbLogement;
	private JTextField textField_dateAcquisition;
	private JSeparator separator_Travaux;
	JRadioButton rdbtnOui = new JRadioButton("Oui");
	JRadioButton rdbtnNon = new JRadioButton("Non");

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
		textField_Numero.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Id Numero",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_Numero.setBounds(110, 104, 190, 40);
		panel.add(textField_Numero);
		textField_Numero.setColumns(10);

		textField_date_emission = new JTextField();
		textField_date_emission.setColumns(10);
		textField_date_emission.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Date Emission",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_date_emission.setBounds(110, 168, 190, 40);
		panel.add(textField_date_emission);

		textField_date_paiement = new JTextField();
		textField_date_paiement.setColumns(10);
		textField_date_paiement.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Date Paiement",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_date_paiement.setBounds(427, 168, 190, 40);
		panel.add(textField_date_paiement);

		textField_ville = new JTextField();
		textField_ville.setColumns(10);
		textField_ville.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Numero Devis",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_ville.setBounds(110, 228, 190, 40);
		panel.add(textField_ville);

		// Menu déroulant pour la designation de la facture
		JComboBox<String> comboBox_Designation = new JComboBox<>();
		comboBox_Designation.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Designation",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		comboBox_Designation.setBounds(427, 105, 190, 40);

		DefaultComboBoxModel<String> designationModel = new DefaultComboBoxModel<>();
		designationModel.addElement("Travaux");
		designationModel.addElement("Eau");
		designationModel.addElement("Électricité parties communes ");
		designationModel.addElement("....");
		comboBox_Designation.setModel(designationModel);
		panel.add(comboBox_Designation);

		textField_nbLogement = new JTextField();
		textField_nbLogement.setColumns(10);
		textField_nbLogement.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Montant",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_nbLogement.setBounds(110, 294, 190, 40);
		panel.add(textField_nbLogement);

		textField_dateAcquisition = new JTextField();
		textField_dateAcquisition.setColumns(10);
		textField_dateAcquisition.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Accompte verse",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_dateAcquisition.setBounds(427, 294, 190, 40);
		panel.add(textField_dateAcquisition);

		separator_Travaux = new JSeparator();
		separator_Travaux.setBounds(90, 401, 591, 2);
		panel.add(separator_Travaux);

		// Menu déroulant pour le mode de paiement
		JComboBox<String> comboBox_modePaiement = new JComboBox<>();
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
		this.rdbtnNon.setBounds(389, 374, 54, 21);
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

}
