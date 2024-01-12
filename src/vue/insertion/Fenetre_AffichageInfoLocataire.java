package vue.insertion;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

import controleur.insertion.GestionAffichageInfoLocataire;
import controleur.modification.GestionModificationLocataire;

public class Fenetre_AffichageInfoLocataire extends JInternalFrame {
    private JTextField textField_Nom;
    private JTextField textField_Prenom;
    private JTextField textField_Telephone;
    private JTextField textField_Mail;
    private JTextField textField_DateN;
    private JTextField textField_Id;
    private JButton btnAnnuler;
    private GestionModificationLocataire gestionModificationLocataire;
    private GestionAffichageInfoLocataire gestionClic;
	private JScrollPane scrollPane_locataireSoldeToutCompte;
	private JTable table_soldeToutCompte;

    public Fenetre_AffichageInfoLocataire() {
        // Initialisation du gestionnaire d'affichage et de modification du locataire
        this.gestionClic = new GestionAffichageInfoLocataire(this);
        this.gestionModificationLocataire = new GestionModificationLocataire(this);

        this.setBounds(100, 100, 762, 541);
        this.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(6, 6, 755, 511);
        this.getContentPane().add(panel);
        panel.setLayout(null);

        // Titre et séparateur
        JSeparator separator_AffichageInfoQuotite = new JSeparator();
        separator_AffichageInfoQuotite.setForeground(new Color(0, 102, 204));
        separator_AffichageInfoQuotite.setBounds(280, 57, 190, 2);
        panel.add(separator_AffichageInfoQuotite);

        JLabel lbl_AffichageInfoLocataire = new JLabel("Mon Locataire");
        lbl_AffichageInfoLocataire.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_AffichageInfoLocataire.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbl_AffichageInfoLocataire.setBounds(293, 11, 160, 48);
        panel.add(lbl_AffichageInfoLocataire);

        // Détail locataire
        JLabel lblNewLabel = new JLabel("Détail locataire");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(33, 93, 137, 14);
        panel.add(lblNewLabel);

        // Bouton Régularisation des charges
        JButton btnRegularisationCharges = new JButton("Régularisation des charges");
        btnRegularisationCharges.setBounds(436, 144, 200, 25);
        panel.add(btnRegularisationCharges);
        btnRegularisationCharges.addActionListener(gestionClic);

        // Champs de texte pour les informations du locataire
        textField_Id = new JTextField();
        textField_Id.setColumns(10);
        textField_Id.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Identifiant",
                TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
        textField_Id.setBounds(33, 130, 190, 40);
        panel.add(textField_Id);
        textField_Id.setEditable(false);

        textField_Nom = new JTextField();
        textField_Nom.setColumns(10);
        textField_Nom.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Nom", TitledBorder.LEADING,
                TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
        textField_Nom.setBounds(33, 182, 190, 40);
        panel.add(textField_Nom);

        textField_Prenom = new JTextField();
        textField_Prenom.setColumns(10);
        textField_Prenom.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Prénom ",
                TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
        textField_Prenom.setBounds(33, 233, 190, 40);
        panel.add(textField_Prenom);

        textField_Telephone = new JTextField();
        textField_Telephone.setColumns(10);
        textField_Telephone.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
                "n° Téléphone", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
        textField_Telephone.setBounds(33, 286, 190, 40);
        panel.add(textField_Telephone);

        textField_Mail = new JTextField();
        textField_Mail.setColumns(10);
        textField_Mail.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Mail", TitledBorder.LEADING,
                TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
        textField_Mail.setBounds(33, 337, 190, 40);
        panel.add(textField_Mail);

        textField_DateN = new JTextField();
        textField_DateN.setColumns(10);
        textField_DateN.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Date de naissance",
                TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
        textField_DateN.setBounds(33, 388, 190, 40);
        panel.add(textField_DateN);

        // Bouton Retour
        btnAnnuler = new JButton("Retour");
        btnAnnuler.setBounds(399, 460, 200, 25);
        panel.add(btnAnnuler);
        btnAnnuler.addActionListener(gestionModificationLocataire);

        // Bouton Modifier
        JButton btnModifier = new JButton("Modifier");
        btnModifier.setBounds(144, 461, 200, 25);
        panel.add(btnModifier);
        btnModifier.addActionListener(gestionModificationLocataire);

        // Séparateur vertical et étiquette "Opérations"
        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBackground(new Color(0, 102, 204));
        separator.setBounds(313, 93, 20, 344);
        panel.add(separator);

        JLabel lblOprations = new JLabel("Opérations");
        lblOprations.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblOprations.setBounds(358, 88, 137, 25);
        panel.add(lblOprations);

        // Bouton Solde tout compte
        JButton btnSoldeToutCompte = new JButton("Solde tout compte");
        btnSoldeToutCompte.setBounds(426, 223, 210, 25);
        panel.add(btnSoldeToutCompte);
        btnSoldeToutCompte.addActionListener(gestionClic);

        JLabel lblDpartLoca = new JLabel("Départ de votre locataire :");
        lblDpartLoca.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblDpartLoca.setBounds(451, 196, 137, 25);
        panel.add(lblDpartLoca);
        
        
        this.scrollPane_locataireSoldeToutCompte = new JScrollPane();
		this.scrollPane_locataireSoldeToutCompte.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
		this.scrollPane_locataireSoldeToutCompte.setBounds(343, 259, 380, 107);
		panel.add(this.scrollPane_locataireSoldeToutCompte);

		// Table pour afficher les données d'entreprise
		this.table_soldeToutCompte = new JTable();
		this.table_soldeToutCompte
				.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Provisions sur charges","Charges réelles payées", "Caution", "Travaux imputables", "Reste"
			}
		));
		scrollPane_locataireSoldeToutCompte.setViewportView(this.table_soldeToutCompte);

        
    }
    

    // Getters pour récupérer les valeurs des champs
    public JTextField getTextField_Nom() {
        return textField_Nom;
    }

    public JTextField getTextField_Prenom() {
        return textField_Prenom;
    }

    public JTextField getTextField_Telephone() {
        return textField_Telephone;
    }

    public JTextField getTextField_Mail() {
        return textField_Mail;
    }

    public JTextField getTextField_DateN() {
        return textField_DateN;
    }

    public JTextField getTextField_Id() {
        return textField_Id;
    }

    public GestionAffichageInfoLocataire getGestionClic() {
        return gestionClic;
    }
}
