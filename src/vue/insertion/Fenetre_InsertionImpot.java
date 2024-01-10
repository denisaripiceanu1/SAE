package vue.insertion;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
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

import controleur.GestionTableEntrepriseFenetreInsertionAssurance;
import controleur.insertion.GestionInsertionAssurance;
import controleur.insertion.GestionInsertionImpot;

public class Fenetre_InsertionImpot extends JInternalFrame {
	private JTextField textField_nom;
	private JTextField textField_montant;
	private GestionInsertionImpot gestionClic;

	// Table pour afficher les données d'entreprise
	private JTable table_entreprise;

	private JTextField textField_dateEcheance;

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

		// Libellé "Assurance"
		JLabel lbl_InsertionImpot = new JLabel("Insérer un Impôt");
		lbl_InsertionImpot.setBounds(302, 39, 163, 20);
		lbl_InsertionImpot.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_InsertionImpot.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lbl_InsertionImpot);

		// Champs de saisie
		this.textField_nom = new JTextField();
		this.textField_nom.setBounds(135, 166, 197, 40);
		this.textField_nom.setColumns(10);
		this.textField_nom.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Nom",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel.add(this.textField_nom);

		this.textField_montant = new JTextField();
		this.textField_montant.setColumns(10);
		this.textField_montant.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Montant",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_montant.setBounds(135, 229, 197, 40);
		panel.add(this.textField_montant);

		// Bouton "Ajouter"
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAjouter.setBackground(new Color(0, 102, 204));
		btnAjouter.setBounds(276, 431, 94, 31);
		btnAjouter.addActionListener(this.gestionClic);
		panel.add(btnAjouter);

		// Bouton "Annuler"
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAnnuler.setBackground(new Color(0, 102, 204));
		btnAnnuler.setBounds(428, 431, 94, 31);
		btnAnnuler.addActionListener(this.gestionClic);
		panel.add(btnAnnuler);

		// Séparateur
		JSeparator separator_Assurance = new JSeparator();
		separator_Assurance.setForeground(new Color(0, 102, 204));
		separator_Assurance.setBounds(302, 72, 190, 2);
		panel.add(separator_Assurance);

	}

	// Getters pour les champs de saisie
	public JTextField getTextField_numPolice() {
		return this.textField_numPolice;
	}

	public JTextField getTextField_montant() {
		return this.textField_montant;
	}

	public GestionInsertionAssurance getGestionClic() {
		return this.gestionClic;
	}

	public GestionTableEntrepriseFenetreInsertionAssurance getGtefia() {
		return gtefia;
	}

	public JTextField getTextField_dateEcheance() {
		return this.textField_dateEcheance;
	}

	public JButton getBtn_ajouter_entreprise() {
		return btn_ajouter_entreprise;
	}

	public JButton getBtn_charger_entreprise() {
		return btn_charger_entreprise;
	}

	public JScrollPane getScrollPane_table_entreprise() {
		return scrollPane_table_entreprise;
	}

	public JTable getTable_entreprise() {
		return this.table_entreprise;
	}
}
