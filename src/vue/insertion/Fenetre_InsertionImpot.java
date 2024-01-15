package vue.insertion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		JLabel lbl_InsertionImpot = new JLabel("Insérer un Impôt");
		lbl_InsertionImpot.setBounds(302, 39, 163, 20);
		lbl_InsertionImpot.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_InsertionImpot.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lbl_InsertionImpot);

		// Champs de saisie
		this.textField_nom = new JTextField();
		this.textField_nom.setBounds(288, 167, 197, 40);
		this.textField_nom.setColumns(10);
		this.textField_nom.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Nom",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel.add(this.textField_nom);

		this.textField_montant = new JTextField();
		this.textField_montant.setColumns(10);
		this.textField_montant.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Montant",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_montant.setBounds(288, 229, 197, 40);
		panel.add(this.textField_montant);

		this.textField_annee = new JTextField();
		this.textField_annee.setColumns(10);
		this.textField_annee.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Année",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_annee.setBounds(288, 295, 197, 40);
		panel.add(this.textField_annee);

		// Bouton "Ajouter"
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(this.gestionClic);
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAjouter.setBackground(new Color(0, 102, 204));
		btnAjouter.setBounds(276, 431, 94, 31);
		panel.add(btnAjouter);

		// Bouton "Annuler"
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this.gestionClic);
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAnnuler.setBackground(new Color(0, 102, 204));
		btnAnnuler.setBounds(428, 431, 94, 31);
		panel.add(btnAnnuler);

		// Séparateur
		JSeparator separator_Document = new JSeparator();
		separator_Document.setForeground(new Color(0, 102, 204));
		separator_Document.setBounds(302, 72, 190, 2);
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

	public GestionInsertionImpot getGestionClic() {
		return this.gestionClic;
	}

}
