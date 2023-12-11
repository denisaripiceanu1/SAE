package vue.insertion;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controleur.insertion.GestionInsertionLogement;

import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;


public class Fenetre_InsertionLogement extends JInternalFrame {
	private JTextField textField_IdLogement;
	private JTextField textField_SurfaceHabitable;
	private JTextField textField_NbPièces;
	private JTextField textField_DateAcquisition;
	private JTextField textField_NumEtage;
	private JButton btnAjouter;
	private JButton btnAnnuler;
	private JButton btnAjouterCompteur;
	private JButton btnAjouterQuotite;
	private GestionInsertionLogement gestionClic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre_InsertionLogement frame = new Fenetre_InsertionLogement();
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
	public Fenetre_InsertionLogement() {
		
		this.gestionClic = new GestionInsertionLogement(this);
		
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JSeparator separator_titreInsererLogement = new JSeparator();
		separator_titreInsererLogement.setForeground(new Color(0, 102, 204));
		separator_titreInsererLogement.setBounds(271, 72, 190, 2);
		panel.add(separator_titreInsererLogement);
		
		JLabel lbl_InsererUnLogement = new JLabel("Insérer un logement");
		lbl_InsererUnLogement.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUnLogement.setBounds(290, 25, 171, 48);
		panel.add(lbl_InsererUnLogement);
		
		JComboBox comboBox_typeDeLogement = new JComboBox();
		comboBox_typeDeLogement.setModel(new DefaultComboBoxModel(new String[] {"Appartement", "Maison", "Garage"}));
		comboBox_typeDeLogement.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Type", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		comboBox_typeDeLogement.setBounds(376, 119, 189, 39);
		panel.add(comboBox_typeDeLogement);
		
		textField_IdLogement = new JTextField();
		textField_IdLogement.setColumns(10);
		textField_IdLogement.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Id Logement", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_IdLogement.setBounds(145, 118, 190, 40);
		panel.add(textField_IdLogement);
		
		textField_SurfaceHabitable = new JTextField();
		textField_SurfaceHabitable.setColumns(10);
		textField_SurfaceHabitable.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Surface habitable", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_SurfaceHabitable.setBounds(145, 193, 190, 40);
		panel.add(textField_SurfaceHabitable);
		
		textField_NbPièces = new JTextField();
		textField_NbPièces.setColumns(10);
		textField_NbPièces.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Nombre de pi\u00E8ces", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_NbPièces.setBounds(375, 193, 190, 40);
		panel.add(textField_NbPièces);
		
		textField_DateAcquisition = new JTextField();
		textField_DateAcquisition.setColumns(10);
		textField_DateAcquisition.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Date d'acquisition", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_DateAcquisition.setBounds(145, 269, 190, 40);
		panel.add(textField_DateAcquisition);
		
		textField_NumEtage = new JTextField();
		textField_NumEtage.setColumns(10);
		textField_NumEtage.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Num\u00E9ro d'\u00E9tage", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_NumEtage.setBounds(375, 269, 190, 40);
		panel.add(textField_NumEtage);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAjouter.setBounds(235, 445, 94, 31);
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setBackground(new Color(0, 102, 204));
		btnAjouter.addActionListener(gestionClic);
		panel.add(btnAjouter);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAnnuler.setBounds(394, 445, 94, 31);
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBackground(new Color(0, 102, 204));
		btnAnnuler.addActionListener(gestionClic);
		panel.add(btnAnnuler);
		
		btnAjouterCompteur = new JButton("Ajouter un compteur");
		btnAjouterCompteur.setBounds(291, 390, 154, 23);
		btnAjouterCompteur.addActionListener(gestionClic);
		panel.add(btnAjouterCompteur);
		
		btnAjouterQuotite = new JButton("Ajouter une quotité");
		btnAjouterQuotite.setBounds(290, 356, 154, 23);
		btnAjouterQuotite.addActionListener(gestionClic);
		panel.add(btnAjouterQuotite);

	}
}
