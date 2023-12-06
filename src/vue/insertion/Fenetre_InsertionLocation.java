package vue.insertion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controleur.insertion.GestionInsertionLocation;

public class Fenetre_InsertionLocation extends JInternalFrame {
	private JTextField textField_IdLocataire;
	private JTextField textField_Nom;
	private JTextField textField_Prenom;
	private JTextField textField_tel;
	private JTextField textField_e_mail;
	private JTextField textField_Date_de_naissance;
	private JTable table;
	private JTable table_id_logements;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private GestionInsertionLocation gestionClic;


	public Fenetre_InsertionLocation() {
		this.gestionClic = new GestionInsertionLocation(this);
		
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 755, 511);
		panel.setLayout(null);
		this.getContentPane().add(panel);

		JSeparator separator_titreInsererLocation = new JSeparator();
		separator_titreInsererLocation.setForeground(new Color(0, 102, 204));
		separator_titreInsererLocation.setBounds(271, 61, 190, 2);
		panel.add(separator_titreInsererLocation);

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
		this.textField_IdLocataire.setBounds(24, 116, 190, 40);
		panel.add(this.textField_IdLocataire);

		this.textField_Nom = new JTextField();
		this.textField_Nom.setColumns(10);
		this.textField_Nom.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Nom",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_Nom.setBounds(24, 165, 190, 40);
		panel.add(this.textField_Nom);

		this.textField_Prenom = new JTextField();
		this.textField_Prenom.setColumns(10);
		this.textField_Prenom.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Pr\u00E9nom",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_Prenom.setBounds(24, 214, 190, 40);
		panel.add(this.textField_Prenom);

		this.textField_tel = new JTextField();
		this.textField_tel.setColumns(10);
		this.textField_tel.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"N\u00B0 t\u00E9l\u00E9phone", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_tel.setBounds(24, 314, 190, 40);
		panel.add(this.textField_tel);

		this.textField_e_mail = new JTextField();
		this.textField_e_mail.setColumns(10);
		this.textField_e_mail.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "E-mail",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_e_mail.setBounds(24, 364, 190, 40);
		panel.add(this.textField_e_mail);

		this.textField_Date_de_naissance = new JTextField();
		this.textField_Date_de_naissance.setColumns(10);
		this.textField_Date_de_naissance.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"Date de naissance", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_Date_de_naissance.setBounds(24, 264, 190, 40);
		panel.add(this.textField_Date_de_naissance);

		JButton btn_ajouter_coloc = new JButton("Ajouter un colocataire");
		btn_ajouter_coloc.setBounds(54, 439, 139, 21);
		btn_ajouter_coloc.addActionListener(gestionClic);
		panel.add(btn_ajouter_coloc);

		JLabel lbl_titre_locataire = new JLabel("Locataire");
		lbl_titre_locataire.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_titre_locataire.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titre_locataire.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_titre_locataire.setBounds(75, 80, 99, 27);
		panel.add(lbl_titre_locataire);

		JLabel lbl_titre_logement = new JLabel("Logement");
		lbl_titre_logement.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_titre_logement.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titre_logement.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_titre_logement.setBounds(313, 80, 99, 27);
		panel.add(lbl_titre_logement);

		JButton btn_ajouter_location = new JButton("Ajouter");
		btn_ajouter_location.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_ajouter_location.setBounds(257, 457, 94, 31);
		btn_ajouter_location.addActionListener(gestionClic);
		panel.add(btn_ajouter_location);

		JButton btn_annuler_location = new JButton("Annuler");
		btn_annuler_location.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_annuler_location.setBounds(400, 457, 94, 31);
		btn_annuler_location.addActionListener(gestionClic);
		panel.add(btn_annuler_location);

		JComboBox comboBox_bien = new JComboBox();
		comboBox_bien.setBorder(new LineBorder(new Color(0, 102, 204)));
		comboBox_bien.setModel(new DefaultComboBoxModel(new String[] { "Biens" }));
		comboBox_bien.setBounds(267, 131, 94, 21);
		panel.add(comboBox_bien);
		this.table.setModel(new DefaultTableModel(new Object[][] { { null }, }, new String[] { "ID des logements" }));
		this.table.setBounds(369, 214, 1, 1);
		panel.add(this.table);

		JScrollPane scrollPane_table_id_logements = new JScrollPane();
		scrollPane_table_id_logements.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
		scrollPane_table_id_logements.setBounds(271, 182, 223, 222);
		panel.add(scrollPane_table_id_logements);

		this.table_id_logements = new JTable();
		this.table_id_logements.setCellSelectionEnabled(true);
		this.table_id_logements
				.setModel(new DefaultTableModel(new Object[][] { { null }, }, new String[] { "ID des logements" }));
		this.table_id_logements.setBounds(0, 0, 1, 1);
		scrollPane_table_id_logements.setViewportView(this.table_id_logements);

		JButton btnAjouterBail = new JButton("Ajouter un bail");
		btnAjouterBail.setBounds(534, 149, 154, 21);
		btnAjouterBail.addActionListener(gestionClic);
		panel.add(btnAjouterBail);

		JButton btnAjouterEtatDesLieux = new JButton("Ajouter l'état des lieux");
		btnAjouterEtatDesLieux.setBounds(534, 116, 154, 21);
		btnAjouterEtatDesLieux.addActionListener(gestionClic);
		panel.add(btnAjouterEtatDesLieux);

		this.textField = new JTextField();
		this.textField.setColumns(10);
		this.textField.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Caution",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField.setBounds(548, 247, 120, 40);
		panel.add(this.textField);

		this.textField_1 = new JTextField();
		this.textField_1.setColumns(10);
		this.textField_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Date d'arriv\u00E9e",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_1.setBounds(548, 297, 120, 40);
		panel.add(this.textField_1);

		this.textField_2 = new JTextField();
		this.textField_2.setColumns(10);
		this.textField_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Provisions sur charges",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_2.setBounds(548, 347, 120, 40);
		panel.add(this.textField_2);

		this.textField_3 = new JTextField();
		this.textField_3.setColumns(10);
		this.textField_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Loyer",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_3.setBounds(548, 197, 120, 40);
		panel.add(this.textField_3);

	}
}
