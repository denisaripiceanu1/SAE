package vue.insertion;

import java.awt.Color;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controleur.insertion.GestionInsertionLogement;

public class Fenetre_InsertionLogement extends JInternalFrame {
	// Champs de saisie
	private JTextField textField_IdLogement;
	private JTextField textField_SurfaceHabitable;
	private JTextField textField_NbPièces;
	private JTextField textField_DateAcquisition;
	private JTextField textField_NumEtage;

	// Gestionnaire d'événements
	private GestionInsertionLogement gestionClic;

	// ComboBox pour le type de logement
	private JComboBox<String> comboBox_typeDeLogement;

	public Fenetre_InsertionLogement() {
		// Initialisation du gestionnaire d'actions pour la fenêtre d'insertion de
		// logement
		this.gestionClic = new GestionInsertionLogement(this);

		// Configuration de la fenêtre interne
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		// Configuration du panel principal
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		// Séparateur
		JSeparator separator_titreInsererLogement = new JSeparator();
		separator_titreInsererLogement.setForeground(new Color(0, 102, 204));
		separator_titreInsererLogement.setBounds(271, 72, 190, 12);
		panel.add(separator_titreInsererLogement);

		// Titre
		JLabel lbl_InsererUnLogement = new JLabel("Insérer un logement");
		lbl_InsererUnLogement.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUnLogement.setBounds(290, 25, 171, 48);
		panel.add(lbl_InsererUnLogement);

		// ComboBox pour le type de logement
		this.comboBox_typeDeLogement = new JComboBox<String>();
		this.comboBox_typeDeLogement
				.setModel(new DefaultComboBoxModel<String>(new String[] { "Appartement", "Maison", "Garage" }));
		this.comboBox_typeDeLogement.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Type",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		this.comboBox_typeDeLogement.setBounds(376, 119, 189, 39);
		panel.add(this.comboBox_typeDeLogement);

		// TextFields
		this.textField_IdLogement = new JTextField();
		this.textField_IdLogement.setColumns(10);
		this.textField_IdLogement.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Id Logement",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_IdLogement.setBounds(145, 118, 190, 40);
		panel.add(this.textField_IdLogement);

		this.textField_SurfaceHabitable = new JTextField();
		this.textField_SurfaceHabitable.setColumns(10);
		this.textField_SurfaceHabitable.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"Surface habitable", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_SurfaceHabitable.setBounds(145, 193, 190, 40);
		panel.add(this.textField_SurfaceHabitable);

		this.textField_NbPièces = new JTextField();
		this.textField_NbPièces.setColumns(10);
		this.textField_NbPièces.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"Nombre de pi\u00E8ces", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_NbPièces.setBounds(375, 193, 190, 40);
		panel.add(this.textField_NbPièces);

		this.textField_DateAcquisition = new JTextField();
		this.textField_DateAcquisition.setColumns(10);
		this.textField_DateAcquisition.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"Date d'acquisition", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_DateAcquisition.setBounds(145, 269, 190, 40);
		panel.add(this.textField_DateAcquisition);

		this.textField_NumEtage = new JTextField();
		this.textField_NumEtage.setColumns(10);
		this.textField_NumEtage.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"Num\u00E9ro d'\u00E9tage", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_NumEtage.setBounds(375, 269, 190, 40);
		panel.add(this.textField_NumEtage);

		// Boutons généraux
		createButton("Ajouter", 235, 445, 94, 31, "Ajouter", gestionClic, panel);
		createButton("Annuler", 394, 445, 94, 31, "Annuler", gestionClic, panel);
		createButton("Ajouter un compteur", 291, 390, 154, 23, "Ajouter un compteur", gestionClic, panel);
		createButton("Ajouter une quotité", 290, 356, 154, 23, "Ajouter une quotité", gestionClic, panel);

	}


	// Getters pour récupérer les valeurs des champs
	public JTextField getTextField_IdLogement() {
		return this.textField_IdLogement;
	}

	public JTextField getTextField_SurfaceHabitable() {
		return this.textField_SurfaceHabitable;
	}

	public JTextField getTextField_NbPièces() {
		return this.textField_NbPièces;
	}

	public JTextField getTextField_DateAcquisition() {
		return this.textField_DateAcquisition;
	}

	public JTextField getTextField_NumEtage() {
		return this.textField_NumEtage;
	}

	public JComboBox<String> getComboBox_typeDeLogement() {
		return this.comboBox_typeDeLogement;
	}

}
