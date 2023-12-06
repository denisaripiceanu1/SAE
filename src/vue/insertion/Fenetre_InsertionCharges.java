package vue.insertion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;

import controleur.insertion.GestionInsertionBien;
import controleur.insertion.GestionInsertionCharges;

public class Fenetre_InsertionCharges extends JFrame {
	private JTextField textField_nomCharge;
	private JTextField textField_montantPrevisionnel;
	private GestionInsertionCharges gestionClic;
	public Fenetre_InsertionCharges() {
		
		this.gestionClic = new GestionInsertionCharges(this);
		
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
		
		JLabel lbl_InsererUneCharge = new JLabel("Ajouter une Charge");
		lbl_InsererUneCharge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUneCharge.setBounds(288, 26, 160, 48);
		panel.add(lbl_InsererUneCharge);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAjouter.setBounds(246, 447, 94, 31);
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setBackground(new Color(0, 102, 204));
		btnAjouter.addActionListener(gestionClic);
		panel.add(btnAjouter);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAnnuler.setBounds(398, 447, 94, 31);
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBackground(new Color(0, 102, 204));
		btnAnnuler.addActionListener(gestionClic);
		panel.add(btnAnnuler);
		
		textField_nomCharge = new JTextField();
		textField_nomCharge.setColumns(10);
		textField_nomCharge.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Nom", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_nomCharge.setBounds(271, 109, 190, 40);
		panel.add(textField_nomCharge);
		
		textField_montantPrevisionnel = new JTextField();
		textField_montantPrevisionnel.setColumns(10);
		textField_montantPrevisionnel.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Montant pr\u00E9visionnel", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_montantPrevisionnel.setBounds(271, 194, 190, 40);
		panel.add(textField_montantPrevisionnel);
		JRadioButton rdbtnAjouterChargeOui = new JRadioButton("Oui");
		rdbtnAjouterChargeOui.setBounds(288, 291, 111, 23);
		panel.add(rdbtnAjouterChargeOui);
		
		JRadioButton rdbtnAjouterChargeNon = new JRadioButton("Non");
		rdbtnAjouterChargeNon.setBounds(288, 324, 111, 23);
		panel.add(rdbtnAjouterChargeNon);
		
		JLabel lbl_AjouterCharge_Déductible = new JLabel("Déductible");
		lbl_AjouterCharge_Déductible.setBounds(280, 270, 96, 14);
		panel.add(lbl_AjouterCharge_Déductible);
		}
	}


