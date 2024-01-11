package vue.insertion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controleur.insertion.GestionInsertionReleve;


public class Fenetre_InsertionReleve extends JInternalFrame {
	
	private JTextField textField_dateReleve;
	private JTextField textField_indiceCompteur;
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
		JLabel lbl_InsertionImpot = new JLabel("Insérer un relevé");
		lbl_InsertionImpot.setBounds(291, 39, 163, 20);
		lbl_InsertionImpot.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_InsertionImpot.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lbl_InsertionImpot);

		// Champs de saisie
		this.textField_dateReleve = new JTextField();
		this.textField_dateReleve.setBounds(276, 166, 197, 40);
		this.textField_dateReleve.setColumns(10);
		this.textField_dateReleve.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Date Relev\u00E9", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel.add(this.textField_dateReleve);

		this.textField_indiceCompteur = new JTextField();
		this.textField_indiceCompteur.setColumns(10);
		this.textField_indiceCompteur.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Indice compteur", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_indiceCompteur.setBounds(276, 264, 197, 40);
		panel.add(this.textField_indiceCompteur);

		// Bouton "Ajouter"
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAjouter.setBackground(new Color(0, 102, 204));
		btnAjouter.setBounds(249, 431, 94, 31);
		btnAjouter.addActionListener(this.gestionClic);
		panel.add(btnAjouter);

		// Bouton "Annuler"
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAnnuler.setBackground(new Color(0, 102, 204));
		btnAnnuler.setBounds(393, 431, 94, 31);
		btnAnnuler.addActionListener(this.gestionClic);
		panel.add(btnAnnuler);

		// Séparateur
		JSeparator separator_Releve = new JSeparator();
		separator_Releve.setForeground(new Color(0, 102, 204));
		separator_Releve.setBounds(275, 69, 190, 2);
		panel.add(separator_Releve);

	}
	
	public JTextField getTextField_dateReleve() {
		return textField_dateReleve;
	}

	public JTextField getTextField_indiceCompteur() {
		return textField_indiceCompteur;
	}

}
