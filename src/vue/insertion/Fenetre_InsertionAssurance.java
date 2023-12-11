package vue.insertion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controleur.insertion.GestionInsertionAssurance;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;

public class Fenetre_InsertionAssurance extends JInternalFrame {
	private JTextField textField_numPolice;
	private JTextField textField_montant;
	private JTextField textField_IDImmeuble;
	private JTextField textField_SIRET;
	private GestionInsertionAssurance gestionClic;
	
	public Fenetre_InsertionAssurance() {
		this.gestionClic = new GestionInsertionAssurance(this);
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 6, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField_numPolice = new JTextField();
		textField_numPolice.setBounds(314, 112, 163, 40);
		textField_numPolice.setColumns(10);
		textField_numPolice.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Num\u00E9ro de police", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel.add(textField_numPolice);
		
		JLabel lbl_InsertionAssurance = new JLabel("Assurance");
		lbl_InsertionAssurance.setBounds(354, 41, 71, 20);
		lbl_InsertionAssurance.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_InsertionAssurance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lbl_InsertionAssurance);
		
		textField_montant = new JTextField();
		textField_montant.setColumns(10);
		textField_montant.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Montant", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_montant.setBounds(314, 188, 163, 40);
		panel.add(textField_montant);
		
		textField_IDImmeuble = new JTextField();
		textField_IDImmeuble.setColumns(10);
		textField_IDImmeuble.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Identifiant immeuble", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_IDImmeuble.setBounds(314, 271, 163, 40);
		panel.add(textField_IDImmeuble);
		
		textField_SIRET = new JTextField();
		textField_SIRET.setColumns(10);
		textField_SIRET.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "SIRET", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_SIRET.setBounds(314, 353, 163, 40);
		panel.add(textField_SIRET);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAjouter.setBackground(new Color(0, 102, 204));
		btnAjouter.setBounds(276, 431, 94, 31);
		panel.add(btnAjouter);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAnnuler.setBackground(new Color(0, 102, 204));
		btnAnnuler.setBounds(428, 431, 94, 31);
		panel.add(btnAnnuler);

	}
}
