package vue.modification;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controleur.insertion.GestionInsertionCharges;
import controleur.modification.GestionModificationCharges;

public class Fenetre_ModificationCharges extends JInternalFrame {
	private JTextField textField_nomCharge;
	private JTextField textField_montantPrevisionnel;
	private GestionModificationCharges gestionModification;
	private JTextField textField_montantReel;
	private JRadioButton rdbtnAjouterChargeOui;
	private JRadioButton rdbtnAjouterChargeNon;

	public Fenetre_ModificationCharges() {

		this.gestionModification = new GestionModificationCharges(this);

		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		JSeparator separator_titreAjouterCharge = new JSeparator();
		separator_titreAjouterCharge.setForeground(new Color(0, 102, 204));
		separator_titreAjouterCharge.setBounds(271, 72, 190, 2);
		panel.add(separator_titreAjouterCharge);

		JLabel lbl_InsererUneCharge = new JLabel("Modifier une Charge");
		lbl_InsererUneCharge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUneCharge.setBounds(288, 26, 160, 48);
		panel.add(lbl_InsererUneCharge);

		JButton btnAjouter = new JButton("Modifier");
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAjouter.setBounds(246, 447, 94, 31);
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setBackground(new Color(0, 102, 204));
		panel.add(btnAjouter);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAnnuler.setBounds(398, 447, 94, 31);
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBackground(new Color(0, 102, 204));
		panel.add(btnAnnuler);

		this.textField_nomCharge = new JTextField();
		this.textField_nomCharge.setColumns(10);
		this.textField_nomCharge.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Nom",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_nomCharge.setBounds(271, 115, 190, 40);
		panel.add(this.textField_nomCharge);

		this.textField_montantPrevisionnel = new JTextField();
		this.textField_montantPrevisionnel.setColumns(10);
		this.textField_montantPrevisionnel.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"Montant pr\u00E9visionnel", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_montantPrevisionnel.setBounds(135, 195, 190, 40);
		panel.add(this.textField_montantPrevisionnel);

		this.rdbtnAjouterChargeOui = new JRadioButton("Oui");
		this.rdbtnAjouterChargeOui.setBounds(288, 291, 111, 23);
		panel.add(this.rdbtnAjouterChargeOui);

		this.rdbtnAjouterChargeNon = new JRadioButton("Non");
		this.rdbtnAjouterChargeNon.setBounds(288, 324, 111, 23);
		panel.add(this.rdbtnAjouterChargeNon);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(this.rdbtnAjouterChargeOui);
		buttonGroup.add(this.rdbtnAjouterChargeNon);

		JLabel lbl_AjouterCharge_Déductible = new JLabel("Déductible");
		lbl_AjouterCharge_Déductible.setBounds(280, 270, 96, 14);
		panel.add(lbl_AjouterCharge_Déductible);

		this.textField_montantReel = new JTextField();
		this.textField_montantReel.setColumns(10);
		this.textField_montantReel.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"Montant r\u00E9el", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		this.textField_montantReel.setBounds(398, 195, 190, 40);
		panel.add(this.textField_montantReel);
	}

	public JTextField getTextField_nomCharge() {
		return textField_nomCharge;
	}

	public JTextField getTextField_montantPrevisionnel() {
		return textField_montantPrevisionnel;
	}

	public JTextField getTextField_montantReel() {
		return textField_montantReel;
	}

	public JRadioButton getRdbtnAjouterChargeOui() {
		return rdbtnAjouterChargeOui;
	}

	public JRadioButton getRdbtnAjouterChargeNon() {
		return rdbtnAjouterChargeNon;
	}
	
}
