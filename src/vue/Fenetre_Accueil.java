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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

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
	private JTable table_MesBiens_Assurances;
	private JTable table_MesLocations;
	private JTable table_MesTravaux;
	private JTable table_MesChargesLocatives;
	private JTable table_MesAssurances;
	private JTable table_SoldeDeToutCompte;

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
		scrollPane_MesLocations.setBounds(55, 96, 643, 225);
		panel_MesLocations.add(scrollPane_MesLocations);

		this.table_MesLocations = new JTable();
		this.table_MesLocations.setSelectionBackground(new Color(0, 102, 204));
		this.table_MesLocations.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column", "New column", "New column" }));
		this.table_MesLocations.setBounds(40, 53, 668, 130);
		scrollPane_MesLocations.setViewportView(this.table_MesLocations);

		JButton btn_MesLocations_Charger = new JButton("Charger");
		btn_MesLocations_Charger.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_MesLocations_Charger.setBounds(245, 449, 94, 31);
		panel_MesLocations.add(btn_MesLocations_Charger);

		JButton btn_MesLocations_Inserer = new JButton("Insérer");
		btn_MesLocations_Inserer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_MesLocations_Inserer.setBounds(93, 449, 94, 31);
		panel_MesLocations.add(btn_MesLocations_Inserer);

		JButton btn_MesLocations_Supprimer = new JButton("Supprimer");
		btn_MesLocations_Supprimer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_MesLocations_Supprimer.setBounds(396, 449, 94, 31);
		panel_MesLocations.add(btn_MesLocations_Supprimer);

		JButton btn_MesLocations_Modifier = new JButton("Modifier");
		btn_MesLocations_Modifier.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_MesLocations_Modifier.setBounds(551, 449, 99, 31);
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

		// LAYERED ACCUEIL
		// ////////////////////////////////////////////////////////////////

		this.layeredPane_Accueil = new JLayeredPane();
		this.layeredPane_Accueil.setBackground(new Color(255, 255, 255));
		this.contentPane.add(this.layeredPane_Accueil, BorderLayout.CENTER);
		this.layeredPane_Accueil.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		this.layeredPane_Accueil.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("Accueil");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1, BorderLayout.CENTER);

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
		scrollPane_MesBiens.setBounds(40, 81, 668, 130);
		panel_biens.add(scrollPane_MesBiens);

		this.table_MesBiens = new JTable();
		this.table_MesBiens.setSelectionBackground(new Color(0, 102, 204));
		this.table_MesBiens.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "ID", "Adresse", "Code Postal", "Ville", "Description", "Nb de logements" }));
		this.table_MesBiens.setBounds(40, 53, 668, 130);
		scrollPane_MesBiens.setViewportView(this.table_MesBiens);

		JButton btnInserer = new JButton("Insérer");
		btnInserer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnInserer.setBounds(93, 449, 94, 31);
		panel_biens.add(btnInserer);

		JButton btnCharger = new JButton("Charger");
		btnCharger.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCharger.setBounds(245, 449, 94, 31);
		panel_biens.add(btnCharger);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSupprimer.setBounds(396, 449, 94, 31);
		panel_biens.add(btnSupprimer);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModifier.setBounds(551, 449, 99, 31);
		panel_biens.add(btnModifier);

		JScrollPane scrollPane_MesBiens_Logements = new JScrollPane();
		scrollPane_MesBiens_Logements.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
		scrollPane_MesBiens_Logements.setBackground(Color.LIGHT_GRAY);
		scrollPane_MesBiens_Logements.setBounds(40, 266, 420, 106);
		panel_biens.add(scrollPane_MesBiens_Logements);

		this.table_MesBiens_Logements = new JTable();
		this.table_MesBiens_Logements
				.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
						new String[] { "ID", "Surface", "Nombre de Pi\u00E8ces", "Etage", "Date d'aquisition" }));
		this.table_MesBiens_Logements.setBounds(40, 266, 438, 106);
		scrollPane_MesBiens_Logements.setViewportView(this.table_MesBiens_Logements);

		JScrollPane scrollPane_MesBiens_Assurance = new JScrollPane();
		scrollPane_MesBiens_Assurance.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
		scrollPane_MesBiens_Assurance.setBackground(Color.LIGHT_GRAY);
		scrollPane_MesBiens_Assurance.setBounds(533, 266, 165, 106);
		panel_biens.add(scrollPane_MesBiens_Assurance);

		this.table_MesBiens_Assurances = new JTable();
		this.table_MesBiens_Assurances.setModel(new DefaultTableModel(new Object[][] { { null, null }, },
				new String[] { "N\u00B0 Police", "Montant" }));
		this.table_MesBiens_Assurances.setBounds(533, 266, 175, 106);
		scrollPane_MesBiens_Assurance.setViewportView(this.table_MesBiens_Assurances);

		JLabel lblNewLabel = new JLabel("Assurance");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(533, 239, 94, 13);
		panel_biens.add(lblNewLabel);

		JLabel lblLogements = new JLabel("Logements");
		lblLogements.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLogements.setBounds(40, 240, 94, 13);
		panel_biens.add(lblLogements);

		JSeparator separator_mesBiens = new JSeparator();
		separator_mesBiens.setForeground(new Color(0, 102, 204));
		separator_mesBiens.setBounds(258, 63, 190, 2);
		panel_biens.add(separator_mesBiens);

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
		scrollPane_MesTravaux.setBounds(55, 96, 643, 225);
		panel_MesTravaux.add(scrollPane_MesTravaux);

		this.table_MesTravaux = new JTable();
		this.table_MesTravaux.setSelectionBackground(new Color(0, 102, 204));
		this.table_MesTravaux.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column", "New column", "New column" }));
		this.table_MesTravaux.setBounds(40, 53, 668, 130);
		scrollPane_MesTravaux.setViewportView(this.table_MesTravaux);

		JButton btn_MesTravaux_Charger = new JButton("Charger");
		btn_MesTravaux_Charger.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_MesTravaux_Charger.setBounds(245, 449, 94, 31);
		panel_MesTravaux.add(btn_MesTravaux_Charger);

		JButton btn_MesTravaux_Inserer = new JButton("Insérer");
		btn_MesTravaux_Inserer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_MesTravaux_Inserer.setBounds(93, 449, 94, 31);
		panel_MesTravaux.add(btn_MesTravaux_Inserer);

		JButton btn_MesTravaux_Supprimer = new JButton("Supprimer");
		btn_MesTravaux_Supprimer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_MesTravaux_Supprimer.setBounds(396, 449, 94, 31);
		panel_MesTravaux.add(btn_MesTravaux_Supprimer);

		JButton btn_MesTravaux_Modifier = new JButton("Modifier");
		btn_MesTravaux_Modifier.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_MesTravaux_Modifier.setBounds(551, 449, 99, 31);
		panel_MesTravaux.add(btn_MesTravaux_Modifier);

		JSeparator separator_MesTravaux = new JSeparator();
		separator_MesTravaux.setForeground(new Color(0, 102, 204));
		separator_MesTravaux.setBounds(258, 63, 190, 2);
		panel_MesTravaux.add(separator_MesTravaux);

		// LAYERED MES CHARGES LOCATIVES
		// ////////////////////////////////////////////////////////////////

		this.layeredPane_MesChargesLocatives = new JLayeredPane();
		this.contentPane.add(this.layeredPane_MesChargesLocatives, BorderLayout.CENTER);
		this.layeredPane_MesChargesLocatives.setLayout(new BorderLayout(0, 0));

		JPanel panel_chargesLocatives = new JPanel();
		panel_chargesLocatives.setBackground(Color.WHITE);
		this.layeredPane_MesChargesLocatives.add(panel_chargesLocatives);
		panel_chargesLocatives.setLayout(null);

		JScrollPane scrollPane_MesChargesLocatives = new JScrollPane();
		scrollPane_MesChargesLocatives.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
		scrollPane_MesChargesLocatives.setBounds(55, 96, 643, 225);
		panel_chargesLocatives.add(scrollPane_MesChargesLocatives);

		this.table_MesChargesLocatives = new JTable();
		this.table_MesChargesLocatives.setSelectionBackground(new Color(0, 102, 204));
		this.table_MesChargesLocatives.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column", "New column", "New column" }));
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
		btn_MesChargesLocatives_Supprimer.setBounds(396, 449, 94, 31);
		panel_chargesLocatives.add(btn_MesChargesLocatives_Supprimer);

		JButton btn_MesChargesLocatives_Modifier = new JButton("Modifier");
		btn_MesChargesLocatives_Modifier.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_MesChargesLocatives_Modifier.setBounds(551, 449, 99, 31);
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

		// LAYERED MES ASSURANCES
		// ////////////////////////////////////////////////////////////////

		this.layeredPane_MesAssurances = new JLayeredPane();
		this.contentPane.add(this.layeredPane_MesAssurances, BorderLayout.CENTER);
		this.layeredPane_MesAssurances.setLayout(new BorderLayout(0, 0));

		JPanel panel_MesAssurances = new JPanel();
		panel_MesAssurances.setBackground(Color.WHITE);
		this.layeredPane_MesAssurances.add(panel_MesAssurances);
		panel_MesAssurances.setLayout(null);

		JLabel lbl_MesAssurances = new JLabel("Mes Assurances");
		lbl_MesAssurances.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MesAssurances.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_MesAssurances.setBounds(244, 22, 216, 43);
		panel_MesAssurances.add(lbl_MesAssurances);

		JSeparator separator_mesAssurances = new JSeparator();
		separator_mesAssurances.setForeground(new Color(0, 102, 204));
		separator_mesAssurances.setBounds(258, 63, 190, 2);
		panel_MesAssurances.add(separator_mesAssurances);

		JScrollPane scrollPane_MesAssurances = new JScrollPane();
		scrollPane_MesAssurances.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
		scrollPane_MesAssurances.setBounds(55, 96, 643, 225);
		panel_MesAssurances.add(scrollPane_MesAssurances);

		this.table_MesAssurances = new JTable();
		this.table_MesAssurances.setSelectionBackground(new Color(0, 102, 204));
		this.table_MesAssurances.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column", "New column", "New column" }));
		this.table_MesAssurances.setBounds(40, 53, 668, 130);
		scrollPane_MesAssurances.setViewportView(this.table_MesAssurances);

		JButton btn_MesAssurances_Inserer = new JButton("Insérer");
		btn_MesAssurances_Inserer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_MesAssurances_Inserer.setBounds(244, 449, 94, 31);
		panel_MesAssurances.add(btn_MesAssurances_Inserer);

		JButton btn_MesAssurances_Annuler = new JButton("Annuler");
		btn_MesAssurances_Annuler.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_MesAssurances_Annuler.setBounds(396, 449, 94, 31);
		panel_MesAssurances.add(btn_MesAssurances_Annuler);

		JComboBox comboBox_MesAssurances = new JComboBox();
		comboBox_MesAssurances.setModel(new DefaultComboBoxModel(new String[] { "ID de l'immeuble" }));
		comboBox_MesAssurances.setBounds(55, 63, 130, 21);
		panel_MesAssurances.add(comboBox_MesAssurances);

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

		JLabel aFAIRE = new JLabel("A FAIRE");
		aFAIRE.setFont(new Font("Tahoma", Font.PLAIN, 44));
		aFAIRE.setBounds(258, 189, 312, 139);
		panel_RegularisationDesCharges.add(aFAIRE);

		////// Bande accueil//////////////////////////////////////////////////

		JPanel bandeAccueil = new JPanel();
		bandeAccueil.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
		bandeAccueil.setBackground(Color.LIGHT_GRAY);
		this.contentPane.add(bandeAccueil, BorderLayout.NORTH);
		bandeAccueil.setLayout(new GridLayout(0, 8, 0, 0));

		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon(Fenetre_Accueil.class.getResource("/icon/logo_appli.png"))); //pour éviter l'erreur location is null faire de façon graphique
		logo.setIcon(new ImageIcon(Fenetre_Accueil.class.getResource("/icon/logo_appli.png")));
		bandeAccueil.add(logo);

		JPanel panelDuBtnAccueil = new JPanel();
		panelDuBtnAccueil.setBackground(new Color(192, 192, 192));
		bandeAccueil.add(panelDuBtnAccueil);
		panelDuBtnAccueil.setLayout(null);

		JButton btnAccueil = new JButton("");
		btnAccueil.setBorder(null);
		btnAccueil.addActionListener(this);
		btnAccueil.setBackground(new Color(192, 192, 192));
		btnAccueil.setIcon(new ImageIcon(Fenetre_Accueil.class.getResource("/icon/home_att-removebg-preview.png"))); //pour éviter l'erreur location is null
		btnAccueil.setIcon(new ImageIcon(Fenetre_Accueil.class.getResource("/icon/home_att-removebg-preview.png")));
		btnAccueil.setBounds(0, 53, 42, 31);
		btnAccueil.setName("btnAccueil");
		panelDuBtnAccueil.add(btnAccueil);

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

		// LAYERED
		// DOCUMENTS////////////////////////////////////////////////////////////////

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
		case "Ajouter une location":
			AjouterLogement logement = new AjouterLogement();
			this.getLayeredPane().add(logement);
			logement.setVisible(true);
			logement.moveToFront();
			break;

		}
	}

	public void rendreVisible(JLayeredPane visible) {
		this.layeredPane_Accueil.setVisible(false);
		this.layeredPane_MesBiens.setVisible(false);
		this.layeredPane_MesTravaux.setVisible(false);
		this.layeredPane_MesChargesLocatives.setVisible(false);
		this.layeredPane_MesLocations.setVisible(false);
		this.layeredPane_MesAssurances.setVisible(false);
		this.layeredPane_RegularisationDesCharges.setVisible(false);
		this.layeredPane_SoldeDeToutCompte.setVisible(false);
		this.layeredPane_MesDocuments.setVisible(false);

		visible.setVisible(true);
		this.contentPane.add(visible, BorderLayout.CENTER);
	}
}
