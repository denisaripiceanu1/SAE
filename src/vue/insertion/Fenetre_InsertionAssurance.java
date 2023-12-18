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

import controleur.insertion.GestionInsertionAssurance;

public class Fenetre_InsertionAssurance extends JInternalFrame {
	private JTextField textField_numPolice;
	private JTextField textField_montant;
	private JTextField textField_SIRET;
	private GestionInsertionAssurance gestionClic;
	private JTextField textField_Nom;
	private JTextField textField_Adresse;
	private JTextField textField_CodePostal;
	private JTextField textField_Ville;
	private JTextField textField_Mail;
	private JTextField textField_tel;
	private JTextField textField_IBAN;

	public Fenetre_InsertionAssurance() {
		this.gestionClic = new GestionInsertionAssurance(this);
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		this.textField_numPolice = new JTextField();
		this.textField_numPolice.setBounds(70, 100, 163, 40);
		this.textField_numPolice.setColumns(10);
		this.textField_numPolice.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"Num\u00E9ro de police", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel.add(this.textField_numPolice);

		JLabel lbl_InsertionAssurance = new JLabel("Assurance");
		lbl_InsertionAssurance.setBounds(314, 41, 163, 20);
		lbl_InsertionAssurance.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_InsertionAssurance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lbl_InsertionAssurance);

		this.textField_montant = new JTextField();
		this.textField_montant.setColumns(10);
		this.textField_montant.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Montant",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_montant.setBounds(70, 169, 163, 40);
		panel.add(this.textField_montant);

		this.textField_SIRET = new JTextField();
		this.textField_SIRET.setColumns(10);
		this.textField_SIRET.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "SIRET",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_SIRET.setBounds(359, 100, 163, 40);
		panel.add(this.textField_SIRET);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAjouter.setBackground(new Color(0, 102, 204));
		btnAjouter.setBounds(276, 431, 94, 31);
		btnAjouter.addActionListener(this.gestionClic);
		panel.add(btnAjouter);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAnnuler.setBackground(new Color(0, 102, 204));
		btnAnnuler.setBounds(428, 431, 94, 31);
		btnAnnuler.addActionListener(this.gestionClic);
		panel.add(btnAnnuler);

		JSeparator separator_Assurance = new JSeparator();
		separator_Assurance.setForeground(new Color(0, 102, 204));
		separator_Assurance.setBounds(302, 72, 190, 2);
		panel.add(separator_Assurance);

		JSeparator separator_Assurance_1 = new JSeparator();
		separator_Assurance_1.setOrientation(SwingConstants.VERTICAL);
		separator_Assurance_1.setForeground(new Color(0, 102, 204));
		separator_Assurance_1.setBounds(302, 98, 15, 292);
		panel.add(separator_Assurance_1);

		this.textField_Nom = new JTextField();
		this.textField_Nom.setColumns(10);
		this.textField_Nom.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Nom",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_Nom.setBounds(359, 150, 163, 40);
		panel.add(this.textField_Nom);

		this.textField_Adresse = new JTextField();
		this.textField_Adresse.setColumns(10);
		this.textField_Adresse.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Adresse",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_Adresse.setBounds(359, 200, 329, 40);
		panel.add(this.textField_Adresse);

		this.textField_CodePostal = new JTextField();
		this.textField_CodePostal.setColumns(10);
		this.textField_CodePostal.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Code Postal",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_CodePostal.setBounds(359, 250, 107, 40);
		panel.add(this.textField_CodePostal);

		this.textField_Ville = new JTextField();
		this.textField_Ville.setColumns(10);
		this.textField_Ville.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Ville",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_Ville.setBounds(487, 250, 201, 40);
		panel.add(this.textField_Ville);

		this.textField_Mail = new JTextField();
		this.textField_Mail.setColumns(10);
		this.textField_Mail.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "E-mail",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_Mail.setBounds(359, 300, 163, 40);
		panel.add(this.textField_Mail);

		this.textField_tel = new JTextField();
		this.textField_tel.setColumns(10);
		this.textField_tel.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "T\u00E9l\u00E9phone",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_tel.setBounds(542, 300, 146, 40);
		panel.add(this.textField_tel);

		this.textField_IBAN = new JTextField();
		this.textField_IBAN.setColumns(10);
		this.textField_IBAN.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "IBAN",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_IBAN.setBounds(359, 350, 329, 40);
		panel.add(this.textField_IBAN);

	}

	public JTextField getTextField_numPolice() {
		return this.textField_numPolice;
	}

	public JTextField getTextField_montant() {
		return this.textField_montant;
	}
	
	public JTextField getTextField_SIRET() {
		return this.textField_SIRET;
	}

	public GestionInsertionAssurance getGestionClic() {
		return this.gestionClic;
	}

	public JTextField getTextField_Nom() {
		return this.textField_Nom;
	}

	public JTextField getTextField_Adresse() {
		return this.textField_Adresse;
	}

	public JTextField getTextField_CodePostal() {
		return this.textField_CodePostal;
	}

	public JTextField getTextField_Ville() {
		return this.textField_Ville;
	}

	public JTextField getTextField_Mail() {
		return this.textField_Mail;
	}

	public JTextField getTextField_tel() {
		return this.textField_tel;
	}

	public JTextField getTextField_IBAN() {
		return this.textField_IBAN;
	}
}
