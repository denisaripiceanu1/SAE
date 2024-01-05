package vue.modification;

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

import controleur.insertion.GestionInsertionEntreprise;
import controleur.modification.GestionModificationEntreprise;

public class Fenetre_ModificationEntreprise extends JInternalFrame {
	// Champs de saisie
		private JTextField textField_Nom;
		private JTextField textField_SIRET;
		private JTextField textField_Telephone;
		private JTextField textField_Mail;
		private JTextField textField_Adresse;
		private JTextField textField_CP;
		private JTextField textField_Ville;
		private JTextField textField_IBAN;
		private JTextField textField_Date_Validite;
		private JTextField textField_Type;

		// Gestionnaires d'événements
		private GestionModificationEntreprise gestionClic;

		public Fenetre_ModificationEntreprise() {

			// Initialisation des gestionnaires d'événements
			this.gestionClic = new GestionModificationEntreprise(this);

			// Configuration de la fenêtre interne
			this.setBounds(100, 100, 762, 541);
			this.getContentPane().setLayout(null);

			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(0, 0, 755, 511);
			this.getContentPane().add(panel);
			panel.setLayout(null);

			JSeparator separator_titreInsererEntreprise = new JSeparator();
			separator_titreInsererEntreprise.setForeground(new Color(0, 102, 204));
			separator_titreInsererEntreprise.setBounds(263, 99, 190, 2);
			panel.add(separator_titreInsererEntreprise);

			// Label titre
			JLabel lbl_InsererUneEntreprise = new JLabel("Modifier un Prestataire");
			lbl_InsererUneEntreprise.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lbl_InsererUneEntreprise.setBounds(275, 53, 163, 48);
			panel.add(lbl_InsererUneEntreprise);

			// Champs de saisie
			textField_Nom = new JTextField();
			textField_Nom.setColumns(10);
			textField_Nom.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Nom", TitledBorder.LEADING,
					TitledBorder.ABOVE_TOP, new Font("Tahoma", Font.PLAIN, 12), new Color(0, 0, 0)));
			textField_Nom.setBounds(131, 166, 190, 40);
			panel.add(textField_Nom);

			textField_SIRET = new JTextField();
			textField_SIRET.setColumns(10);
			textField_SIRET.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "SIRET",
					TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new Font("Tahoma", Font.PLAIN, 12), new Color(0, 0, 0)));
			textField_SIRET.setBounds(381, 166, 190, 40);
			panel.add(textField_SIRET);
			textField_SIRET.setEditable(false);


			textField_Telephone = new JTextField();
			textField_Telephone.setColumns(10);
			textField_Telephone.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
					"n\u00B0 T\u00E9l\u00E9phone", TitledBorder.LEADING, TitledBorder.ABOVE_TOP,
					new Font("Tahoma", Font.PLAIN, 12), new Color(0, 0, 0)));
			textField_Telephone.setBounds(131, 218, 190, 40);
			panel.add(textField_Telephone);

			textField_Mail = new JTextField();
			textField_Mail.setColumns(10);
			textField_Mail.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Mail", TitledBorder.LEADING,
					TitledBorder.ABOVE_TOP, new Font("Tahoma", Font.PLAIN, 12), new Color(0, 0, 0)));
			textField_Mail.setBounds(381, 218, 190, 40);
			panel.add(textField_Mail);

			textField_Adresse = new JTextField();
			textField_Adresse.setColumns(10);
			textField_Adresse.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Adresse",
					TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new Font("Tahoma", Font.PLAIN, 12), new Color(0, 0, 0)));
			textField_Adresse.setBounds(131, 270, 190, 40);
			panel.add(textField_Adresse);

			textField_CP = new JTextField();
			textField_CP.setColumns(10);
			textField_CP.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Code Postal",
					TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new Font("Tahoma", Font.PLAIN, 12), new Color(0, 0, 0)));
			textField_CP.setBounds(381, 270, 190, 40);
			panel.add(textField_CP);

			textField_Ville = new JTextField();
			textField_Ville.setColumns(10);
			textField_Ville.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Ville",
					TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new Font("Tahoma", Font.PLAIN, 12), new Color(0, 0, 0)));
			textField_Ville.setBounds(131, 322, 190, 40);
			panel.add(textField_Ville);

			textField_IBAN = new JTextField();
			textField_IBAN.setColumns(10);
			textField_IBAN.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "IBAN", TitledBorder.LEADING,
					TitledBorder.ABOVE_TOP, new Font("Tahoma", Font.PLAIN, 12), new Color(0, 0, 0)));
			textField_IBAN.setBounds(381, 322, 190, 40);
			panel.add(textField_IBAN);

			// Boutons généraux
			JButton btnAjouter = new JButton("Modifier");
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

		}

		public JTextField getTextField_Nom() {
			return this.textField_Nom;
		}

		public JTextField getTextField_SIRET() {
			return this.textField_SIRET;
		}

		public JTextField getTextField_Telephone() {
			return this.textField_Telephone;
		}

		public JTextField getTextField_Mail() {
			return this.textField_Mail;
		}

		public JTextField getTextField_Adresse() {
			return this.textField_Adresse;
		}

		public JTextField getTextField_CP() {
			return this.textField_CP;
		}

		public JTextField getTextField_Ville() {
			return this.textField_Ville;
		}

		public JTextField getTextField_IBAN() {
			return this.textField_IBAN;
		}

		public JTextField getTextField_Date_Validite() {
			return this.textField_Date_Validite;
		}

		public JTextField getTextField_Type() {
			return this.textField_Type;
		}

}
