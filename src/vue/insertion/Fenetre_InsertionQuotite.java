package vue.insertion;

import java.awt.Color;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controleur.insertion.GestionInsertionQuotite;

public class Fenetre_InsertionQuotite extends JInternalFrame {
    // Champ de saisie
	private JTextField textField_Pourcentage;
	// Déclaration des gestionnaires
    private GestionInsertionQuotite gestionClic;
    // Menu déroulant pour le type de compteur
    private JComboBox<String> comboBox_typeDeCompteur;

    public Fenetre_InsertionQuotite() {
        // Initialisation du gestionnaire d'insertion de quotité
        this.gestionClic = new GestionInsertionQuotite(this);

        // Configuration de la fenêtre interne
        this.setBounds(100, 100, 762, 541);
        this.getContentPane().setLayout(null);

        // Panneau principal
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 755, 511);
        this.getContentPane().add(panel);
        panel.setLayout(null);

        // Titre et séparateur
		Utils.creerLabel("Insérer un Quotité", 284, 84, 160, 48, 16, panel);

        JSeparator separator_titreInsererQuotite = new JSeparator();
        separator_titreInsererQuotite.setForeground(new Color(0, 102, 204));
        separator_titreInsererQuotite.setBounds(271, 130, 190, 2);
        panel.add(separator_titreInsererQuotite);

        // Menu déroulant pour le type de compteur
        this.comboBox_typeDeCompteur = new JComboBox<String>();
        this.comboBox_typeDeCompteur.setModel(new DefaultComboBoxModel<String>(
                new String[] { "Eau", "Électricité", "Ordures ménagères", "Entretien" }));
        this.comboBox_typeDeCompteur.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Type",
                TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
        this.comboBox_typeDeCompteur.setBounds(271, 215, 189, 39);
        panel.add(this.comboBox_typeDeCompteur);

        // Champ de texte pour le pourcentage
        this.textField_Pourcentage = Utils.creerTextField("Pourcentage (%)", 271, 291, 190, 40, panel);

        // Boutons Ajouter et Annuler
		JButton btnAjouter = Utils.creerBouton(panel, "Ajouter", 246, 447, 94, 31);
		btnAjouter.addActionListener(this.gestionClic);

		JButton btnAnnuler = Utils.creerBouton(panel, "Annuler", 398, 447, 94, 31);
		btnAnnuler.addActionListener(this.gestionClic);
    }

    // Getters 
    public JTextField getTextField_Pourcentage() {
        return this.textField_Pourcentage;
    }

    public JComboBox<String> getComboBox_typeDeCompteur() {
        return this.comboBox_typeDeCompteur;
    }
}
