package vue.insertion;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fenetre_AffichageInfoLocataire extends JInternalFrame {
	private JTextField textField_Nom;
	private JTextField textField_Prenom;
	private JTextField textField_Adresse;
	private JTextField textField_Telephone;
	private JTextField textField_Mail;
	private JTextField textField_DateN;
	private JTextField textField_Id;

    public Fenetre_AffichageInfoLocataire() {
        this.setBounds(100, 100, 762, 541);
        this.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		JSeparator separator_AffichageInfoQuotite = new JSeparator();
		separator_AffichageInfoQuotite.setForeground(new Color(0, 102, 204));
		separator_AffichageInfoQuotite.setBounds(280, 57, 190, 2);
		panel.add(separator_AffichageInfoQuotite);

		JLabel lbl_AffichageInfoLocataire = new JLabel("Mon Locataire");
		lbl_AffichageInfoLocataire.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_AffichageInfoLocataire.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_AffichageInfoLocataire.setBounds(293, 11, 160, 48);
		panel.add(lbl_AffichageInfoLocataire);

		JLabel lblNewLabel = new JLabel("Détail locataire");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(33, 93, 137, 14);
		panel.add(lblNewLabel);

		JButton btnRegularisationCharges = new JButton("Régularisation des charges");
		btnRegularisationCharges.setBounds(502, 198, 200, 25);
		// Ajoutez le code associé à l'action du bouton ici
		panel.add(btnRegularisationCharges);

		textField_Nom = new JTextField();
		textField_Nom.setColumns(10);
		textField_Nom.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Nom", TitledBorder.LEADING,
				TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_Nom.setBounds(33, 169, 190, 40);
		panel.add(textField_Nom);

		textField_Prenom = new JTextField();
		textField_Prenom.setColumns(10);
		textField_Prenom.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Prenom",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_Prenom.setBounds(233, 169, 190, 40);
		panel.add(textField_Prenom);

		textField_Adresse = new JTextField();
		textField_Adresse.setColumns(10);
		textField_Adresse.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Adresse",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_Adresse.setBounds(33, 220, 390, 69);
		panel.add(textField_Adresse);

		textField_Telephone = new JTextField();
		textField_Telephone.setColumns(10);
		textField_Telephone.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"n\u00B0 T\u00E9l\u00E9phone", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_Telephone.setBounds(33, 305, 190, 40);
		panel.add(textField_Telephone);

		textField_Mail = new JTextField();
		textField_Mail.setColumns(10);
		textField_Mail.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Mail", TitledBorder.LEADING,
				TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_Mail.setBounds(233, 305, 190, 40);
		panel.add(textField_Mail);

		JButton btnAnnuler = new JButton("Retour");
		btnAnnuler.setBounds(399, 460, 200, 25);
		panel.add(btnAnnuler);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModifier.setBounds(144, 461, 200, 25);
		panel.add(btnModifier);

		textField_DateN = new JTextField();
		textField_DateN.setColumns(10);
		textField_DateN.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Date de naissance",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_DateN.setBounds(33, 356, 190, 40);
		panel.add(textField_DateN);

		textField_Id = new JTextField();
		textField_Id.setColumns(10);
		textField_Id.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Identifiant",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_Id.setBounds(33, 118, 190, 40);
		panel.add(textField_Id);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(new Color(0, 102, 204));
		separator.setBounds(450, 84, 20, 344);
		panel.add(separator);

		JLabel lblOprations = new JLabel("Opérations");
		lblOprations.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOprations.setBounds(480, 88, 137, 25);
		panel.add(lblOprations);

		JButton btnSoldeToutCompte = new JButton("Solde tout compte");
		btnSoldeToutCompte.setBounds(502, 295, 200, 25);
		panel.add(btnSoldeToutCompte);

		JLabel lblDpartLoca = new JLabel("Départ de votre locataire :");
		lblDpartLoca.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDpartLoca.setBounds(534, 264, 137, 25);
		panel.add(lblDpartLoca);
	}
}
