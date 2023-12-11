package vue.insertion;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controleur.insertion.GestionInsertionDiagnostic;

public class Fenetre_InsertionDiagnostic extends JInternalFrame {
	private JTextField textField_Date_Validite;
	private JTextField textField_Type;

	private GestionInsertionDiagnostic gestionClic;

	public Fenetre_InsertionDiagnostic() {

		this.gestionClic = new GestionInsertionDiagnostic(this);

		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		JSeparator separator_titreInsererBien = new JSeparator();
		separator_titreInsererBien.setForeground(new Color(0, 102, 204));
		separator_titreInsererBien.setBounds(263, 99, 190, 2);
		panel.add(separator_titreInsererBien);

		JLabel lbl_InsererUnDiagnostic = new JLabel("Ajouter un Diagnostic");
		lbl_InsererUnDiagnostic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUnDiagnostic.setBounds(275, 53, 163, 48);
		panel.add(lbl_InsererUnDiagnostic);

		this.textField_Date_Validite = new JTextField();
		this.textField_Date_Validite.setColumns(10);
		this.textField_Date_Validite.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Date Validite",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_Date_Validite.setBounds(263, 232, 190, 40);
		panel.add(this.textField_Date_Validite);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setBackground(new Color(0, 102, 204));
		btnAjouter.setBounds(244, 395, 94, 31);
		btnAjouter.addActionListener(this.gestionClic);
		panel.add(btnAjouter);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBackground(new Color(0, 102, 204));
		btnAnnuler.setBounds(396, 395, 94, 31);
		btnAnnuler.addActionListener(this.gestionClic);
		panel.add(btnAnnuler);

		this.textField_Type = new JTextField();
		this.textField_Type.setColumns(10);
		this.textField_Type.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Type",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_Type.setBounds(263, 161, 190, 40);
		panel.add(this.textField_Type);

	}

	public JTextField getTextField_Date_Validite() {
		return this.textField_Date_Validite;
	}

	public JTextField getTextField_Type() {
		return this.textField_Type;
	}
}
