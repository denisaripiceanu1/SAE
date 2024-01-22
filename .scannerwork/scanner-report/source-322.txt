package vue.insertion;

import java.awt.Color;

import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controleur.GestionTableICCFenetreLocation;
import controleur.GestionTableLogementsFenetreLocation;
import controleur.insertion.GestionInsertionLocation;
import modele.dao.DaoImmeuble;
import vue.Utils;

public class Fenetre_InsertionLocation extends JInternalFrame {
	// Champs de saisie
	private JTextField textField_IdLocataire;
	private JTextField textField_Nom;
	private JTextField textField_Prenom;
	private JTextField textField_tel;
	private JTextField textField_e_mail;
	private JTextField textField_Date_de_naissance;
	private JTextField textField_caution;
	private JTextField textField_date_arrivee;
	private JTextField textField_provision_sur_charges;
	private JTextField textField_loyer;

	// Table pour afficher les identifiants des logements
	private JTable table_id_logements;
	// Table pour affciher les differents ICC
	private JTable table_icc;

	// JLabels
	private JLabel lblNomEtatDesLieux;
	private JLabel lblBail;

	// ComboBox avec les identifiants des immeubles
	private JComboBox<String> comboBox_bien;

	private DaoImmeuble daoImmeuble;

	// Gestionnaires d'événements
	private GestionInsertionLocation gestionClic;
	private GestionTableLogementsFenetreLocation gtfl;
	private GestionTableICCFenetreLocation gtIccFl;

	public Fenetre_InsertionLocation() {
		// Initialisation des gestionnaires
		this.gestionClic = new GestionInsertionLocation(this);
		this.gtfl = new GestionTableLogementsFenetreLocation(this);
		this.gtIccFl = new GestionTableICCFenetreLocation(this);

		this.daoImmeuble = new DaoImmeuble();

		// Configuration de la fenêtre interne
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		// Création du panneau principal
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 755, 511);
		panel.setLayout(null);
		this.getContentPane().add(panel);

		// Séparateurs
		JSeparator separator_titreInsererLocation = new JSeparator();
		separator_titreInsererLocation.setForeground(new Color(0, 102, 204));
		separator_titreInsererLocation.setBounds(271, 52, 190, 21);
		panel.add(separator_titreInsererLocation);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 102, 204));
		separator.setBounds(237, 80, 20, 344);
		separator.setOrientation(SwingConstants.VERTICAL);
		panel.add(separator);

		// Titre de la fenêtre
		Utils.creerLabel("Insérer une location", 290, 14, 171, 48, 16, panel);

		// TextFields
		this.textField_IdLocataire = Utils.creerTextField("Id Locataire", 24, 69, 208, 40, panel);
		this.textField_Nom =  Utils.creerTextField("Nom", 24, 116, 208, 40, panel);
		this.textField_Prenom =  Utils.creerTextField("Prénom", 24, 165, 208, 40, panel);
		this.textField_tel =  Utils.creerTextField("N° téléphone", 24, 262, 208, 40, panel);
		this.textField_e_mail =  Utils.creerTextField("E-mail", 24, 312, 208, 40, panel);
		this.textField_Date_de_naissance =  Utils.creerTextField("Date naissance (YYYY-MM-JJ)", 24, 215, 208, 40, panel);
		this.textField_caution =  Utils.creerTextField("Caution", 548, 247, 120, 40, panel);
		this.textField_date_arrivee =  Utils.creerTextField("Date d'arrivée", 548, 297, 120, 40, panel);
		this.textField_provision_sur_charges =  Utils.creerTextField("Provisions sur charges", 548, 347, 171, 40, panel);
		this.textField_loyer =  Utils.creerTextField("Loyer", 548, 197, 120, 40, panel);

		// JLabels
		Utils.creerLabel("Locataire", 72, 40, 99, 27, 13, panel);
		Utils.creerLabel("Logement", 313, 80, 99, 27, 13, panel);

		JLabel lblNomEtatDesLieux = new JLabel("État des lieux : ");
		this.lblNomEtatDesLieux = lblNomEtatDesLieux;
		lblNomEtatDesLieux.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomEtatDesLieux.setBounds(24, 397, 233, 20);
		panel.add(lblNomEtatDesLieux);
		lblNomEtatDesLieux.addMouseListener(this.gestionClic);

		JLabel lblNomBail = new JLabel("Bail : ");
		this.lblBail = lblNomBail;
		lblNomBail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomBail.setBounds(34, 457, 223, 20); // Adjust the position as needed
		panel.add(lblNomBail);

		// JComboBox - Menu deroulant avec les identifiants des logements
		this.comboBox_bien = new JComboBox<String>();
		comboBox_bien.setBorder(new LineBorder(new Color(0, 102, 204)));
		comboBox_bien.setModel(new DefaultComboBoxModel<String>(new String[] { "Biens" }));
		comboBox_bien.setBounds(267, 131, 94, 21);
		panel.add(comboBox_bien);
		this.comboBox_bien.addActionListener(this.gestionClic);

		// Remplir le JComboBox avec les identifiants des logements
		try {
			List<String> identifiantsImmeuble = this.daoImmeuble.getAllIdImmeuble();
			identifiantsImmeuble.add(0, "Biens");

			// Ajouter les identifiants au modèle du JComboBox
			DefaultComboBoxModel<String> modelComboBox = new DefaultComboBoxModel<>(
					identifiantsImmeuble.toArray(new String[0]));

			this.comboBox_bien.setModel(modelComboBox);
			this.comboBox_bien.setModel(modelComboBox);
		} catch (SQLException e) {
			e.printStackTrace();
			// Gestion de l'erreur SQL
			JOptionPane.showMessageDialog(this, "Erreur lors de la récupération des identifiants de logement.",
					"Erreur", JOptionPane.ERROR_MESSAGE);
		}

		// Table Logements
		JScrollPane scrollPane_table_id_logements = new JScrollPane();
		scrollPane_table_id_logements.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
		scrollPane_table_id_logements.setBounds(271, 197, 223, 222);
		panel.add(scrollPane_table_id_logements);

		this.table_id_logements = new JTable();
		this.table_id_logements.setCellSelectionEnabled(true);
		this.table_id_logements
				.setModel(new DefaultTableModel(new Object[][] { { null }, }, new String[] { "ID des logements" }));
		this.table_id_logements.setBounds(0, 0, 1, 1);
		scrollPane_table_id_logements.setViewportView(this.table_id_logements);
		this.table_id_logements.getSelectionModel().addListSelectionListener(this.gtfl);

		// Table ICC
		JScrollPane scrollPane_table_icc = new JScrollPane();
		scrollPane_table_icc.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
		scrollPane_table_icc.setBounds(524, 80, 195, 97);
		panel.add(scrollPane_table_icc);

		this.table_icc = new JTable();
		this.table_icc.setSelectionBackground(new Color(0, 102, 204));
		this.table_icc.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
				new String[] { "Annee", "Trimestre", "ICC" }));
		this.table_icc.setBounds(499, 80, 135, 16);
		scrollPane_table_icc.setViewportView(this.table_icc);
		this.table_icc.getSelectionModel().addListSelectionListener(this.gtIccFl);

		// Boutons
		JButton btnAnnuler = Utils.creerBouton(panel, "Annuler", 400, 457, 94, 31);
		btnAnnuler.addActionListener(this.gestionClic);

		JButton btnAnjouter = Utils.creerBouton(panel, "Ajouter", 257, 457, 94, 31);
		btnAnjouter.addActionListener(this.gestionClic);

		JButton btnAjouterBail = Utils.creerBouton(panel, "Ajouter un bail", 24, 429, 154, 21);
		btnAjouterBail.addActionListener(this.gestionClic);

		JButton btnAjouterEtatLieux = Utils.creerBouton(panel, "Ajouter l'état des lieux", 24, 364, 154, 21);
		btnAjouterEtatLieux.addActionListener(this.gestionClic);

		JButton btnChargerICC = Utils.creerBouton(panel, "Charger ICC", 627, 39, 106, 31);
		btnChargerICC.addActionListener(this.gestionClic);

		JButton btnAjouterICC = Utils.creerBouton(panel, "Ajouter ICC", 511, 38, 106, 31);
		btnAjouterICC.addActionListener(this.gestionClic);
	}

	// Getters pour récupérer les valeurs des champs
	public JTextField getTextField_IdLocataire() {
		return this.textField_IdLocataire;
	}

	public JTextField getTextField_Nom() {
		return this.textField_Nom;
	}

	public JTextField getTextField_Prenom() {
		return this.textField_Prenom;
	}

	public JTextField getTextField_tel() {
		return this.textField_tel;
	}

	public JTextField getTextField_e_mail() {
		return this.textField_e_mail;
	}

	public JTextField getTextField_Date_de_naissance() {
		return this.textField_Date_de_naissance;
	}

	public JTable getTable_id_logements() {
		return this.table_id_logements;
	}

	public JTextField getTextField_caution() {
		return this.textField_caution;
	}

	public JTextField getTextField_date_arrivee() {
		return this.textField_date_arrivee;
	}

	public JTextField getTextField_provision_sur_charges() {
		return this.textField_provision_sur_charges;
	}

	public JTextField getTextField_loyer() {
		return this.textField_loyer;
	}

	public JTable getTable_liste_logements() {
		return this.table_id_logements;
	}

	public JTable getTable_liste_ICC() {
		return this.table_icc;
	}

	public JLabel getLblNomEtatDesLieux() {
		return this.lblNomEtatDesLieux;
	}

	public JLabel getLblBail() {
		return this.lblBail;
	}

	public JComboBox<String> getComboBox_bien() {
		return comboBox_bien;
	}

}