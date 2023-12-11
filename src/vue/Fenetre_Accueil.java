package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controleur.GestionAccueil;
import controleur.insertion.GestionInsertionBien;
import vue.insertion.Fenetre_InsertionAssurance;
import vue.insertion.Fenetre_InsertionBien;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;

public class Fenetre_Accueil extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLayeredPane layeredPane_Accueil;
	private JLayeredPane layeredPane_MesLocations;
	private JLayeredPane layeredPane_MesBiens;
	private JLayeredPane layeredPane_MesTravaux;
	private JLayeredPane layeredPane_MesChargesLocatives;
	private JLayeredPane layeredPane_MesAssurances;
	private JLayeredPane layeredPane_RegularisationDesCharges;
	private JLayeredPane layeredPane_SoldeDeToutCompte;
	private JLayeredPane layeredPane_MesDocuments;
	private JTable tableMesBiens;
	private JTable tableMesBiens_Logements;
	private JTable table_MesLocations;
	private JTable table_MesTravaux;
	private JTable table_MesChargesLocatives;
	private JTable table_MesAssurances;
	private JTable table_SoldeDeToutCompte;
	private JTextField textField_loyer;
	private JTextField textField_provisionCharges;
	private JTextField textField_caution;
	private JTextField textField_dateEmission;
	private JTextField textField_dateEcheance;
	private JTextField textField_paye;
	private JTextField textField_restantDu;
	private JTable tableRegularisation;

	private GestionAccueil gestionAccueil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Fenetre_Accueil frame = new Fenetre_Accueil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Fenetre_Accueil() {

		this.gestionAccueil = new GestionAccueil(this);

		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 970, 646);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_Menu = new JPanel();
		panel_Menu.setBackground(Color.LIGHT_GRAY);
		this.contentPane.add(panel_Menu, BorderLayout.WEST);
		panel_Menu.setLayout(new BorderLayout(0, 0));

		JPanel panel_Menu_Boutons = new JPanel();
		panel_Menu_Boutons.setBackground(Color.LIGHT_GRAY);
		panel_Menu.add(panel_Menu_Boutons, BorderLayout.CENTER);
		panel_Menu_Boutons.setLayout(new GridLayout(8, 1, 0, 0));

		////// Bande accueil//////////////////////////////////////////////////
		JPanel bandeAccueil = new JPanel();
		bandeAccueil.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
		bandeAccueil.setBackground(Color.LIGHT_GRAY);
		this.contentPane.add(bandeAccueil, BorderLayout.NORTH);
		bandeAccueil.setLayout(new GridLayout(0, 8, 0, 0));

		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);

		logo.setIcon(new ImageIcon(Fenetre_Accueil.class.getResource("/icon/logo_appli.png"))); // pour éviter l'erreur
																								// location is null
																								// faire de façon
																								// graphique
		bandeAccueil.add(logo);
		JPanel panelDuBtnAccueil = new JPanel();
		panelDuBtnAccueil.setBackground(new Color(192, 192, 192));
		bandeAccueil.add(panelDuBtnAccueil);
		panelDuBtnAccueil.setLayout(null);

		JButton btnAccueil = new JButton("");
		btnAccueil.setBorder(null);
		btnAccueil.addActionListener(this.gestionAccueil);
		btnAccueil.setBackground(new Color(192, 192, 192));
		btnAccueil.setIcon(new ImageIcon(Fenetre_Accueil.class.getResource("/icon/home_att-removebg-preview.png"))); // pour
																														// éviter
																														// l'erreur
																														// location
																														// is
																														// null

		btnAccueil.setBounds(0, 53, 42, 31);
		btnAccueil.setName("btnAccueil");
		panelDuBtnAccueil.add(btnAccueil);

		///////////////////////////////////////////////////////////////////
		// MENU DE BOUTONS SUR LE CÔTE
		// ////////////////////////////////////////////////////////////////
		JButton btnMesBiens = new JButton("Mes Biens");
		btnMesBiens.addActionListener(this.gestionAccueil);
		btnMesBiens.setBackground(new Color(0, 102, 204));
		btnMesBiens.setForeground(new Color(255, 255, 255));
		btnMesBiens.setFont(new Font("Dialog", Font.BOLD, 12));
		btnMesBiens.setName("btnMesBiens");
		panel_Menu_Boutons.add(btnMesBiens);

		JButton btnMesLocations = new JButton("Mes Locations");
		btnMesLocations.setForeground(new Color(255, 255, 255));
		btnMesLocations.addActionListener(this.gestionAccueil);
		btnMesLocations.setBackground(new Color(0, 102, 204));
		btnMesLocations.setFont(new Font("Dialog", Font.BOLD, 12));
		btnMesLocations.setName("btnMesLocations");
		panel_Menu_Boutons.add(btnMesLocations);

		JButton btnMesTravaux = new JButton("Mes Travaux");
		btnMesTravaux.setForeground(new Color(255, 255, 255));
		btnMesTravaux.addActionListener(this.gestionAccueil);
		btnMesTravaux.setBackground(new Color(0, 102, 204));
		btnMesTravaux.setFont(new Font("Dialog", Font.BOLD, 12));
		btnMesTravaux.setName("btnMesTravaux");
		panel_Menu_Boutons.add(btnMesTravaux);

		JButton btnMesChargesLocatives = new JButton("Mes Charges Locatives");
		btnMesChargesLocatives.setForeground(new Color(255, 255, 255));
		btnMesChargesLocatives.addActionListener(this.gestionAccueil);
		btnMesChargesLocatives.setBackground(new Color(0, 102, 204));
		btnMesChargesLocatives.setFont(new Font("Dialog", Font.BOLD, 12));
		btnMesChargesLocatives.setName("btnMesChargesLocatives");
		panel_Menu_Boutons.add(btnMesChargesLocatives);

		JButton btnMesAssurances = new JButton("Mes Assurances");
		btnMesAssurances.setForeground(new Color(255, 255, 255));
		btnMesAssurances.addActionListener(this.gestionAccueil);
		btnMesAssurances.setBackground(new Color(0, 102, 204));
		btnMesAssurances.setFont(new Font("Dialog", Font.BOLD, 12));
		btnMesAssurances.setName("btnMesAssurances");
		panel_Menu_Boutons.add(btnMesAssurances);

		JButton btnRegularisationDesCharges = new JButton("Régularisation des Charges");
		btnRegularisationDesCharges.setForeground(new Color(255, 255, 255));
		btnRegularisationDesCharges.addActionListener(this.gestionAccueil);
		btnRegularisationDesCharges.setBackground(new Color(0, 102, 204));
		btnRegularisationDesCharges.setFont(new Font("Dialog", Font.BOLD, 12));
		btnRegularisationDesCharges.setName("btnRegularisationDesCharges");
		panel_Menu_Boutons.add(btnRegularisationDesCharges);

		JButton btnSoldeDeToutCompte = new JButton("Solde de tout compte");
		btnSoldeDeToutCompte.setForeground(new Color(255, 255, 255));
		btnSoldeDeToutCompte.addActionListener(this.gestionAccueil);
		btnSoldeDeToutCompte.setBackground(new Color(0, 102, 204));
		btnSoldeDeToutCompte.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSoldeDeToutCompte.setName("btnSoldeDeToutCompte");
		panel_Menu_Boutons.add(btnSoldeDeToutCompte);

		JButton btnMesDocuments = new JButton("Mes Documents");
		btnMesDocuments.setForeground(new Color(255, 255, 255));
		btnMesDocuments.addActionListener(this.gestionAccueil);
		btnMesDocuments.setBackground(new Color(0, 102, 204));
		btnMesDocuments.setFont(new Font("Dialog", Font.BOLD, 12));
		btnMesDocuments.setName("btnMesDocuments");
		panel_Menu_Boutons.add(btnMesDocuments);

		///////////////////////////////////////////////////////////////////
		// LAYERED ACCUEIL
		// ////////////////////////////////////////////////////////////////

		this.layeredPane_Accueil = new JLayeredPane();
		this.layeredPane_Accueil.setBackground(new Color(255, 255, 255));
		this.contentPane.add(this.layeredPane_Accueil, BorderLayout.CENTER);
		this.layeredPane_Accueil.setLayout(new BorderLayout(0, 0));

		JPanel panel_accueil = new JPanel();
		this.layeredPane_Accueil.add(panel_accueil, BorderLayout.CENTER);
		panel_accueil.setLayout(new BorderLayout(0, 0));

		JLabel lbl_accueil = new JLabel("Accueil");
		lbl_accueil.setHorizontalAlignment(SwingConstants.CENTER);
		panel_accueil.add(lbl_accueil, BorderLayout.CENTER);

		///////////////////////////////////////////////////////////////////
		// LAYERED MES BIENS
		///////////////////////////////////////////////////////////////////
		this.layeredPane_MesBiens = new JLayeredPane();
		this.contentPane.add(this.layeredPane_MesBiens, BorderLayout.CENTER);
		this.layeredPane_MesBiens.setLayout(new BorderLayout(0, 0));

		JPanel panelMesBiens = new JPanel();
		panelMesBiens.setBackground(Color.WHITE);
		this.layeredPane_MesBiens.add(panelMesBiens);
		panelMesBiens.setLayout(null);

		// Tableaux et scrollPane
		JScrollPane scrollPaneMesBiens = new JScrollPane();
		scrollPaneMesBiens.setToolTipText("40, 53, 668, 130");
		scrollPaneMesBiens.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
		scrollPaneMesBiens.setBackground(Color.LIGHT_GRAY);
		scrollPaneMesBiens.setBounds(40, 76, 475, 148);
		panelMesBiens.add(scrollPaneMesBiens);

		this.tableMesBiens = new JTable();
		this.tableMesBiens.setSelectionBackground(new Color(0, 102, 204));
		this.tableMesBiens.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
				new String[] { "Nom du bien", "Adresse", "Nb de logements" }));
		this.tableMesBiens.setBounds(40, 53, 668, 130);
		scrollPaneMesBiens.setViewportView(this.tableMesBiens);
		//this.tableMesBiens.getSelectionModel().addListSelectionListener(table_MesTravaux);

		JScrollPane scrollPaneMesBiens_Logements = new JScrollPane();
		scrollPaneMesBiens_Logements.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
		scrollPaneMesBiens_Logements.setBackground(Color.LIGHT_GRAY);
		scrollPaneMesBiens_Logements.setBounds(40, 293, 475, 134);
		panelMesBiens.add(scrollPaneMesBiens_Logements);

		this.tableMesBiens_Logements = new JTable();
		this.tableMesBiens_Logements
				.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
						new String[] { "Nom", "Surface", "Nb pi\u00E8ces", "Etage", "Aquisition", "Occup\u00E9" }));
		this.tableMesBiens_Logements.setBounds(40, 266, 438, 106);
		scrollPaneMesBiens_Logements.setViewportView(this.tableMesBiens_Logements);

		// Labels
		JLabel lblMesBiens = new JLabel("Mes Biens");
		lblMesBiens.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMesBiens.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesBiens.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMesBiens.setBounds(244, 22, 216, 43);
		panelMesBiens.add(lblMesBiens);

		JLabel lblLogements = new JLabel("Mes Logements");
		lblLogements.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLogements.setBounds(40, 269, 94, 13);
		panelMesBiens.add(lblLogements);

		// Séparateurs
		JSeparator separatorMesBiens = new JSeparator();
		separatorMesBiens.setForeground(new Color(0, 102, 204));
		separatorMesBiens.setBounds(258, 63, 190, 2);
		panelMesBiens.add(separatorMesBiens);

		JSeparator separator_mesBiens_1 = new JSeparator();
		separator_mesBiens_1.setForeground(new Color(0, 102, 204));
		separator_mesBiens_1.setBounds(32, 250, 494, 2);
		panelMesBiens.add(separator_mesBiens_1);

		// Boutons généraux
		JButton btnMesBiens_Charger = new JButton("Charger");
		btnMesBiens_Charger.setForeground(Color.WHITE);
		btnMesBiens_Charger.setBackground(new Color(0, 102, 204));
		btnMesBiens_Charger.setBounds(111, 449, 94, 31);
		btnMesBiens_Charger.addActionListener(this.gestionAccueil);
		btnMesBiens_Charger.setName("btnMesBiens_Charger");
		panelMesBiens.add(btnMesBiens_Charger);

		JButton btnMesBiens_Modifier = new JButton("Modifier");
		btnMesBiens_Modifier.setForeground(Color.WHITE);
		btnMesBiens_Modifier.setBackground(new Color(0, 102, 204));
		btnMesBiens_Modifier.setBounds(287, 449, 99, 31);
		btnMesBiens_Modifier.addActionListener(this.gestionAccueil);
		btnMesBiens_Modifier.setName("btnMesBiens_Modifier");
		panelMesBiens.add(btnMesBiens_Modifier);

		JButton btnMesBiens_Supprimer = new JButton("Supprimer");
		btnMesBiens_Supprimer.setForeground(Color.WHITE);
		btnMesBiens_Supprimer.setBackground(new Color(0, 102, 204));
		btnMesBiens_Supprimer.setBounds(457, 449, 109, 31);
		btnMesBiens_Supprimer.addActionListener(this.gestionAccueil);
		btnMesBiens_Supprimer.setName("btnMesBiens_Supprimer");
		panelMesBiens.add(btnMesBiens_Supprimer);

		// Boutons BIENS
		JButton btnMesBiens_AjouterBien = new JButton("Ajouter un bien");
		btnMesBiens_AjouterBien.setBounds(551, 97, 161, 23);
		btnMesBiens_AjouterBien.addActionListener(this.gestionAccueil);
		btnMesBiens_AjouterBien.setName("btnMesBiens_AjouterBien");
		panelMesBiens.add(btnMesBiens_AjouterBien);

		JButton btnMesBiens_AjouterDiagnostic = new JButton("Ajouter un diagnostic");
		btnMesBiens_AjouterDiagnostic.setBounds(551, 131, 161, 23);
		btnMesBiens_AjouterDiagnostic.addActionListener(this.gestionAccueil);
		btnMesBiens_AjouterDiagnostic.setName("btnMesBiens_AjouterDiagnostic");
		panelMesBiens.add(btnMesBiens_AjouterDiagnostic);

		JButton btnMesBiens_AjouterDesTravaux = new JButton("Ajouter des travaux");
		btnMesBiens_AjouterDesTravaux.addActionListener(this.gestionAccueil);
		btnMesBiens_AjouterDesTravaux.setBounds(551, 165, 161, 23);
		btnMesBiens_AjouterDesTravaux.setName("btnMesBiens_AjouterDesTravaux");
		panelMesBiens.add(btnMesBiens_AjouterDesTravaux);

		// Boutons LOGEMENTS
		JButton btnMesBiens_AjouterLogement = new JButton("Ajouter un logement");
		btnMesBiens_AjouterLogement.setBounds(551, 314, 161, 23);
		btnMesBiens_AjouterLogement.addActionListener(this.gestionAccueil);
		btnMesBiens_AjouterLogement.setName("btnMesBiens_AjouterLogement");
		panelMesBiens.add(btnMesBiens_AjouterLogement);

		JButton btnMesBiens_AjouterDiagnostic_Logements = new JButton("Ajouter un diagnostic");
		btnMesBiens_AjouterDiagnostic_Logements.setBounds(551, 348, 161, 23);
		btnMesBiens_AjouterDiagnostic_Logements.addActionListener(this.gestionAccueil);
		btnMesBiens_AjouterDiagnostic_Logements.setName("btnMesBiens_AjouterDiagnostic_Logements");
		panelMesBiens.add(btnMesBiens_AjouterDiagnostic_Logements);

		JButton btnMesBiens_AjouterDesTravaux_Logements = new JButton("Ajouter des travaux");
		btnMesBiens_AjouterDesTravaux_Logements.setBounds(551, 382, 161, 23);
		btnMesBiens_AjouterDesTravaux_Logements.addActionListener(this.gestionAccueil);
		btnMesBiens_AjouterDesTravaux_Logements.setName("btnMesBiens_AjouterDesTravaux_Logements");
		panelMesBiens.add(btnMesBiens_AjouterDesTravaux_Logements);

		////////////////////////////////////////////////////////////////////////////
		// LAYERED MES
		// LOCATIONS////////////////////////////////////////////////////////////////
		this.layeredPane_MesLocations = new JLayeredPane();
		this.layeredPane_MesLocations.setBackground(Color.WHITE);
		this.contentPane.add(this.layeredPane_MesLocations, BorderLayout.CENTER);
		this.layeredPane_MesLocations.setLayout(new BorderLayout(0, 0));

		JPanel panel_MesLocations = new JPanel();
		panel_MesLocations.setBackground(Color.WHITE);
		this.layeredPane_MesLocations.add(panel_MesLocations, BorderLayout.CENTER);
		panel_MesLocations.setLayout(null);

		// Tableaux et scrollPane
		JScrollPane scrollPane_MesLocations = new JScrollPane();
		scrollPane_MesLocations.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
		scrollPane_MesLocations.setBounds(30, 95, 447, 323);
		panel_MesLocations.add(scrollPane_MesLocations);

		this.table_MesLocations = new JTable();
		this.table_MesLocations.setSelectionBackground(new Color(0, 102, 204));
		this.table_MesLocations
				.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
						new String[] { "Locataire", "Bien", "Type", "Adresse", "Code Postal", "Ville" }));
		this.table_MesLocations.setBounds(40, 53, 668, 130);
		scrollPane_MesLocations.setViewportView(this.table_MesLocations);

		// Labels
		JLabel lbl_MesLocations = new JLabel("Mes Locations");
		lbl_MesLocations.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MesLocations.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_MesLocations.setBounds(244, 22, 216, 43);
		panel_MesLocations.add(lbl_MesLocations);

		// Séparateurs
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 102, 204));
		separator.setBounds(258, 63, 190, 2);
		panel_MesLocations.add(separator);

		// Boutons généraux
		JButton btn_MesLocations_Charger = new JButton("Charger");
		btn_MesLocations_Charger.setForeground(Color.WHITE);
		btn_MesLocations_Charger.setBackground(new Color(0, 102, 204));
		btn_MesLocations_Charger.setBounds(118, 449, 94, 31);
		btn_MesLocations_Charger.addActionListener(this.gestionAccueil);
		btn_MesLocations_Charger.setName("btn_MesLocations_Charger");
		panel_MesLocations.add(btn_MesLocations_Charger);

		JButton btn_MesLocations_Modifier = new JButton("Modifier");
		btn_MesLocations_Modifier.setForeground(Color.WHITE);
		btn_MesLocations_Modifier.setBackground(new Color(0, 102, 204));
		btn_MesLocations_Modifier.setBounds(396, 449, 99, 31);
		btn_MesLocations_Modifier.addActionListener(this.gestionAccueil);
		btn_MesLocations_Modifier.setName("btn_MesLocations_Modifier");
		panel_MesLocations.add(btn_MesLocations_Modifier);

		JButton btn_MesLocations_Inserer = new JButton("Insérer");
		btn_MesLocations_Inserer.setForeground(Color.WHITE);
		btn_MesLocations_Inserer.setBackground(new Color(0, 102, 204));
		btn_MesLocations_Inserer.setBounds(258, 449, 94, 31);
		btn_MesLocations_Inserer.addActionListener(this.gestionAccueil);
		btn_MesLocations_Inserer.setName("btn_MesLocations_Inserer");
		panel_MesLocations.add(btn_MesLocations_Inserer);

		JButton btn_MesLocations_Supprimer = new JButton("Supprimer");
		btn_MesLocations_Supprimer.setForeground(Color.WHITE);
		btn_MesLocations_Supprimer.setBackground(new Color(0, 102, 204));
		btn_MesLocations_Supprimer.setBounds(539, 449, 94, 31);
		btn_MesLocations_Supprimer.addActionListener(this.gestionAccueil);
		btn_MesLocations_Supprimer.setName("btn_MesLocations_Supprimer");
		panel_MesLocations.add(btn_MesLocations_Supprimer);

		// Bouton propre à la page
		JButton btn_mesLocations_InfoLocataire = new JButton("Mon locataire");
		btn_mesLocations_InfoLocataire.setBounds(510, 395, 152, 23);
		btn_mesLocations_InfoLocataire.addActionListener(this.gestionAccueil);
		btn_mesLocations_InfoLocataire.setName("btn_mesLocations_InfoLocataire");
		panel_MesLocations.add(btn_mesLocations_InfoLocataire);

		// Champs de saisie
		this.textField_loyer = new JTextField();
		this.textField_loyer.setBackground(new Color(255, 255, 255));
		this.textField_loyer.setEditable(false);
		this.textField_loyer.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204), 1, true), "Loyer",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
		this.textField_loyer.setBounds(510, 89, 152, 31);
		panel_MesLocations.add(this.textField_loyer);
		this.textField_loyer.setColumns(10);

		this.textField_provisionCharges = new JTextField();
		this.textField_provisionCharges.setEditable(false);
		this.textField_provisionCharges.setColumns(10);
		this.textField_provisionCharges.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204), 1, true),
				"Provision sur charges", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
		this.textField_provisionCharges.setBackground(Color.WHITE);
		this.textField_provisionCharges.setBounds(510, 341, 152, 31);
		panel_MesLocations.add(this.textField_provisionCharges);

		this.textField_caution = new JTextField();
		this.textField_caution.setEditable(false);
		this.textField_caution.setColumns(10);
		this.textField_caution.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204), 1, true), "Caution",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
		this.textField_caution.setBackground(Color.WHITE);
		this.textField_caution.setBounds(510, 299, 152, 31);
		panel_MesLocations.add(this.textField_caution);

		this.textField_dateEmission = new JTextField();
		this.textField_dateEmission.setEditable(false);
		this.textField_dateEmission.setColumns(10);
		this.textField_dateEmission.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204), 1, true),
				"Date \u00E9mission", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
		this.textField_dateEmission.setBackground(Color.WHITE);
		this.textField_dateEmission.setBounds(510, 131, 152, 31);
		panel_MesLocations.add(this.textField_dateEmission);

		this.textField_dateEcheance = new JTextField();
		this.textField_dateEcheance.setEditable(false);
		this.textField_dateEcheance.setColumns(10);
		this.textField_dateEcheance.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204), 1, true),
				"Date \u00E9ch\u00E9ance", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
		this.textField_dateEcheance.setBackground(Color.WHITE);
		this.textField_dateEcheance.setBounds(510, 173, 152, 31);
		panel_MesLocations.add(this.textField_dateEcheance);

		this.textField_paye = new JTextField();
		this.textField_paye.setEditable(false);
		this.textField_paye.setColumns(10);
		this.textField_paye.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204), 1, true), "Pay\u00E9",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
		this.textField_paye.setBackground(Color.WHITE);
		this.textField_paye.setBounds(510, 215, 152, 31);
		panel_MesLocations.add(this.textField_paye);

		this.textField_restantDu = new JTextField();
		this.textField_restantDu.setEditable(false);
		this.textField_restantDu.setColumns(10);
		this.textField_restantDu.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204), 1, true),
				"Restant d\u00FB", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
		this.textField_restantDu.setBackground(Color.WHITE);
		this.textField_restantDu.setBounds(510, 257, 152, 31);
		panel_MesLocations.add(this.textField_restantDu);

		//////////////////////////////////////////////////////////////////////////
		// LAYERED MES
		// TRAVAUX////////////////////////////////////////////////////////////////
		this.layeredPane_MesTravaux = new JLayeredPane();
		this.contentPane.add(this.layeredPane_MesTravaux, BorderLayout.CENTER);
		this.layeredPane_MesTravaux.setLayout(new BorderLayout(0, 0));

		JPanel panel_MesTravaux = new JPanel();
		panel_MesTravaux.setBackground(Color.WHITE);
		this.layeredPane_MesTravaux.add(panel_MesTravaux);
		panel_MesTravaux.setLayout(null);

		// Tableaux et scrollPane
		JScrollPane scrollPane_MesTravaux = new JScrollPane();
		scrollPane_MesTravaux.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
		scrollPane_MesTravaux.setBounds(51, 128, 641, 289);
		panel_MesTravaux.add(scrollPane_MesTravaux);

		this.table_MesTravaux = new JTable();
		this.table_MesTravaux.setSelectionBackground(new Color(0, 102, 204));
		this.table_MesTravaux.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null }, }, new String[] { "Bien/Logement",
						"D\u00E9signation", "Date \u00E9mission", "Montant", "Pay\u00E9", "Prestataire", "Adresse" }));
		this.table_MesTravaux.setBounds(40, 53, 668, 130);
		scrollPane_MesTravaux.setViewportView(this.table_MesTravaux);

		// labels
		JLabel lbl_MesTravaux = new JLabel("Mes Travaux");
		lbl_MesTravaux.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MesTravaux.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_MesTravaux.setBounds(244, 22, 216, 43);
		panel_MesTravaux.add(lbl_MesTravaux);

		// Séparateurs
		JSeparator separator_MesTravaux = new JSeparator();
		separator_MesTravaux.setForeground(new Color(0, 102, 204));
		separator_MesTravaux.setBounds(258, 63, 190, 2);
		panel_MesTravaux.add(separator_MesTravaux);

		// Boutons généraux
		JButton btn_Travaux_Modifier = new JButton("Modifier");
		btn_Travaux_Modifier.setForeground(Color.WHITE);
		btn_Travaux_Modifier.setBackground(new Color(0, 102, 204));
		btn_Travaux_Modifier.setBounds(216, 449, 99, 31);
		btn_Travaux_Modifier.addActionListener(this.gestionAccueil);
		btn_Travaux_Modifier.setName("btn_Travaux_Modifier");
		panel_MesTravaux.add(btn_Travaux_Modifier);

		JButton btn_Travaux_Supprimer = new JButton("Supprimer");
		btn_Travaux_Supprimer.setForeground(Color.WHITE);
		btn_Travaux_Supprimer.setBackground(new Color(0, 102, 204));
		btn_Travaux_Supprimer.setBounds(425, 449, 105, 31);
		btn_Travaux_Supprimer.addActionListener(this.gestionAccueil);
		btn_Travaux_Supprimer.setName("btn_Travaux_Supprimer");
		panel_MesTravaux.add(btn_Travaux_Supprimer);

		// Boutons propres à la page
		JToggleButton tglbtn_Travaux_immeubles = new JToggleButton("Travaux pour mes immeubles");
		tglbtn_Travaux_immeubles.setBounds(112, 76, 216, 23);
		tglbtn_Travaux_immeubles.addActionListener(this.gestionAccueil);
		tglbtn_Travaux_immeubles.setName("tglbtn_Travaux_immeubles");
		panel_MesTravaux.add(tglbtn_Travaux_immeubles);

		JToggleButton tglbtn_Travaux_logements = new JToggleButton("Travaux pour mes logements");
		tglbtn_Travaux_logements.setBounds(384, 76, 208, 23);
		tglbtn_Travaux_logements.addActionListener(this.gestionAccueil);
		tglbtn_Travaux_logements.setName("tglbtn_Travaux_logements");
		panel_MesTravaux.add(tglbtn_Travaux_logements);

		///////////////////////////////////////////////////////////////////
		// LAYERED MES CHARGES LOCATIVES
		// ////////////////////////////////////////////////////////////////
		this.layeredPane_MesChargesLocatives = new JLayeredPane();
		this.contentPane.add(this.layeredPane_MesChargesLocatives, BorderLayout.CENTER);
		this.layeredPane_MesChargesLocatives.setLayout(new BorderLayout(0, 0));

		JPanel panel_chargesLocatives = new JPanel();
		panel_chargesLocatives.setBackground(Color.WHITE);
		this.layeredPane_MesChargesLocatives.add(panel_chargesLocatives);
		panel_chargesLocatives.setLayout(null);

		// Tableaux et scrollPane
		JScrollPane scrollPane_MesChargesLocatives = new JScrollPane();
		scrollPane_MesChargesLocatives.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
		scrollPane_MesChargesLocatives.setBounds(55, 124, 643, 288);
		panel_chargesLocatives.add(scrollPane_MesChargesLocatives);

		this.table_MesChargesLocatives = new JTable();
		this.table_MesChargesLocatives.setSelectionBackground(new Color(0, 102, 204));
		this.table_MesChargesLocatives.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, },
				new String[] { "Libell\u00E9", "Bien", "D\u00E9ductible", "Montant" }));
		this.table_MesChargesLocatives.setBounds(40, 53, 668, 130);
		scrollPane_MesChargesLocatives.setViewportView(this.table_MesChargesLocatives);

		// Labels
		JLabel lbl_MesChargesLocatives = new JLabel("Mes Charges Locatives");
		lbl_MesChargesLocatives.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MesChargesLocatives.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_MesChargesLocatives.setBounds(244, 22, 216, 43);
		panel_chargesLocatives.add(lbl_MesChargesLocatives);

		// Séparateurs
		JSeparator separator_mesChargesLocatives = new JSeparator();
		separator_mesChargesLocatives.setForeground(new Color(0, 102, 204));
		separator_mesChargesLocatives.setBounds(258, 63, 190, 2);
		panel_chargesLocatives.add(separator_mesChargesLocatives);

		// Boutons généraux
		JButton btn_MesChargesLocatives_Charger = new JButton("Charger");
		btn_MesChargesLocatives_Charger.setForeground(Color.WHITE);
		btn_MesChargesLocatives_Charger.setBackground(new Color(0, 102, 204));
		btn_MesChargesLocatives_Charger.setBounds(118, 449, 94, 31);
		btn_MesChargesLocatives_Charger.addActionListener(this.gestionAccueil);
		btn_MesChargesLocatives_Charger.setName("btn_MesChargesLocatives_Charger");
		panel_chargesLocatives.add(btn_MesChargesLocatives_Charger);

		JButton btn_MesChargesLocatives_Modifier = new JButton("Modifier");
		btn_MesChargesLocatives_Modifier.setForeground(Color.WHITE);
		btn_MesChargesLocatives_Modifier.setBackground(new Color(0, 102, 204));
		btn_MesChargesLocatives_Modifier.setBounds(396, 449, 99, 31);
		btn_MesChargesLocatives_Modifier.addActionListener(this.gestionAccueil);
		btn_MesChargesLocatives_Modifier.setName("btn_MesChargesLocatives_Modifier");
		panel_chargesLocatives.add(btn_MesChargesLocatives_Modifier);

		JButton btn_MesChargesLocatives_Inserer = new JButton("Insérer");
		btn_MesChargesLocatives_Inserer.setForeground(Color.WHITE);
		btn_MesChargesLocatives_Inserer.setBackground(new Color(0, 102, 204));
		btn_MesChargesLocatives_Inserer.setBounds(258, 449, 94, 31);
		btn_MesChargesLocatives_Inserer.addActionListener(this.gestionAccueil);
		btn_MesChargesLocatives_Inserer.setName("btn_MesChargesLocatives_Inserer");
		panel_chargesLocatives.add(btn_MesChargesLocatives_Inserer);

		JButton btn_MesChargesLocatives_Supprimer = new JButton("Supprimer");
		btn_MesChargesLocatives_Supprimer.setForeground(Color.WHITE);
		btn_MesChargesLocatives_Supprimer.setBackground(new Color(0, 102, 204));
		btn_MesChargesLocatives_Supprimer.setBounds(539, 449, 106, 31);
		btn_MesChargesLocatives_Supprimer.addActionListener(this.gestionAccueil);
		btn_MesChargesLocatives_Supprimer.setName("btn_MesChargesLocatives_Supprimer");
		panel_chargesLocatives.add(btn_MesChargesLocatives_Supprimer);

		// ComboBox
		// CODE A FOURNIR POUR LA LISTE DES IDENTIFIANTS DE LOGEMENTS
		JComboBox comboBox_MesChargesLocatives = new JComboBox();
		comboBox_MesChargesLocatives.setModel(new DefaultComboBoxModel(new String[] { "ID du logement" }));
		comboBox_MesChargesLocatives.setBounds(55, 81, 130, 21);
		panel_chargesLocatives.add(comboBox_MesChargesLocatives);

		///////////////////////////////////////////////////////////////////
		// LAYERED MES ASSURANCES
		// ////////////////////////////////////////////////////////////////
		this.layeredPane_MesAssurances = new JLayeredPane();
		this.contentPane.add(this.layeredPane_MesAssurances, BorderLayout.CENTER);
		this.layeredPane_MesAssurances.setLayout(new BorderLayout(0, 0));

		JPanel panel_MesAssurances = new JPanel();
		panel_MesAssurances.setBackground(Color.WHITE);
		this.layeredPane_MesAssurances.add(panel_MesAssurances);
		panel_MesAssurances.setLayout(null);

		// Tableaux et scrollPane
		JScrollPane scrollPane_MesAssurances = new JScrollPane();
		scrollPane_MesAssurances.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
		scrollPane_MesAssurances.setBounds(55, 124, 643, 270);
		panel_MesAssurances.add(scrollPane_MesAssurances);

		this.table_MesAssurances = new JTable();
		this.table_MesAssurances.setSelectionBackground(new Color(0, 102, 204));
		this.table_MesAssurances.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, }, new String[] { "n\u00B0 Police", "Montant",
						"Date \u00E9ch\u00E9ance", "Prestataire", "Adresse", "n\u00B0 T\u00E9l\u00E9phone" }));
		this.table_MesAssurances.setBounds(40, 53, 668, 130);
		scrollPane_MesAssurances.setViewportView(this.table_MesAssurances);

		// Labels
		JLabel lbl_MesAssurances = new JLabel("Mes Assurances");
		lbl_MesAssurances.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MesAssurances.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_MesAssurances.setBounds(244, 22, 216, 43);
		panel_MesAssurances.add(lbl_MesAssurances);

		// Séparateurs
		JSeparator separator_mesAssurances = new JSeparator();
		separator_mesAssurances.setForeground(new Color(0, 102, 204));
		separator_mesAssurances.setBounds(258, 63, 190, 2);
		panel_MesAssurances.add(separator_mesAssurances);

		// Boutons généraux
		JButton btn_MesAssurances_Charger = new JButton("Charger");
		btn_MesAssurances_Charger.setForeground(Color.WHITE);
		btn_MesAssurances_Charger.setBackground(new Color(0, 102, 204));
		btn_MesAssurances_Charger.setBounds(118, 449, 94, 31);
		btn_MesAssurances_Charger.addActionListener(this.gestionAccueil);
		btn_MesAssurances_Charger.setName("btn_MesAssurances_Charger");
		panel_MesAssurances.add(btn_MesAssurances_Charger);

		JButton btn_MesAssurances_Modifier = new JButton("Modifier");
		btn_MesAssurances_Modifier.setForeground(Color.WHITE);
		btn_MesAssurances_Modifier.setBackground(new Color(0, 102, 204));
		btn_MesAssurances_Modifier.setBounds(396, 449, 99, 31);
		btn_MesAssurances_Modifier.addActionListener(this.gestionAccueil);
		btn_MesAssurances_Modifier.setName("btn_MesAssurances_Modifier");
		panel_MesAssurances.add(btn_MesAssurances_Modifier);

		JButton btn_MesAssurances_Inserer = new JButton("Insérer");
		btn_MesAssurances_Inserer.setForeground(Color.WHITE);
		btn_MesAssurances_Inserer.setBackground(new Color(0, 102, 204));
		btn_MesAssurances_Inserer.setBounds(258, 449, 94, 31);
		btn_MesAssurances_Inserer.addActionListener(this.gestionAccueil);
		btn_MesAssurances_Inserer.setName("btn_MesAssurances_Inserer");
		panel_MesAssurances.add(btn_MesAssurances_Inserer);

		JButton btn_MesAssurances_Supprimer = new JButton("Supprimer");
		btn_MesAssurances_Supprimer.setForeground(Color.WHITE);
		btn_MesAssurances_Supprimer.setBackground(new Color(0, 102, 204));
		btn_MesAssurances_Supprimer.setBounds(539, 449, 106, 31);
		btn_MesAssurances_Supprimer.addActionListener(this.gestionAccueil);
		btn_MesAssurances_Supprimer.setName("btn_MesAssurances_Supprimer");
		panel_MesAssurances.add(btn_MesAssurances_Supprimer);

		// ComboBox
		// CODE A FOURNIR POUR LA LISTE DES IDENTIFIANTS DE LOGEMENTS
		JComboBox comboBox_MesAssurances = new JComboBox();
		comboBox_MesAssurances.setModel(new DefaultComboBoxModel(new String[] { "ID du logement" }));
		comboBox_MesAssurances.setBounds(55, 80, 130, 21);
		panel_MesAssurances.add(comboBox_MesAssurances);

		///////////////////////////////////////////////////////////////////
		// LAYERED REGULARISATION DES CHARGES
		// ////////////////////////////////////////////////////////////////
		this.layeredPane_RegularisationDesCharges = new JLayeredPane();
		this.contentPane.add(this.layeredPane_RegularisationDesCharges, BorderLayout.CENTER);
		this.layeredPane_RegularisationDesCharges.setLayout(new BorderLayout(0, 0));

		JPanel panel_RegularisationDesCharges = new JPanel();
		panel_RegularisationDesCharges.setBackground(Color.WHITE);
		this.layeredPane_RegularisationDesCharges.add(panel_RegularisationDesCharges);
		panel_RegularisationDesCharges.setLayout(null);

		// Tableaux et scrollPane
		JScrollPane scrollPane_Regularisation = new JScrollPane();
		scrollPane_Regularisation.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
		scrollPane_Regularisation.setBounds(28, 121, 697, 303);
		panel_RegularisationDesCharges.add(scrollPane_Regularisation);

		tableRegularisation = new JTable();
		tableRegularisation.setSelectionBackground(new Color(0, 102, 204));
		tableRegularisation.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "Date entr\u00E9e", "Date sortie", "Total charges", "Travaux imputables",
						"Charges garage", "Total des provisions" }));
		tableRegularisation.getColumnModel().getColumn(0).setPreferredWidth(65);
		tableRegularisation.getColumnModel().getColumn(1).setPreferredWidth(65);
		this.tableRegularisation.setBounds(40, 53, 668, 130);
		scrollPane_Regularisation.setViewportView(this.tableRegularisation);

		// Labels
		JLabel lbl_RegularisationDesCharges = new JLabel("Régularisation des Charges");
		lbl_RegularisationDesCharges.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_RegularisationDesCharges.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_RegularisationDesCharges.setBounds(244, 22, 216, 43);
		panel_RegularisationDesCharges.add(lbl_RegularisationDesCharges);

		// Séparateurs
		JSeparator separator_RegularisationDesChargess = new JSeparator();
		separator_RegularisationDesChargess.setForeground(new Color(0, 102, 204));
		separator_RegularisationDesChargess.setBounds(258, 63, 190, 2);
		panel_RegularisationDesCharges.add(separator_RegularisationDesChargess);

		// JComboBox
		JComboBox comboBox_Regularisation = new JComboBox();
		comboBox_Regularisation.setModel(new DefaultComboBoxModel(new String[] { "Locataire" }));
		comboBox_Regularisation.setBounds(55, 81, 130, 21);
		panel_RegularisationDesCharges.add(comboBox_Regularisation);

		/////////////////////////////////////////////////////////////////////////
		// LAYERED SOLDE DE TOUT
		// COMPTE////////////////////////////////////////////////////////////////
//		this.layeredPane_SoldeDeToutCompte = new JLayeredPane();
//		this.contentPane.add(this.layeredPane_SoldeDeToutCompte, BorderLayout.CENTER);
//		this.layeredPane_SoldeDeToutCompte.setLayout(new BorderLayout(0, 0));
//
//		JPanel panel_SoldeDeToutCompte = new JPanel();
//		panel_SoldeDeToutCompte.setBackground(Color.WHITE);
//		this.layeredPane_SoldeDeToutCompte.add(panel_SoldeDeToutCompte);
//		panel_SoldeDeToutCompte.setLayout(null);
//
//		JLabel lbl_SoldeDeToutCompte = new JLabel("Mon Solde de Tout Compte");
//		lbl_SoldeDeToutCompte.setHorizontalAlignment(SwingConstants.CENTER);
//		lbl_SoldeDeToutCompte.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lbl_SoldeDeToutCompte.setBounds(244, 22, 216, 43);
//		panel_SoldeDeToutCompte.add(lbl_SoldeDeToutCompte);
//
//		JSeparator separator_SoldeDeToutCompte = new JSeparator();
//		separator_SoldeDeToutCompte.setForeground(new Color(0, 102, 204));
//		separator_SoldeDeToutCompte.setBounds(258, 63, 190, 2);
//		panel_SoldeDeToutCompte.add(separator_SoldeDeToutCompte);
//
//		JScrollPane scrollPane_SoldeDeToutCompte = new JScrollPane();
//		scrollPane_SoldeDeToutCompte.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
//		scrollPane_SoldeDeToutCompte.setBounds(55, 131, 643, 225);
//		panel_SoldeDeToutCompte.add(scrollPane_SoldeDeToutCompte);
//
//		this.table_SoldeDeToutCompte = new JTable();
//		this.table_SoldeDeToutCompte.setSelectionBackground(new Color(0, 102, 204));
//		this.table_SoldeDeToutCompte
//				.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
//						new String[] { "New column", "New column", "New column", "New column" }));
//		this.table_SoldeDeToutCompte.setBounds(40, 53, 668, 130);
//		scrollPane_SoldeDeToutCompte.setViewportView(this.table_SoldeDeToutCompte);
//
//		JButton btn_SoldeDeToutCompte_Inserer = new JButton("Générer le reçu");
//		btn_SoldeDeToutCompte_Inserer.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btn_SoldeDeToutCompte_Inserer.setBounds(201, 449, 137, 31);
//		panel_SoldeDeToutCompte.add(btn_SoldeDeToutCompte_Inserer);
//
//		JButton btn_SoldeDeToutCompte_Annuler = new JButton("Annuler");
//		btn_SoldeDeToutCompte_Annuler.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btn_SoldeDeToutCompte_Annuler.setBounds(396, 449, 94, 31);
//		panel_SoldeDeToutCompte.add(btn_SoldeDeToutCompte_Annuler);
//
//		JComboBox comboBox_SoldeDeToutCompte = new JComboBox();
//		comboBox_SoldeDeToutCompte.setModel(new DefaultComboBoxModel(new String[] { "Locataire" }));
//		comboBox_SoldeDeToutCompte.setBounds(55, 92, 118, 21);
//		panel_SoldeDeToutCompte.add(comboBox_SoldeDeToutCompte);
//
//		JLabel lbl_SoldeDeToutCompte_Locataires = new JLabel("Locataires");
//		lbl_SoldeDeToutCompte_Locataires.setBounds(56, 69, 82, 13);
//		panel_SoldeDeToutCompte.add(lbl_SoldeDeToutCompte_Locataires);

		// A faire éventuellement à la fin
		////////////////////////////////////////////////////////////////////////////
		// LAYERED
		// DOCUMENTS////////////////////////////////////////////////////////////////
//		this.layeredPane_MesDocuments = new JLayeredPane();
//		this.contentPane.add(this.layeredPane_MesDocuments, BorderLayout.CENTER);
//		this.layeredPane_MesDocuments.setLayout(new BorderLayout(0, 0));
//
//		JPanel panel_MesDocuments = new JPanel();
//		panel_MesDocuments.setBackground(Color.WHITE);
//		this.layeredPane_MesDocuments.add(panel_MesDocuments);
//		panel_MesDocuments.setLayout(null);
//
//		JLabel lbl_MesDocuments = new JLabel("Mes Documents");
//		lbl_MesDocuments.setHorizontalAlignment(SwingConstants.CENTER);
//		lbl_MesDocuments.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lbl_MesDocuments.setBounds(244, 22, 216, 43);
//		panel_MesDocuments.add(lbl_MesDocuments);
//
//		JSeparator separator_MesDocuments = new JSeparator();
//		separator_MesDocuments.setForeground(new Color(0, 102, 204));
//		separator_MesDocuments.setBounds(258, 63, 190, 2);
//		panel_MesDocuments.add(separator_MesDocuments);
//
//		JLabel aFAIRE2 = new JLabel("A FAIRE");
//		aFAIRE2.setFont(new Font("Tahoma", Font.PLAIN, 44));
//		aFAIRE2.setBounds(258, 189, 312, 139);
//		panel_MesDocuments.add(aFAIRE2);

		// this.mettrePageParDef();
	}

	public JLayeredPane getLayeredPane_MesDocuments() {
		return layeredPane_MesDocuments;
	}

	public JLayeredPane getLayeredPane_Accueil() {
		return layeredPane_Accueil;
	}

	public JLayeredPane getLayeredPane_MesLocations() {
		return layeredPane_MesLocations;
	}

	public JLayeredPane getLayeredPane_MesBiens() {
		return layeredPane_MesBiens;
	}

	public JLayeredPane getLayeredPane_MesTravaux() {
		return layeredPane_MesTravaux;
	}

	public JLayeredPane getLayeredPane_MesChargesLocatives() {
		return layeredPane_MesChargesLocatives;
	}

	public JLayeredPane getLayeredPane_MesAssurances() {
		return layeredPane_MesAssurances;
	}

	public JLayeredPane getLayeredPane_RegularisationDesCharges() {
		return layeredPane_RegularisationDesCharges;
	}

	public JLayeredPane getLayeredPane_SoldeDeToutCompte() {
		return layeredPane_SoldeDeToutCompte;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	
	// ---------fonctions--------//
	public JTable getTableBiens() {
		return tableMesBiens;
	}

}