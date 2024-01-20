package vue.insertion;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Font;

import controleur.insertion.GestionInsertionBien;

public class Fenetre_InsertionBien extends JInternalFrame {
	// Champs de saisie
	private JTextField textField_IdImmeuble;
	private JTextField textField_adresse;
	private JTextField textField_codePostal;
	private JTextField textField_ville;
	private JTextField textField_periodeDeConstruction;
	// Menu déroulant pour le type de compteur
	private JComboBox<String> comboBox_typeDeBien;
	// Gestionnaire d'actions
	private GestionInsertionBien gestionInsertionBien;

	public Fenetre_InsertionBien() {
		// Initialisation du gestionnaire d'insertion de bien
		this.gestionInsertionBien = new GestionInsertionBien(this);

		// Configuration de la fenêtre interne
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		// Panneau principal
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		// Titre et séparateur
		JSeparator separator_titreInsererBien = new JSeparator();
		separator_titreInsererBien.setForeground(new Color(0, 102, 204));
		separator_titreInsererBien.setBounds(271, 72, 190, 2);
		panel.add(separator_titreInsererBien);

		JLabel lbl_InsererUnBien = new JLabel("Ajouter un Bien");
		lbl_InsererUnBien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUnBien.setBounds(308, 26, 117, 48);
		panel.add(lbl_InsererUnBien);

		// Champs de texte
		textField_IdImmeuble = Utils.createTextField("Id Bien", 110, 104, 190, 40, panel, true);
		textField_adresse = Utils.createTextField("Adresse", 110, 168, 190, 40, panel, true);
		textField_codePostal = Utils.createTextField("Code Postal", 427, 168, 190, 40, panel, true);
		textField_ville = Utils.createTextField("Ville", 110, 228, 190, 40, panel, true);
		textField_periodeDeConstruction = Utils.createTextField("Période de construction", 427, 228, 190, 40, panel, true);

		// Menu déroulant
		comboBox_typeDeBien = createComboBox("Type", new String[] { "Immeuble", "Maison" }, 427, 104, 189, 45, panel);

		// Boutons
		JButton btnAnnuler = Utils.creerBouton(panel, "Annuler", 398, 447, 94, 31);
		btnAnnuler.addActionListener(this.gestionInsertionBien);

		JButton btnAnjouter = Utils.creerBouton(panel, "Ajouter", 246, 447, 94, 31);
		btnAnjouter.addActionListener(this.gestionInsertionBien);

		JButton btnAjouterCompteur = Utils.creerBouton(panel, "Ajouter un compteur", 246, 378, 246, 31);
		btnAjouterCompteur.addActionListener(this.gestionInsertionBien);

	}

	// Méthode pour créer un menu déroulant avec une bordure spécifique
	private JComboBox<String> createComboBox(String title, String[] items, int x, int y, int width, int height,
			JPanel panel) {
		JComboBox<String> comboBox = new JComboBox<>(items);
		comboBox.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), title, TitledBorder.LEADING,
				TitledBorder.ABOVE_TOP, null, null));
		comboBox.setBounds(x, y, width, height);
		panel.add(comboBox);
		return comboBox;
	}

	// Getters pour récupérer les valeurs des champs
	public JTextField getTextField_IdImmeuble() {
		return textField_IdImmeuble;
	}

	public JTextField getTextField_adresse() {
		return textField_adresse;
	}

	public JTextField getTextField_codePostal() {
		return textField_codePostal;
	}

	public JTextField getTextField_ville() {
		return textField_ville;
	}

	public JTextField getTextField_periodeDeConstruction() {
		return textField_periodeDeConstruction;
	}

	public JComboBox<String> getComboBox_typeDeBien() {
		return comboBox_typeDeBien;
	}
}
