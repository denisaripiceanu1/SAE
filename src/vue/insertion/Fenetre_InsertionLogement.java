package vue.insertion;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
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
		Utils.creerLabel("Insérer un logement", 290, 25, 171, 48, 16, panel);

		// ComboBox pour le type de logement
		this.comboBox_typeDeLogement = new JComboBox<String>();
		this.comboBox_typeDeLogement
				.setModel(new DefaultComboBoxModel<String>(new String[] { "Appartement", "Maison", "Garage" }));
		this.comboBox_typeDeLogement.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Type",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		this.comboBox_typeDeLogement.setBounds(376, 119, 189, 39);
		panel.add(this.comboBox_typeDeLogement);

		// TextFields
		this.textField_IdLogement = Utils.creerTextField("Id Logement", 145, 118, 190, 40, panel);
		this.textField_SurfaceHabitable = Utils.creerTextField("Surface habitable", 145, 193, 190, 40, panel);
		this.textField_NbPièces = Utils.creerTextField("Nombre de pièces", 375, 193, 190, 40, panel);
		this.textField_DateAcquisition = Utils.creerTextField("Date d'acquisition", 145, 269, 190, 40, panel);
		this.textField_NumEtage = Utils.creerTextField("Numéro d'étage", 375, 269, 190, 40, panel);

		// Boutons généraux
		JButton btnAjouter = Utils.creerBouton(panel, "Ajouter", 235, 445, 94, 31);
		btnAjouter.addActionListener(this.gestionClic);

		JButton btnAnnuler = Utils.creerBouton(panel, "Annuler", 394, 445, 94, 31);
		btnAnnuler.addActionListener(this.gestionClic);

		JButton btnAjouterCompteur = Utils.creerBouton(panel, "Ajouter un compteur", 291, 390, 154, 23);
		btnAjouterCompteur.addActionListener(this.gestionClic);

		JButton btnAjouterQuotite = Utils.creerBouton(panel, "Ajouter une quotité", 290, 356, 154, 23);
		btnAjouterQuotite.addActionListener(this.gestionClic);

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
