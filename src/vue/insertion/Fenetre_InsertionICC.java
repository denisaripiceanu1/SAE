package vue.insertion;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controleur.insertion.GestionInsertionICC;

public class Fenetre_InsertionICC extends JInternalFrame {
	// Champs de saisie
	private JTextField textField_Annee;
	private JTextField textField_Trimestre;
	private JTextField textField_indice;

	// Gestionnaire d'événements
	private GestionInsertionICC gestionClic;

	public Fenetre_InsertionICC() {
		// Initialisation du gestionnaire d'insertion ICC
		this.gestionClic = new GestionInsertionICC(this);

		// Configuration de la fenêtre interne
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		// Configuration du panel principal
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		// Titre et séparateur
		Utils.createLabel("Ajouter un ICC", 284, 84, 160, 48, 16, panel);

		JSeparator separator_titreInsererQuotite = new JSeparator();
		separator_titreInsererQuotite.setForeground(new Color(0, 102, 204));
		separator_titreInsererQuotite.setBounds(271, 130, 190, 2);
		panel.add(separator_titreInsererQuotite);

		// Champ de texte pour l'année
		this.textField_Annee = Utils.createTextField("Année", 271, 189, 190, 40, panel);
		
		// Champ de texte pour le trimestre
		this.textField_Trimestre = Utils.createTextField("Trimestre", 271, 263, 190, 40, panel);

		// Champ de texte pour l'indice
		this.textField_indice = Utils.createTextField("Indice", 271, 341, 190, 40, panel);

		// Boutons Ajouter et Annuler
		JButton btnAnnuler = Utils.creerBouton(panel, "Annuler", 398, 395, 94, 31);
		btnAnnuler.addActionListener(this.gestionClic);

		JButton btnAnjouter = Utils.creerBouton(panel, "Ajouter", 246, 395, 94, 31);
		btnAnjouter.addActionListener(this.gestionClic);
	}

	// Getters pour récupérer les valeurs des champs
	public JTextField getTextField_Annee() {
		return textField_Annee;
	}

	public JTextField getTextField_Trimestre() {
		return textField_Trimestre;
	}

	public JTextField getTextField_indice() {
		return textField_indice;
	}

	public GestionInsertionICC getGestionClic() {
		return gestionClic;
	}
}
