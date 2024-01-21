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

import controleur.insertion.GestionInsertionCompteur;

public class Fenetre_InsertionCompteur extends JInternalFrame {
    // Champs de saisie
	private JTextField textField_IdCompteur;
    private JTextField textField_IndiceCompteur;
    private JTextField textFieldPrixAbo;
    // Menu déroulant pour le type de compteur
    private JComboBox<String> comboBox_typeDeCompteur;
    // Gestionnaire d'actions
    private GestionInsertionCompteur gestionClic;

    public Fenetre_InsertionCompteur() {
        // Initialisation du gestionnaire d'insertion de compteur
        this.gestionClic = new GestionInsertionCompteur(this);
        
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
		Utils.creerLabel("Ajouter un Compteur", 285, 56, 160, 48, 16, panel);

        JSeparator separator_titreInsererCompteur = new JSeparator();
        separator_titreInsererCompteur.setForeground(new Color(0, 102, 204));
        separator_titreInsererCompteur.setBounds(269, 101, 190, 33);
        panel.add(separator_titreInsererCompteur);
        
        // Menu déroulant pour le type de compteur
        comboBox_typeDeCompteur = new JComboBox<String>();
        comboBox_typeDeCompteur.setModel(new DefaultComboBoxModel<String>(new String[] { "Eau", "Gaz", "Electricité" }));
        comboBox_typeDeCompteur.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Type",
                TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
        comboBox_typeDeCompteur.setBounds(270, 147, 189, 39);
        panel.add(comboBox_typeDeCompteur);

        // Champs de texte pour l'ID du compteur et l'indice du compteur
        textField_IdCompteur = Utils.creerTextField("Id Compteur", 270, 207, 190, 40, panel);
        textField_IndiceCompteur = Utils.creerTextField("Indice du Compteur", 270, 273, 190, 40, panel);
        textFieldPrixAbo = Utils.creerTextField("Prix de l'abonnement", 270, 343, 190, 40, panel);

        // Boutons Ajouter et Annuler
        JButton btnAnnuler = Utils.creerBouton(panel, "Annuler", 398, 447, 94, 31);
		btnAnnuler.addActionListener(this.gestionClic);

		JButton btnAnjouter = Utils.creerBouton(panel, "Ajouter", 246, 447, 94, 31);
		btnAnjouter.addActionListener(this.gestionClic);
    }

    
    // Getters pour récupérer les valeurs des champs
    public JTextField getTextField_IdCompteur() {
        return textField_IdCompteur;
    }

    public JTextField getTextField_textFieldPrixAbo() {
        return textFieldPrixAbo;
    }

    public JTextField getTextField_IndiceCompteur() {
        return textField_IndiceCompteur;
    }

    public JComboBox<String> getComboBox_typeDeCompteur() {
        return comboBox_typeDeCompteur;
    }
}
