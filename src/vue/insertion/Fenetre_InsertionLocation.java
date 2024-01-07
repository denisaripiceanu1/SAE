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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controleur.GestionTableICCFenetreLocation;
import controleur.GestionTableLogementsFenetreLocation;
import controleur.insertion.GestionInsertionLocation;
import modele.dao.DaoImmeuble;

public class Fenetre_InsertionLocation extends JInternalFrame {
	private JTextField textField_IdLocataire;
	private JTextField textField_Nom;
	private JTextField textField_Prenom;
	private JTextField textField_tel;
	private JTextField textField_e_mail;
	private JTextField textField_Date_de_naissance;
	private JTable table_id_logements;
	private JTable table_icc;
	private JTextField textField_caution;
	private JTextField textField_date_arrivee;
	private JTextField textField_provision_sur_charges;
	private JLabel lblNomEtatDesLieux;
	private JLabel lblBail;
	private JPanel panel;
	private JTextField textField_loyer;
	private JComboBox<String> comboBox_bien;

    // Gestionnaires d'événements
	private DaoImmeuble daoImmeuble;
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

        // Séparateur sous le titre
		JSeparator separator_titreInsererLocation = new JSeparator();
		separator_titreInsererLocation.setForeground(new Color(0, 102, 204));
		separator_titreInsererLocation.setBounds(271, 61, 190, 2);
		panel.add(separator_titreInsererLocation);

        // Titre de la fenêtre
		JLabel lbl_InsererUneLocation = new JLabel("Insérer une location");
		lbl_InsererUneLocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUneLocation.setBounds(290, 14, 171, 48);
		panel.add(lbl_InsererUneLocation);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 102, 204));
		separator.setBounds(237, 80, 20, 344);
		separator.setOrientation(SwingConstants.VERTICAL);
		panel.add(separator);

		this.textField_IdLocataire = new JTextField();
		this.textField_IdLocataire.setColumns(10);
		this.textField_IdLocataire.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Id Locataire",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_IdLocataire.setBounds(24, 69, 190, 40);
		panel.add(this.textField_IdLocataire);

		this.textField_Nom = new JTextField();
		this.textField_Nom.setColumns(10);
		this.textField_Nom.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Nom",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_Nom.setBounds(24, 116, 190, 40);
		panel.add(this.textField_Nom);

		this.textField_Prenom = new JTextField();
		this.textField_Prenom.setColumns(10);
		this.textField_Prenom.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Pr\u00E9nom",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_Prenom.setBounds(24, 165, 190, 40);
		panel.add(this.textField_Prenom);

		this.textField_tel = new JTextField();
		this.textField_tel.setColumns(10);
		this.textField_tel.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"N\u00B0 t\u00E9l\u00E9phone", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_tel.setBounds(24, 262, 190, 40);
		panel.add(this.textField_tel);

		this.textField_e_mail = new JTextField();
		this.textField_e_mail.setColumns(10);
		this.textField_e_mail.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "E-mail",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_e_mail.setBounds(24, 312, 190, 40);
		panel.add(this.textField_e_mail);

		this.textField_Date_de_naissance = new JTextField();
		this.textField_Date_de_naissance.setColumns(10);
		this.textField_Date_de_naissance.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"Date de naissance", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_Date_de_naissance.setBounds(24, 215, 190, 40);
		panel.add(this.textField_Date_de_naissance);

		JLabel lbl_titre_locataire = new JLabel("Locataire");
		lbl_titre_locataire.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_titre_locataire.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titre_locataire.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_titre_locataire.setBounds(72, 40, 99, 27);
		panel.add(lbl_titre_locataire);

		JLabel lbl_titre_logement = new JLabel("Logement");
		lbl_titre_logement.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_titre_logement.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titre_logement.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_titre_logement.setBounds(313, 80, 99, 27);
		panel.add(lbl_titre_logement);

		JButton btn_ajouter_location = new JButton("Ajouter");
		btn_ajouter_location.setForeground(new Color(255, 255, 255));
		btn_ajouter_location.setBackground(new Color(0, 102, 204));
		btn_ajouter_location.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_ajouter_location.setBounds(257, 457, 94, 31);
		btn_ajouter_location.addActionListener(this.gestionClic);
		panel.add(btn_ajouter_location);

		JButton btn_annuler_location = new JButton("Annuler");
		btn_annuler_location.setForeground(new Color(255, 255, 255));
		btn_annuler_location.setBackground(new Color(0, 102, 204));
		btn_annuler_location.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_annuler_location.setBounds(400, 457, 94, 31);
		btn_annuler_location.addActionListener(this.gestionClic);
		panel.add(btn_annuler_location);

		this.comboBox_bien = new JComboBox<String>();
		comboBox_bien.setBorder(new LineBorder(new Color(0, 102, 204)));
		comboBox_bien.setModel(new DefaultComboBoxModel(new String[] { "Biens" }));
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
			// Gestion de l'erreur SQL, par exemple, afficher un message à l'utilisateur
			JOptionPane.showMessageDialog(this, "Erreur lors de la récupération des identifiants de logement.",
					"Erreur", JOptionPane.ERROR_MESSAGE);
		}

		this.textField_caution = new JTextField();
		this.textField_caution.setColumns(10);
		this.textField_caution.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Caution",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_caution.setBounds(548, 247, 120, 40);
		panel.add(this.textField_caution);

		this.textField_date_arrivee = new JTextField();
		this.textField_date_arrivee.setColumns(10);
		this.textField_date_arrivee.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"Date d'arriv\u00E9e", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_date_arrivee.setBounds(548, 297, 120, 40);
		panel.add(this.textField_date_arrivee);

		this.textField_provision_sur_charges = new JTextField();
		this.textField_provision_sur_charges.setColumns(10);
		this.textField_provision_sur_charges.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"Provisions sur charges", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_provision_sur_charges.setBounds(548, 347, 171, 40);
		panel.add(this.textField_provision_sur_charges);

		this.textField_loyer = new JTextField();
		this.textField_loyer.setColumns(10);
		this.textField_loyer.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Loyer",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_loyer.setBounds(548, 197, 120, 40);
		panel.add(this.textField_loyer);

		// Bail et Etat de Lieux
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

		JButton btnAjouterBail = new JButton("Ajouter un bail");
		btnAjouterBail.setBounds(24, 429, 154, 21);
		btnAjouterBail.addActionListener(this.gestionClic);
		panel.add(btnAjouterBail);

		JButton btnAjouterEtatDesLieux = new JButton("Ajouter l'état des lieux");
		btnAjouterEtatDesLieux.setBounds(24, 364, 154, 21);
		btnAjouterEtatDesLieux.addActionListener(this.gestionClic);
		panel.add(btnAjouterEtatDesLieux);

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
		this.table_icc.setModel(new DefaultTableModel(new Object[][] { {  null, null, null }, }, new String[] { "Annee", "Trimestre", "ICC" }));
		this.table_icc.setBounds(499, 80, 135, 16);
		scrollPane_table_icc.setViewportView(this.table_icc);
		this.table_icc.getSelectionModel().addListSelectionListener(this.gtIccFl);

		JButton btn_ajouter_icc = new JButton("Ajouter ICC");
		btn_ajouter_icc.setForeground(Color.WHITE);
		btn_ajouter_icc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_ajouter_icc.setBackground(new Color(0, 102, 204));
		btn_ajouter_icc.setBounds(511, 38, 106, 31);
		panel.add(btn_ajouter_icc);
		btn_ajouter_icc.addActionListener(this.gestionClic);

		JButton btn_charger_icc = new JButton("Charger ICC");
		btn_charger_icc.setForeground(Color.WHITE);
		btn_charger_icc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_charger_icc.setBackground(new Color(0, 102, 204));
		btn_charger_icc.setBounds(627, 39, 106, 31);
		panel.add(btn_charger_icc);
		btn_charger_icc.addActionListener(this.gestionClic);
	}

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

	public GestionInsertionLocation getGestionClic() {
		return this.gestionClic;
	}

	public JComboBox<String> getComboBox_bien() {
		return comboBox_bien;
	}

	public JPanel getPanel() {
		return panel;
	}
}