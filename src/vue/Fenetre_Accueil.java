package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
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
	private JTable table;
	private JLayeredPane layeredPane_SoldeDeToutCompte;
	private JLayeredPane layeredPane_MesDocuments;
	private JTable table_MesBiens;

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

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		this.contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(8, 1, 0, 0));

		// MENU DE BOUTONS SUR LE CÔTE
		// ////////////////////////////////////////////////////////////////

		JButton btnMesBiens = new JButton("Mes Biens");
		btnMesBiens.addActionListener(this);
		btnMesBiens.setBackground(new Color(0, 102, 204));
		btnMesBiens.setForeground(new Color(255, 255, 255));
		btnMesBiens.setFont(new Font("Dialog", Font.BOLD, 12));
		btnMesBiens.setName("btnMesBiens");
		panel_3.add(btnMesBiens);

		JButton btnMesLocations = new JButton("Mes Locations");
		btnMesLocations.setForeground(new Color(255, 255, 255));
		btnMesLocations.addActionListener(this);
		btnMesLocations.setBackground(new Color(0, 102, 204));
		btnMesLocations.setFont(new Font("Dialog", Font.BOLD, 12));
		btnMesLocations.setName("btnMesLocations");
		panel_3.add(btnMesLocations);

		JButton btnMesTravaux = new JButton("Mes Travaux");
		btnMesTravaux.setForeground(new Color(255, 255, 255));
		btnMesTravaux.addActionListener(this);
		btnMesTravaux.setBackground(new Color(0, 102, 204));
		btnMesTravaux.setFont(new Font("Dialog", Font.BOLD, 12));
		btnMesTravaux.setName("btnMesTravaux");
		panel_3.add(btnMesTravaux);

		JButton btnMesChargesLocatives = new JButton("Mes Charges Locatives");
		btnMesChargesLocatives.setForeground(new Color(255, 255, 255));
		btnMesChargesLocatives.addActionListener(this);
		btnMesChargesLocatives.setBackground(new Color(0, 102, 204));
		btnMesChargesLocatives.setFont(new Font("Dialog", Font.BOLD, 12));
		btnMesChargesLocatives.setName("btnMesChargesLocatives");
		panel_3.add(btnMesChargesLocatives);

		JButton btnMesAssurances = new JButton("Mes Assurances");
		btnMesAssurances.setForeground(new Color(255, 255, 255));
		btnMesAssurances.addActionListener(this);
		btnMesAssurances.setBackground(new Color(0, 102, 204));
		btnMesAssurances.setFont(new Font("Dialog", Font.BOLD, 12));
		btnMesAssurances.setName("btnMesAssurances");
		panel_3.add(btnMesAssurances);

		JButton btnRegularisationDesCharges = new JButton("Régularisation des Charges");
		btnRegularisationDesCharges.setForeground(new Color(255, 255, 255));
		btnRegularisationDesCharges.addActionListener(this);
		btnRegularisationDesCharges.setBackground(new Color(0, 102, 204));
		btnRegularisationDesCharges.setFont(new Font("Dialog", Font.BOLD, 12));
		btnRegularisationDesCharges.setName("btnRegularisationDesCharges");
		panel_3.add(btnRegularisationDesCharges);

		JButton btnSoldeDeToutCompte = new JButton("Solde de tout compte");
		btnSoldeDeToutCompte.setForeground(new Color(255, 255, 255));
		btnSoldeDeToutCompte.addActionListener(this);
		btnSoldeDeToutCompte.setBackground(new Color(0, 102, 204));
		btnSoldeDeToutCompte.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSoldeDeToutCompte.setName("btnSoldeDeToutCompte");
		panel_3.add(btnSoldeDeToutCompte);

		JButton btnMesDocuments = new JButton("Mes Documents");
		btnMesDocuments.setForeground(new Color(255, 255, 255));
		btnMesDocuments.addActionListener(this);
		btnMesDocuments.setBackground(new Color(0, 102, 204));
		btnMesDocuments.setFont(new Font("Dialog", Font.BOLD, 12));
		btnMesDocuments.setName("btnMesDocuments");
		panel_3.add(btnMesDocuments);

		// LAYERED MES
		// LOCATIONS////////////////////////////////////////////////////////////////
		this.layeredPane_MesLocations = new JLayeredPane();
		this.layeredPane_MesLocations.setBackground(new Color(255, 255, 255));
		this.contentPane.add(this.layeredPane_MesLocations, BorderLayout.CENTER);
		this.layeredPane_MesLocations.setLayout(new BorderLayout(0, 0));

		JPanel panel_north = new JPanel();
		this.layeredPane_MesLocations.add(panel_north, BorderLayout.NORTH);
		panel_north.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_2 = new JLabel("Mes locations");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_north.add(lblNewLabel_2, BorderLayout.CENTER);

		JPanel panel_center = new JPanel();
		this.layeredPane_MesLocations.add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new BorderLayout(0, 0));

		this.table = new JTable();
		this.table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null }, },
				new String[] { "JSPP", "Adresse", "Nom" }));
		panel_center.add(this.table);

		JPanel panel_south = new JPanel();
		this.layeredPane_MesLocations.add(panel_south, BorderLayout.SOUTH);
		panel_south.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btn_ajouter_logement = new JButton("Ajouter une location");
		btn_ajouter_logement.addActionListener(this);
		panel_south.add(btn_ajouter_logement);

		JButton btn_supprimer_logement = new JButton("New button");
		panel_south.add(btn_supprimer_logement);

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

		JPanel panel_5 = new JPanel();
		this.layeredPane_MesBiens.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_3 = new JLabel("Mes Biens");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel_3, BorderLayout.CENTER);

		// LAYERED MES
		// TRAVAUX////////////////////////////////////////////////////////////////

		this.layeredPane_MesTravaux = new JLayeredPane();
		this.contentPane.add(this.layeredPane_MesTravaux, BorderLayout.CENTER);
		this.layeredPane_MesTravaux.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		this.layeredPane_MesTravaux.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_4 = new JLabel("Mes Travaux");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel_4);

		// LAYERED MES CHARGES LOCATIVES
		// ////////////////////////////////////////////////////////////////

		this.layeredPane_MesChargesLocatives = new JLayeredPane();
		this.contentPane.add(this.layeredPane_MesChargesLocatives, BorderLayout.CENTER);
		this.layeredPane_MesChargesLocatives.setLayout(new BorderLayout(0, 0));

		JPanel panel_7 = new JPanel();
		this.layeredPane_MesChargesLocatives.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_5 = new JLabel("Mes Charges Locatives");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblNewLabel_5, BorderLayout.CENTER);

		// LAYERED MES ASSURANCES
		// ////////////////////////////////////////////////////////////////

		this.layeredPane_MesAssurances = new JLayeredPane();
		this.contentPane.add(this.layeredPane_MesAssurances, BorderLayout.CENTER);
		this.layeredPane_MesAssurances.setLayout(new BorderLayout(0, 0));

		JPanel panel_8 = new JPanel();
		this.layeredPane_MesAssurances.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_6 = new JLabel("Mes Assurances");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(lblNewLabel_6, BorderLayout.CENTER);

		// LAYERED REGULARISATION DES CHARGES
		// ////////////////////////////////////////////////////////////////

		this.layeredPane_RegularisationDesCharges = new JLayeredPane();
		this.contentPane.add(this.layeredPane_RegularisationDesCharges, BorderLayout.CENTER);
		this.layeredPane_RegularisationDesCharges.setLayout(new BorderLayout(0, 0));

		JPanel panel_9 = new JPanel();
		this.layeredPane_RegularisationDesCharges.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_7 = new JLabel("Régularisation des Charges");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel_7);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
		panel_4.setBackground(Color.LIGHT_GRAY);
		this.contentPane.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new GridLayout(0, 8, 0, 0));

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setIcon(new ImageIcon(Fenetre_Accueil.class.getResource("/Appli/src/icon/logo_appli.png")));
		panel_4.add(lblNewLabel_8);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(192, 192, 192));
		panel_4.add(panel_10);
		panel_10.setLayout(null);

		JButton btnAccueil = new JButton("");
		btnAccueil.addActionListener(this);
		btnAccueil.setBackground(new Color(192, 192, 192));
		btnAccueil.setIcon(
				new ImageIcon(Fenetre_Accueil.class.getResource("/Appli/src/icon/home_att-removebg-preview.png")));
		btnAccueil.setBounds(0, 53, 42, 31);
		btnAccueil.setName("btnAccueil");
		panel_10.add(btnAccueil);

		// LAYERED SOLDE DE TOUT
		// COMPTE////////////////////////////////////////////////////////////////

		this.layeredPane_SoldeDeToutCompte = new JLayeredPane();
		this.contentPane.add(this.layeredPane_SoldeDeToutCompte, BorderLayout.CENTER);
		this.layeredPane_SoldeDeToutCompte.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		this.layeredPane_SoldeDeToutCompte.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Solde de tout compte");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel);

		this.layeredPane_MesDocuments = new JLayeredPane();
		this.contentPane.add(this.layeredPane_MesDocuments, BorderLayout.CENTER);
		this.layeredPane_MesDocuments.setLayout(new BorderLayout(0, 0));

		JPanel panel_11 = new JPanel();
		this.layeredPane_MesDocuments.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_9 = new JLabel("Mes Documents");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(lblNewLabel_9);

		this.mettrePageParDef();
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

	private void mettrePageParDef() {
		this.rendreVisible(this.layeredPane_Accueil);
	}

}
