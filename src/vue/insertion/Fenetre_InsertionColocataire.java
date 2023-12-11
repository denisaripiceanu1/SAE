package vue.insertion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controleur.insertion.GestionInsertionColocataire;

public class Fenetre_InsertionColocataire extends JInternalFrame {

	private JTextField textField_IdLocataire;
	private JTextField textField_Nom;
	private JTextField textField_Prenom;
	private JTextField textField_Date_de_naissance;
	private JTextField textField;
	private JTextField textField_1;
	private GestionInsertionColocataire gestionClic;

	public Fenetre_InsertionColocataire() {

		this.gestionClic = new GestionInsertionColocataire(this);
		this.setBounds(100, 100, 609, 397);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JSeparator separator_titreInsererColocataire = new JSeparator();
		separator_titreInsererColocataire.setForeground(new Color(0, 102, 204));
		separator_titreInsererColocataire.setBounds(175, 54, 190, 2);
		panel.add(separator_titreInsererColocataire);

		JLabel lbl_InsererUnColocataire = new JLabel("Insérer un colocataire");
		lbl_InsererUnColocataire.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUnColocataire.setBounds(194, 10, 171, 48);
		panel.add(lbl_InsererUnColocataire);

		this.textField_IdLocataire = new JTextField();
		this.textField_IdLocataire.setColumns(10);
		this.textField_IdLocataire.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Id Locataire",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_IdLocataire.setBounds(42, 72, 190, 40);
		panel.add(this.textField_IdLocataire);

		this.textField_Nom = new JTextField();
		this.textField_Nom.setColumns(10);
		this.textField_Nom.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Nom",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_Nom.setBounds(42, 122, 190, 40);
		panel.add(this.textField_Nom);

		this.textField_Prenom = new JTextField();
		this.textField_Prenom.setColumns(10);
		this.textField_Prenom.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Pr\u00E9nom",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_Prenom.setBounds(42, 172, 190, 40);
		panel.add(this.textField_Prenom);

		this.textField_Date_de_naissance = new JTextField();
		this.textField_Date_de_naissance.setColumns(10);
		this.textField_Date_de_naissance.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"Date de naissance", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_Date_de_naissance.setBounds(42, 222, 190, 40);
		panel.add(this.textField_Date_de_naissance);

		this.textField = new JTextField();
		this.textField.setColumns(10);
		this.textField.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "N\u00B0T\u00E9lephone",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField.setBounds(332, 122, 190, 40);
		panel.add(this.textField);

		this.textField_1 = new JTextField();
		this.textField_1.setColumns(10);
		this.textField_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "E-mail",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_1.setBounds(332, 172, 190, 40);
		panel.add(this.textField_1);

		JButton btn_ajouter_colocataire = new JButton("Ajouter le colocataire");
		btn_ajouter_colocataire.setForeground(new Color(255, 255, 255));
		btn_ajouter_colocataire.setBackground(new Color(0, 102, 204));
		btn_ajouter_colocataire.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_ajouter_colocataire.setBounds(131, 300, 190, 40);
		panel.add(btn_ajouter_colocataire);

		JButton btn_annuler_colocataire = new JButton("Annuler");
		btn_annuler_colocataire.setForeground(new Color(255, 255, 255));
		btn_annuler_colocataire.setBackground(new Color(0, 102, 204));
		btn_annuler_colocataire.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_annuler_colocataire.setBounds(347, 300, 83, 40);
		panel.add(btn_annuler_colocataire);
		btn_annuler_colocataire.addActionListener(gestionClic);

	}

}
