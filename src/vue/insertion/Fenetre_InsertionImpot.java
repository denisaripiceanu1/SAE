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

import controleur.insertion.GestionInsertionImpot;

public class Fenetre_InsertionImpot extends JInternalFrame {
	private JTextField textField_nom;
	private JTextField textField_montant;
	private GestionInsertionImpot gestionClic;
	private JTextField textField_annee;

	public Fenetre_InsertionImpot() {
		// Initialisation du gestionnaire d'actions
		this.gestionClic = new GestionInsertionImpot(this);

		// Configuration de la fenêtre interne
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		// Panneau principal
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		// Libellé "Impôt"
		Utils.creerLabel("Insérer un Impôt", 302, 39, 163, 20, 16, panel);

		// Champs de saisie
		this.textField_nom = Utils.creerTextField("Nom", 288, 167, 197, 40, panel);
		this.textField_montant = Utils.creerTextField("Montant", 288, 229, 197, 40, panel);
		this.textField_annee = Utils.creerTextField("Année", 288, 295, 197, 40, panel);

		// Boutons Ajouter et Annuler
		JButton btnAnnuler = Utils.creerBouton(panel, "Annuler", 428, 431, 94, 31);
		btnAnnuler.addActionListener(this.gestionClic);

		JButton btnAnjouter = Utils.creerBouton(panel, "Ajouter", 276, 431, 94, 31);
		btnAnjouter.addActionListener(this.gestionClic);
		
		// Séparateur
		JSeparator separator_Document = new JSeparator();
		separator_Document.setForeground(new Color(0, 102, 204));
		separator_Document.setBounds(302, 72, 190, 20);
		panel.add(separator_Document);

	}

	// Getters pour les champs de saisie
	public JTextField getTextField_nom() {
		return this.textField_nom;
	}

	public JTextField getTextField_montant() {
		return this.textField_montant;
	}

	public JTextField getTextField_annee() {
		return this.textField_annee;
	}

}
