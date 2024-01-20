package vue.insertion;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
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
        JSeparator separator_titreInsererCompteur = new JSeparator();
        separator_titreInsererCompteur.setForeground(new Color(0, 102, 204));
        separator_titreInsererCompteur.setBounds(269, 101, 190, 33);
        panel.add(separator_titreInsererCompteur);

        JLabel lbl_InsererUnCompteur = new JLabel("Ajouter un Compteur");
        lbl_InsererUnCompteur.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbl_InsererUnCompteur.setBounds(285, 56, 160, 48);
        panel.add(lbl_InsererUnCompteur);

        // Menu déroulant pour le type de compteur
        comboBox_typeDeCompteur = new JComboBox<String>();
        comboBox_typeDeCompteur.setModel(new DefaultComboBoxModel<String>(new String[] { "Eau", "Gaz", "Electricité" }));
        comboBox_typeDeCompteur.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Type",
                TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
        comboBox_typeDeCompteur.setBounds(270, 147, 189, 39);
        panel.add(comboBox_typeDeCompteur);

        // Champs de texte pour l'ID du compteur et l'indice du compteur
        textField_IdCompteur = createTextField("Id Compteur", 270, 207, 190, 40, panel);
        textField_IndiceCompteur = createTextField("Indice du Compteur", 270, 273, 190, 40, panel);

        // Boutons Ajouter et Annuler
        createButton("Ajouter", 246, 447, 94, 31, Color.WHITE, new Color(0, 102, 204), gestionClic, panel);
        createButton("Annuler", 398, 447, 94, 31, Color.WHITE, new Color(0, 102, 204), gestionClic, panel);

        // Champ de texte pour le prix de l'abonnement
        textFieldPrixAbo = createTextField("Prix de l'abonnement", 270, 343, 190, 40, panel);
    }

    // Méthode pour créer un champ de texte avec une bordure spécifique
    private JTextField createTextField(String title, int x, int y, int width, int height, JPanel panel) {
        JTextField textField = new JTextField();
        textField.setColumns(10);
        textField.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), title, TitledBorder.LEADING,
                TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
        textField.setBounds(x, y, width, height);
        panel.add(textField);
        return textField;
    }

    // Méthode pour créer un bouton avec une couleur de texte, de fond et un gestionnaire d'événements spécifiques
    private JButton createButton(String label, int x, int y, int width, int height, Color textColor, Color bgColor,
            GestionInsertionCompteur listener, JPanel panel) {
        JButton button = new JButton(label);
        button.setFont(new Font("Tahoma", Font.PLAIN, 12));
        button.setBounds(x, y, width, height);
        button.setForeground(textColor);
        button.setBackground(bgColor);
        button.addActionListener(listener);
        panel.add(button);
        return button;
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
