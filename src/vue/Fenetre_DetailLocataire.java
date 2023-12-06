package vue;

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

public class Fenetre_DetailLocataire extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Fenetre_DetailLocataire frame = new Fenetre_DetailLocataire();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTextField textField_IdCompteur;
	private JTextField textField_IndiceCompteur;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_IdLocataire;
	private JTextField textField_Nom;
	private JTextField textField_Prenom;
	private JTextField textField_Date_de_naissance;
	private JTextField textField_telephone;
	private JTextField textField_email;

	/**
	 * Create the frame.
	 */
	public Fenetre_DetailLocataire() {
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		JSeparator separator_titreDetailLocataire = new JSeparator();
		separator_titreDetailLocataire.setForeground(new Color(0, 102, 204));
		separator_titreDetailLocataire.setBounds(271, 72, 190, 2);
		panel.add(separator_titreDetailLocataire);

		JLabel lbl_InsererUnLogement = new JLabel("Détails sur le locataire");
		lbl_InsererUnLogement.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUnLogement.setBounds(290, 25, 171, 48);
		panel.add(lbl_InsererUnLogement);

		this.textField_IdLocataire = new JTextField();
		this.textField_IdLocataire.setColumns(10);
		this.textField_IdLocataire.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "ID locataire",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
		this.textField_IdLocataire.setBounds(271, 92, 190, 40);
		panel.add(this.textField_IdLocataire);

		this.textField_Nom = new JTextField();
		this.textField_Nom.setColumns(10);
		this.textField_Nom.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Nom",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
		this.textField_Nom.setBounds(271, 142, 190, 40);
		panel.add(this.textField_Nom);

		this.textField_Prenom = new JTextField();
		this.textField_Prenom.setColumns(10);
		this.textField_Prenom.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Prénom",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
		this.textField_Prenom.setBounds(271, 192, 190, 40);
		panel.add(this.textField_Prenom);

		this.textField_Date_de_naissance = new JTextField();
		this.textField_Date_de_naissance.setColumns(10);
		this.textField_Date_de_naissance.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"Date de naissance", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
		this.textField_Date_de_naissance.setBounds(271, 249, 190, 40);
		panel.add(this.textField_Date_de_naissance);

		this.textField_telephone = new JTextField();
		this.textField_telephone.setColumns(10);
		this.textField_telephone.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "N°téléphone",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
		this.textField_telephone.setBounds(271, 299, 190, 40);
		panel.add(this.textField_telephone);

		this.textField_email = new JTextField();
		this.textField_email.setColumns(10);
		this.textField_email.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "E-mail",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 204)));
		this.textField_email.setBounds(271, 349, 190, 40);
		panel.add(this.textField_email);

		JButton btnFermer = new JButton("Fermer");
		btnFermer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnFermer.setBounds(315, 427, 94, 31);
		panel.add(btnFermer);

	}
}
