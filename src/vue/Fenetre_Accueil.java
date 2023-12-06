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
import javax.swing.JComboBox;
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
import javax.swing.table.DefaultTableModel;

import vue.insertion.Fenetre_InsertionAssurance;
import vue.insertion.Fenetre_InsertionBien;

public class Fenetre_Accueil extends JFrame implements ActionListener {

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
	private JTable table_MesBiens;
	private JTable table_MesBiens_Logements;
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
		btnAccueil.addActionListener(this);
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
		btnMesBiens.addActionListener(this);
		btnMesBiens.setBackground(new Color(0, 102, 204));
		btnMesBiens.setForeground(new Color(255, 255, 255));
		btnMesBiens.setFont(new Font("Dialog", Font.BOLD, 12));
		btnMesBiens.setName("btnMesBiens");
		panel_Menu_Boutons.add(btnMesBiens);

		JButton btnMesLocations = new JButton("Mes Locations");
		btnMesLocations.setForeground(new Color(255, 255, 255));
		btnMesLocations.addActionListener(this);
		btnMesLocations.setBackground(new Color(0, 102, 204));
		btnMesLocations.setFont(new Font("Dialog", Font.BOLD, 12));
		btnMesLocations.setName("btnMesLocations");
		panel_Menu_Boutons.add(btnMesLocations);

		JButton btnMesTravaux = new JButton("Mes Travaux");
		btnMesTravaux.setForeground(new Color(255, 255, 255));
		btnMesTravaux.addActionListener(this);
		btnMesTravaux.setBackground(new Color(0, 102, 204));
		btnMesTravaux.setFont(new Font("Dialog", Font.BOLD, 12));
		btnMesTravaux.setName("btnMesTravaux");
		panel_Menu_Boutons.add(btnMesTravaux);

		JButton btnMesChargesLocatives = new JButton("Mes Charges Locatives");
		btnMesChargesLocatives.setForeground(new Color(255, 255, 255));
		btnMesChargesLocatives.addActionListener(this);
		btnMesChargesLocatives.setBackground(new Color(0, 102, 204));
		btnMesChargesLocatives.setFont(new Font("Dialog", Font.BOLD, 12));
		btnMesChargesLocatives.setName("btnMesChargesLocatives");
		panel_Menu_Boutons.add(btnMesChargesLocatives);

		JButton btnMesAssurances = new JButton("Mes Assurances");
		btnMesAssurances.setForeground(new Color(255, 255, 255));
		btnMesAssurances.addActionListener(this);
		btnMesAssurances.setBackground(new Color(0, 102, 204));
		btnMesAssurances.setFont(new Font("Dialog", Font.BOLD, 12));
		btnMesAssurances.setName("btnMesAssurances");
		panel_Menu_Boutons.add(btnMesAssurances);

		JButton btnRegularisationDesCharges = new JButton("Régularisation des Charges");
		btnRegularisationDesCharges.setForeground(new Color(255, 255, 255));
		btnRegularisationDesCharges.addActionListener(this);
		btnRegularisationDesCharges.setBackground(new Color(0, 102, 204));
		btnRegularisationDesCharges.setFont(new Font("Dialog", Font.BOLD, 12));
		btnRegularisationDesCharges.setName("btnRegularisationDesCharges");
		panel_Menu_Boutons.add(btnRegularisationDesCharges);

		JButton btnSoldeDeToutCompte = new JButton("Solde de tout compte");
		btnSoldeDeToutCompte.setForeground(new Color(255, 255, 255));
		btnSoldeDeToutCompte.addActionListener(this);
		btnSoldeDeToutCompte.setBackground(new Color(0, 102, 204));
		btnSoldeDeToutCompte.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSoldeDeToutCompte.setName("btnSoldeDeToutCompte");
		panel_Menu_Boutons.add(btnSoldeDeToutCompte);

		JButton btnMesDocuments = new JButton("Mes Documents");
		btnMesDocuments.setForeground(new Color(255, 255, 255));
		btnMesDocuments.addActionListener(this);
		btnMesDocuments.setBackground(new Color(0, 102, 204));
		btnMesDocuments.setFont(new Font("Dialog", Font.BOLD, 12));
		btnMesDocuments.setName("btnMesDocuments");
		panel_Menu_Boutons.add(btnMesDocuments);

<<<<<<< HEAD
=======


		///////////////////////////////////////////////////////////////////
>>>>>>> 1a5ce9528c16a3f97fec90ef26dbd2ab357e8231
		// LAYERED ACCUEIL
		// ////////////////////////////////////////////////////////////////

		this.layeredPane_Accueil = new JLayeredPane();
		this.layeredPane_Accueil.setBackground(new Color(255, 255, 255));
		this.contentPane.add(this.layeredPane_Accueil, BorderLayout.CENTER);
		this.layeredPane_Accueil.setLayout(new BorderLayout(0, 0));

<<<<<<< HEAD
//		// LAYERED MES BIENS
//		// ////////////////////////////////////////////////////////////////
//		this.layeredPane_MesBiens = new JLayeredPane();
//		this.contentPane.add(this.layeredPane_MesBiens, BorderLayout.CENTER);
//		this.layeredPane_MesBiens.setLayout(new BorderLayout(0, 0));
//
//		JPanel panel_biens = new JPanel();
//		panel_biens.setBackground(Color.WHITE);
//		this.layeredPane_MesBiens.add(panel_biens);
//		panel_biens.setLayout(null);
//
//		JLabel lbl_mesBiens = new JLabel("Mes Biens");
//		lbl_mesBiens.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lbl_mesBiens.setHorizontalAlignment(SwingConstants.CENTER);
//		lbl_mesBiens.setHorizontalTextPosition(SwingConstants.CENTER);
//		lbl_mesBiens.setBounds(244, 22, 216, 43);
//		panel_biens.add(lbl_mesBiens);
//
//		JScrollPane scrollPane_MesBiens = new JScrollPane();
//		scrollPane_MesBiens.setToolTipText("40, 53, 668, 130");
//		scrollPane_MesBiens.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
//		scrollPane_MesBiens.setBackground(Color.LIGHT_GRAY);
//		scrollPane_MesBiens.setBounds(40, 98, 475, 126);
//		panel_biens.add(scrollPane_MesBiens);
//
//		this.table_MesBiens = new JTable();
//		this.table_MesBiens.setSelectionBackground(new Color(0, 102, 204));
//		this.table_MesBiens.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
//				new String[] { "Nom du bien", "Adresse", "Nb de logements" }));
//		this.table_MesBiens.setBounds(40, 53, 668, 130);
//		scrollPane_MesBiens.setViewportView(this.table_MesBiens);
//
//		JButton btnInserer = new JButton("Insérer");
//		btnInserer.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btnInserer.setBounds(262, 449, 94, 31);
//		panel_biens.add(btnInserer);
//
//		JButton btnCharger = new JButton("Charger");
//		btnCharger.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btnCharger.setBounds(111, 449, 94, 31);
//		panel_biens.add(btnCharger);
//
//		JButton btnSupprimer = new JButton("Supprimer");
//		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btnSupprimer.setBounds(551, 449, 94, 31);
//		panel_biens.add(btnSupprimer);
//
//		JButton btnModifier = new JButton("Modifier");
//		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btnModifier.setBounds(406, 449, 99, 31);
//		panel_biens.add(btnModifier);
//
//		JScrollPane scrollPane_MesBiens_Logements = new JScrollPane();
//		scrollPane_MesBiens_Logements.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
//		scrollPane_MesBiens_Logements.setBackground(Color.LIGHT_GRAY);
//		scrollPane_MesBiens_Logements.setBounds(40, 283, 475, 134);
//		panel_biens.add(scrollPane_MesBiens_Logements);
//
//		this.table_MesBiens_Logements = new JTable();
//		this.table_MesBiens_Logements
//				.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
//						new String[] { "Nom", "Surface", "Nb pi\u00E8ces", "Etage", "Aquisition", "Occup\u00E9" }));
//		this.table_MesBiens_Logements.setBounds(40, 266, 438, 106);
//		scrollPane_MesBiens_Logements.setViewportView(this.table_MesBiens_Logements);
//
//		JLabel lblLogements = new JLabel("Mes Logements");
//		lblLogements.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblLogements.setBounds(40, 259, 94, 13);
//		panel_biens.add(lblLogements);
//
//		JSeparator separator_mesBiens = new JSeparator();
//		separator_mesBiens.setForeground(new Color(0, 102, 204));
//		separator_mesBiens.setBounds(258, 63, 190, 2);
//		panel_biens.add(separator_mesBiens);
//
//		JButton btnAjouterDiagnosticBien = new JButton("Ajouter un diagnostic");
//		btnAjouterDiagnosticBien.setBounds(561, 137, 151, 23);
//		panel_biens.add(btnAjouterDiagnosticBien);
//
//		JButton btnAjouterDesTravaux = new JButton("Ajouter des travaux");
//		btnAjouterDesTravaux.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnAjouterDesTravaux.setBounds(561, 171, 151, 23);
//		panel_biens.add(btnAjouterDesTravaux);
//
//		JButton btnAjouterDesTravaux_1 = new JButton("Ajouter des travaux");
//		btnAjouterDesTravaux_1.setBounds(561, 360, 151, 23);
//		panel_biens.add(btnAjouterDesTravaux_1);
//
//		JButton btnAjouterDiagnosticBien_1 = new JButton("Ajouter un diagnostic");
//		btnAjouterDiagnosticBien_1.setBounds(561, 326, 151, 23);
//		panel_biens.add(btnAjouterDiagnosticBien_1);

		// LAYERED MES
		// LOCATIONS////////////////////////////////////////////////////////////////
//		this.layeredPane_MesLocations = new JLayeredPane();
//		this.layeredPane_MesLocations.setBackground(Color.WHITE);
//		this.contentPane.add(this.layeredPane_MesLocations, BorderLayout.CENTER);
//		this.layeredPane_MesLocations.setLayout(new BorderLayout(0, 0));
//
//		JPanel panel_MesLocations = new JPanel();
//		panel_MesLocations.setBackground(Color.WHITE);
//		this.layeredPane_MesLocations.add(panel_MesLocations, BorderLayout.CENTER);
//		panel_MesLocations.setLayout(null);
//
//		JScrollPane scrollPane_MesLocations = new JScrollPane();
//		scrollPane_MesLocations.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
//		scrollPane_MesLocations.setBounds(30, 95, 418, 309);
//		panel_MesLocations.add(scrollPane_MesLocations);
//
//		this.table_MesLocations = new JTable();
//		this.table_MesLocations.setSelectionBackground(new Color(0, 102, 204));
//		this.table_MesLocations.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
//				new String[] { "Locataire", "Bien", "Adresse", "Code Postal", "Ville" }));
//		this.table_MesLocations.setBounds(40, 53, 668, 130);
//		scrollPane_MesLocations.setViewportView(this.table_MesLocations);
//
//		JButton btn_MesLocations_Charger = new JButton("Charger");
//		btn_MesLocations_Charger.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btn_MesLocations_Charger.setBounds(118, 449, 94, 31);
//		panel_MesLocations.add(btn_MesLocations_Charger);
//
//		JButton btn_MesLocations_Inserer = new JButton("Insérer");
//		btn_MesLocations_Inserer.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btn_MesLocations_Inserer.setBounds(258, 449, 94, 31);
//		panel_MesLocations.add(btn_MesLocations_Inserer);
//
//		JButton btn_MesLocations_Supprimer = new JButton("Supprimer");
//		btn_MesLocations_Supprimer.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btn_MesLocations_Supprimer.setBounds(539, 449, 94, 31);
//		panel_MesLocations.add(btn_MesLocations_Supprimer);
//
//		JButton btn_MesLocations_Modifier = new JButton("Modifier");
//		btn_MesLocations_Modifier.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btn_MesLocations_Modifier.setBounds(396, 449, 99, 31);
//		panel_MesLocations.add(btn_MesLocations_Modifier);
//
//		JLabel lbl_MesLocations = new JLabel("Mes Locations");
//		lbl_MesLocations.setHorizontalAlignment(SwingConstants.CENTER);
//		lbl_MesLocations.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lbl_MesLocations.setBounds(244, 22, 216, 43);
//		panel_MesLocations.add(lbl_MesLocations);
//
//		JSeparator separator = new JSeparator();
//		separator.setForeground(new Color(0, 102, 204));
//		separator.setBounds(258, 63, 190, 2);
//		panel_MesLocations.add(separator);
//
//		this.textField = new JTextField();
//		this.textField.setBackground(new Color(255, 255, 255));
//		this.textField.setEditable(false);
//		this.textField.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204), 1, true), "Loyer",
//				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
//		this.textField.setBounds(510, 107, 152, 31);
//		panel_MesLocations.add(this.textField);
//		this.textField.setColumns(10);
//
//		this.textField_1 = new JTextField();
//		this.textField_1.setEditable(false);
//		this.textField_1.setColumns(10);
//		this.textField_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204), 1, true),
//				"Provision sur charges", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
//		this.textField_1.setBackground(Color.WHITE);
//		this.textField_1.setBounds(510, 353, 152, 31);
//		panel_MesLocations.add(this.textField_1);
//
//		this.textField_2 = new JTextField();
//		this.textField_2.setEditable(false);
//		this.textField_2.setColumns(10);
//		this.textField_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204), 1, true), "Caution",
//				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
//		this.textField_2.setBackground(Color.WHITE);
//		this.textField_2.setBounds(510, 312, 152, 31);
//		panel_MesLocations.add(this.textField_2);
//
//		this.textField_3 = new JTextField();
//		this.textField_3.setEditable(false);
//		this.textField_3.setColumns(10);
//		this.textField_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204), 1, true),
//				"Date \u00E9mission", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
//		this.textField_3.setBackground(Color.WHITE);
//		this.textField_3.setBounds(510, 148, 152, 31);
//		panel_MesLocations.add(this.textField_3);
//
//		this.textField_4 = new JTextField();
//		this.textField_4.setEditable(false);
//		this.textField_4.setColumns(10);
//		this.textField_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204), 1, true),
//				"Date \u00E9ch\u00E9ance", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
//		this.textField_4.setBackground(Color.WHITE);
//		this.textField_4.setBounds(510, 189, 152, 31);
//		panel_MesLocations.add(this.textField_4);
//
//		this.textField_5 = new JTextField();
//		this.textField_5.setEditable(false);
//		this.textField_5.setColumns(10);
//		this.textField_5.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204), 1, true), "Pay\u00E9",
//				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
//		this.textField_5.setBackground(Color.WHITE);
//		this.textField_5.setBounds(510, 230, 152, 31);
//		panel_MesLocations.add(this.textField_5);
//
//		this.textField_6 = new JTextField();
//		this.textField_6.setEditable(false);
//		this.textField_6.setColumns(10);
//		this.textField_6.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204), 1, true), "Restant d\u00FB",
//				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
//		this.textField_6.setBackground(Color.WHITE);
//		this.textField_6.setBounds(510, 271, 152, 31);
//		panel_MesLocations.add(this.textField_6);

		// LAYERED MES
		// TRAVAUX////////////////////////////////////////////////////////////////
//		this.layeredPane_MesTravaux = new JLayeredPane();
//		this.contentPane.add(this.layeredPane_MesTravaux, BorderLayout.CENTER);
//		this.layeredPane_MesTravaux.setLayout(new BorderLayout(0, 0));
//
//		JPanel panel_MesTravaux = new JPanel();
//		panel_MesTravaux.setBackground(Color.WHITE);
//		this.layeredPane_MesTravaux.add(panel_MesTravaux);
//		panel_MesTravaux.setLayout(null);
//
//		JLabel lbl_MesTravaux = new JLabel("Mes Travaux");
//		lbl_MesTravaux.setHorizontalAlignment(SwingConstants.CENTER);
//		lbl_MesTravaux.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lbl_MesTravaux.setBounds(244, 22, 216, 43);
//		panel_MesTravaux.add(lbl_MesTravaux);
//
//		JScrollPane scrollPane_MesTravaux = new JScrollPane();
//		scrollPane_MesTravaux.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
//		scrollPane_MesTravaux.setBounds(67, 173, 603, 277);
//		panel_MesTravaux.add(scrollPane_MesTravaux);
//
//		this.table_MesTravaux = new JTable();
//		this.table_MesTravaux.setSelectionBackground(new Color(0, 102, 204));
//		this.table_MesTravaux.setModel(
//				new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, }, new String[] {
//						"D\u00E9signation", "Date \u00E9mission", "Montant", "Pay\u00E9", "Prestataire", "Adresse" }));
//		this.table_MesTravaux.setBounds(40, 53, 668, 130);
//		scrollPane_MesTravaux.setViewportView(this.table_MesTravaux);
//
//		JSeparator separator_MesTravaux = new JSeparator();
//		separator_MesTravaux.setForeground(new Color(0, 102, 204));
//		separator_MesTravaux.setBounds(258, 63, 190, 2);
//		panel_MesTravaux.add(separator_MesTravaux);
//
//		JButton btnNewButton = new JButton("Travaux pour mes immeubles");
//		btnNewButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnNewButton.setBounds(120, 111, 203, 23);
//		panel_MesTravaux.add(btnNewButton);
//
//		JButton btnNewButton_1 = new JButton("Travaux pour mes logements");
//		btnNewButton_1.setBounds(369, 111, 203, 23);
//		panel_MesTravaux.add(btnNewButton_1);

		// LAYERED MES CHARGES LOCATIVES
		// ////////////////////////////////////////////////////////////////
//		this.layeredPane_MesChargesLocatives = new JLayeredPane();
//		this.contentPane.add(this.layeredPane_MesChargesLocatives, BorderLayout.CENTER);
//		this.layeredPane_MesChargesLocatives.setLayout(new BorderLayout(0, 0));
//
//		JPanel panel_chargesLocatives = new JPanel();
//		panel_chargesLocatives.setBackground(Color.WHITE);
//		this.layeredPane_MesChargesLocatives.add(panel_chargesLocatives);
//		panel_chargesLocatives.setLayout(null);
//
//		JScrollPane scrollPane_MesChargesLocatives = new JScrollPane();
//		scrollPane_MesChargesLocatives.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
//		scrollPane_MesChargesLocatives.setBounds(55, 124, 643, 225);
//		panel_chargesLocatives.add(scrollPane_MesChargesLocatives);
//
//		this.table_MesChargesLocatives = new JTable();
//		this.table_MesChargesLocatives.setSelectionBackground(new Color(0, 102, 204));
//		this.table_MesChargesLocatives.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, },
//				new String[] { "Libell\u00E9", "Bien", "D\u00E9ductible", "Montant" }));
//		this.table_MesChargesLocatives.setBounds(40, 53, 668, 130);
//		scrollPane_MesChargesLocatives.setViewportView(this.table_MesChargesLocatives);
//
//		JButton btn_MesChargesLocatives_Charger = new JButton("Charger");
//		btn_MesChargesLocatives_Charger.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btn_MesChargesLocatives_Charger.setBounds(245, 449, 94, 31);
//		panel_chargesLocatives.add(btn_MesChargesLocatives_Charger);
//
//		JButton btn_MesChargesLocatives_Inserer = new JButton("Insérer");
//		btn_MesChargesLocatives_Inserer.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btn_MesChargesLocatives_Inserer.setBounds(93, 449, 94, 31);
//		panel_chargesLocatives.add(btn_MesChargesLocatives_Inserer);
//
//		JButton btn_MesChargesLocatives_Supprimer = new JButton("Supprimer");
//		btn_MesChargesLocatives_Supprimer.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btn_MesChargesLocatives_Supprimer.setBounds(539, 449, 94, 31);
//		panel_chargesLocatives.add(btn_MesChargesLocatives_Supprimer);
//
//		JButton btn_MesChargesLocatives_Modifier = new JButton("Modifier");
//		btn_MesChargesLocatives_Modifier.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btn_MesChargesLocatives_Modifier.setBounds(396, 449, 99, 31);
//		panel_chargesLocatives.add(btn_MesChargesLocatives_Modifier);
//
//		JLabel lbl_MesChargesLocatives = new JLabel("Mes Charges Locatives");
//		lbl_MesChargesLocatives.setHorizontalAlignment(SwingConstants.CENTER);
//		lbl_MesChargesLocatives.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lbl_MesChargesLocatives.setBounds(244, 22, 216, 43);
//		panel_chargesLocatives.add(lbl_MesChargesLocatives);
//
//		JSeparator separator_mesChargesLocatives = new JSeparator();
//		separator_mesChargesLocatives.setForeground(new Color(0, 102, 204));
//		separator_mesChargesLocatives.setBounds(258, 63, 190, 2);
//		panel_chargesLocatives.add(separator_mesChargesLocatives);
//
//		JComboBox comboBox_MesChargesLocatives = new JComboBox();
//		comboBox_MesChargesLocatives.setModel(new DefaultComboBoxModel(new String[] { "ID de l'immeuble" }));
//		comboBox_MesChargesLocatives.setBounds(55, 63, 130, 21);
//		panel_chargesLocatives.add(comboBox_MesChargesLocatives);
=======
		JPanel panel_accueil = new JPanel();
		this.layeredPane_Accueil.add(panel_accueil, BorderLayout.CENTER);
		panel_accueil.setLayout(new BorderLayout(0, 0));

		JLabel lbl_accueil = new JLabel("Accueil");
		lbl_accueil.setHorizontalAlignment(SwingConstants.CENTER);
		panel_accueil.add(lbl_accueil, BorderLayout.CENTER);
		
		
		
		
		///////////////////////////////////////////////////////////////////
		// LAYERED MES BIENS
		// ////////////////////////////////////////////////////////////////
		this.layeredPane_MesBiens = new JLayeredPane();
		this.contentPane.add(this.layeredPane_MesBiens, BorderLayout.CENTER);
		this.layeredPane_MesBiens.setLayout(new BorderLayout(0, 0));

		JPanel panel_biens = new JPanel();
		panel_biens.setBackground(Color.WHITE);
		this.layeredPane_MesBiens.add(panel_biens);
		panel_biens.setLayout(null);

		JLabel lbl_mesBiens = new JLabel("Mes Biens");
		lbl_mesBiens.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_mesBiens.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_mesBiens.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_mesBiens.setBounds(244, 22, 216, 43);
		panel_biens.add(lbl_mesBiens);

		JScrollPane scrollPane_MesBiens = new JScrollPane();
		scrollPane_MesBiens.setToolTipText("40, 53, 668, 130");
		scrollPane_MesBiens.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
		scrollPane_MesBiens.setBackground(Color.LIGHT_GRAY);
		scrollPane_MesBiens.setBounds(40, 98, 475, 126);
		panel_biens.add(scrollPane_MesBiens);

		this.table_MesBiens = new JTable();
		this.table_MesBiens.setSelectionBackground(new Color(0, 102, 204));
		this.table_MesBiens.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Nom du bien", "Adresse", "Nb de logements"
			}
		));
		this.table_MesBiens.setBounds(40, 53, 668, 130);
		scrollPane_MesBiens.setViewportView(this.table_MesBiens);

		JButton btnInserer = new JButton("Insérer");
		btnInserer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnInserer.setBounds(262, 449, 94, 31);
		panel_biens.add(btnInserer);

		JButton btnCharger = new JButton("Charger");
		btnCharger.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCharger.setBounds(111, 449, 94, 31);
		panel_biens.add(btnCharger);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSupprimer.setBounds(551, 449, 94, 31);
		panel_biens.add(btnSupprimer);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModifier.setBounds(406, 449, 99, 31);
		panel_biens.add(btnModifier);

		JScrollPane scrollPane_MesBiens_Logements = new JScrollPane();
		scrollPane_MesBiens_Logements.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
		scrollPane_MesBiens_Logements.setBackground(Color.LIGHT_GRAY);
		scrollPane_MesBiens_Logements.setBounds(40, 283, 475, 134);
		panel_biens.add(scrollPane_MesBiens_Logements);

		this.table_MesBiens_Logements = new JTable();
		this.table_MesBiens_Logements.setModel(
				new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Nom", "Surface", "Nb pi\u00E8ces", "Etage", "Aquisition", "Occup\u00E9"
			}
		));
		this.table_MesBiens_Logements.setBounds(40, 266, 438, 106);
		scrollPane_MesBiens_Logements.setViewportView(this.table_MesBiens_Logements);

		JLabel lblLogements = new JLabel("Mes Logements");
		lblLogements.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLogements.setBounds(40, 259, 94, 13);
		panel_biens.add(lblLogements);

		JSeparator separator_mesBiens = new JSeparator();
		separator_mesBiens.setForeground(new Color(0, 102, 204));
		separator_mesBiens.setBounds(258, 63, 190, 2);
		panel_biens.add(separator_mesBiens);
		
		JButton btnAjouterDiagnosticBien = new JButton("Ajouter un diagnostic");
		btnAjouterDiagnosticBien.setBounds(561, 137, 151, 23);
		panel_biens.add(btnAjouterDiagnosticBien);
		
		JButton btnAjouterDesTravaux = new JButton("Ajouter des travaux");
		btnAjouterDesTravaux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAjouterDesTravaux.setBounds(561, 171, 151, 23);
		panel_biens.add(btnAjouterDesTravaux);
		
		JButton btnAjouterDesTravaux_1 = new JButton("Ajouter des travaux");
		btnAjouterDesTravaux_1.setBounds(561, 360, 151, 23);
		panel_biens.add(btnAjouterDesTravaux_1);
		
		JButton btnAjouterDiagnosticBien_1 = new JButton("Ajouter un diagnostic");
		btnAjouterDiagnosticBien_1.setBounds(561, 326, 151, 23);
		panel_biens.add(btnAjouterDiagnosticBien_1);
		
		
		
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

		JScrollPane scrollPane_MesLocations = new JScrollPane();
		scrollPane_MesLocations.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
		scrollPane_MesLocations.setBounds(30, 95, 418, 309);
		panel_MesLocations.add(scrollPane_MesLocations);

		this.table_MesLocations = new JTable();
		this.table_MesLocations.setSelectionBackground(new Color(0, 102, 204));
		this.table_MesLocations.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
				new String[] { "Locataire", "Bien", "Adresse", "Code Postal", "Ville" }));
		this.table_MesLocations.setBounds(40, 53, 668, 130);
		scrollPane_MesLocations.setViewportView(this.table_MesLocations);

		JButton btn_MesLocations_Charger = new JButton("Charger");
		btn_MesLocations_Charger.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_MesLocations_Charger.setBounds(118, 449, 94, 31);
		panel_MesLocations.add(btn_MesLocations_Charger);

		JButton btn_MesLocations_Inserer = new JButton("Insérer");
		btn_MesLocations_Inserer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_MesLocations_Inserer.setBounds(258, 449, 94, 31);
		panel_MesLocations.add(btn_MesLocations_Inserer);

		JButton btn_MesLocations_Supprimer = new JButton("Supprimer");
		btn_MesLocations_Supprimer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_MesLocations_Supprimer.setBounds(539, 449, 94, 31);
		panel_MesLocations.add(btn_MesLocations_Supprimer);

		JButton btn_MesLocations_Modifier = new JButton("Modifier");
		btn_MesLocations_Modifier.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_MesLocations_Modifier.setBounds(396, 449, 99, 31);
		panel_MesLocations.add(btn_MesLocations_Modifier);

		JLabel lbl_MesLocations = new JLabel("Mes Locations");
		lbl_MesLocations.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MesLocations.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_MesLocations.setBounds(244, 22, 216, 43);
		panel_MesLocations.add(lbl_MesLocations);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 102, 204));
		separator.setBounds(258, 63, 190, 2);
		panel_MesLocations.add(separator);

		this.textField_loyer = new JTextField();
		this.textField_loyer.setBackground(new Color(255, 255, 255));
		this.textField_loyer.setEditable(false);
		this.textField_loyer.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204), 1, true), "Loyer", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
		this.textField_loyer.setBounds(510, 107, 152, 31);
		panel_MesLocations.add(this.textField_loyer);
		this.textField_loyer.setColumns(10);

		this.textField_provisionCharges = new JTextField();
		this.textField_provisionCharges.setEditable(false);
		this.textField_provisionCharges.setColumns(10);
		this.textField_provisionCharges.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204), 1, true),
				"Provision sur charges", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
		this.textField_provisionCharges.setBackground(Color.WHITE);
		this.textField_provisionCharges.setBounds(510, 353, 152, 31);
		panel_MesLocations.add(this.textField_provisionCharges);

		this.textField_caution = new JTextField();
		this.textField_caution.setEditable(false);
		this.textField_caution.setColumns(10);
		this.textField_caution.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204), 1, true), "Caution",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
		this.textField_caution.setBackground(Color.WHITE);
		this.textField_caution.setBounds(510, 312, 152, 31);
		panel_MesLocations.add(this.textField_caution);

		this.textField_dateEmission = new JTextField();
		this.textField_dateEmission.setEditable(false);
		this.textField_dateEmission.setColumns(10);
		this.textField_dateEmission.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204), 1, true), "Date \u00E9mission", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
		this.textField_dateEmission.setBackground(Color.WHITE);
		this.textField_dateEmission.setBounds(510, 148, 152, 31);
		panel_MesLocations.add(this.textField_dateEmission);

		this.textField_dateEcheance = new JTextField();
		this.textField_dateEcheance.setEditable(false);
		this.textField_dateEcheance.setColumns(10);
		this.textField_dateEcheance.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204), 1, true), "Date \u00E9ch\u00E9ance", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
		this.textField_dateEcheance.setBackground(Color.WHITE);
		this.textField_dateEcheance.setBounds(510, 189, 152, 31);
		panel_MesLocations.add(this.textField_dateEcheance);

		this.textField_paye = new JTextField();
		this.textField_paye.setEditable(false);
		this.textField_paye.setColumns(10);
		this.textField_paye.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204), 1, true), "Pay\u00E9",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
		this.textField_paye.setBackground(Color.WHITE);
		this.textField_paye.setBounds(510, 230, 152, 31);
		panel_MesLocations.add(this.textField_paye);

		this.textField_restantDu = new JTextField();
		this.textField_restantDu.setEditable(false);
		this.textField_restantDu.setColumns(10);
		this.textField_restantDu.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204), 1, true), "Restant d\u00FB",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
		this.textField_restantDu.setBackground(Color.WHITE);
		this.textField_restantDu.setBounds(510, 271, 152, 31);
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

		JLabel lbl_MesTravaux = new JLabel("Mes Travaux");
		lbl_MesTravaux.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MesTravaux.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_MesTravaux.setBounds(244, 22, 216, 43);
		panel_MesTravaux.add(lbl_MesTravaux);

		JScrollPane scrollPane_MesTravaux = new JScrollPane();
		scrollPane_MesTravaux.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
		scrollPane_MesTravaux.setBounds(67, 173, 603, 277);
		panel_MesTravaux.add(scrollPane_MesTravaux);

		this.table_MesTravaux = new JTable();
		this.table_MesTravaux.setSelectionBackground(new Color(0, 102, 204));
		this.table_MesTravaux.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"D\u00E9signation", "Date \u00E9mission", "Montant", "Pay\u00E9", "Prestataire", "Adresse"
			}
		));
		this.table_MesTravaux.setBounds(40, 53, 668, 130);
		scrollPane_MesTravaux.setViewportView(this.table_MesTravaux);

		JSeparator separator_MesTravaux = new JSeparator();
		separator_MesTravaux.setForeground(new Color(0, 102, 204));
		separator_MesTravaux.setBounds(258, 63, 190, 2);
		panel_MesTravaux.add(separator_MesTravaux);
		
		JButton btn_Travaux_immeubles = new JButton("Travaux pour mes immeubles");
		btn_Travaux_immeubles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Travaux_immeubles.setBounds(120, 111, 203, 23);
		panel_MesTravaux.add(btn_Travaux_immeubles);
		
		JButton btn_Travaux_logements = new JButton("Travaux pour mes logements");
		btn_Travaux_logements.setBounds(369, 111, 203, 23);
		panel_MesTravaux.add(btn_Travaux_logements);

		
		
		
		///////////////////////////////////////////////////////////////////
		// LAYERED MES CHARGES LOCATIVES
		// ////////////////////////////////////////////////////////////////
		this.layeredPane_MesChargesLocatives = new JLayeredPane();
		this.contentPane.add(this.layeredPane_MesChargesLocatives, BorderLayout.CENTER);
		this.layeredPane_MesChargesLocatives.setLayout(new BorderLayout(0, 0));
>>>>>>> 1a5ce9528c16a3f97fec90ef26dbd2ab357e8231

		JPanel panel_chargesLocatives = new JPanel();
		panel_chargesLocatives.setBackground(Color.WHITE);
		this.layeredPane_MesChargesLocatives.add(panel_chargesLocatives);
		panel_chargesLocatives.setLayout(null);

		JScrollPane scrollPane_MesChargesLocatives = new JScrollPane();
		scrollPane_MesChargesLocatives.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
		scrollPane_MesChargesLocatives.setBounds(55, 124, 643, 225);
		panel_chargesLocatives.add(scrollPane_MesChargesLocatives);

		this.table_MesChargesLocatives = new JTable();
		this.table_MesChargesLocatives.setSelectionBackground(new Color(0, 102, 204));
		this.table_MesChargesLocatives.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Libell\u00E9", "Bien", "D\u00E9ductible", "Montant"
			}
		));
		this.table_MesChargesLocatives.setBounds(40, 53, 668, 130);
		scrollPane_MesChargesLocatives.setViewportView(this.table_MesChargesLocatives);

		JButton btn_MesChargesLocatives_Charger = new JButton("Charger");
		btn_MesChargesLocatives_Charger.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_MesChargesLocatives_Charger.setBounds(245, 449, 94, 31);
		panel_chargesLocatives.add(btn_MesChargesLocatives_Charger);

		JButton btn_MesChargesLocatives_Inserer = new JButton("Insérer");
		btn_MesChargesLocatives_Inserer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_MesChargesLocatives_Inserer.setBounds(93, 449, 94, 31);
		panel_chargesLocatives.add(btn_MesChargesLocatives_Inserer);

		JButton btn_MesChargesLocatives_Supprimer = new JButton("Supprimer");
		btn_MesChargesLocatives_Supprimer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_MesChargesLocatives_Supprimer.setBounds(539, 449, 94, 31);
		panel_chargesLocatives.add(btn_MesChargesLocatives_Supprimer);

		JButton btn_MesChargesLocatives_Modifier = new JButton("Modifier");
		btn_MesChargesLocatives_Modifier.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_MesChargesLocatives_Modifier.setBounds(396, 449, 99, 31);
		panel_chargesLocatives.add(btn_MesChargesLocatives_Modifier);

		JLabel lbl_MesChargesLocatives = new JLabel("Mes Charges Locatives");
		lbl_MesChargesLocatives.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MesChargesLocatives.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_MesChargesLocatives.setBounds(244, 22, 216, 43);
		panel_chargesLocatives.add(lbl_MesChargesLocatives);

		JSeparator separator_mesChargesLocatives = new JSeparator();
		separator_mesChargesLocatives.setForeground(new Color(0, 102, 204));
		separator_mesChargesLocatives.setBounds(258, 63, 190, 2);
		panel_chargesLocatives.add(separator_mesChargesLocatives);
		
		JComboBox comboBox_MesChargesLocatives  = new JComboBox();
		comboBox_MesChargesLocatives.setModel(new DefaultComboBoxModel(new String[] { "ID de l'immeuble" }));
		comboBox_MesChargesLocatives.setBounds(55, 63, 130, 21);
		panel_chargesLocatives.add(comboBox_MesChargesLocatives);
		
		
		
		
		///////////////////////////////////////////////////////////////////
		// LAYERED MES ASSURANCES
		// ////////////////////////////////////////////////////////////////
//		this.layeredPane_MesAssurances = new JLayeredPane();
//		this.contentPane.add(this.layeredPane_MesAssurances, BorderLayout.CENTER);
//		this.layeredPane_MesAssurances.setLayout(new BorderLayout(0, 0));
//
//		JPanel panel_MesAssurances = new JPanel();
//		panel_MesAssurances.setBackground(Color.WHITE);
//		this.layeredPane_MesAssurances.add(panel_MesAssurances);
//		panel_MesAssurances.setLayout(null);
//
//		JLabel lbl_MesAssurances = new JLabel("Mes Assurances");
//		lbl_MesAssurances.setHorizontalAlignment(SwingConstants.CENTER);
//		lbl_MesAssurances.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lbl_MesAssurances.setBounds(244, 22, 216, 43);
//		panel_MesAssurances.add(lbl_MesAssurances);
//
//		JSeparator separator_mesAssurances = new JSeparator();
//		separator_mesAssurances.setForeground(new Color(0, 102, 204));
//		separator_mesAssurances.setBounds(258, 63, 190, 2);
//		panel_MesAssurances.add(separator_mesAssurances);
//
//		JScrollPane scrollPane_MesAssurances = new JScrollPane();
//		scrollPane_MesAssurances.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
//		scrollPane_MesAssurances.setBounds(55, 96, 643, 225);
//		panel_MesAssurances.add(scrollPane_MesAssurances);
//
//		this.table_MesAssurances = new JTable();
//		this.table_MesAssurances.setSelectionBackground(new Color(0, 102, 204));
//		this.table_MesAssurances.setModel(new DefaultTableModel(
//				new Object[][] { { null, null, null, null, null, null }, },
//				new String[] { "New column", "New column", "New column", "New column", "New column", "New column" }));
//		this.table_MesAssurances.setBounds(40, 53, 668, 130);
//		scrollPane_MesAssurances.setViewportView(this.table_MesAssurances);
//
//		JButton btn_MesAssurances_Inserer = new JButton("Insérer");
//		btn_MesAssurances_Inserer.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btn_MesAssurances_Inserer.setBounds(244, 449, 94, 31);
//		panel_MesAssurances.add(btn_MesAssurances_Inserer);
//
//		JButton btn_MesAssurances_Annuler = new JButton("Annuler");
//		btn_MesAssurances_Annuler.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btn_MesAssurances_Annuler.setBounds(396, 449, 94, 31);
//		panel_MesAssurances.add(btn_MesAssurances_Annuler);
//
//		JComboBox comboBox_MesAssurances = new JComboBox();
//		comboBox_MesAssurances.setModel(new DefaultComboBoxModel(new String[] { "ID de l'immeuble" }));
//		comboBox_MesAssurances.setBounds(55, 63, 130, 21);
//		panel_MesAssurances.add(comboBox_MesAssurances);

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

		JLabel lbl_RegularisationDesCharges = new JLabel("Régularisation des Charges");
		lbl_RegularisationDesCharges.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_RegularisationDesCharges.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_RegularisationDesCharges.setBounds(244, 22, 216, 43);
		panel_RegularisationDesCharges.add(lbl_RegularisationDesCharges);

		JSeparator separator_RegularisationDesChargess = new JSeparator();
		separator_RegularisationDesChargess.setForeground(new Color(0, 102, 204));
		separator_RegularisationDesChargess.setBounds(258, 63, 190, 2);
		panel_RegularisationDesCharges.add(separator_RegularisationDesChargess);

<<<<<<< HEAD
		// LAYERED SOLDE DE TOUT
		// COMPTE////////////////////////////////////////////////////////////////

		this.layeredPane_SoldeDeToutCompte = new JLayeredPane();
		this.contentPane.add(this.layeredPane_SoldeDeToutCompte, BorderLayout.CENTER);
		this.layeredPane_SoldeDeToutCompte.setLayout(new BorderLayout(0, 0));

		JPanel panel_SoldeDeToutCompte = new JPanel();
		panel_SoldeDeToutCompte.setBackground(Color.WHITE);
		this.layeredPane_SoldeDeToutCompte.add(panel_SoldeDeToutCompte);
		panel_SoldeDeToutCompte.setLayout(null);

		JLabel lbl_SoldeDeToutCompte = new JLabel("Mon Solde de Tout Compte");
		lbl_SoldeDeToutCompte.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SoldeDeToutCompte.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_SoldeDeToutCompte.setBounds(244, 22, 216, 43);
		panel_SoldeDeToutCompte.add(lbl_SoldeDeToutCompte);

		JSeparator separator_SoldeDeToutCompte = new JSeparator();
		separator_SoldeDeToutCompte.setForeground(new Color(0, 102, 204));
		separator_SoldeDeToutCompte.setBounds(258, 63, 190, 2);
		panel_SoldeDeToutCompte.add(separator_SoldeDeToutCompte);

		JScrollPane scrollPane_SoldeDeToutCompte = new JScrollPane();
		scrollPane_SoldeDeToutCompte.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
		scrollPane_SoldeDeToutCompte.setBounds(55, 131, 643, 225);
		panel_SoldeDeToutCompte.add(scrollPane_SoldeDeToutCompte);

		this.table_SoldeDeToutCompte = new JTable();
		this.table_SoldeDeToutCompte.setSelectionBackground(new Color(0, 102, 204));
		this.table_SoldeDeToutCompte
				.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
						new String[] { "New column", "New column", "New column", "New column" }));
		this.table_SoldeDeToutCompte.setBounds(40, 53, 668, 130);
		scrollPane_SoldeDeToutCompte.setViewportView(this.table_SoldeDeToutCompte);

		JButton btn_SoldeDeToutCompte_Inserer = new JButton("Générer le reçu");
		btn_SoldeDeToutCompte_Inserer.setForeground(new Color(0, 0, 0));
		btn_SoldeDeToutCompte_Inserer.setBackground(new Color(255, 255, 255));
		btn_SoldeDeToutCompte_Inserer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_SoldeDeToutCompte_Inserer.setBounds(201, 449, 137, 31);
		panel_SoldeDeToutCompte.add(btn_SoldeDeToutCompte_Inserer);

		JButton btn_SoldeDeToutCompte_Annuler = new JButton("Annuler");
		btn_SoldeDeToutCompte_Annuler.setForeground(new Color(255, 255, 255));
		btn_SoldeDeToutCompte_Annuler.setBackground(new Color(0, 102, 204));
		btn_SoldeDeToutCompte_Annuler.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_SoldeDeToutCompte_Annuler.setBounds(396, 449, 94, 31);
		panel_SoldeDeToutCompte.add(btn_SoldeDeToutCompte_Annuler);

		JComboBox comboBox_SoldeDeToutCompte = new JComboBox();
		comboBox_SoldeDeToutCompte.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
		comboBox_SoldeDeToutCompte.setModel(new DefaultComboBoxModel(new String[] { "Locataire" }));
		comboBox_SoldeDeToutCompte.setBounds(55, 92, 118, 21);
		panel_SoldeDeToutCompte.add(comboBox_SoldeDeToutCompte);

		JLabel lbl_SoldeDeToutCompte_Locataires = new JLabel("Locataires");
		lbl_SoldeDeToutCompte_Locataires.setBounds(56, 69, 82, 13);
		panel_SoldeDeToutCompte.add(lbl_SoldeDeToutCompte_Locataires);
=======
		

		/////////////////////////////////////////////////////////////////////////
		// LAYERED SOLDE DE TOUT
		// COMPTE////////////////////////////////////////////////////////////////
		this.layeredPane_SoldeDeToutCompte = new JLayeredPane();
		this.contentPane.add(this.layeredPane_SoldeDeToutCompte, BorderLayout.CENTER);
		this.layeredPane_SoldeDeToutCompte.setLayout(new BorderLayout(0, 0));
>>>>>>> 1a5ce9528c16a3f97fec90ef26dbd2ab357e8231

		JPanel panel_SoldeDeToutCompte = new JPanel();
		panel_SoldeDeToutCompte.setBackground(Color.WHITE);
		this.layeredPane_SoldeDeToutCompte.add(panel_SoldeDeToutCompte);
		panel_SoldeDeToutCompte.setLayout(null);

		JLabel lbl_SoldeDeToutCompte = new JLabel("Mon Solde de Tout Compte");
		lbl_SoldeDeToutCompte.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SoldeDeToutCompte.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_SoldeDeToutCompte.setBounds(244, 22, 216, 43);
		panel_SoldeDeToutCompte.add(lbl_SoldeDeToutCompte);

		JSeparator separator_SoldeDeToutCompte = new JSeparator();
		separator_SoldeDeToutCompte.setForeground(new Color(0, 102, 204));
		separator_SoldeDeToutCompte.setBounds(258, 63, 190, 2);
		panel_SoldeDeToutCompte.add(separator_SoldeDeToutCompte);

		JScrollPane scrollPane_SoldeDeToutCompte = new JScrollPane();
		scrollPane_SoldeDeToutCompte.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
		scrollPane_SoldeDeToutCompte.setBounds(55, 131, 643, 225);
		panel_SoldeDeToutCompte.add(scrollPane_SoldeDeToutCompte);

		this.table_SoldeDeToutCompte = new JTable();
		this.table_SoldeDeToutCompte.setSelectionBackground(new Color(0, 102, 204));
		this.table_SoldeDeToutCompte
				.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
						new String[] { "New column", "New column", "New column", "New column" }));
		this.table_SoldeDeToutCompte.setBounds(40, 53, 668, 130);
		scrollPane_SoldeDeToutCompte.setViewportView(this.table_SoldeDeToutCompte);

		JButton btn_SoldeDeToutCompte_Inserer = new JButton("Générer le reçu");
		btn_SoldeDeToutCompte_Inserer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_SoldeDeToutCompte_Inserer.setBounds(201, 449, 137, 31);
		panel_SoldeDeToutCompte.add(btn_SoldeDeToutCompte_Inserer);

		JButton btn_SoldeDeToutCompte_Annuler = new JButton("Annuler");
		btn_SoldeDeToutCompte_Annuler.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_SoldeDeToutCompte_Annuler.setBounds(396, 449, 94, 31);
		panel_SoldeDeToutCompte.add(btn_SoldeDeToutCompte_Annuler);

		JComboBox comboBox_SoldeDeToutCompte = new JComboBox();
		comboBox_SoldeDeToutCompte.setModel(new DefaultComboBoxModel(new String[] { "Locataire" }));
		comboBox_SoldeDeToutCompte.setBounds(55, 92, 118, 21);
		panel_SoldeDeToutCompte.add(comboBox_SoldeDeToutCompte);

		JLabel lbl_SoldeDeToutCompte_Locataires = new JLabel("Locataires");
		lbl_SoldeDeToutCompte_Locataires.setBounds(56, 69, 82, 13);
		panel_SoldeDeToutCompte.add(lbl_SoldeDeToutCompte_Locataires);
		
		
		
		
		////////////////////////////////////////////////////////////////////////////
		// LAYERED
		// DOCUMENTS////////////////////////////////////////////////////////////////
<<<<<<< HEAD

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
=======
		this.layeredPane_MesDocuments = new JLayeredPane();
		this.contentPane.add(this.layeredPane_MesDocuments, BorderLayout.CENTER);
		this.layeredPane_MesDocuments.setLayout(new BorderLayout(0, 0));

		JPanel panel_MesDocuments = new JPanel();
		panel_MesDocuments.setBackground(Color.WHITE);
		this.layeredPane_MesDocuments.add(panel_MesDocuments);
		panel_MesDocuments.setLayout(null);

		JLabel lbl_MesDocuments = new JLabel("Mes Documents");
		lbl_MesDocuments.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MesDocuments.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_MesDocuments.setBounds(244, 22, 216, 43);
		panel_MesDocuments.add(lbl_MesDocuments);

		JSeparator separator_MesDocuments = new JSeparator();
		separator_MesDocuments.setForeground(new Color(0, 102, 204));
		separator_MesDocuments.setBounds(258, 63, 190, 2);
		panel_MesDocuments.add(separator_MesDocuments);

		JLabel aFAIRE2 = new JLabel("A FAIRE");
		aFAIRE2.setFont(new Font("Tahoma", Font.PLAIN, 44));
		aFAIRE2.setBounds(258, 189, 312, 139);
		panel_MesDocuments.add(aFAIRE2);
>>>>>>> 1a5ce9528c16a3f97fec90ef26dbd2ab357e8231

		// this.mettrePageParDef();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		switch (btn.getName()) { // a partir du nom des boutons
		case "btnAccueil":
			this.rendreVisible(this.layeredPane_Accueil);
			break;
		case "btnMesBiens":
			this.rendreVisible(this.layeredPane_MesBiens);
			break;
		case "btnMesLocations":
			this.rendreVisible(this.layeredPane_MesLocations);
			break;
		case "btnMesTravaux":
			this.rendreVisible(this.layeredPane_MesTravaux);
			break;
		case "btnMesChargesLocatives":
			this.rendreVisible(this.layeredPane_MesChargesLocatives);
			break;
		case "btnMesAssurances":
			this.rendreVisible(this.layeredPane_MesAssurances);
			break;
		case "btnRegularisationDesCharges":
			this.rendreVisible(this.layeredPane_RegularisationDesCharges);
			break;
		case "btnSoldeDeToutCompte":
			this.rendreVisible(this.layeredPane_SoldeDeToutCompte);
			break;
		case "btnMesDocuments":
			this.rendreVisible(this.layeredPane_MesDocuments);
			break;
		// Inserer un bien
		case "btnInserer":
			Fenetre_InsertionBien insertion_bien = new Fenetre_InsertionBien();
			this.getLayeredPane().add(insertion_bien);
			insertion_bien.setVisible(true);
			insertion_bien.moveToFront();
			break;
		case "btn_MesAssurances_Inserer":
			Fenetre_InsertionAssurance insertion_assurance = new Fenetre_InsertionAssurance();
			this.getLayeredPane().add(insertion_assurance);
			insertion_assurance.setVisible(true);
			insertion_assurance.moveToFront();
			break;

		}
	}

	public void rendreVisible(JLayeredPane visible) {
<<<<<<< HEAD
//		this.layeredPane_Accueil.setVisible(false);
//		this.layeredPane_MesBiens.setVisible(false);
//		this.layeredPane_MesTravaux.setVisible(false);
//		this.layeredPane_MesChargesLocatives.setVisible(false);
//		this.layeredPane_MesLocations.setVisible(false);
//		this.layeredPane_MesAssurances.setVisible(false);
//		this.layeredPane_RegularisationDesCharges.setVisible(false);
		this.layeredPane_SoldeDeToutCompte.setVisible(false);
//		this.layeredPane_MesDocuments.setVisible(false);
=======
		this.layeredPane_Accueil.setVisible(false);
		this.layeredPane_MesBiens.setVisible(false);
		this.layeredPane_MesTravaux.setVisible(false);
		this.layeredPane_MesChargesLocatives.setVisible(false);
		this.layeredPane_MesLocations.setVisible(false);
		this.layeredPane_MesAssurances.setVisible(false);
		this.layeredPane_RegularisationDesCharges.setVisible(false);
		this.layeredPane_SoldeDeToutCompte.setVisible(false);
		this.layeredPane_MesDocuments.setVisible(false);
>>>>>>> 1a5ce9528c16a3f97fec90ef26dbd2ab357e8231

		visible.setVisible(true);
		this.contentPane.add(visible, BorderLayout.CENTER);
	}
}
