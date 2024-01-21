package vue.insertion;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controleur.insertion.GestionInsertionReleve;

public class Fenetre_InsertionReleve extends JInternalFrame {
	// Champs de saisie
	private JTextField textField_dateReleve;
	private JTextField textField_indiceCompteur;
	// Déclaration des gestionnaires
	private GestionInsertionReleve gestionClic;

	public Fenetre_InsertionReleve() {
		// Initialisation du gestionnaire d'actions
		this.gestionClic = new GestionInsertionReleve(this);

		// Configuration de la fenêtre interne
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		// Panneau principal
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		// Libellé "Assurance"
		Utils.creerLabel("Insérer un relevé", 291, 39, 163, 20, 16, panel);

		// Champs de saisie
		this.textField_dateReleve = Utils.creerTextField("Date relev\\u00E9", 276, 166, 197, 40, panel);
		this.textField_dateReleve = Utils.creerTextField("Indice compteur", 276, 264, 197, 40, panel);

		// Boutons "Ajouter" et "Annuler"
		JButton btnAjouter = Utils.creerBouton(panel, "Ajouter", 249, 431, 94, 31);
		btnAjouter.addActionListener(this.gestionClic);

		JButton btnAnnuler = Utils.creerBouton(panel, "Annuler", 393, 431, 94, 31);
		btnAnnuler.addActionListener(this.gestionClic);

		// Séparateur
		JSeparator separator_Releve = new JSeparator();
		separator_Releve.setForeground(new Color(0, 102, 204));
		separator_Releve.setBounds(275, 69, 190, 20);
		panel.add(separator_Releve);

	}

	// Getters
	public JTextField getTextField_dateReleve() {
		return textField_dateReleve;
	}

	public JTextField getTextField_indiceCompteur() {
		return textField_indiceCompteur;
	}

}
