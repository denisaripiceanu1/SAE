package vue.insertion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controleur.insertion.GestionInsertionCompteur;

import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;

public class Fenetre_InsertionQuotite extends JInternalFrame {
	private JTextField textField_Pourcentage;


	public Fenetre_InsertionQuotite() {
		
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
		
		JLabel lbl_InsererUneQuotite = new JLabel("Ajouter une Quotité");
		lbl_InsererUneQuotite.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_InsererUneQuotite.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUneQuotite.setBounds(284, 84, 160, 48);
		panel.add(lbl_InsererUneQuotite);
		
		JComboBox comboBox_typeDeCompteur = new JComboBox();
		comboBox_typeDeCompteur.setModel(new DefaultComboBoxModel(new String[] {"Eau", "Gaz", "Electricité", "Ordure Ménagère"}));
		comboBox_typeDeCompteur.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Type", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		comboBox_typeDeCompteur.setBounds(271, 215, 189, 39);
		panel.add(comboBox_typeDeCompteur);
		
		textField_Pourcentage = new JTextField();
		textField_Pourcentage.setColumns(10);
		textField_Pourcentage.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Pourcentage", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_Pourcentage.setBounds(271, 291, 190, 40);
		panel.add(textField_Pourcentage);
		
		JButton btnAjouter = new JButton("Ajouter");
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
		

	}
}
