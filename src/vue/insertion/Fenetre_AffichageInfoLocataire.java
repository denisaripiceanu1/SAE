package vue.insertion;

import java.awt.Color;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controleur.insertion.GestionAffichageInfoLocataire;
import controleur.modification.GestionModificationLocataire;

public class Fenetre_AffichageInfoLocataire extends JInternalFrame {

	// Déclaration des composants Swing
	private JTextField textField_Nom;
	private JTextField textField_Prenom;
	private JTextField textField_Telephone;
	private JTextField textField_Mail;
	private JTextField textField_DateN;
	private JTextField textField_Id;

	// Déclaration des gestionnaires
	private GestionModificationLocataire gestionModificationLocataire;
	private GestionAffichageInfoLocataire gestionClic;

	// Tableau pour afficher la regularisation des charges d'un locataire
	// et le scrollPane associé
	private JTable tableRegularisation;
	private JScrollPane scrollPane_Regularisation;

	// Tableau pour afficher le sole de tout compte d'un locataire
	// et le scrollPane associé
	private JTable table_soldeToutCompte;
	private JScrollPane scrollPane_locataireSoldeToutCompte;

	public Fenetre_AffichageInfoLocataire() {
		// Initialisation des gestionnaires d'affichage et de modification du locataire
		this.gestionClic = new GestionAffichageInfoLocataire(this);
		this.gestionModificationLocataire = new GestionModificationLocataire(this);

		// Configuration de la fenêtre interne
		this.setBounds(100, 100, 958, 553);
		this.getContentPane().setLayout(null);

		// Configuration du panel principal
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 946, 524);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		// Séparateurs
		JSeparator separator_AffichageInfoQuotite = new JSeparator();
		separator_AffichageInfoQuotite.setForeground(new Color(0, 102, 204));
		separator_AffichageInfoQuotite.setBounds(399, 56, 190, 2);
		panel.add(separator_AffichageInfoQuotite);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(new Color(0, 102, 204));
		separator.setBounds(233, 84, 20, 344);
		panel.add(separator);

		// JLabels
		JLabel lbl_AffichageInfoLocataire = new JLabel("Mon Locataire");
		lbl_AffichageInfoLocataire.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_AffichageInfoLocataire.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_AffichageInfoLocataire.setBounds(417, 10, 160, 48);
		panel.add(lbl_AffichageInfoLocataire);

		JLabel lblDetailLocataire = new JLabel("Détail locataire");
		lblDetailLocataire.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDetailLocataire.setBounds(33, 93, 137, 14);
		panel.add(lblDetailLocataire);

		JLabel lblOprations = new JLabel("Opérations");
		lblOprations.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOprations.setBounds(248, 88, 137, 25);
		panel.add(lblOprations);

		JLabel lblDpartLoca = new JLabel("Départ de votre locataire :");
		lblDpartLoca.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDpartLoca.setBounds(511, 267, 137, 25);
		panel.add(lblDpartLoca);

		JLabel lblResteLoca = new JLabel(
				"Si votre reste est négatif, alors votre locataire vous doit de l'argent. Sinon, vous lui en devez");
		lblResteLoca.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblResteLoca.setBounds(248, 401, 461, 25);
		panel.add(lblResteLoca);

		JLabel lblSiVotreReste = new JLabel(
				"Si votre reste est positif, alors vous devez de l'argent a votre locataire. Sinon, il vous doit de l'argent");
		lblSiVotreReste.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSiVotreReste.setBounds(248, 221, 506, 25);
		panel.add(lblSiVotreReste);

		// Champs de texte pour les informations du locataire
		this.textField_Id = Utils.createTextField("Identifiant", 21, 132, 190, 40, panel, true);
		this.textField_Nom = Utils.createTextField("Nom", 21, 183, 190, 40, panel, true);
		this.textField_Prenom = Utils.createTextField("Prénom", 21, 233, 190, 40, panel, true);
		this.textField_Telephone = Utils.createTextField("n° Téléphone", 21, 287, 190, 40, panel, true);
		this.textField_Mail = Utils.createTextField("Mail", 21, 338, 190, 40, panel, true);
		this.textField_DateN = Utils.createTextField("Date de naissance", 21, 388, 190, 40, panel, true);

		// Tableau pour afficher la regularisation des charges d'un locataire
		// et le scrollPane associé
		scrollPane_Regularisation = new JScrollPane();
		scrollPane_Regularisation.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
		scrollPane_Regularisation.setBounds(248, 126, 688, 96);
		panel.add(scrollPane_Regularisation);

		this.tableRegularisation = new JTable();
		this.tableRegularisation.setSelectionBackground(new Color(0, 102, 204));
		this.tableRegularisation.setModel(
				new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null, null }, },
						new String[] { "Bien", "Période du", "au", "Charges réelles", "Ordures ménagères",
								"TOTAL Charges", "Restant du loyer", "Total provisions", "RESTE" }));
		tableRegularisation.getColumnModel().getColumn(0).setPreferredWidth(42);
		tableRegularisation.getColumnModel().getColumn(1).setPreferredWidth(62);
		tableRegularisation.getColumnModel().getColumn(2).setPreferredWidth(72);
		tableRegularisation.getColumnModel().getColumn(3).setPreferredWidth(88);
		tableRegularisation.getColumnModel().getColumn(4).setPreferredWidth(101);
		tableRegularisation.getColumnModel().getColumn(5).setPreferredWidth(87);
		tableRegularisation.getColumnModel().getColumn(6).setPreferredWidth(91);
		tableRegularisation.getColumnModel().getColumn(7).setPreferredWidth(85);
		tableRegularisation.getColumnModel().getColumn(8).setPreferredWidth(55);
		this.tableRegularisation.setBounds(40, 53, 668, 130);
		scrollPane_Regularisation.setViewportView(this.tableRegularisation);

		// Tableau pour afficher le sole de tout compte d'un locataire
		// et le scrollPane associé
		this.scrollPane_locataireSoldeToutCompte = new JScrollPane();
		this.scrollPane_locataireSoldeToutCompte.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
		this.scrollPane_locataireSoldeToutCompte.setBounds(248, 334, 688, 68);
		panel.add(this.scrollPane_locataireSoldeToutCompte);

		// Table pour afficher les données d'entreprise
		this.table_soldeToutCompte = new JTable();
		this.table_soldeToutCompte.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null, null, null }, },
				new String[] { "Provisions sur charges", " ", "Charges r\u00E9elles", "", "Caution", " ",
						"Travaux imputables", " ", "Restant du loyer", " ", "RESTE" }));
		table_soldeToutCompte.getColumnModel().getColumn(0).setPreferredWidth(122);
		table_soldeToutCompte.getColumnModel().getColumn(1).setPreferredWidth(15);
		table_soldeToutCompte.getColumnModel().getColumn(2).setPreferredWidth(86);
		table_soldeToutCompte.getColumnModel().getColumn(3).setPreferredWidth(15);
		table_soldeToutCompte.getColumnModel().getColumn(5).setPreferredWidth(15);
		table_soldeToutCompte.getColumnModel().getColumn(6).setPreferredWidth(103);
		table_soldeToutCompte.getColumnModel().getColumn(7).setPreferredWidth(15);
		table_soldeToutCompte.getColumnModel().getColumn(8).setPreferredWidth(95);
		table_soldeToutCompte.getColumnModel().getColumn(9).setPreferredWidth(15);
		this.scrollPane_locataireSoldeToutCompte.setViewportView(this.table_soldeToutCompte);

		// Création des boutons
		JButton btnAnnuler = Utils.creerBouton(panel, "Retour", 498, 461, 200, 25);
		btnAnnuler.addActionListener(this.gestionModificationLocataire);
		
		JButton btnModifier = Utils.creerBouton(panel, "Modifier", 230, 461, 200, 25);
		btnModifier.addActionListener(this.gestionModificationLocataire);
		
		JButton btnRegularisation = Utils.creerBouton(panel, "Régularisation des charges", 467, 90, 200, 25);
		btnRegularisation.addActionListener(this.gestionModificationLocataire);
		
		JButton btnSoldeToutCompte = Utils.creerBouton(panel, "Solde tout compte", 467, 299, 210, 25);
		btnSoldeToutCompte.addActionListener(this.gestionModificationLocataire);

	}

	// Getters
	public JTextField getTextField_Nom() {
		return this.textField_Nom;
	}

	public JTextField getTextField_Prenom() {
		return this.textField_Prenom;
	}

	public JTextField getTextField_Telephone() {
		return this.textField_Telephone;
	}

	public JTextField getTextField_Mail() {
		return this.textField_Mail;
	}

	public JTextField getTextField_DateN() {
		return this.textField_DateN;
	}

	public JTextField getTextField_Id() {
		return this.textField_Id;
	}

	public JTable getTable_soldeToutCompte() {
		return table_soldeToutCompte;
	}

	public JTable getTableRegularisation() {
		return tableRegularisation;
	}
}