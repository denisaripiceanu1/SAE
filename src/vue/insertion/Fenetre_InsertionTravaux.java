package vue.insertion;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class Fenetre_InsertionTravaux extends JFrame{
	private JTextField textField_Numero;
	private JTextField textField_date_emission;
	private JTextField textField_date_paiement;
	private JTextField textField_ville;
	private JTextField textField_periodeDeConstruction;
	private JTextField textField_nbLogement;
	private JTextField textField_dateAcquisition;
	private JSeparator separator_Travaux;
    JRadioButton rdbtnOui = new JRadioButton("Oui");
    JRadioButton rdbtnNon = new JRadioButton("Non");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Fenetre_InsertionTravaux frame = new Fenetre_InsertionTravaux();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Fenetre_InsertionTravaux() {
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JSeparator separator_titreInsererTravaux = new JSeparator();
		separator_titreInsererTravaux.setForeground(new Color(0, 102, 204));
		separator_titreInsererTravaux.setBounds(271, 72, 190, 2);
		panel.add(separator_titreInsererTravaux);
		
		JLabel lbl_InsererUnTravaux = new JLabel("Ajouter un Travaux");
		lbl_InsererUnTravaux.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUnTravaux.setBounds(294, 26, 153, 48);
		panel.add(lbl_InsererUnTravaux);
		
		textField_Numero = new JTextField();
		textField_Numero.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Id Numero", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_Numero.setBounds(110, 104, 190, 40);
		panel.add(textField_Numero);
		textField_Numero.setColumns(10);
		
		textField_date_emission = new JTextField();
		textField_date_emission.setColumns(10);
		textField_date_emission.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Date Emission", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_date_emission.setBounds(110, 168, 190, 40);
		panel.add(textField_date_emission);
		
		textField_date_paiement = new JTextField();
		textField_date_paiement.setColumns(10);
		textField_date_paiement.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Date Paiement", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_date_paiement.setBounds(427, 168, 190, 40);
		panel.add(textField_date_paiement);
		
		textField_ville = new JTextField();
		textField_ville.setColumns(10);
		textField_ville.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Numero Devis", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_ville.setBounds(110, 228, 190, 40);
		panel.add(textField_ville);
		
		textField_periodeDeConstruction = new JTextField();
		textField_periodeDeConstruction.setColumns(10);
		textField_periodeDeConstruction.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "D\u00E9signation", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_periodeDeConstruction.setBounds(427, 228, 190, 40);
		panel.add(textField_periodeDeConstruction);
		
		textField_nbLogement = new JTextField();
		textField_nbLogement.setColumns(10);
		textField_nbLogement.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Montant", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_nbLogement.setBounds(110, 294, 190, 40);
		panel.add(textField_nbLogement);
		
		textField_dateAcquisition = new JTextField();
		textField_dateAcquisition.setColumns(10);
		textField_dateAcquisition.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Accompte verse", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_dateAcquisition.setBounds(427, 294, 190, 40);
		panel.add(textField_dateAcquisition);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setBackground(new Color(0, 102, 204));
		btnAjouter.setBounds(248, 437, 94, 31);
		panel.add(btnAjouter);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBackground(new Color(0, 102, 204));
		btnAnnuler.setBounds(389, 437, 94, 31);
		panel.add(btnAnnuler);
		
		separator_Travaux = new JSeparator();
		separator_Travaux.setBounds(90, 401, 591, 2);
		panel.add(separator_Travaux);
		
		JComboBox comboBox_modePaiement = new JComboBox();
		comboBox_modePaiement.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Mode de Paiement", TitledBorder.LEADING, 
				TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		comboBox_modePaiement.setBounds(427, 104, 189, 39);
		panel.add(comboBox_modePaiement);
		
		this.rdbtnOui.setForeground(new Color(0, 0, 0));
		this.rdbtnOui.setHorizontalAlignment(SwingConstants.TRAILING);
		this.rdbtnOui.setHorizontalTextPosition(SwingConstants.LEADING);
		this.rdbtnOui.setBounds(286, 374, 54, 21);
		panel.add(this.rdbtnOui);
		
		this.rdbtnNon.setBounds(389, 374, 54, 21);
		panel.add(this.rdbtnNon);
		
		ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(this.rdbtnOui);
        buttonGroup.add(this.rdbtnNon);
		
		JLabel lbl_ImputableLocataire = new JLabel("Imputable Locataire");
		lbl_ImputableLocataire.setForeground(Color.BLACK);
		lbl_ImputableLocataire.setBackground(new Color(0, 102, 204));
		lbl_ImputableLocataire.setBounds(311, 337, 132, 31);
		panel.add(lbl_ImputableLocataire);
        
        
	}



}
