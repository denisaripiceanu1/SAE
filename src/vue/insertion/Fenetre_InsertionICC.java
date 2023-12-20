package vue.insertion;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controleur.insertion.GestionInsertionICC;
import controleur.insertion.GestionInsertionQuotite;

public class Fenetre_InsertionICC extends JInternalFrame {
	private JTextField textField_Annee;
	private GestionInsertionICC gestionClic;
	private JTextField textField_Trimestre;
	private JTextField textField_indice;

	public Fenetre_InsertionICC() {

		this.gestionClic = new GestionInsertionICC(this);

		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		JSeparator separator_titreInsererQuotite = new JSeparator();
		separator_titreInsererQuotite.setForeground(new Color(0, 102, 204));
		separator_titreInsererQuotite.setBounds(271, 130, 190, 2);
		panel.add(separator_titreInsererQuotite);

		JLabel lbl_InsererUnICC = new JLabel("Ajouter un ICC");
		lbl_InsererUnICC.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_InsererUnICC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUnICC.setBounds(284, 84, 160, 48);
		panel.add(lbl_InsererUnICC);

		this.textField_Annee = new JTextField();
		this.textField_Annee.setColumns(10);
		this.textField_Annee.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Ann\u00E9e", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_Annee.setBounds(271, 189, 190, 40);
		panel.add(this.textField_Annee);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAjouter.setBounds(246, 447, 94, 31);
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setBackground(new Color(0, 102, 204));
		btnAjouter.addActionListener(this.gestionClic);
		panel.add(btnAjouter);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAnnuler.setBounds(398, 447, 94, 31);
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBackground(new Color(0, 102, 204));
		btnAnnuler.addActionListener(this.gestionClic);
		panel.add(btnAnnuler);
		
		textField_Trimestre = new JTextField();
		textField_Trimestre.setColumns(10);
		textField_Trimestre.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Trimestre", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_Trimestre.setBounds(271, 263, 190, 40);
		panel.add(textField_Trimestre);
		
		textField_indice = new JTextField();
		textField_indice.setColumns(10);
		textField_indice.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Indice", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_indice.setBounds(271, 341, 190, 40);
		panel.add(textField_indice);

	}

	public JTextField getTextField_Annee() {
		return textField_Annee;
	}

	public GestionInsertionICC getGestionClic() {
		return gestionClic;
	}

	public JTextField getTextField_Trimestre() {
		return textField_Trimestre;
	}

	public JTextField getTextField_indice() {
		return textField_indice;
	}
	

}
